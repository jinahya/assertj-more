package com.github.jinahya.assertj.more.api;

import org.assertj.core.api.ComparableAssert;

/**
 * A proxy interface for {@link ComparableAssert} interface.
 *
 * @param <S> self type parameter
 * @param <A> actual type parameter
 */
public interface ComparableAssertProxy<S extends ComparableAssert<S, A>, A extends Comparable<? super A>>
        extends ComparableAssert<S, A> {

    @SuppressWarnings({"unchecked"})
    @Override
    default S isEqualByComparingTo(final A other) {
        return ComparableAssertProxyHelper.comparableAssertDelegate(
                (S) this,
                s -> d -> {
                    d = d.isEqualByComparingTo(other);
                    return s;
                }
        );
    }

    @SuppressWarnings({"unchecked"})
    @Override
    default S isNotEqualByComparingTo(final A other) {
        return ComparableAssertProxyHelper.comparableAssertDelegate(
                (S) this,
                s -> d -> {
                    d = d.isNotEqualByComparingTo(other);
                    return s;
                }
        );
    }

    @SuppressWarnings({"unchecked"})
    @Override
    default S isLessThan(final A other) {
        return ComparableAssertProxyHelper.comparableAssertDelegate(
                (S) this,
                s -> d -> {
                    d = d.isLessThan(other);
                    return s;
                }
        );
    }

    @SuppressWarnings({"unchecked"})
    @Override
    default S isLessThanOrEqualTo(final A other) {
        return ComparableAssertProxyHelper.comparableAssertDelegate(
                (S) this,
                s -> d -> {
                    d = d.isLessThanOrEqualTo(other);
                    return s;
                }
        );
    }

    @SuppressWarnings({"unchecked"})
    @Override
    default S isGreaterThan(final A other) {
        return ComparableAssertProxyHelper.comparableAssertDelegate(
                (S) this,
                s -> d -> {
                    d = d.isGreaterThan(other);
                    return s;
                }
        );
    }

    @SuppressWarnings({"unchecked"})
    @Override
    default S isGreaterThanOrEqualTo(final A other) {
        return ComparableAssertProxyHelper.comparableAssertDelegate(
                (S) this,
                s -> d -> {
                    d = d.isGreaterThanOrEqualTo(other);
                    return s;
                }
        );
    }

    @SuppressWarnings({"unchecked"})
    @Override
    default S isBetween(final A startInclusive, final A endInclusive) {
        return ComparableAssertProxyHelper.comparableAssertDelegate(
                (S) this,
                s -> d -> {
                    d = d.isBetween(startInclusive, endInclusive);
                    return s;
                }
        );
    }

    @SuppressWarnings({"unchecked"})
    @Override
    default S isStrictlyBetween(final A startExclusive, final A endExclusive) {
        return ComparableAssertProxyHelper.comparableAssertDelegate(
                (S) this,
                s -> d -> {
                    d = d.isStrictlyBetween(startExclusive, endExclusive);
                    return s;
                }
        );
    }
}
