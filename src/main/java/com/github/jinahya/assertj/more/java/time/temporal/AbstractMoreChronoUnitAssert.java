package com.github.jinahya.assertj.more.java.time.temporal;

import java.time.temporal.ChronoUnit;

public abstract class AbstractMoreChronoUnitAssert<S extends AbstractMoreChronoUnitAssert<S>>
        extends AbstractMoreTemporalUnitAssert<S, ChronoUnit>
        implements MoreChronoUnitAssert<S> {

    protected AbstractMoreChronoUnitAssert(final ChronoUnit actual, final Class<S> selfType) {
        super(actual, selfType);
    }
}
