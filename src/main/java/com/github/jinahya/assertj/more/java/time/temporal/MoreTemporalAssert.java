package com.github.jinahya.assertj.more.java.time.temporal;

import com.github.jinahya.assertj.more.api.MoreAssertions;
import com.github.jinahya.assertj.more.hidden.ForAssert;
import org.assertj.core.api.AbstractLongAssert;
import org.assertj.core.api.Assertions;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;

/**
 * An abstract class for verifying instances of {@link Temporal} interface.
 *
 * @param <S> self type parameter
 * @param <A> actual type parameter
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
public interface MoreTemporalAssert<S extends MoreTemporalAssert<S, A>, A extends Temporal>
        extends MoreTemporalAccessorAssert<S, A> {

    default S supports(final TemporalUnit unit) {
        return ForAssert.applyActual2(isNotNull(), s -> a -> {
            Assertions.assertThat(a.isSupported(unit))
                    .isTrue();
            return s;
        });
    }

    default S doesNotSupport(final TemporalUnit unit) {
        return ForAssert.applyActual2(isNotNull(), s -> a -> {
            Assertions.assertThat(a.isSupported(unit))
                    .isFalse();
            return s;
        });
    }

    /**
     * Returns an assertion object for verifying the result of {@link Temporal#minus(long, TemporalUnit)} method invoked
     * on the {@code actual} with specified arguments.
     *
     * @param amountToSubtract a value for {@code amountToSubtract} argument.
     * @param unit             a value for {@code unit} argument.
     * @return an assertion object for verifying the result of {@code actual.minus(amountToSubtract, unit)}.
     * @see Temporal#minus(long, TemporalUnit)
     */
    MoreTemporalAssert<?, A> extractingMinus(long amountToSubtract, TemporalUnit unit);

    /**
     * Returns an assertion object for verifying the result of {@link Temporal#minus(TemporalAmount)} method invoked on
     * the {@code actual} with specified arguments.
     *
     * @param amount a value for {@code amount} argument.
     * @return an assertion object for verifying the result of {@code actual.minus(amount)}.
     * @see Temporal#minus(TemporalAmount)
     */
    MoreTemporalAssert<?, A> extractingMinus(TemporalAmount amount);

    /**
     * Returns an assertion object for verifying the result of {@link Temporal#plus(long, TemporalUnit)} method invoked
     * on the {@code actual} with specified arguments.
     *
     * @param amountToAdd a value for {@code amountToAdd} argument.
     * @param unit        a value for {@code unit} argument.
     * @return an assertion object for verifying the result of {@code actual.plus(amountToSubtract, unit)}.
     * @see Temporal#plus(long, TemporalUnit)
     */
    MoreTemporalAssert<?, A> extractingPlus(long amountToAdd, TemporalUnit unit);

    /**
     * Returns an assertion object for verifying the result of {@link Temporal#plus(TemporalAmount)} method invoked on
     * the {@code actual} with specified arguments.
     *
     * @param amount a value for {@code amount} argument.
     * @return an assertion object for verifying the result of {@code actual.plus(amount)}.
     * @see Temporal#plus(TemporalAmount)
     */
    MoreTemporalAssert<?, A> extractingPlus(TemporalAmount amount);

    default AbstractLongAssert<?> extractingUntil(final Temporal endExclusive, final TemporalUnit unit) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.until(endExclusive, unit),
                        Assertions::assertThat
                )
        );
    }

    MoreTemporalAssert<?, ? extends Temporal> extractingWith(TemporalAdjuster adjuster);

    MoreTemporalAssert<?, ? extends Temporal> extractingWith(TemporalField field, long newValue);
}
