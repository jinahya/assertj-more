package com.github.jinahya.assertj.more.java.time.chrono;

import org.assertj.core.api.Assert;

import java.time.chrono.ChronoPeriod;
import java.util.function.Function;

public final class ChronoPeriodAssertHelper {

    // ------------------------------------------------------------------------------------------- multipliedBy(I)ACTUAL
    @SuppressWarnings({"unchecked"})
    private static <A extends ChronoPeriod> A multipliedBy(final A actual, final int scalar) {
        try {
            return (A) ChronoPeriod.class.getMethod("multipliedBy", int.class)
                    .invoke(actual, scalar);
        } catch (final ReflectiveOperationException roe) {
            throw new RuntimeException(roe);
        }
    }

    public static <S extends Assert<S, A>, A extends ChronoPeriod, R> R multipliedBy(
            final S assertion,
            final A actual,
            final int scalar,
            final Function<? super S, ? extends Function<? super A, ? extends R>> function) {
        return function.apply(assertion.isNotNull())
                .apply(multipliedBy(actual, scalar));
    }

    // -----------------------------------------------------------------------------------------------------------------
    private ChronoPeriodAssertHelper() {
        throw new AssertionError("instantiation is not allowed");
    }
}
