package com.github.jinahya.assertj.more.java.time.chrono;

import com.github.jinahya.assertj.more.hidden.ForAssert;
import org.assertj.core.api.Assert;

import java.time.chrono.ChronoPeriod;
import java.time.chrono.Chronology;
import java.util.function.Function;

class MoreChronoPeriodAssertHelper {

    // --------------------------------------------------------------------------------------- getChronology()Chronology
    static <SELF extends Assert<SELF, ACTUAL>, ACTUAL extends ChronoPeriod, R> R getChronology(
            final SELF self,
            final Function<? super SELF, ? extends Function<? super Chronology, ? extends R>> function) {
        return function.apply(ForAssert.invokeIsNotNull(self))
                .apply(ForAssert.getActual(self).getChronology());
    }

    // ------------------------------------------------------------------------------------------------------- isZero()Z
    static <SELF extends Assert<SELF, ACTUAL>, ACTUAL extends ChronoPeriod, R> R isZero(
            final SELF self,
            final Function<? super SELF, ? extends Function<? super Boolean, ? extends R>> function) {
        return function.apply(ForAssert.invokeIsNotNull(self))
                .apply(ForAssert.getActual(self).isZero());
    }

    // --------------------------------------------------------------------------------------------------- isNegative()Z
    static <SELF extends Assert<SELF, ACTUAL>, ACTUAL extends ChronoPeriod, R> R isNegative(
            final SELF self,
            final Function<? super SELF, ? extends Function<? super Boolean, ? extends R>> function) {
        return function.apply(ForAssert.invokeIsNotNull(self))
                .apply(ForAssert.getActual(self).isNegative());
    }

    protected MoreChronoPeriodAssertHelper() {
        super();
    }
}
