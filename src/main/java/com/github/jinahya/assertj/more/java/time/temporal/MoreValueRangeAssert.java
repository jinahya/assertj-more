package com.github.jinahya.assertj.more.java.time.temporal;

import com.github.jinahya.assertj.more.hidden.ForAssert;
import org.assertj.core.api.AbstractIntegerAssert;
import org.assertj.core.api.AbstractLongAssert;
import org.assertj.core.api.Assertions;

import java.time.DateTimeException;
import java.time.temporal.TemporalField;
import java.time.temporal.ValueRange;

/**
 * An interface for verifying actual values of {@link ValueRange}.
 *
 * @param <S> self type parameter.
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
public interface MoreValueRangeAssert<S extends MoreValueRangeAssert<S>>
        extends MoreJavaTimeTemporalAssert<S, ValueRange> {

    // ---------------------------------------------------------------------------- checkValidIntValue(J,TemporalField)I
    default AbstractIntegerAssert<?> extractingCheckValidIntValue(final long value, final TemporalField field) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    final int[] results = new int[1];
                    Assertions.assertThatCode(() -> {
                                results[0] = a.checkValidIntValue(value, field);
                            })
                            .doesNotThrowAnyException();
                    return Assertions.assertThat(results[0]);
                }
        );
    }

    default S checksAsValidIntValue(final long value, final TemporalField field) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThatCode(() -> {
                                final int checked = a.checkValidIntValue(value, field);
                            })
                            .doesNotThrowAnyException();
                    return s;
                }
        );
    }

    default S doesNotCheckAsValidIntValue(final long value, final TemporalField field) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThatThrownBy(() -> {
                                final int checked = a.checkValidIntValue(value, field);
                            })
                            .isInstanceOf(DateTimeException.class);
                    return s;
                }
        );
    }

    // ------------------------------------------------------------------------------- checkValidValue(J,TemporalField)J
    default AbstractLongAssert<?> extractingCheckValidValue(final long value, final TemporalField field) {
        return ForAssert.applyActual2(isNotNull(), s -> a -> {
            final long[] results = new long[1];
            Assertions.assertThatCode(() -> {
                        results[0] = a.checkValidValue(value, field);
                    })
                    .doesNotThrowAnyException();
            return Assertions.assertThat(results[0]);
        });
    }

    default S checksAsValidValue(final long value, final TemporalField field) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThatCode(() -> {
                                final long checked = a.checkValidValue(value, field);
                            })
                            .doesNotThrowAnyException();
                    return s;
                }
        );
    }

    default S doesNotCheckAsValidValue(final long value, final TemporalField field) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThatThrownBy(() -> {
                                final long checked = a.checkValidValue(value, field);
                            })
                            .isInstanceOf(DateTimeException.class);
                    return s;
                }
        );
    }

    // -------------------------------------------------------------------------------------------- getLargestMinimum()J
    default AbstractLongAssert<?> extractingLargestMinimum() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> Assertions.assertThat(a.getLargestMinimum())
        );
    }

    @SuppressWarnings({"unchecked"})
    default S hasLargestMinimum(final long expected) {
        extractingLargestMinimum()
                .isEqualTo(expected);
        return (S) this;
    }

    // --------------------------------------------------------------------------------------------------- getMaximum()J
    default AbstractLongAssert<?> extractingMaximum() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> Assertions.assertThat(a.getMaximum())
        );
    }

    @SuppressWarnings({"unchecked"})
    default S hasMaximum(final long expected) {
        extractingMaximum()
                .isEqualTo(expected);
        return (S) this;
    }

    // --------------------------------------------------------------------------------------------------- getMinimum()J
    default AbstractLongAssert<?> extractingMinimum() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> Assertions.assertThat(a.getMinimum())
        );
    }

    @SuppressWarnings({"unchecked"})
    default S hasMinimum(final long expected) {
        extractingMinimum()
                .isEqualTo(expected);
        return (S) this;
    }

    // ------------------------------------------------------------------------------------------- getSmallestMaximum()J
    default AbstractLongAssert<?> extractingSmallestMaximum() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> Assertions.assertThat(a.getSmallestMaximum())
        );
    }

    default S hasSmallestMaximum(final long expected) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.getSmallestMaximum())
                            .isEqualTo(expected);
                    return s;
                }
        );
    }

    // ------------------------------------------------------------------------------------------------------ isFixed()Z
    default S isFixed() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.isFixed())
                            .isTrue();
                    return s;
                }
        );
    }

    default S isNotFixed() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.isFixed())
                            .isFalse();
                    return s;
                }
        );
    }

    // --------------------------------------------------------------------------------------------------- isIntValue()Z
    default S isIntValue() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.isIntValue())
                            .isTrue();
                    return s;
                }
        );
    }

    default S isNotIntValue() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.isIntValue())
                            .isFalse();
                    return s;
                }
        );
    }

    // --------------------------------------------------------------------------------------------- isValidIntValue(I)Z

    default S testsAsValidIntValue(final long value) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.isValidIntValue(value))
                            .isTrue();
                    return s;
                }
        );
    }

    default S doesNotTestAsValidIntValue(final long value) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.isValidIntValue(value))
                            .isFalse();
                    return s;
                }
        );
    }

    // ------------------------------------------------------------------------------------------------ isValidValue(I)Z

    default S testsAsValidValue(final long value) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.isValidValue(value))
                            .isTrue();
                    return s;
                }
        );
    }

    default S doesNotTestAsValidValue(final long value) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.isValidValue(value))
                            .isFalse();
                    return s;
                }
        );
    }
}
