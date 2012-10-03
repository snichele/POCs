package poc.jee6.skillz.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
/**
 * Utilisé dans le code pour annoter les entités avec une remarque concernant
 * l'IHM.
 */
public @interface UIHint {
    String value();
}