package com.github.jinahya.assertj.more.java.time.temporal;

import com.github.jinahya.assertj.more.hidden.ForAssert;
import org.assertj.core.api.Assertions;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.function.Function;
import java.util.function.LongFunction;

final class MoreTemporalAmountAssertHelper {

    // ----------------------------------------------------------------------------------------- addTo(Temporal)Temporal
    static <SELF extends MoreTemporalAmountAssert<SELF, ACTUAL>, ACTUAL extends TemporalAmount, R> R addTo(
            final Temporal temporal, SELF self,
            final Function<? super SELF, ? extends Function<? super Temporal, ? extends R>> function) {
        // https://github.com/assertj/assertj-core/issues/1652#issuecomment-1061246488
        self = ForAssert.invokeIsNotNull(self);
        final ACTUAL actual = ForAssert.getActual(self);
        final Temporal[] results = new Temporal[1];
        Assertions.assertThatCode(() -> results[0] = actual.addTo(temporal))
                .describedAs("adding %1$s to %2$s", temporal, actual)
                .doesNotThrowAnyException();
        return function.apply(self).apply(results[0]);
    }

    // ---------------------------------------------------------------------------------------------- get(TemporalUnit)J
    static <SELF extends MoreTemporalAmountAssert<SELF, ACTUAL>, ACTUAL extends TemporalAmount, R> R get(
            final TemporalUnit unit, SELF self,
            final Function<? super SELF, ? extends LongFunction<? extends R>> function) {
        // https://github.com/assertj/assertj-core/issues/1652#issuecomment-1061246488
        self = ForAssert.invokeIsNotNull(self);
        final ACTUAL actual = ForAssert.getActual(self);
        final long[] results = new long[1];
        Assertions.assertThatCode(() -> results[0] = actual.get(unit))
                .describedAs("getting %1$s", unit)
                .doesNotThrowAnyException();
        return function.apply(self).apply(results[0]);
    }

    // ------------------------------------------------------------------------------------ getUnits()List<TemporalUnit>
    static <SELF extends MoreTemporalAmountAssert<SELF, ACTUAL>, ACTUAL extends TemporalAmount, R> R getUnits(
            final TemporalUnit unit, final SELF self,
            final Function<? super SELF, ? extends Function<? super List<TemporalUnit>, ? extends R>> function) {
        return function.apply(ForAssert.invokeIsNotNull(self))
                .apply(ForAssert.getActual(self).getUnits());
    }

    // ---------------------------------------------------------------------------------- subtractFrom(Temporal)Temporal
    static <SELF extends MoreTemporalAmountAssert<SELF, ACTUAL>, ACTUAL extends TemporalAmount, R> R subtractFrom(
            final Temporal temporal, SELF self,
            final Function<? super SELF, ? extends Function<? super Temporal, ? extends R>> function) {
        // https://github.com/assertj/assertj-core/issues/1652#issuecomment-1061246488
        self = ForAssert.invokeIsNotNull(self);
        final ACTUAL actual = ForAssert.getActual(self);
        final Temporal[] results = new Temporal[1];
        Assertions.assertThatCode(() -> results[0] = actual.subtractFrom(temporal))
                .describedAs("subtracting %1$s from %2$s", actual, temporal)
                .doesNotThrowAnyException();
        return function.apply(self).apply(results[0]);
    }

    private MoreTemporalAmountAssertHelper() {
        throw new AssertionError("instantiation is not allowed");
    }
}
