package com.github.jinahya.assertj.more.java.time.chrono;

import org.assertj.core.api.Assert;

import java.time.chrono.ChronoPeriod;
import java.time.temporal.TemporalAmount;

class MoreChronoPeriodAssertImpl
        extends AbstractMoreChronoPeriodAssert<MoreChronoPeriodAssertImpl, ChronoPeriod> {

    MoreChronoPeriodAssertImpl(final ChronoPeriod actual) {
        super(actual, MoreChronoPeriodAssertImpl.class);
    }

    @Override
    public Assert<?, ChronoPeriod> extractingPlus(TemporalAmount amountToAdd) {
        return null;
    }

    @Override
    public Assert<?, ChronoPeriod> extractingMinus(TemporalAmount amountToSubtract) {
        return null;
    }

    @Override
    public Assert<?, ChronoPeriod> extractingMultipliedBy(int scalar) {
        return null;
    }

    @Override
    public Assert<?, ChronoPeriod> extractingNegated() {
        return null;
    }

    @Override
    public Assert<?, ChronoPeriod> extractingNormalized() {
        return null;
    }
}
