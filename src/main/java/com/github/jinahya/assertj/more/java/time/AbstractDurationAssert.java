package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.java.time.temporal.AbstractTemporalAmountAssert;
import org.assertj.core.api.Assert;
import org.assertj.core.api.AssertFactory;
import org.assertj.core.api.Assertions;

import java.time.Duration;
import java.util.Objects;
import java.util.function.Function;

/**
 * An abstract assert class for verifying values of {@link Duration}.
 *
 * @param <SELF> self type parameter.
 * @author Jin Kwon &lt;onacit_at_wemakeprice.com&gt;
 */
public abstract class AbstractDurationAssert<SELF extends AbstractDurationAssert<SELF>>
        extends AbstractTemporalAmountAssert<SELF, Duration> {

    /**
     * Creates a new instance with specified actual value and self type.
     *
     * @param actual   the actual value to verify.
     * @param selfType the self type.
     */
    protected AbstractDurationAssert(final Duration actual, final Class<?> selfType) {
        super(actual, selfType);
    }

    // -----------------------------------------------------------------------------------------------------------------
    public org.assertj.core.api.AbstractDurationAssert<?> assertj() {
        return extracting(Function.identity(), Assertions::assertThat);
    }

    // --------------------------------------------------------------------------------------------------- abs()Duration
    protected <R> R abs(final Function<? super SELF, ? extends Function<? super Duration, ? extends R>> function) {
        Objects.requireNonNull(function, "function is null");
        return function.apply(isNotNull())
                .apply(actual.abs());
    }

    public <A extends Assert<A, Duration>> A extractingAbsApplying(
            final Function<? super Duration, ? extends A> function) {
        Objects.requireNonNull(function, "function is null");
        return abs(s -> function);
    }

    public <A extends Assert<A, Duration>> A extractingAbsCreating(
            final AssertFactory<? super Duration, ? extends A> factory) {
        Objects.requireNonNull(factory, "factory is null");
        return extractingAbsApplying(factory::createAssert);
    }

    public SELF hasAbs(final Duration expected) {
        return abs(s -> r -> {
            Assertions.assertThat(r)
                    .isEqualTo(expected);
            return s;
        });
    }

    // ---------------------------------------------------------------------------------------------------- dividedBy(J)
    protected <R> R dividedBy(
            final long divisor,
            final Function<? super SELF, ? extends Function<? super Duration, ? extends R>> function) {
        return function.apply(isNotNull())
                .apply(actual.dividedBy(divisor));
    }

    public AbstractDurationAssert<?> extractingDividedBy(final long divisor) {
        return dividedBy(divisor, s -> DurationAssert::new);
    }

    // -------------------------------------------------------------------------------------------- minusDays(J)Duration
    protected <R> R minusDays(
            long daysToSubtract,
            final Function<? super SELF, ? extends Function<? super Duration, ? extends R>> function) {
        return function.apply(isNotNull())
                .apply(actual.minusDays(daysToSubtract));
    }
}
