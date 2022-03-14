package com.github.jinahya.assertj.more.java.time.chrono;

import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAmountAssert;
import org.assertj.core.api.AbstractBooleanAssert;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;

import java.time.chrono.ChronoPeriod;
import java.time.chrono.Chronology;
import java.time.temporal.TemporalAmount;

/**
 * An interface for verifying values of {@link ChronoPeriod} interface.
 *
 * @param <SELF>   self type parameter
 * @param <ACTUAL> actual type parameter
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
public interface MoreChronoPeriodAssert<
        SELF extends MoreChronoPeriodAssert<SELF, ACTUAL>,
        ACTUAL extends ChronoPeriod>
        extends MoreJavaTimeChronoAssert<SELF, ACTUAL>,
                MoreTemporalAmountAssert<SELF, ACTUAL> {

    // --------------------------------------------------------------------------------------- getChronology()Chronology
    default AbstractMoreChronologyAssert<?, Chronology> extractingChronology() {
        return MoreChronoPeriodAssertHelper.getChronology((SELF) this, s -> MoreChronologyAssertImpl::new);
    }

    // ------------------------------------------------------------------------------------------------------- isZero()Z
    default AbstractBooleanAssert<?> extractingIsZero() {
        return MoreChronoPeriodAssertHelper.isZero((SELF) this, s -> Assertions::assertThat);
    }

    default SELF isZero() {
        return MoreChronoPeriodAssertHelper.isZero((SELF) this, s -> r -> {
            Assertions.assertThat(r).isTrue();
            return s;
        });
    }

    default SELF isNotZero() {
        return MoreChronoPeriodAssertHelper.isZero((SELF) this, s -> r -> {
            Assertions.assertThat(r).isFalse();
            return s;
        });
    }

    // --------------------------------------------------------------------------------------------------- isNegative()Z
    default AbstractBooleanAssert<?> extractingIsNegative() {
        return MoreChronoPeriodAssertHelper.isNegative((SELF) this, s -> Assertions::assertThat);
    }

    /**
     * Verifies that {@code actual#isNegative} returns {@code true}.
     *
     * @return this assertion.
     */
    default SELF isNegative() {
        return MoreChronoPeriodAssertHelper.isNegative((SELF) this, s -> r -> {
            Assertions.assertThat(r).isTrue();
            return s;
        });
    }

    /**
     * Verifies that {@code actual#isNegative} returns {@code false}.
     *
     * @return this assertion.
     */
    default SELF isNotNegative() {
        return MoreChronoPeriodAssertHelper.isNegative((SELF) this, s -> r -> {
            Assertions.assertThat(r).isFalse();
            return s;
        });
    }

    // -------------------------------------------------------------------------------- plus(TemporalAmount)ChronoPeriod
    Assert<?, ACTUAL> extractingPlus(TemporalAmount amountToAdd);

    default Assert<?, ACTUAL> asAddedBy(final TemporalAmount amountToAdd) {
        return extractingPlus(amountToAdd);
    }

    // ------------------------------------------------------------------------------- minus(TemporalAmount)ChronoPeriod
    Assert<?, ACTUAL> extractingMinus(TemporalAmount amountToSubtract);

    default Assert<?, ACTUAL> asSubtractedBy(final TemporalAmount amountToSubtract) {
        return extractingMinus(amountToSubtract);
    }

    // ------------------------------------------------------------------------------------- multipliedBy(I)ChronoPeriod
    Assert<?, ACTUAL> extractingMultipliedBy(int scalar);

    default Assert<?, ACTUAL> asMultipliedBy(final int scalar) {
        return extractingMultipliedBy(scalar);
    }

    // ------------------------------------------------------------------------------------------- negated()ChronoPeriod
    Assert<?, ACTUAL> extractingNegated();

    default Assert<?, ACTUAL> asNegated() {
        return extractingNegated();
    }

    // ---------------------------------------------------------------------------------------- normalized()ChronoPeriod
    Assert<?, ACTUAL> extractingNormalized();

    default Assert<?, ACTUAL> asNormalized() {
        return extractingNormalized();
    }
}
