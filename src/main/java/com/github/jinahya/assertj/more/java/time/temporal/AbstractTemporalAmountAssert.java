package com.github.jinahya.assertj.more.java.time.temporal;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.AbstractLongAssert;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ListAssert;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.LongFunction;

/**
 * An abstract assert class for verifying values of {@link TemporalAmount}.
 *
 * @param <SELF>   self type parameter.
 * @param <ACTUAL> actual type parameter.
 * @author Jin Kwon &lt;onacit_at_wemakeprice.com&gt;
 */
public abstract class AbstractTemporalAmountAssert<
        SELF extends AbstractTemporalAmountAssert<SELF, ACTUAL>,
        ACTUAL extends TemporalAmount
        >
        extends AbstractAssert<SELF, ACTUAL> {

    /**
     * Creates a new instance with specified actual value and self type.
     *
     * @param actual   the actual value to verify.
     * @param selfType the self type.
     */
    protected AbstractTemporalAmountAssert(final ACTUAL actual, final Class<?> selfType) {
        super(actual, selfType);
    }

    // ----------------------------------------------------------------------------------------- addTo(Temporal)Temporal
    protected <R> R addTo(final Temporal temporal,
                          final Function<? super SELF, ? extends Function<? super Temporal, ? extends R>> function) {
        return function.apply(isNotNull())
                .apply(actual.addTo(temporal));
    }

//    public AbstractTemporalAssert<?, Temporal> extractingAddTo(final Temporal temporal) {
//        return addTo(temporal, s -> DefaultMoreTemporalAssert::new);
//    }

    // -----------------------------------------------------------------------------------------------get(TemporalUnit)J
    protected <R> R get(final TemporalUnit unit,
                        final Function<? super SELF, ? extends LongFunction<? extends R>> function) {
        return function.apply(isNotNull())
                .apply(actual.get(unit));
    }

    public AbstractLongAssert<?> extracting(final TemporalUnit unit) {
        return get(unit, s -> Assertions::assertThat);
    }

    // ------------------------------------------------------------------------------------ getUnits()List<TemporalUnit>
    protected <R> R getUnits(
            final Function<? super SELF, ? extends Function<? super List<TemporalUnit>, ? extends R>> function) {
        Objects.requireNonNull(function, "function is null");
        return function.apply(isNotNull())
                .apply(actual.getUnits());
    }

    public ListAssert<TemporalUnit> extractingUnits() {
        return getUnits(s -> Assertions::assertThat);
    }

    // ---------------------------------------------------------------------------------- subtractFrom(Temporal)Temporal
    protected <R> R subtractFrom(
            final Temporal temporal,
            final Function<? super SELF, ? extends Function<? super Temporal, ? extends R>> function) {
        Objects.requireNonNull(function, "function is null");
        return function.apply(isNotNull())
                .apply(actual.subtractFrom(temporal));
    }

//    public AbstractTemporalAssert<?, Temporal> extractingSubtractFrom(final Temporal temporal) {
//        return subtractFrom(temporal, s -> DefaultMoreTemporalAssert::new);
//    }
}
