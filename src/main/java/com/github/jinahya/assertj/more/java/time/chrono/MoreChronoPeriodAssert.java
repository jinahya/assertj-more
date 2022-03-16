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
 * @param <S>   self type parameter
 * @param <A> actual type parameter
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
public interface MoreChronoPeriodAssert<
        S extends MoreChronoPeriodAssert<S, A>,
        A extends ChronoPeriod>
        extends MoreJavaTimeChronoAssert<S, A>,
                MoreTemporalAmountAssert<S, A> {

    // --------------------------------------------------------------------------------------- getChronology()Chronology
    default AbstractMoreChronologyAssert<?, Chronology> extractingChronology() {
        return MoreChronoPeriodAssertHelper.getChronology((S) this, s -> MoreChronologyAssertImpl::new);
    }

    // ------------------------------------------------------------------------------------------------------- isZero()Z
    default AbstractBooleanAssert<?> extractingIsZero() {
        return MoreChronoPeriodAssertHelper.isZero((S) this, s -> Assertions::assertThat);
    }

    default S isZero() {
        return MoreChronoPeriodAssertHelper.isZero((S) this, s -> r -> {
            Assertions.assertThat(r).isTrue();
            return s;
        });
    }

    default S isNotZero() {
        return MoreChronoPeriodAssertHelper.isZero((S) this, s -> r -> {
            Assertions.assertThat(r).isFalse();
            return s;
        });
    }

    // --------------------------------------------------------------------------------------------------- isNegative()Z
    default AbstractBooleanAssert<?> extractingIsNegative() {
        return MoreChronoPeriodAssertHelper.isNegative((S) this, s -> Assertions::assertThat);
    }

    /**
     * Verifies that {@code actual#isNegative} returns {@code true}.
     *
     * @return this assertion.
     */
    default S isNegative() {
        return MoreChronoPeriodAssertHelper.isNegative((S) this, s -> r -> {
            Assertions.assertThat(r).isTrue();
            return s;
        });
    }

    /**
     * Verifies that {@code actual#isNegative} returns {@code false}.
     *
     * @return this assertion.
     */
    default S isNotNegative() {
        return MoreChronoPeriodAssertHelper.isNegative((S) this, s -> r -> {
            Assertions.assertThat(r).isFalse();
            return s;
        });
    }

    // -------------------------------------------------------------------------------- plus(TemporalAmount)ChronoPeriod
    Assert<?, A> extractingPlus(TemporalAmount amountToAdd);

    default Assert<?, A> asAddedBy(final TemporalAmount amountToAdd) {
        return extractingPlus(amountToAdd);
    }

    // ------------------------------------------------------------------------------- minus(TemporalAmount)ChronoPeriod
    Assert<?, A> extractingMinus(TemporalAmount amountToSubtract);

    default Assert<?, A> asSubtractedBy(final TemporalAmount amountToSubtract) {
        return extractingMinus(amountToSubtract);
    }

    // ------------------------------------------------------------------------------------- multipliedBy(I)ChronoPeriod
    Assert<?, A> extractingMultipliedBy(int scalar);

    default Assert<?, A> asMultipliedBy(final int scalar) {
        return extractingMultipliedBy(scalar);
    }

    // ------------------------------------------------------------------------------------------- negated()ChronoPeriod
    Assert<?, A> extractingNegated();

    default Assert<?, A> asNegated() {
        return extractingNegated();
    }

    // ---------------------------------------------------------------------------------------- normalized()ChronoPeriod
    Assert<?, A> extractingNormalized();

    default Assert<?, A> asNormalized() {
        return extractingNormalized();
    }
}
