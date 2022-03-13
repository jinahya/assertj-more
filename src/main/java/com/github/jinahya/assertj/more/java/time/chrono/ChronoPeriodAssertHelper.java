package com.github.jinahya.assertj.more.java.time.chrono;

import org.assertj.core.api.Assert;

import java.time.chrono.ChronoPeriod;
import java.util.function.Function;

public final class ChronoPeriodAssertHelper {

    // ------------------------------------------------------------------------------------------- multipliedBy(I)ACTUAL
    @SuppressWarnings({"unchecked"})
    private static <ACTUAL extends ChronoPeriod> ACTUAL multipliedBy(final ACTUAL actual, final int scalar) {
        try {
            return (ACTUAL) ChronoPeriod.class.getMethod("multipliedBy", int.class)
                    .invoke(actual, scalar);
        } catch (final ReflectiveOperationException roe) {
            throw new RuntimeException(roe);
        }
    }

    public static <SELF extends Assert<SELF, ACTUAL>, ACTUAL extends ChronoPeriod, R> R multipliedBy(
            final SELF assertion,
            final ACTUAL actual,
            final int scalar,
            final Function<? super SELF, ? extends Function<? super ACTUAL, ? extends R>> function) {
        return function.apply(assertion.isNotNull())
                .apply(multipliedBy(actual, scalar));
    }

    // -----------------------------------------------------------------------------------------------------------------
    private ChronoPeriodAssertHelper() {
        throw new AssertionError("instantiation is not allowed");
    }
}
