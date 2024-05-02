package eu.jasperlorelai.antigone.nms.shared.parameters.config;

import org.bukkit.Tag;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

import java.util.*;
import java.lang.reflect.Field;
import java.util.function.Predicate;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.destroystokyo.paper.MaterialTags;
import com.destroystokyo.paper.MaterialSetTag;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.core.registries.BuiltInRegistries;

import eu.jasperlorelai.antigone.nms.shared.util.Util;
import eu.jasperlorelai.antigone.nms.shared.util.Default;
import eu.jasperlorelai.antigone.nms.shared.util.Description;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigSupplier;
import eu.jasperlorelai.antigone.nms.shared.parameters.ConfigParameter;

@SuppressWarnings("rawtypes")
public class NmsIngredientParameter extends ConfigParameter<Class<Predicate>, Predicate<ItemStack>> {

	private static final Map<String, Tag<Material>> MATERIAL_TAGS = new HashMap<>();
	static {
		try {
			for (Field field : MaterialTags.class.getDeclaredFields()) {
				if (!(field.get(null) instanceof MaterialSetTag tag)) continue;
				MATERIAL_TAGS.put(field.getName(), tag);
			}
		} catch (ExceptionInInitializerError | IllegalAccessException ignored) {}
	}

	private static Tag<Material> getMaterialTag(String string) {
		Tag<Material> tag = MATERIAL_TAGS.get(string.toUpperCase());
		if (tag != null) return tag;

		NamespacedKey key = NamespacedKey.fromString(string);
		if (key == null) return null;

		tag = Bukkit.getTag(Tag.REGISTRY_BLOCKS, key, Material.class);
		if (tag == null) return Bukkit.getTag(Tag.REGISTRY_ITEMS, key, Material.class);
		return tag;
	}

	private static final ConfigSupplier<Predicate<ItemStack>> supplier = ConfigSupplier.fromList(list -> {
		List<Material> materials = new ArrayList<>();
		for (String string : list) {
			if (string.startsWith("#")) {
				Tag<Material> tag = getMaterialTag(string.substring(1));
				if (tag == null) continue;
				materials.addAll(tag.getValues());
				continue;
			}
			Material material = Material.matchMaterial(string);
			if (material == null) continue;
			materials.add(material);
		}

		return fromMaterials(materials);
	});

	public NmsIngredientParameter(@NotNull String name) {
		this(name, (List<Material>) null);
	}

	public NmsIngredientParameter(@NotNull String name, @Nullable List<Material> def) {
		this(name, toDefault(def));
	}

	private NmsIngredientParameter(String name, Default<Predicate<ItemStack>> def) {
		super(name, Predicate.class, supplier, def);
	}

	private static Default<Predicate<ItemStack>> toDefault(List<Material> def) {
		if (def == null) return null;
		String description = Description.of(Description.Conjunction.NONE, m -> m.name().toLowerCase(), def.toArray(new Material[0]));
		return new Default<>(fromMaterials(def), description);
	}

	private static Ingredient fromMaterials(List<Material> materials) {
		if (Util.isNotBootstrapped()) return null;
		if (materials == null) return null;
		Item[] items = new Item[materials.size()];
		for (int i = 0; i < materials.size(); i++) {
			items[i] = BuiltInRegistries.ITEM.get(new ResourceLocation(materials.get(i).getKey().getKey()));
		}
		return Ingredient.of(items);
	}

	@Override
	public String documentType() {
		return Description.ofEnum("List of ", Material.class) + " or " + Description.of("List of the following prepended by '#': ", Description.Conjunction.OR,
				Description.hyperlink("Block tag", "https://github.com/TheComputerGeek2/MagicSpells/wiki/Other-Data-Types#block-tags"),
				Description.hyperlink("Item tag", "https://minecraft.wiki/w/Tag#Items")
		);
	}

}
