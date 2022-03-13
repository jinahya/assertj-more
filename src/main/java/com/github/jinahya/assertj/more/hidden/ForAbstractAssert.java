package com.github.jinahya.assertj.more.hidden;

import org.assertj.core.api.AbstractAssert;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

public final class ForAbstractAssert {

    private static final Field FIELD_ACTUAL;

    private static final MethodHandle HANDLE_ACTUAL;

    static {
        try {
            FIELD_ACTUAL = AbstractAssert.class.getDeclaredField("actual");
            FIELD_ACTUAL.setAccessible(true);
            HANDLE_ACTUAL = MethodHandles.lookup().unreflectGetter(FIELD_ACTUAL);
        } catch (final ReflectiveOperationException roe) {
            throw new InstantiationError(roe.getMessage());
        }
    }

    @SuppressWarnings({"unchecked"})
    public static <ACTUAL> ACTUAL getActual(final AbstractAssert<?, ACTUAL> self) {
        Objects.requireNonNull(self, "self is null");
        try {
            //return (ACTUAL) FIELD_ACTUAL.get(self);
            return (ACTUAL) HANDLE_ACTUAL.invoke(self);
        } catch (final Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private static final Method METHOD_FAILURE;

    private static final MethodHandle HANDLE_FAILURE;

    static {
        try {
            METHOD_FAILURE = AbstractAssert.class.getDeclaredMethod(
                    "failure", String.class, Object[].class);
            METHOD_FAILURE.setAccessible(true);
            HANDLE_FAILURE = MethodHandles.lookup().unreflect(METHOD_FAILURE);
        } catch (final ReflectiveOperationException roe) {
            throw new InstantiationError(roe.getMessage());
        }
    }

    public static AssertionError invokeFailure(final AbstractAssert<?, ?> self,
                                               final String errorMessage, final Object... arguments) {
        Objects.requireNonNull(self, "self is null");
        try {
            return (AssertionError) HANDLE_FAILURE
                    .bindTo(self)
                    .invokeExact(errorMessage, arguments);
        } catch (final Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private static final Method METHOD_FAIL_WITH_MESSAGE;

    private static final MethodHandle HANDLE_FAIL_WITH_MESSAGE;

    static {
        try {
            METHOD_FAIL_WITH_MESSAGE = AbstractAssert.class.getDeclaredMethod(
                    "failWithMessage", String.class, Object[].class);
            METHOD_FAIL_WITH_MESSAGE.setAccessible(true);
            HANDLE_FAIL_WITH_MESSAGE = MethodHandles.lookup().unreflect(METHOD_FAIL_WITH_MESSAGE);
        } catch (final ReflectiveOperationException roe) {
            throw new InstantiationError(roe.getMessage());
        }
    }

    public static void invokeFailWithMessage(final AbstractAssert<?, ?> self,
                                             final String errorMessage, final Object... arguments) {
        Objects.requireNonNull(self, "self is null");
        try {
            HANDLE_FAIL_WITH_MESSAGE
                    .bindTo(self)
                    .invokeExact(errorMessage, arguments);
        } catch (final Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private ForAbstractAssert() {
        throw new AssertionError("instantiation is not allowed");
    }
}
