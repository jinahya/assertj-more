package com.github.jinahya.assertj.more.java.time.temporal;

import com.github.jinahya.assertj.more.hidden.ForAssert;
import com.github.jinahya.assertj.more.java.time.chrono.MoreChronoLocalDateAssertHelper;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.function.Function;
import java.util.function.IntFunction;

final class MoreLocalDateAssertHelper {

    // ---------------------------------------------------------------------------------- atTime(LocalDate)LocalDateTime
    static <S extends MoreLocalDateAssert<S>, R> R atTime(
            final LocalTime localTime, final S self,
            final Function<? super S, ? extends Function<? super LocalDateTime, ? extends R>> function) {
        return MoreChronoLocalDateAssertHelper.atTime(
                localTime, self, s -> r -> function.apply(s).apply((LocalDateTime) r));
    }

    static <S extends MoreLocalDateAssert<S>, R> R getYear(
            final S self, final Function<? super S, ? extends IntFunction<? extends R>> function) {
        return function.apply(ForAssert.assertActualIsNotNull(self))
                .apply(ForAssert.getActual(self).getYear());
    }

    static <S extends MoreLocalDateAssert<S>, R> R getMonthValue(
            final S self, final Function<? super S, ? extends IntFunction<? extends R>> function) {
        return function.apply(ForAssert.assertActualIsNotNull(self))
                .apply(ForAssert.getActual(self).getMonthValue());
    }

    static <S extends MoreLocalDateAssert<S>, R> R getMonth(
            final S self, final Function<? super S, ? extends Function<? super Month, ? extends R>> function) {
        return function.apply(ForAssert.assertActualIsNotNull(self))
                .apply(ForAssert.getActual(self).getMonth());
    }

    static <S extends MoreLocalDateAssert<S>, R> R getDayOfMonth(
            final S self, final Function<? super S, ? extends IntFunction<? extends R>> function) {
        return function.apply(ForAssert.assertActualIsNotNull(self))
                .apply(ForAssert.getActual(self).getDayOfMonth());
    }

    private MoreLocalDateAssertHelper() {
        throw new AssertionError("instantiation is not allowed");
    }
}
