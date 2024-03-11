package eu.jasperlorelai.antigone.nms.shared.parameters.mob;

import org.bukkit.entity.Mob;

@FunctionalInterface
public interface MobConverter<T> {

	T fromBukkit(Mob mob);

}
