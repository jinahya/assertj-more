package com.github.jinahya.assertj.more.java.time.temporal;

import org.assertj.core.api.AbstractBooleanAssert;
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
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public interface MoreTemporalAccessorAssert<
        SELF extends MoreTemporalAccessorAssert<SELF, ACTUAL>,
        ACTUAL extends TemporalAccessor>
        extends MoreJavaTimeTemporalAssert<SELF, ACTUAL> {

    // --------------------------------------------------------------------------------------------- get(TemporalField)I

    /**
     * Verifies that specified field is {@link #supports(TemporalField) supported} by the {@code actual} and returns an
     * assertion for verifying the {@code actual}'s value of the field.
     *
     * @param field the field.
     * @return an assertion instance of integer.
     * @see #supports(TemporalField)
     * @see TemporalAccessor#get(TemporalField)
     */
    default AbstractIntegerAssert<?> extracting(final TemporalField field) {
        return MoreTemporalAccessorAssertHelper.get(field, supports(field), s -> Assertions::assertThat);
    }

    /**
     * Verifies that specified is {@link #supports(TemporalField) supported} by the {@code actual} and the {@code
     * actual}'s value of the field is equal to specified value.
     *
     * @param field    the field whose value is verified.
     * @param expected the expected value of the {@code field}.
     * @return this assertion.
     * @see #supports(TemporalField)
     * @see TemporalAccessor#get(TemporalField)
     */
    default SELF has(final TemporalField field, final int expected) {
        return MoreTemporalAccessorAssertHelper.get(field, supports(field), s -> r -> {
            assertThat(r).isEqualTo(expected);
            return s;
        });
    }

    // ----------------------------------------------------------------------------------------- getLong(TemporalField)J

    /**
     * Verifies that specified field is {@link #supports(TemporalField) supported} by the {@code actual} and returns an
     * assertion for verifying the {@code actual}'s value of the field.
     *
     * @param field the field.
     * @return an assertion instance of integer.
     * @see #supports(TemporalField)
     * @see TemporalAccessor#getLong(TemporalField)
     */
    default AbstractLongAssert<?> extractingLong(final TemporalField field) {
        return MoreTemporalAccessorAssertHelper.getLong(field, supports(field), s -> Assertions::assertThat);
    }

    /**
     * Verifies that specified is {@link #supports(TemporalField) supported} by the {@code actual} and the {@code
     * actual}'s value of the field is equal to specified value.
     *
     * @param field    the field whose value is verified.
     * @param expected the expected value of the {@code field}.
     * @return this assertion.
     * @see #supports(TemporalField)
     * @see TemporalAccessor#getLong(TemporalField)
     */
    default SELF hasLong(final TemporalField field, final long expected) {
        return MoreTemporalAccessorAssertHelper.getLong(field, supports(field), s -> r -> {
            assertThat(r).isEqualTo(expected);
            return s;
        });
    }

    // ------------------------------------------------------------------------------------- isSupported(TemporalField)Z

    /**
     * Returns an assertion for verifying the result of {@link TemporalAccessor#isSupported(TemporalField)} invoked on
     * the {@code actual} with specified field.
     *
     * @param field the field.
     * @return an assertion of boolean.
     * @see TemporalAccessor#isSupported(TemporalField)
     * @see #supports(TemporalField)
     * @see #doesNotSupport(TemporalField)
     */
    @SuppressWarnings({"unchecked"})
    default AbstractBooleanAssert<?> extractingIsSupported(final TemporalField field) {
        return MoreTemporalAccessorAssertHelper.extractingIsSupported(field, (SELF) this, s -> a -> a);
    }

    /**
     * Verifies that the {@code actual} supports specified field.
     *
     * @param field the field.
     * @return this assertion.
     * @see TemporalAccessor#isSupported(TemporalField)
     * @see #doesNotSupport(TemporalField)
     */
    @SuppressWarnings({"unchecked"})
    default SELF supports(final TemporalField field) {
        return MoreTemporalAccessorAssertHelper.extractingIsSupported(field, (SELF) this, s -> a -> {
            a.isTrue();
            return s;
        });
    }

    /**
     * Verifies that the {@code actual} does not support specified field.
     *
     * @param field the field.
     * @return this assertion.
     * @see TemporalAccessor#isSupported(TemporalField)
     * @see #supports(TemporalField)
     */
    @SuppressWarnings({"unchecked"})
    default SELF doesNotSupport(final TemporalField field) {
        return MoreTemporalAccessorAssertHelper.extractingIsSupported(field, (SELF) this, s -> a -> {
            a.isFalse();
            return s;
        });
    }

    // -------------------------------------------------------------------------------------- query(TemporalQuery)Object
    @SuppressWarnings({"unchecked"})
    default <R, A extends Assert<A, R>> A extractingQueryResultApplying(
            final TemporalQuery<R> query, final Function<? super R, ? extends A> function) {
        Objects.requireNonNull(function, "function is null");
        return MoreTemporalAccessorAssertHelper.query(query, (SELF) this, s -> function);
    }

    default <R, A extends Assert<A, R>> A extractingQueryResultCreating(
            final TemporalQuery<R> query, final AssertFactory<? super R, ? extends A> factory) {
        Objects.requireNonNull(factory, "factory is null");
        return extractingQueryResultApplying(query, factory::createAssert);
    }

    default <R> AbstractObjectAssert<?, R> extractingQueryResult(final TemporalQuery<R> query, final Class<R> type) {
        return extractingQueryResultCreating(query, v -> InstanceOfAssertFactories.type(type).createAssert(v));
    }

    default <R> AbstractObjectAssert<?, R> extractingQueryResult(final TemporalQuery<R> query) {
        return extractingQueryResultCreating(query, Assertions::assertThat);
    }

    // ---------------------------------------------------------------------------------- range(TemporalField)ValueRange
    @SuppressWarnings({"unchecked"})
    default <R> R extractingRangeApplying(final TemporalField field,
                                          final Function<? super ValueRange, ? extends R> function) {
        Objects.requireNonNull(function, "function is null");
        return MoreTemporalAccessorAssertHelper.range(field, (SELF) this, s -> function);
    }

    @SuppressWarnings({"unchecked"})
    default <R> R extractingRangeCreating(final TemporalField field,
                                          final AssertFactory<? super ValueRange, ? extends R> factory) {
        Objects.requireNonNull(factory, "factory is null");
        return extractingRangeApplying(field, factory::createAssert);
    }

    default MoreValueRangeAssert<?> extractingRange(final TemporalField field) {
        return MoreTemporalAccessorAssertHelper.range(field, (SELF) this, s -> MoreValueRangeAssertImpl::new);
    }
}
