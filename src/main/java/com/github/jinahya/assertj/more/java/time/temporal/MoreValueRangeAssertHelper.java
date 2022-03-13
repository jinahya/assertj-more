package com.github.jinahya.assertj.more.java.time.temporal;

import com.github.jinahya.assertj.more.hidden.ForAssert;
import org.assertj.core.api.AbstractBooleanAssert;
import org.assertj.core.api.AbstractIntegerAssert;
import org.assertj.core.api.AbstractLongAssert;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;

import java.time.DateTimeException;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.time.temporal.ValueRange;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.LongFunction;

final class MoreValueRangeAssertHelper {

    // ---------------------------------------------------------------------------- checkValidIntValue(J,TemporalField)I
    static <SELF extends Assert<SELF, ACTUAL>, ACTUAL extends ValueRange, R> R checkValidIntValue(
            final long value, final TemporalField field,
            final SELF self,
            final Function<? super SELF, ? extends IntFunction<? extends R>> function) {
        return function.apply(ForAssert.invokeIsNotNull(self))
                .apply(ForAssert.getActual(self).checkValidIntValue(value, field)); // DateTimeException
    }

//    static <SELF extends Assert<SELF, ACTUAL>, ACTUAL extends ValueRange, R> R checkValidIntValue(
//            final long value, final TemporalField field,
//            final SELF self,
//            final Function<? super SELF, ? extends IntFunction<? extends R>> function) {
//        return function.apply(ForAssert.invokeIsNotNull(self))
//                .apply(ForAssert.getActual(self).checkValidIntValue(value, field)); // DateTimeException
//    }

//    /**
//     * Asserts that {@link ValueRange#checkValidIntValue(long, TemporalField)} method, invoked on {@link #actual} with
//     * specified arguments, does not throw any exception.
//     *
//     * @param value the {@code value} argument.
//     * @param field the {@code field} argument.
//     * @return {@link SELF}.
//     * @see ValueRange#checkValidIntValue(long, TemporalField)
//     */
//    // https://github.com/assertj/assertj-core/issues/1652#issuecomment-1061246488
//    public SELF checksAsValidIntValue(final long value, final TemporalField field) {
//        if (true) {
//            final SELF self = isNotNull();
//            Assertions.assertThatCode(() -> checkValidIntValue(value, field, s -> r -> null))
//                    .as("invoking checkValidIntValue(%1$d, %2$s) on {}", value, field, actual)
//                    .doesNotThrowAnyException();
//            return self;
//        }
//        try {
//            return checkValidIntValue(value, field, s -> r -> s);
//        } catch (final DateTimeException dte) {
//            final String message = String.format(
//                    "<%1$d> supposed to be checked as a valid int value, but it wasn't.", value);
//            throw new AssertionError(message, dte);
//        }
//    }
//
//    /**
//     * Asserts that {@code actual.checkValidIntValue(value, field)} does not check specified values as a valid int
//     * value.
//     *
//     * @param value the {@code value} argument.
//     * @param field the {@code field} argument.
//     * @return {@link SELF}.
//     * @see ValueRange#checkValidIntValue(long, TemporalField)
//     */
//    public SELF doesNotCheckAsValidIntValue(final long value, final TemporalField field) {
//        final SELF self = isNotNull();
//        Assertions.assertThatThrownBy(() -> self.checkValidIntValue(value, field, s -> r -> null))
//                .as("asserting checkValidIntValue(%1$d, %1$s) throws a DateTimeException", value, field)
//                .isInstanceOf(DateTimeException.class);
//        return self;
//    }
//
//    // ------------------------------------------------------------------------------- checkValidValue(J,TemporalField)J
//    protected <R> R checkValidValue(final long value, final TemporalField field,
//                                    final Function<? super SELF, ? extends LongFunction<? extends R>> function) {
//        return function.apply(isNotNull())
//                .apply(actual.checkValidValue(value, field)); // DateTimeException
//    }
//
//    public AbstractLongAssert<?> extractingValidValue(final long value, final TemporalField field) {
//        final long[] results = new long[1];
//        Assertions.assertThatCode(() -> {
//                    checkValidValue(value, field, s -> r -> {
//                        results[0] = r;
//                        return null;
//                    });
//                })
//                .doesNotThrowAnyException();
//        return Assertions.assertThat(results[0]);
//    }
//
//    /**
//     * Asserts that {@link ValueRange#checkValidValue(long, TemporalField)} method, invoked on {@link #actual} with
//     * specified arguments, does not throw any exception.
//     *
//     * @param value the {@code value} argument.
//     * @param field the {@code field} argument.
//     * @return {@link SELF}.
//     * @see ValueRange#checkValidIntValue(long, TemporalField)
//     */
//    // https://github.com/assertj/assertj-core/issues/1652#issuecomment-1061246488
//    public SELF checksAsValidValue(final long value, final TemporalField field) {
//        if (true) {
//            final SELF self = isNotNull();
//            Assertions.assertThatCode(() -> checkValidValue(value, field, s -> r -> null))
//                    .as("invoking checkValidValue(%1$d, %2$s) on {}", value, field, actual)
//                    .doesNotThrowAnyException();
//            return self;
//        }
//        try {
//            return checkValidIntValue(value, field, s -> r -> s);
//        } catch (final DateTimeException dte) {
//            final String message = String.format(
//                    "<%1$d> supposed to be checked as a valid value, but it wasn't.", value);
//            throw new AssertionError(message, dte);
//        }
//    }
//
//    /**
//     * Asserts that {@code actual.checkValidValue(value, field)} does not check specified values as a valid int value.
//     *
//     * @param value the {@code value} argument.
//     * @param field the {@code field} argument.
//     * @return {@link SELF}.
//     * @see ValueRange#checkValidIntValue(long, TemporalField)
//     */
//    public SELF doesNotCheckAsValidValue(final long value, final TemporalField field) {
//        final SELF self = isNotNull();
//        Assertions.assertThatThrownBy(() -> self.checkValidValue(value, field, s -> r -> null))
//                .as("asserting checkValidValue(%1$d, %1$s) throws a DateTimeException", value, field)
//                .isInstanceOf(DateTimeException.class);
//        return self;
//    }
//
//    // -------------------------------------------------------------------------------------------- getLargestMinimum()J
//    protected <R> R getLargestMinimum(final Function<? super SELF, ? extends LongFunction<? extends R>> function) {
//        return function.apply(isNotNull())
//                .apply(actual.getLargestMinimum());
//    }
//
//    public AbstractLongAssert<?> extractingLargestMinimum() {
//        return getLargestMinimum(s -> Assertions::assertThat);
//    }
//
//    public SELF hasLargestMinimum(final long expected) {
//        return getLargestMinimum(s -> r -> {
//            Assertions.assertThat(r).isEqualTo(expected);
//            return s;
//        });
//    }
//
//    // --------------------------------------------------------------------------------------------------- getMaximum()J
//    protected <R> R getMaximum(final Function<? super SELF, ? extends LongFunction<? extends R>> function) {
//        return function.apply(isNotNull())
//                .apply(actual.getMaximum());
//    }
//
//    public AbstractLongAssert<?> extractingMaximum() {
//        return getMaximum(s -> Assertions::assertThat);
//    }
//
//    public SELF hasMaximum(final long expected) {
//        return getMaximum(s -> r -> {
//            Assertions.assertThat(r).isEqualTo(expected);
//            return s;
//        });
//    }
//
//    // --------------------------------------------------------------------------------------------------- getMinimum()J
//    protected <R> R getMinimum(final Function<? super SELF, ? extends LongFunction<? extends R>> function) {
//        return function.apply(isNotNull())
//                .apply(actual.getMinimum());
//    }
//
//    public AbstractLongAssert<?> extractingMinimum() {
//        return getMinimum(s -> Assertions::assertThat);
//    }
//
//    public SELF hasMinimum(final long expected) {
//        return getMinimum(s -> r -> {
//            Assertions.assertThat(r).isEqualTo(expected);
//            return s;
//        });
//    }
//
//    // ------------------------------------------------------------------------------------------- getSmallestMaximum()J
//    protected <R> R getSmallestMaximum(final Function<? super SELF, ? extends LongFunction<? extends R>> function) {
//        return function.apply(isNotNull())
//                .apply(actual.getSmallestMaximum());
//    }
//
//    public AbstractLongAssert<?> extractingSmallestMaximum() {
//        return getSmallestMaximum(s -> Assertions::assertThat);
//    }
//
//    public SELF hasSmallestMaximum(final long expected) {
//        return getSmallestMaximum(s -> r -> {
//            Assertions.assertThat(r).isEqualTo(expected);
//            return s;
//        });
//    }
//
//    // ------------------------------------------------------------------------------------------------------ isFixed()Z
//    protected <R> R isFixed(final Function<? super SELF, ? extends Function<? super Boolean, ? extends R>> function) {
//        return function.apply(isNotNull())
//                .apply(actual.isFixed());
//    }
//
//    public AbstractBooleanAssert<?> extractingFixed() {
//        return isFixed(s -> Assertions::assertThat);
//    }
//
//    public SELF isFixed() {
//        return isFixed(s -> r -> {
//            Assertions.assertThat(r).isTrue();
//            return s;
//        });
//    }
//
//    public SELF isNotFixed() {
//        return isFixed(s -> r -> {
//            Assertions.assertThat(r).isFalse();
//            return s;
//        });
//    }
//
//    // --------------------------------------------------------------------------------------------------- isIntValue()Z
//    protected <R> R isIntValue(
//            final Function<? super SELF, ? extends Function<? super Boolean, ? extends R>> function) {
//        return function.apply(isNotNull())
//                .apply(actual.isIntValue());
//    }
//
//    public AbstractBooleanAssert<?> extractingIntValue() {
//        return isIntValue(s -> Assertions::assertThat);
//    }
//
//    public SELF isIntValue() {
//        return isIntValue(s -> r -> {
//            Assertions.assertThat(r)
//                    .isTrue();
//            return s;
//        });
//    }
//
//    public SELF isNotIntValue() {
//        return isIntValue(s -> r -> {
//            Assertions.assertThat(r)
//                    .isFalse();
//            return s;
//        });
//    }
//
//    // --------------------------------------------------------------------------------------------- isValidIntValue(I)Z
//    protected <R> R isValidIntValue(
//            final long value,
//            final Function<? super SELF, ? extends Function<? super Boolean, ? extends R>> function) {
//        return function.apply(isNotNull())
//                .apply(actual.isValidIntValue(value));
//    }
//
//    public SELF testsAsValidIntValue(final long value) {
//        return isValidIntValue(value, s -> (Boolean r) -> {
//            Assertions.assertThat(r).isTrue();
//            return s;
//        });
//    }
//
//    public SELF doesNotTestAsValidIntValue(final long value) {
//        return isValidIntValue(value, s -> (Boolean r) -> {
//            Assertions.assertThat(r).isFalse();
//            return s;
//        });
//    }
//
//    // ------------------------------------------------------------------------------------------------ isValidValue(L)Z
//    protected <R> R isValidValue(
//            final long value,
//            final Function<? super SELF, ? extends Function<? super Boolean, ? extends R>> function) {
//        return function.apply(isNotNull())
//                .apply(actual.isValidValue(value));
//    }
//
//    public SELF testsAsValidValue(final long value) {
//        return isValidValue(value, s -> r -> {
//            Assertions.assertThat(r)
//                    .isTrue();
//            return s;
//        });
//    }
//
//    public SELF doesNotTestAsValidValue(final long value) {
//        return isValidValue(value, s -> r -> {
//            Assertions.assertThat(r)
//                    .isFalse();
//            return s;
//        });
//    }

    // -----------------------------------------------------------------------------------------------------------------
    private MoreValueRangeAssertHelper() {
        throw new AssertionError("instantiation is not allowed");
    }
}
