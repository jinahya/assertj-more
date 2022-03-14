package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.java.time.chrono.MoreChronoPeriodAssert;

import java.time.Period;
import java.time.temporal.TemporalAmount;

public interface MorePeriodAssert<SELF extends MorePeriodAssert<SELF>>
        extends MoreJavaTimeAssert<SELF, Period>,
                MoreChronoPeriodAssert<SELF, Period> {

    @Override
    default AbstractMorePeriodAssert<?> extractingPlus(final TemporalAmount amountToAdd) {
        return MorePeriodAssertHelper.plus(amountToAdd, (SELF) this, s -> MorePeriodAssertImpl::new);
    }

    @Override
    default AbstractMorePeriodAssert<?> asAddedBy(final TemporalAmount amountToAdd) {
        return (AbstractMorePeriodAssert<?>) MoreChronoPeriodAssert.super.asAddedBy(amountToAdd);
    }

    @Override
    default AbstractMorePeriodAssert<?> extractingMinus(final TemporalAmount amountToSubtract) {
        return MorePeriodAssertHelper.minus(amountToSubtract, (SELF) this, s -> MorePeriodAssertImpl::new);
    }

    @Override
    default AbstractMorePeriodAssert<?> asSubtractedBy(final TemporalAmount amountToAdd) {
        return (AbstractMorePeriodAssert<?>) MoreChronoPeriodAssert.super.asSubtractedBy(amountToAdd);
    }

    @Override
    default AbstractMorePeriodAssert<?> extractingMultipliedBy(final int scalar) {
        return MorePeriodAssertHelper.multipliedBy(scalar, (SELF) this, s -> MorePeriodAssertImpl::new);
    }

    @Override
    default AbstractMorePeriodAssert<?> asMultipliedBy(final int scalar) {
        return (AbstractMorePeriodAssert<?>) MoreChronoPeriodAssert.super.asMultipliedBy(scalar);
    }

    // ------------------------------------------------------------------------------------------------- negated()Period
    @Override
    default AbstractMorePeriodAssert<?> extractingNegated() {
        return MorePeriodAssertHelper.negated((SELF) this, s -> MorePeriodAssertImpl::new);
    }

    @Override
    default AbstractMorePeriodAssert<?> asNegated() {
        return (AbstractMorePeriodAssert<?>) MoreChronoPeriodAssert.super.asNegated();
    }

    // ---------------------------------------------------------------------------------------------- normalized()Period
    @Override
    default AbstractMorePeriodAssert<?> extractingNormalized() {
        return MorePeriodAssertHelper.normalized((SELF) this, s -> MorePeriodAssertImpl::new);
    }

    @Override
    default AbstractMorePeriodAssert<?> asNormalized() {
        return (AbstractMorePeriodAssert<?>) MoreChronoPeriodAssert.super.asNormalized();
    }
}
