package com.github.jinahya.assertj.more.time.temporal;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.AbstractIntegerAssert;
import org.assertj.core.api.AbstractLongAssert;
import org.assertj.core.api.Assertions;

import java.time.DateTimeException;
import java.time.temporal.TemporalField;
import java.time.temporal.ValueRange;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.LongFunction;
import java.util.function.ToLongBiFunction;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * An abstract assert class for verifying values of {@link ValueRange}.
 *
 * @param <SELF> self type parameter.
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
public class AbstractValueRangeAssert<SELF extends AbstractValueRangeAssert<SELF>>
        extends AbstractAssert<SELF, ValueRange> {

    /**
     * Creates a new instance with specified actual value and self type.
     *
     * @param actual   the actual value to verify.
     * @param selfType the self type.
     */
    protected AbstractValueRangeAssert(final ValueRange actual, final Class<SELF> selfType) {
        super(actual, selfType);
    }

    // --------------------------------------------------------------------------- checkValidIntValue(J, TemporalField)I
    protected <R> R checkValidIntValue(final long value, final TemporalField field,
                                       final Function<? super SELF, ? extends IntFunction<? extends R>> function) {
        Objects.requireNonNull(function, "function is null");
        return function.apply(isNotNull())
                .apply(actual.checkValidIntValue(value, field));
    }

    protected <R> R checkValidIntValue2(
            final long value, final TemporalField field,
            final Function<? super SELF, ? extends BiFunction<? super Integer, ? super DateTimeException, ? extends R>> function) {
        Objects.requireNonNull(function, "function is null");
        final var self = isNotNull();
        Integer result = 0;
        DateTimeException dateTimeException = null;
        try {
            result = actual.checkValidIntValue(value, field);
        } catch (final DateTimeException dte) {
            dateTimeException = dte;
        }
        return function.apply(self)
                .apply(result, dateTimeException);
    }

    public AbstractIntegerAssert<?> extractingValidIntValueOf(final long value, final TemporalField field) {
        return checkValidIntValue(value, field, s -> Assertions::assertThat);
    }

    /**
     * Asserts that {@code actual.checkValidIntValue(value, field)} does not throw any exception and accepts the result
     * to specified consumer.
     *
     * @param value    the {@code value} argument.
     * @param field    the {@code field} argument.
     * @param consumer the consumer to which the result is accepted.
     * @return {@link SELF}.
     * @see ValueRange#checkValidIntValue(long, TemporalField)
     */
    public SELF checksAsValidIntValue(final long value, final TemporalField field, final IntConsumer consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        try {
            return checkValidIntValue(value, field, s -> r -> {
                consumer.accept(r);
                return s;
            });
        } catch (final DateTimeException dte) {
            final var message = String.format("%1$s does not check %2$d as a valid int value", actual, value);
            throw new AssertionError(message, dte);
        }
    }

    /**
     * Asserts that {@code actual.checkValidIntValue(value, field)} does not check specified values as a valid int
     * value.
     *
     * @param value the {@code value} argument.
     * @param field the {@code field} argument.
     * @return {@link SELF}.
     * @see ValueRange#checkValidIntValue(long, TemporalField)
     */
    public SELF doesNotCheckAsValidIntValue(final long value, final TemporalField field) {
        if (true) {
            return checkValidIntValue2(value, field, s -> (r, e) -> {
                Assertions.assertThat(e).isNotNull();
                return s;
            });
        }
        SELF self = null;
        try {
            self = checkValidIntValue(value, field, s -> r -> {
                return s;
            });
            final var message = String.format("%1$s does check %2$d as a valid int value", actual, value);
            throw new AssertionError(message);
        } catch (final DateTimeException dte) {
            // expected
        }
        return Objects.requireNonNull(self, "self is null");
    }

    // --------------------------------------------------------------------------- checkValidIntValue(J, TemporalField)J
    protected <R> R checkValidValue(final long value, final TemporalField field,
                                    final Function<? super SELF, ? extends LongFunction<? extends R>> function) {
        Objects.requireNonNull(function, "function is null");
        return function.apply(isNotNull())
                .apply(actual.checkValidValue(value, field));
    }

    public AbstractLongAssert<?> extractingValidValueOf(final long value, final TemporalField field) {
        return checkValidValue(value, field, s -> Assertions::assertThat);
    }

    public SELF checkValidValue(
            final Consumer<? super ToLongBiFunction<? super Long, ? super TemporalField>> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        return isNotNull()
                .satisfies(a -> {
                    final ToLongBiFunction<Long, TemporalField> f = a::checkValidValue;
                    consumer.accept(f);
                });
    }

    // -------------------------------------------------------------------------------------------- getLargestMinimum()J
    public SELF hasLargestMinimum(final long expected) {
        return isNotNull()
                .satisfies(a -> {
                    assertThat(a.getLargestMinimum())
                            .isEqualTo(expected);
                });
    }

    // --------------------------------------------------------------------------------------------------- getMaximum()J
    public SELF hasMaximum(final long expected) {
        return isNotNull()
                .satisfies(a -> {
                    assertThat(a.getMaximum())
                            .isEqualTo(expected);
                });
    }

    // --------------------------------------------------------------------------------------------------- getMinimum()J
    public SELF hasMinimum(final long expected) {
        return isNotNull()
                .satisfies(a -> {
                    assertThat(a.getMinimum())
                            .isEqualTo(expected);
                });
    }

    // ------------------------------------------------------------------------------------------- getSmallestMaximum()J
    public SELF hasSmallestMaximum(final long expected) {
        return isNotNull()
                .satisfies(a -> {
                    assertThat(a.getSmallestMaximum())
                            .isEqualTo(expected);
                });
    }

    // ------------------------------------------------------------------------------------------------------ isFixed()Z
    protected SELF isFixed(final boolean expected) {
        return isNotNull()
                .satisfies(a -> {
                    assertThat(a.isFixed())
                            .isEqualTo(expected);
                });
    }

    public SELF isFixed() {
        return isFixed(true);
    }

    public SELF isNotFixed() {
        return isFixed(false);
    }

    // --------------------------------------------------------------------------------------------------- isIntValue()Z
    protected SELF isIntValue(final boolean expected) {
        return isNotNull()
                .satisfies(a -> {
                    assertThat(a.isIntValue())
                            .isEqualTo(expected);
                });
    }

    public SELF isIntValue() {
        return isIntValue(true);
    }

    public SELF allValuesFitInInt() {
        return isIntValue(true);
    }

    public SELF notAllValuesFitInInt() {
        return isIntValue(true);
    }

    // --------------------------------------------------------------------------------------------- isValidIntValue(I)Z
    protected <R> R isValidIntValue(
            final long value,
            final Function<? super SELF, ? extends Function<? super Boolean, ? extends R>> function) {
        return Objects.requireNonNull(function, "function is null")
                .apply(isNotNull())
                .apply(actual.isValidIntValue(value));
    }

    public SELF testsAsValidIntValue(final long value) {
        return isValidIntValue(value, s -> (Boolean r) -> {
            Assertions.assertThat(r).isTrue();
            return s;
        });
    }

    public SELF doesNotTestsAsValidIntValue(final long value) {
        return isValidIntValue(value, s -> (Boolean r) -> {
            Assertions.assertThat(r).isFalse();
            return s;
        });
    }

    // ------------------------------------------------------------------------------------------------ isValidValue(L)Z
    protected <R> R isValidValue(
            final long value,
            final Function<? super SELF, ? extends Function<? super Boolean, ? extends R>> function) {
        return Objects.requireNonNull(function, "function is null")
                .apply(isNotNull())
                .apply(actual.isValidValue(value));
    }

    public SELF testsAsValidValue(final long value) {
        return isValidValue(value, s -> (Boolean r) -> {
            Assertions.assertThat(r).isTrue();
            return s;
        });
    }

    public SELF doesNotTestsAsValidValue(final long value) {
        return isValidValue(value, s -> (Boolean r) -> {
            Assertions.assertThat(r).isFalse();
            return s;
        });
    }
}
