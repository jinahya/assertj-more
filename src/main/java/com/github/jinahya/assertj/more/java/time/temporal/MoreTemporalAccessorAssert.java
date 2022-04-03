package com.github.jinahya.assertj.more.java.time.temporal;

import com.github.jinahya.assertj.more.api.MoreAssertions;
import com.github.jinahya.assertj.more.hidden.ForAssert;
import org.assertj.core.api.AbstractObjectAssert;
import org.assertj.core.api.Assert;
import org.assertj.core.api.AssertFactory;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.InstanceOfAssertFactories;

import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalQuery;
import java.util.Objects;
import java.util.function.Function;

public interface MoreTemporalAccessorAssert<S extends MoreTemporalAccessorAssert<S, A>, A extends TemporalAccessor>
        extends MoreJavaTimeTemporalAssert<S, A> {

    /**
     * Verifies that the result of {@link TemporalAccessor#get(TemporalField) actual.get(field)} is equals to specified
     * value.
     *
     * @param field    a value for the {@code field} argument.
     * @param expected the expected value of the {@code actual.get(field)}.
     * @return this assertion object.
     * @see TemporalAccessor#get(TemporalField)
     */
    default S has(final TemporalField field, final int expected) {
        Objects.requireNonNull(field, "field is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.get(field),
                        r -> {
                            Assertions.assertThat(r).isEqualTo(expected);
                            return s;
                        }
                )
        );
    }

    /**
     * Verifies that the result of {@link TemporalAccessor#getLong(TemporalField) actual.get(field)} is equals to
     * specified value.
     *
     * @param field    a value for the {@code field} argument.
     * @param expected the expected value of the {@code actual.getLong(field)}.
     * @return this assertion object.
     * @see TemporalAccessor#getLong(TemporalField)
     */
    default S hasLong(final TemporalField field, final long expected) {
        Objects.requireNonNull(field, "field is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.getLong(field),
                        r -> {
                            Assertions.assertThat(r).isEqualTo(expected);
                            return s;
                        }
                )
        );
    }

    /**
     * Verifies that the {@code actual} supports specified field.
     *
     * @param field the field.
     * @return this assertion.
     * @see TemporalAccessor#isSupported(TemporalField)
     * @see #doesNotSupport(TemporalField)
     */
    default S supports(final TemporalField field) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.isSupported(field))
                            .isTrue();
                    return s;
                }
        );
    }

    /**
     * Verifies that the {@code actual} does not support specified field.
     *
     * @param field the field.
     * @return this assertion.
     * @see TemporalAccessor#isSupported(TemporalField)
     * @see #supports(TemporalField)
     */
    default S doesNotSupport(final TemporalField field) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.isSupported(field))
                            .isFalse();
                    return s;
                }
        );
    }

    default <R, E extends Assert<E, ? super R>> E extractingQueryResultApplying(
            final TemporalQuery<R> query, final Function<? super R, ? extends E> function) {
        Objects.requireNonNull(query, "query is null");
        Objects.requireNonNull(function, "function is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.query(query),
                        function
                )
        );
    }

    default <R, E extends Assert<E, ? super R>> E extractingQueryResultCreating(
            final TemporalQuery<R> query, final AssertFactory<? super R, ? extends E> factory) {
        Objects.requireNonNull(factory, "factory is null");
        return extractingQueryResultApplying(query, factory::createAssert);
    }

    default <R> AbstractObjectAssert<?, R> extractingQueryResult(final TemporalQuery<R> query, final Class<R> type) {
        return extractingQueryResultCreating(query, v -> InstanceOfAssertFactories.type(type).createAssert(v));
    }

    default <R> AbstractObjectAssert<?, R> extractingQueryResult(final TemporalQuery<R> query) {
        return extractingQueryResultCreating(query, Assertions::assertThat);
    }

    default AbstractMoreValueRangeAssert<?> extractingRange(final TemporalField field) {
        Objects.requireNonNull(field, "field is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.range(field),
                        MoreJavaTimeTemporalAssertions::assertMore
                )
        );
    }
}
