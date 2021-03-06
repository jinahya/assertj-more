package com.github.jinahya.assertj.more.hidden;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

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
    public static <S extends Assert<?, ?>> S assertActualIsNotNull(final S self) {
        Objects.requireNonNull(self, "self is null");
        // https://github.com/assertj/assertj-core/issues/1652#issuecomment-1061246488
        final List<S> results = new ArrayList<>(1);
        Assertions.assertThatCode(() -> results.add((S) HANDLE_IS_NOT_NULL.invoke(self)))
                .doesNotThrowAnyException();
        return results.get(0);
    }

    @SuppressWarnings({"unchecked"})
    public static <S extends Assert<?, A>, A> A getActual(final S self) {
        Objects.requireNonNull(self, "self is null");
        if (self instanceof AbstractAssert) {
            return ForAbstractAssert.getActual((AbstractAssert<?, ? extends A>) self);
        }
        throw new RuntimeException("unable to get actual from " + self);
    }

    public static <S extends Assert<?, A>, A, R> R applyActual1(
            final S self, final Function<? super A, ? extends R> function) {
        Objects.requireNonNull(self, "self is null");
        Objects.requireNonNull(function, "function is null");
        final A actual = getActual(self);
        return function.apply(actual);
    }

    public static <S extends Assert<?, A>, A, R> R applyActual2(
            final S self, final Function<? super S, ? extends Function<? super A, ? extends R>> function) {
        Objects.requireNonNull(self, "self is null");
        Objects.requireNonNull(function, "function is null");
        final A actual = getActual(self);
        return function.apply(self)
                .apply(actual);
    }

    public static <S extends Assert<?, A>, A, R> R applyNonNullActual1(
            final S self, final Function<? super A, ? extends R> function) {
        Objects.requireNonNull(function, "function is null");
        return applyActual1(self, a -> function.apply(Objects.requireNonNull(a, "actual is null")));
    }

    public static <S extends Assert<?, A>, A, R> R applyNonNullActual2(
            final S self, final Function<? super S, ? extends Function<? super A, ? extends R>> function) {
        Objects.requireNonNull(function, "function is null");
        return applyActual2(self, s -> a -> function.apply(s).apply(Objects.requireNonNull(a, "actual is null")));
    }

    public static <S extends Assert<?, A>, A, R> R assertActualIsNotNullAndApply(
            final S self,
            final Function<? super A, ? extends R> function) {
        final A actual = getActual(self);
        Assertions.assertThat(actual).isNotNull();
        return function.apply(actual);
    }

    public static <S extends Assert<?, A>, A, R> R assertActualIsNotNullAndApply2(
            final S self,
            final Function<? super S, ? extends Function<? super A, ? extends R>> function) {
        final A actual = getActual(self);
        Assertions.assertThat(actual).isNotNull().extracting(a -> {
            return function.apply(self).apply(a);
        });
        return function.apply(self).apply(actual);
    }

    private ForAssert() {
        throw new AssertionError("instantiation is not allowed");
    }
}
