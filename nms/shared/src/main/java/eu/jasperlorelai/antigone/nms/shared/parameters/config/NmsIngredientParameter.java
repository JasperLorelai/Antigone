package eu.jasperlorelai.antigone.nms.shared.parameters.config;

import java.util.*;
import java.lang.reflect.Field;
import java.util.function.Predicate;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.destroystokyo.paper.MaterialTags;
import com.destroystokyo.paper.MaterialSetTag;

import org.bukkit.Tag;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.craftbukkit.tag.CraftItemTag;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.core.registries.BuiltInRegistries;

import eu.jasperlorelai.antigone.nms.shared.util.*;
import eu.jasperlorelai.antigone.nms.shared.versioned.holders.RegistryResolverHolder;

public class NmsIngredientParameter extends NmsRegistryParameter<Class<Predicate>, Predicate<ItemStack>, Item> {

	private final Collection<ItemLike> defaultItems;

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
		if (tag != null) return tag;

		return Bukkit.getTag(Tag.REGISTRY_ITEMS, key, Material.class);
	}

	public NmsIngredientParameter(@NotNull @ConfigKey String name) {
		this(name, null);
	}

	public NmsIngredientParameter(@NotNull @ConfigKey String name, @Nullable Collection<ItemLike> def) {
		super(name, Predicate.class);
		defaultItems = def;
	}

	@Nullable
	@Override
	public Default<Predicate<ItemStack>> getDefault() {
		if (defaultItems == null) return null;
		String description = Description.List.create().build(defaultItems, ItemLike.class, ItemLike::toString);
		return new Default<>(fromMaterials(defaultItems), description);
	}

	@Override
	public ConfigSupplier<Predicate<ItemStack>> getSupplier() {
		return ConfigSupplier.fromList(list -> {
			List<ItemLike> itemLikes = new ArrayList<>();
			for (String string : list) {
				if (string.startsWith("#")) {
					Tag<Material> tag = getMaterialTag(string.substring(1));
					if (tag == null) continue;
					itemLikes.add(new ItemLike(tag));
					continue;
				}
				Material material = Material.matchMaterial(string);
				if (material == null) continue;
				itemLikes.add(new ItemLike(material));
			}

			return fromMaterials(itemLikes);
		});
	}

	private Ingredient fromMaterials(Collection<ItemLike> itemLikes) {
		if (Util.isNotBootstrapped()) return null;
		return Ingredient.of(itemLikes.stream()
			.<Material>mapMulti(((itemLike, consumer) -> itemLike.getMaterials().forEach(consumer)))
			.map(material -> getVanillaResolver().apply(material.key()))
			.filter(Objects::nonNull)
			.toArray(Item[]::new)
		);
	}

	@Nullable
	@Override
	public BukkitResolver getBukkitResolver() {
		return null;
	}

	@NotNull
	@Override
	public VanillaResolver<Item> getVanillaResolver() {
		return RegistryResolverHolder.getInstance().item();
	}

	@Override
	public String documentType() {
		return Description.List.create()
			.prefix(Description.ofFields("List of ", Material.class) + " or a list of the following prepended by '#':")
			.withOr()
			.build(
				Description.ofFields(MaterialTags.class),
				Description.hyperlink("Block tag", "https://minecraft.wiki/w/Block_tag_(Java_Edition)"),
				Description.hyperlink("Item tag", "https://minecraft.wiki/w/Item_tag_(Java_Edition)")
			);
	}

	public static class ItemLike {

		private Material material;
		private VanillaTag vanillaTag;
		private Tag<Material> paperTag;

		public ItemLike(@NotNull Material material) {
			this.material = material;
		}

		public ItemLike(@NotNull Tag<Material> paperTag) {
			this.paperTag = paperTag;
		}

		/**
		 * @param stringKey Provide tag key as string, so that it's available when not bootstrapped (when generating docs).
		 */
		public ItemLike(@NotNull TagKey<Item> tagKey, @NotNull String stringKey) {
			this.vanillaTag = new VanillaTag(tagKey, stringKey);
		}

		public Collection<Material> getMaterials() {
			if (material != null) return List.of(material);
			if (paperTag != null) return paperTag.getValues();
			if (vanillaTag != null) return vanillaTag.asPaper().getValues();
			return List.of();
		}

		@Override
		public String toString() {
			if (material != null) return material.name();
			if (vanillaTag != null) return "#" + vanillaTag.stringKey();
			if (paperTag != null) return "#" + paperTag.key().asMinimalString();
			return "Unknown";
		}

	}

	private record VanillaTag(TagKey<Item> tagKey, String stringKey) {

		public Tag<Material> asPaper() {
			return new CraftItemTag(BuiltInRegistries.ITEM, tagKey);
		}

	}

}
