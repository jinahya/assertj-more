package com.github.jinahya.assertj.more.java.time.chrono;

import org.assertj.core.api.AbstractZonedDateTimeAssert;
import org.assertj.core.api.ComparableAssert;
import org.assertj.core.api.GenericComparableAssert;

import java.time.ZonedDateTime;
import java.time.chrono.ChronoZonedDateTime;

public abstract class AbstractMoreZonedDateTimeAssert<S extends AbstractMoreZonedDateTimeAssert<S>>
        extends AbstractZonedDateTimeAssert<S>
        implements MoreZonedDateTimeAssert<S> {

    protected AbstractMoreZonedDateTimeAssert(final ZonedDateTime actual, final Class<S> selfType) {
        super(actual, selfType);
        comparableAssertDelegate = new GenericComparableAssert<>(actual);
    }

    private final ComparableAssert<?, ChronoZonedDateTime<?>> comparableAssertDelegate;
}
