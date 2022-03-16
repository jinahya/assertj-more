package com.github.jinahya.assertj.more.api;

import org.assertj.core.api.ComparableAssert;
import org.assertj.core.api.GenericComparableAssert;

import java.util.Objects;

public class ComparableAssertDelegate<S extends ComparableAssert<S, A>, A extends Comparable<? super A>> {

    public ComparableAssertDelegate(final S self, final A actual) {
        super();
        this.self = Objects.requireNonNull(self, "self is null");
        comparableAssert = new GenericComparableAssert<>(actual);
    }

    public S isEqualByComparingTo(final A other) {
        comparableAssert.isEqualByComparingTo(other);
        return self;
    }

    public S isNotEqualByComparingTo(final A other) {
        comparableAssert.isNotEqualByComparingTo(other);
        return self;
    }

    public S isLessThan(final A other) {
        comparableAssert.isLessThan(other);
        return self;
    }

    public S isLessThanOrEqualTo(final A other) {
        comparableAssert.isLessThanOrEqualTo(other);
        return self;
    }

    public S isGreaterThan(final A other) {
        comparableAssert.isGreaterThan(other);
        return self;
    }

    public S isGreaterThanOrEqualTo(final A other) {
        comparableAssert.isGreaterThanOrEqualTo(other);
        return self;
    }

    public S isBetween(final A startInclusive, final A endInclusive) {
        comparableAssert.isBetween(startInclusive, endInclusive);
        return self;
    }

    public S isStrictlyBetween(final A startExclusive, final A endExclusive) {
        comparableAssert.isStrictlyBetween(startExclusive, endExclusive);
        return self;
    }

    private final S self;

    private final ComparableAssert<?, A> comparableAssert;
}
