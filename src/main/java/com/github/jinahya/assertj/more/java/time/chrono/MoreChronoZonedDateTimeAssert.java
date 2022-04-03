package com.github.jinahya.assertj.more.java.time.chrono;

import com.github.jinahya.assertj.more.api.ComparableAssertProxy;
import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAccessorAssert;
import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAssert;

import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoZonedDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;

public interface MoreChronoZonedDateTimeAssert<
        S extends MoreChronoZonedDateTimeAssert<S, A, D>,
        A extends ChronoZonedDateTime<D>,
        D extends ChronoLocalDate>
        extends MoreJavaTimeChronoAssert<S, A>,
                ComparableAssertProxy<S, ChronoZonedDateTime<?>>,
                MoreTemporalAssert<S, A>,
                MoreTemporalAccessorAssert<S, A> {

    @Override
    MoreChronoZonedDateTimeAssert<?, A, D> extractingMinus(long amountToSubtract, TemporalUnit unit);

    @Override
    MoreChronoZonedDateTimeAssert<?, A, D> extractingMinus(TemporalAmount amount);

    @Override
    MoreChronoZonedDateTimeAssert<?, A, D> extractingPlus(long amountToAdd, TemporalUnit unit);

    @Override
    MoreChronoZonedDateTimeAssert<?, A, D> extractingPlus(TemporalAmount amount);

    @Override
    MoreChronoZonedDateTimeAssert<?, ? extends A, D> extractingWith(TemporalAdjuster adjuster);

    @Override
    MoreChronoZonedDateTimeAssert<?, ? extends A, D> extractingWith(TemporalField field, long newValue);
}
