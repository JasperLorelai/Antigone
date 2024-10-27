package eu.jasperlorelai.antigone.nms.shared.parameters.modifiers;

import org.bukkit.entity.Mob;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.BooleanSupplier;

import com.nisovin.magicspells.castmodifiers.ModifierSet;

import eu.jasperlorelai.antigone.nms.shared.util.Default;
import eu.jasperlorelai.antigone.nms.shared.util.ConfigKey;

public class BooleanSupplierParameter extends ModifierParameter<BooleanSupplier, BooleanSupplier> {

	public BooleanSupplierParameter(@NotNull @ConfigKey String name) {
		this(name, null);
	}

	public BooleanSupplierParameter(@NotNull @ConfigKey String name, @Nullable Default<BooleanSupplier> def) {
		super(name, BooleanSupplier.class, def);
	}

	@Override
	protected BooleanSupplier check(ModifierSet modifiers, Mob mob) {
		return () -> modifiers.check(mob);
	}

}
