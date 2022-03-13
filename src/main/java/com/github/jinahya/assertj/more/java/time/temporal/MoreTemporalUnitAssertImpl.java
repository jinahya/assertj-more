package com.github.jinahya.assertj.more.java.time.temporal;

import java.time.temporal.TemporalUnit;

class MoreTemporalUnitAssertImpl
        extends AbstractMoreTemporalUnitAssert<MoreTemporalUnitAssertImpl, TemporalUnit> {

    MoreTemporalUnitAssertImpl(final TemporalUnit actual) {
        super(actual, MoreTemporalAssertImpl.class);
    }
}
