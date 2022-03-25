package com.github.jinahya.assertj.more.java.time.temporal;

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

    MoreTemporalAssert<?, A> extractingMinus(long amountToSubtract, TemporalUnit unit);

    MoreTemporalAssert<?, A> extractingMinus(TemporalAmount amount);

    MoreTemporalAssert<?, A> extractingPlus(long amountToAdd, TemporalUnit unit);

    MoreTemporalAssert<?, A> extractingPlus(TemporalAmount amount);

    default AbstractLongAssert<?> extractingUntil(final Temporal endExclusive, final TemporalUnit unit) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    final long[] results = new long[1];
                    Assertions.assertThatCode(() -> results[0] = a.until(endExclusive, unit))
                            .doesNotThrowAnyException();
                    return Assertions.assertThat(results[0]);
                }
        );
    }

    MoreTemporalAssert<?, ? extends Temporal> with(TemporalAdjuster adjuster);

    MoreTemporalAssert<?, ? extends Temporal> with(TemporalField field, long newValue);
}
