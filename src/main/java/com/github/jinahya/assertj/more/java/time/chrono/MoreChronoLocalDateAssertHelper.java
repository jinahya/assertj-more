package com.github.jinahya.assertj.more.java.time.chrono;

import com.github.jinahya.assertj.more.hidden.ForAssert;

import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.util.function.Function;

public final class MoreChronoLocalDateAssertHelper {

    public static <
            S extends MoreChronoLocalDateAssert<S, A>,
            A extends ChronoLocalDate,
            R>
    R atTime(final LocalTime localTime, final S self,
             final Function<? super S, ? extends Function<? super ChronoLocalDateTime<?>, ? extends R>> function) {
        return function.apply(ForAssert.assertActualIsNotNull(self))
                .apply(ForAssert.getActual(self).atTime(localTime));
    }

    private MoreChronoLocalDateAssertHelper() {
        throw new AssertionError("instantiation is not allowed");
    }
}
