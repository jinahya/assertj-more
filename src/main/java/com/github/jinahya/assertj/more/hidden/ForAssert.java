package com.github.jinahya.assertj.more.hidden;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assert;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.util.Objects;

public final class ForAssert {

    private static final Method METHOD_IS_NOT_NULL;

    private static final MethodHandle HANDLE_IS_NOT_NULL;

    static {
        try {
            METHOD_IS_NOT_NULL = Assert.class.getMethod("isNotNull");
            HANDLE_IS_NOT_NULL = MethodHandles.lookup().unreflect(METHOD_IS_NOT_NULL);
        } catch (final ReflectiveOperationException roe) {
            throw new RuntimeException(roe);
        }
    }

    @SuppressWarnings({"unchecked"})
    public static <SELF extends Assert<?, ?>> SELF invokeIsNotNull(final SELF self) {
        Objects.requireNonNull(self, "self is null");
        try {
            return (SELF) HANDLE_IS_NOT_NULL.invoke(self);
        } catch (final Throwable t) {
            throw new RuntimeException(t);
        }
    }

    @SuppressWarnings({"unchecked"})
    public static <SELF extends Assert<?, ACTUAL>, ACTUAL> ACTUAL getActual(final SELF self) {
        Objects.requireNonNull(self, "self is null");
        if (self instanceof AbstractAssert) {
            return ForAbstractAssert.getActual((AbstractAssert<?, ? extends ACTUAL>) self);
        }
        throw new RuntimeException("unable to get actual from " + self);
    }

    private ForAssert() {
        throw new AssertionError("instantiation is not allowed");
    }
}
