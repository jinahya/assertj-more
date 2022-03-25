package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.api.ComparableAssertProxy;
import org.assertj.core.api.AbstractLocalTimeAssert;
import org.assertj.core.api.ComparableAssert;
import org.assertj.core.api.GenericComparableAssert;

import java.time.LocalTime;

public abstract class AbstractMoreLocalTimeAssert<S extends AbstractMoreLocalTimeAssert<S>>
        extends AbstractLocalTimeAssert<S>
        implements MoreLocalTimeAssert<S>,
                   ComparableAssertProxy<S, LocalTime> {

    protected AbstractMoreLocalTimeAssert(final LocalTime actual, final Class<S> selfType) {
        super(actual, selfType);
        this.comparableAssertDelegate = new GenericComparableAssert<>(actual);
    }

    private final ComparableAssert<?, LocalTime> comparableAssertDelegate;
}
