package com.arangodb.entity;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Mr.Tang on 2021/10/19 14:07.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface DocumentField {

    DocumentField.Type value();

    public static enum Type {
        ID("_id"),
        KEY("_key"),
        REV("_rev"),
        FROM("_from"),
        TO("_to");

        private final String serializeName;

        private Type(String serializeName) {
            this.serializeName = serializeName;
        }

        public String getSerializeName() {
            return this.serializeName;
        }
    }
}
