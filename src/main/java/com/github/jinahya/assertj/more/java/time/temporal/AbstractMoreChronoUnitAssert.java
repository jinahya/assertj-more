package com.github.jinahya.assertj.more.java.time.temporal;

import java.time.temporal.ChronoUnit;

public abstract class AbstractMoreChronoUnitAssert<SELF extends AbstractMoreChronoUnitAssert<SELF>>
        extends AbstractMoreTemporalUnitAssert<SELF, ChronoUnit>
        implements MoreChronoUnitAssert<SELF> {

    protected AbstractMoreChronoUnitAssert(final ChronoUnit actual, final Class<SELF> selfType) {
        super(actual, selfType);
    }
}
