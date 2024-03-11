package eu.jasperlorelai.antigone.nms.shared.util;

import java.util.function.Function;

import org.jetbrains.annotations.NotNull;

public final class Description {

	private static final String JD_URL = "https://jd.papermc.io/paper/1.20/";

	private static String paperJdLink(@NotNull Class<?> clazz, @NotNull String urlSuffix) {
		return hyperlink(ofClassName(clazz), JD_URL + urlSuffix);
	}

	private static String dotsToSlashes(@NotNull String string) {
		return string.replaceAll("\\.", "/");
	}

	public static String hyperlink(@NotNull String text, @NotNull String url) {
		return "[" + text + "](" + url + ")";
	}

	public static String ofClassName(@NotNull Class<?> bukkitClass) {
		return bukkitClass.getSimpleName().replaceAll("([a-z])([A-Z])", "$1 $2");
	}

	public static String ofFields(@NotNull String prefix, @NotNull Class<?> bukkitClass) {
		return prefix + ofFields(bukkitClass);
	}

	public static String ofFields(@NotNull Class<?> bukkitClass) {
		return paperJdLink(bukkitClass, dotsToSlashes(bukkitClass.getName()) + ".html#field-summary");
	}

	public static String ofEntityInterface(@NotNull String prefix, @NotNull Class<?> bukkitClass) {
		return prefix + ofEntityInterface(bukkitClass);
	}

	public static String ofEntityInterface(@NotNull Class<?> bukkitClass) {
		return paperJdLink(bukkitClass, dotsToSlashes(bukkitClass.getName()).replaceAll("(.*/)(\\w+)", "$1class-use/$2") + ".html#org.bukkit.entity");
	}

	public static String ofEnum(@NotNull String prefix, @NotNull Class<?> bukkitEnum) {
		return prefix + ofEnum(bukkitEnum);
	}

	public static String ofEnum(@NotNull Class<?> bukkitEnum) {
		return paperJdLink(bukkitEnum, dotsToSlashes(bukkitEnum.getName()) + ".html#enum-constant-summary");
	}

	public static String of(@NotNull Conjunction conjunction, @NotNull String... strings) {
		return of(conjunction, Function.identity(), strings);
	}

	public static String of(@NotNull String prefix, @NotNull Conjunction conjunction, @NotNull String ...strings) {
		return of(prefix, conjunction, Function.identity(), strings);
	}

	public static <T> String of(@NotNull Conjunction conjunction, @NotNull Function<T, String> toString, @NotNull T[] objects) {
		return of("", conjunction, toString, objects);
	}

	public static <T> String of(@NotNull String prefix, @NotNull Conjunction conjunction, @NotNull Function<T, String> toString, @NotNull T[] objects) {
		StringBuilder builder = new StringBuilder(prefix);
		for (int i = 0; i < objects.length; i++) {
			if (i > 0) {
				builder.append(", ");
				if (i == objects.length - 1) builder.append(conjunction);
			}
			builder.append(toString.apply(objects[i]));
		}
		return builder.toString();
	}

	public enum Conjunction {

		NONE(""),
		AND("and "),
		OR("or ")
		;

		private final String conjunction;

		Conjunction(String conjunction) {
			this.conjunction = conjunction;
		}

		public String get() {
			return conjunction;
		}

		@Override
		public String toString() {
			return conjunction;
		}

	}

}
