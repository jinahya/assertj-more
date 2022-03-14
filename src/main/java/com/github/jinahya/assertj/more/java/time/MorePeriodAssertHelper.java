package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.hidden.ForAssert;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;

import java.time.Period;
import java.time.temporal.TemporalAmount;
import java.util.function.Function;

class MorePeriodAssertHelper {

    // -------------------------------------------------------------------------------------- plus(TemporalAmount)Period
    static <SELF extends Assert<SELF, ACTUAL>, ACTUAL extends Period, R> R plus(
            final TemporalAmount amountToAdd, SELF self,
            final Function<? super SELF, ? extends Function<? super Period, ? extends R>> function) {
        self = ForAssert.invokeIsNotNull(self);
        final ACTUAL actual = ForAssert.getActual(self);
        final Period[] results = new Period[1];
        Assertions.assertThatCode(() -> results[0] = actual.plus(amountToAdd))
                .doesNotThrowAnyException();
        return function.apply(self)
                .apply(results[0]);
    }

    // ------------------------------------------------------------------------------------- minus(TemporalAmount)Period
    static <SELF extends Assert<SELF, ACTUAL>, ACTUAL extends Period, R> R minus(
            final TemporalAmount amountToSubtract, SELF self,
            final Function<? super SELF, ? extends Function<? super Period, ? extends R>> function) {
        self = ForAssert.invokeIsNotNull(self);
        final ACTUAL actual = ForAssert.getActual(self);
        final Period[] results = new Period[1];
        Assertions.assertThatCode(() -> results[0] = actual.minus(amountToSubtract))
                .doesNotThrowAnyException();
        return function.apply(self)
                .apply(results[0]);
    }

    // ------------------------------------------------------------------------------------------- multipliedBy(I)Period
    static <SELF extends Assert<SELF, ACTUAL>, ACTUAL extends Period, R> R multipliedBy(
            final int scalar, SELF self,
            final Function<? super SELF, ? extends Function<? super Period, ? extends R>> function) {
        self = ForAssert.invokeIsNotNull(self);
        final ACTUAL actual = ForAssert.getActual(self);
        final Period[] results = new Period[1];
        Assertions.assertThatCode(() -> results[0] = actual.multipliedBy(scalar))
                .doesNotThrowAnyException();
        return function.apply(self)
                .apply(results[0]);
    }

    static <SELF extends Assert<SELF, ACTUAL>, ACTUAL extends Period, R> R negated(
            SELF self,
            final Function<? super SELF, ? extends Function<? super Period, ? extends R>> function) {
        self = ForAssert.invokeIsNotNull(self);
        final ACTUAL actual = ForAssert.getActual(self);
        final Period[] results = new Period[1];
        Assertions.assertThatCode(() -> results[0] = actual.negated())
                .doesNotThrowAnyException();
        return function.apply(self)
                .apply(results[0]);
    }

    static <SELF extends Assert<SELF, ACTUAL>, ACTUAL extends Period, R> R normalized(
            SELF self,
            final Function<? super SELF, ? extends Function<? super Period, ? extends R>> function) {
        self = ForAssert.invokeIsNotNull(self);
        final ACTUAL actual = ForAssert.getActual(self);
        final Period[] results = new Period[1];
        Assertions.assertThatCode(() -> results[0] = actual.normalized())
                .doesNotThrowAnyException();
        return function.apply(self)
                .apply(results[0]);
    }

    protected MorePeriodAssertHelper() {
        super();
    }
}
