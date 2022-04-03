package com.github.jinahya.assertj.more.java.time.chrono;

import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAdjusterAssert;
import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAssert;
import org.assertj.core.api.ComparableAssert;

import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;

public interface MoreChronoLocalDateTimeAssert<
        S extends MoreChronoLocalDateTimeAssert<S, A, D>,
        A extends ChronoLocalDateTime<D>,
        D extends ChronoLocalDate>
        extends MoreJavaTimeChronoAssert<S, A>,
                ComparableAssert<S, A>,
                MoreTemporalAssert<S, A>,
                MoreTemporalAdjusterAssert<S, A> {

    @Override
    MoreChronoLocalDateTimeAssert<?, A, D> extractingMinus(long amountToSubtract, TemporalUnit unit);

    @Override
    MoreChronoLocalDateTimeAssert<?, A, D> extractingMinus(TemporalAmount amount);

    @Override
    MoreChronoLocalDateTimeAssert<?, A, D> extractingPlus(long amountToAdd, TemporalUnit unit);

    @Override
    MoreChronoLocalDateTimeAssert<?, A, D> extractingPlus(TemporalAmount amount);

    @Override
    MoreChronoLocalDateTimeAssert<?, A, D> extractingWith(TemporalAdjuster adjuster);

    @Override
    MoreChronoLocalDateTimeAssert<?, A, D> extractingWith(TemporalField field, long newValue);
}
