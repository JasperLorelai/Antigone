package eu.jasperlorelai.antigone.nms.shared.util;

import org.jetbrains.annotations.Nullable;

public record Default<D>(@Nullable D value, @Nullable String description) {

	public Default(@Nullable D value) {
		this(value, null);
	}

}
