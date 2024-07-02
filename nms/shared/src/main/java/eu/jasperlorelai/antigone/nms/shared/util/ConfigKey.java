package eu.jasperlorelai.antigone.nms.shared.util;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import org.intellij.lang.annotations.Pattern;

@Pattern("[a-z-]+")
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.PARAMETER})
public @interface ConfigKey {}
