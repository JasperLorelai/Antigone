package eu.jasperlorelai.antigone.nms.shared.parameters.config;

import org.bukkit.Tag;
import org.bukkit.Material;

import java.util.*;
import java.lang.reflect.Field;

import org.jetbrains.annotations.Nullable;

import com.destroystokyo.paper.MaterialTags;
import com.destroystokyo.paper.MaterialSetTag;

import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.core.registries.BuiltInRegistries;

import eu.jasperlorelai.antigone.nms.shared.util.Util;
import eu.jasperlorelai.antigone.nms.shared.util.Description;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigSupplier;
import eu.jasperlorelai.antigone.nms.shared.parameters.ExactConfigParameter;

public class NmsIngredientParameter extends ExactConfigParameter<Ingredient> {

	private static final Map<String, Tag<Material>> MATERIAL_TAGS = new HashMap<>();
	static {
		try {
			for (Field field : Tag.class.getDeclaredFields()) {
				if (!(field.get(null) instanceof Tag<?> tag)) continue;
				if (field.getType() != Material.class) continue;
				//noinspection unchecked
				MATERIAL_TAGS.put(field.getName(), (Tag<Material>) tag);
			}
			for (Field field : MaterialTags.class.getDeclaredFields()) {
				if (!(field.get(null) instanceof MaterialSetTag tag)) continue;
				MATERIAL_TAGS.put(field.getName(), tag);
			}
		} catch (ExceptionInInitializerError | IllegalAccessException ignored) {}
	}

	private static final ConfigSupplier<Ingredient> supplier = ConfigSupplier.fromList(list -> {
		List<Material> materials = new ArrayList<>();
		for (String string : list) {
			if (string.startsWith("#")) {
				Tag<Material> tag = MATERIAL_TAGS.get(string.substring(1).toUpperCase());
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

	private static Ingredient fromMaterials(List<Material> materials) {
		if (Util.isNotBootstrapped()) return null;
		if (materials == null) return null;
		Item[] items = new Item[materials.size()];
		for (int i = 0; i < materials.size(); i++) {
			items[i] = BuiltInRegistries.ITEM.get(new ResourceLocation(materials.get(i).getKey().getKey()));
		}
		return Ingredient.of(items);
	}

	private final Material[] defaultMaterials;

	public NmsIngredientParameter(String name) {
		this(name, null);
	}

	public NmsIngredientParameter(String name, @Nullable List<Material> materials) {
		super(name, Ingredient.class, supplier, fromMaterials(materials));
		this.defaultMaterials = materials == null ? null : materials.toArray(new Material[0]);
	}

	@Override
	public String documentDefault() {
		if (defaultMaterials == null) return null;
		return Description.of(Description.Conjunction.NONE, m -> m.name().toLowerCase(), defaultMaterials);
	}

	@Override
	public String documentType() {
		return Description.of("List of ", Description.Conjunction.OR,
				Description.ofEnum(Material.class),
				Description.ofEnum(Tag.class),
				Description.ofFields(MaterialTags.class)
		);
	}

}
