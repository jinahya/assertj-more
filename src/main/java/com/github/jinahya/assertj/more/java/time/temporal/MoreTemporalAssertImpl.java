package com.github.jinahya.assertj.more.java.time.temporal;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;

class MoreTemporalAssertImpl
        extends AbstractMoreTemporalAssert<MoreTemporalAssertImpl, Temporal> {

    MoreTemporalAssertImpl(final Temporal actual) {
        super(actual, MoreTemporalAssertImpl.class);
    }

    @Override
    public MoreTemporalAssert extractingMinus(long amountToSubtract, TemporalUnit unit) {
        return null;
    }

    @Override
    public MoreTemporalAssert<?, Temporal> extractingMinus(TemporalAmount amount) {
        return null;
    }

    @Override
    public MoreTemporalAssert<?, Temporal> extractingPlus(long amountToAdd, TemporalUnit unit) {
        return null;
    }

    @Override
    public MoreTemporalAssert<?, Temporal> extractingPlus(TemporalAmount amount) {
        return null;
    }

    @Override
    public MoreTemporalAssert<?, ? extends Temporal> with(TemporalAdjuster adjuster) {
        return null;
    }

    @Override
    public MoreTemporalAssert<?, ? extends Temporal> with(TemporalField field, long newValue) {
        return null;
    }

//    @Override
//    protected Temporal parse(String temporalAsString) {
//        return null;
//    }
}
