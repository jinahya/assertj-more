package com.github.jinahya.assertj.more.time.temporal;

import com.github.jinahya.assertj.more.MoreAssertions;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.AbstractIntegerAssert;
import org.assertj.core.api.AbstractLongAssert;
import org.assertj.core.api.AbstractObjectAssert;
import org.assertj.core.api.Assert;
import org.assertj.core.api.AssertFactory;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.InstanceOfAssertFactories;

import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalQuery;
import java.time.temporal.ValueRange;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * An abstract assert class for verifying values of {@link TemporalAccessor}.
 *
 * @param <SELF>   self type parameter.
 * @param <ACTUAL> actual type parameter.
 * @author Jin Kwon &lt;onacit_at_wemakeprice.com&gt;
 */
public abstract class AbstractTemporalAccessorAssert<
        SELF extends AbstractTemporalAccessorAssert<SELF, ACTUAL>,
        ACTUAL extends TemporalAccessor
        >
        extends AbstractAssert<SELF, ACTUAL> {

    /**
     * Creates a new instance with specified actual value and self type.
     *
     * @param actual   the actual value to verify.
     * @param selfType the self type.
     */
    protected AbstractTemporalAccessorAssert(final ACTUAL actual, final Class<?> selfType) {
        super(actual, selfType);
    }

    // --------------------------------------------------------------------------------------------- get(TemporalField)I

    /**
     * Applies this assertion and the value of specified field to specified function and returns the result.
     *
     * @param field    the field.
     * @param function the function.
     * @param <R>      result type parameter
     * @return the result of the {@code function}.
     */
    protected <R> R get(final TemporalField field,
                        final Function<? super SELF, ? extends Function<? super Integer, ? extends R>> function) {
        Objects.requireNonNull(function, "function is null");
        return function.apply(isNotNull())
                .apply(actual.get(field));
    }

    /**
     * Returns an assertion instance for verifying the result of {@link TemporalAccessor#get(TemporalField)} invoked
     * with specified field.
     *
     * @param field the field.
     * @return an integer assert.
     * @see TemporalAccessor#get(TemporalField)
     */
    public AbstractIntegerAssert<?> extracting(final TemporalField field) {
        return get(field, s -> Assertions::assertThat);
    }

    /**
     * Verifies that the {@link #actual}'s value for specified field is equal to specified value.
     *
     * @param field    the field whose value is verified.
     * @param expected the expected value of {@code field} of {@link #actual}.
     * @return {@link #myself}.
     * @see TemporalAccessor#get(TemporalField)
     */
    public SELF has(final TemporalField field, final int expected) {
        return get(field, s -> v -> {
            Assertions.assertThat(v).isEqualTo(expected);
            return s;
        });
    }

    // ----------------------------------------------------------------------------------------- getLong(TemporalField)J
    public AbstractLongAssert<?> extractingLong(final TemporalField field) {
        return isNotNull()
                .extracting(a -> a.getLong(field), InstanceOfAssertFactories.LONG);
    }

    public SELF hasLong(final TemporalField field, final long expected) {
        return isNotNull()
                .satisfies(a -> {
                    Assertions.assertThat(a.getLong(field))
                            .isEqualTo(expected);
                });
    }

    // -------------------------------------------------------------------------------------------------- isSupported()Z
    protected <R> R isSupported(
            final TemporalField field,
            final Function<? super SELF, ? extends Function<? super Boolean, ? extends R>> function) {
        Objects.requireNonNull(function, "function is null");
        return function.apply(isNotNull())
                .apply(actual.isSupported(field));
    }

    public SELF supports(final TemporalField field) {
        return isSupported(field, s -> v -> {
            Assertions.assertThat(v).isTrue();
            return s;
        });
    }

    public SELF doesNotSupport(final TemporalField field) {
        return isSupported(field, s -> v -> {
            Assertions.assertThat(v).isFalse();
            return s;
        });
    }

    // ---------------------------------------------------------------------------------------- query(TemporalQuery<R>)R
    protected <R, T> T query(final TemporalQuery<R> query,
                             final Function<? super SELF, ? extends Function<? super R, ? extends T>> function) {
        Objects.requireNonNull(function, "function is null");
        return function.apply(isNotNull())
                .apply(actual.query(query));
    }

    public <R, A extends Assert<A, R>> A extractingQueryResultApplying(
            final TemporalQuery<R> query, final Function<? super R, ? extends A> function) {
        Objects.requireNonNull(function, "function is null");
        return query(query, s -> function);
    }

    public <R, A extends Assert<A, R>> A extractingQueryResultCreating(
            final TemporalQuery<R> query, final AssertFactory<? super R, ? extends A> factory) {
        Objects.requireNonNull(factory, "factory is null");
        return extractingQueryResultApplying(query, factory::createAssert);
    }

    public <R> AbstractObjectAssert<?, R> extractingQueryResult(final TemporalQuery<R> query, final Class<R> type) {
        return extractingQueryResultCreating(query, v -> InstanceOfAssertFactories.type(type).createAssert(v));
    }

    public <R> AbstractObjectAssert<?, R> extractingQueryResult(final TemporalQuery<R> query) {
        return extractingQueryResultCreating(query, Assertions::assertThat);
    }

    public <R> SELF queryResultSatisfies(final TemporalQuery<R> query, final Consumer<? super R> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        return isNotNull()
                .satisfies(a -> {
                    Assertions.assertThat(a.query(query))
                            .satisfies(consumer);
                });
    }

    // ---------------------------------------------------------------------------------- range(TemporalField)ValueRange
    protected <R> R range(final TemporalField field,
                          final Function<? super SELF, ? extends Function<? super ValueRange, ? extends R>> function) {
        Objects.requireNonNull(function, "function is null");
        return function.apply(isNotNull())
                .apply(actual.range(field));
    }

    public AbstractValueRangeAssert<?> extractingRange(final TemporalField field) {
        return range(field, s -> MoreAssertions::assertMore);
    }

    public SELF rangeSatisfies(final TemporalField field, final Consumer<? super ValueRange> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        return range(field, s -> v -> {
            MoreAssertions.assertMore(v).satisfies(consumer);
            return s;
        });
    }
}
