package eu.jasperlorelai.antigone.nms.shared.versioned;

import eu.jasperlorelai.antigone.nms.shared.util.Util;

public abstract class VersionedHolder<T> {

	private final String mcVersion;
	private final Class<T> superClass;

	public VersionedHolder(Class<T> superClass, String mcVersion) {
		this.mcVersion = mcVersion;
		this.superClass = superClass;
	}

	public T create() {
		try {
			Class<?> clazz = Class.forName(Util.getNMSPackage(mcVersion) + ".versioned." + superClass.getSimpleName() + "_" + Util.getNMSVersion(mcVersion));
			return superClass.cast(clazz.getDeclaredConstructor().newInstance());
		} catch (Throwable ignored) {}
		return null;
	}

}
