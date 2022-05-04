package com.github.jinahya.assertj.more.java.lang.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

final class ModifiersAssertible {

    static int getModifiers(final Object obj) {
        Objects.requireNonNull(obj, "obj is null");
        for (Class<?> c = obj.getClass(); c != null; c = c.getSuperclass()) {
            final Method method;
            try {
                method = c.getMethod("getModifiers");
            } catch (final NoSuchMethodException nsme) {
                continue;
            }
            try {
                return (int) method.invoke(obj);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
        throw new RuntimeException("unable to get modifiers from " + obj);
    }

    private ModifiersAssertible() {
        throw new AssertionError("instantiation is not allowed");
    }
}
