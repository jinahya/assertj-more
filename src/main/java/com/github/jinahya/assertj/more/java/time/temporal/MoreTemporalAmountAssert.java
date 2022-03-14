package com.github.jinahya.assertj.more.java.time.temporal;

import org.assertj.core.api.AbstractLongAssert;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ListAssert;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;

public interface MoreTemporalAmountAssert<
        SELF extends MoreTemporalAmountAssert<SELF, ACTUAL>,
        ACTUAL extends TemporalAmount>
        extends MoreJavaTimeTemporalAssert<SELF, ACTUAL> {

    // ----------------------------------------------------------------------------------------- addTo(Temporal)Temporal
    @SuppressWarnings({"unchecked"})
    default AbstractMoreTemporalAssert<?> extractingAddTo(final Temporal temporal) {
        return MoreTemporalAmountAssertHelper.addTo(temporal, (SELF) this, s -> MoreTemporalAssertImpl::new);
    }

    // ---------------------------------------------------------------------------------------------- get(TemporalUnit)J
    default AbstractLongAssert<?> extracting(final TemporalUnit unit) {
        return MoreTemporalAmountAssertHelper.get(unit, (SELF) this, s -> Assertions::assertThat);
    }

    // ------------------------------------------------------------------------------------ getUnits()List<TemporalUnit>
    default ListAssert<TemporalUnit> extractingUnits(final TemporalUnit unit) {
        return MoreTemporalAmountAssertHelper.getUnits(unit, (SELF) this, s -> Assertions::assertThat);
    }

    // ----------------------------------------------------------------------------------------- addTo(Temporal)Temporal
    @SuppressWarnings({"unchecked"})
    default AbstractMoreTemporalAssert<?> extractingSubtractTo(final Temporal temporal) {
        return MoreTemporalAmountAssertHelper.subtractFrom(temporal, (SELF) this, s -> MoreTemporalAssertImpl::new);
    }
}
