package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.java.time.chrono.AbstractMoreChronologyAssert;
import com.github.jinahya.assertj.more.java.time.chrono.ChronoPeriodAssertHelper;
import com.github.jinahya.assertj.more.java.time.chrono.MoreJavaTimeChronoAssertions;

import java.time.Period;
import java.time.chrono.Chronology;
import java.util.function.Function;

/**
 * An abstract assert class for verifying values of {@link Period}.
 *
 * @param <S> self type parameter.
 * @author Jin Kwon &lt;onacit_at_wemakeprice.com&gt;
 */
public abstract class AbstractPeriodAssert_<S extends AbstractPeriodAssert_<S>>
        extends AbstractTemporalAmountAssert_<S, Period> {

    /**
     * Creates a new instance with specified actual value and self type.
     *
     * @param actual   the actual value to verify.
     * @param selfType the self type.
     */
    protected AbstractPeriodAssert_(final Period actual, final Class<?> selfType) {
        super(actual, selfType, Period.class);
    }

    // --------------------------------------------------------------------------------------- getChronology()Chronology
    protected <R> R getChronology(
            final Function<? super S, ? extends Function<? super Chronology, ? extends R>> function) {
        return function.apply(isNotNull())
                .apply(actual.getChronology());
    }

    public AbstractMoreChronologyAssert<?, Chronology> extractingChronology() {
        return getChronology(s -> MoreJavaTimeChronoAssertions::assertMore);
    }

    // ------------------------------------------------------------------------------------------- multipliedBy(I)Period
    protected <R> R multipliedBy(
            final int scalar,
            final Function<? super S, ? extends Function<? super Period, ? extends R>> function) {
        return ChronoPeriodAssertHelper.multipliedBy(isNotNull(), actual, scalar, function);
    }
}
