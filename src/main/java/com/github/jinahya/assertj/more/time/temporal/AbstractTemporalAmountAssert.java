package com.github.jinahya.assertj.more.time.temporal;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.AbstractLongAssert;
import org.assertj.core.api.Assertions;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.LongFunction;

import static org.assertj.core.api.Assertions.assertThat;

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
        Objects.requireNonNull(function, "function is null");
        return function.apply(isNotNull())
                .apply(actual.addTo(temporal));
    }

    // -----------------------------------------------------------------------------------------------get(TemporalUnit)J
    protected <R> R get(final TemporalUnit unit,
                        final Function<? super SELF, ? extends LongFunction<? extends R>> function) {
        Objects.requireNonNull(function, "function is null");
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

//    public <E extends AbstractAssert<E, TemporalUnit>,
//            A extends AbstractListAssert<?, List<? extends TemporalUnit>, TemporalUnit, E>>
//    A extractingUnits(
//            final Function<? super List<? extends TemporalUnit>, ? extends A> function) {
//        return getUnits(s -> function);
//    }
//
//    public <E extends AbstractTemporalUnitAssert<E, TemporalUnit>>
//    AbstractListAssert<?, List<? extends TemporalUnit>, TemporalUnit, E>
//    extractingUnitsx(
//            final Function<? super List<? extends TemporalUnit>, ? extends E> function) {
//        return extractingUnits(v -> {
//           return Assertions.assertThat(v);
//        });
//    }

    public SELF unitsSatisfies(final Consumer<? super List<? extends TemporalUnit>> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        return getUnits(s -> v -> {
            assertThat(v).satisfies(consumer);
            return s;
        });
    }

    // ---------------------------------------------------------------------------------- subtractFrom(Temporal)Temporal
    protected <R> R subtractFrom(
            final Temporal temporal,
            final Function<? super SELF, ? extends Function<? super Temporal, ? extends R>> function) {
        Objects.requireNonNull(function, "function is null");
        return function.apply(isNotNull())
                .apply(actual.subtractFrom(temporal));
    }
}
