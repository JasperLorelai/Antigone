package eu.jasperlorelai.antigone.nms.shared.util;

import java.util.Collection;
import java.lang.reflect.Array;
import java.util.function.Function;

import org.jetbrains.annotations.NotNull;

public final class Description {

	private static final String JD_URL = "https://jasperlorelai.eu/paperdocs/";

	private static String docsLink(@NotNull Class<?> clazz, @NotNull String urlSuffix) {
		return hyperlink(ofClass(clazz), JD_URL + urlSuffix + ".html");
	}

	private static String dotsToSlashes(@NotNull String string) {
		return string.replaceAll("\\.", "/");
	}

	public static String hyperlink(@NotNull String text, @NotNull String url) {
		return "[" + text + "](" + url + ")";
	}

	public static String ofClass(@NotNull Class<?> bukkitClass) {
		return bukkitClass.getSimpleName().replaceAll("([a-z])([A-Z])", "$1 $2");
	}

	public static String ofFields(@NotNull String prefix, @NotNull Class<?> bukkitClass) {
		return prefix + ofFields(bukkitClass);
	}

	public static String ofFields(@NotNull Class<?> bukkitClass) {
		return docsLink(bukkitClass, dotsToSlashes(bukkitClass.getName()) + ".html");
	}

	public static String ofEntityInterface(@NotNull String prefix, @NotNull Class<?> bukkitClass) {
		return prefix + ofEntityInterface(bukkitClass);
	}

	public static String ofEntityInterface(@NotNull Class<?> bukkitClass) {
		return docsLink(bukkitClass, "org.bukkit.entity/" + dotsToSlashes(bukkitClass.getName()).replaceAll("(.*/)(\\w+)", "$1class-use/$2"));
	}

	public static String ofEnum(@NotNull String prefix, @NotNull Class<?> bukkitEnum) {
		return prefix + ofEnum(bukkitEnum);
	}

	public static String ofEnum(@NotNull Class<?> bukkitEnum) {
		return docsLink(bukkitEnum, dotsToSlashes(bukkitEnum.getName()));
	}

	public static class List {

		private String prefix;
		private Conjunction conjunction;

		private List() {}

		public static List create() {
			return new List();
		}

		public List prefix(String prefix) {
			this.prefix = prefix;
			return this;
		}

		public List withAnd() {
			this.conjunction = Conjunction.AND;
			return this;
		}

		public List withOr() {
			this.conjunction = Conjunction.OR;
			return this;
		}

		public <E extends Enum<E>> String build(Collection<E> objects, Class<E> clazz) {
			return build(objects, clazz, e -> e.name().toLowerCase());
		}

		@SuppressWarnings("unchecked")
		public <T> String build(Collection<T> objects, Class<T> clazz, Function<T, String> toString) {
			T[] array = (T[]) Array.newInstance(clazz, objects.size());
			return build(objects.toArray(array), toString);
		}

		public String build(Collection<String> objects) {
			return build(objects.toArray(new String[0]));
		}

		public String build(String ...objects) {
			return build(objects, Function.identity());
		}

		public <T> String build(T[] objects, Function<T, String> toString) {
			StringBuilder builder = new StringBuilder();
			if (prefix != null && !prefix.isBlank()) builder.append(prefix).append(" ");

			int length = objects.length;
			boolean oxford = conjunction == null || length > 2;

			for (int i = 0; i < length; i++) {
				if (i > 0) {
					if (oxford) builder.append(",");
					builder.append(" ");

					if (i == length - 1 && conjunction != null) {
						builder.append(conjunction.name().toLowerCase()).append(" ");
					}
				}
				builder.append(toString.apply(objects[i]));
			}

			return builder.toString();
		}

	}

	public enum Conjunction {
		AND,
		OR
	}

}
