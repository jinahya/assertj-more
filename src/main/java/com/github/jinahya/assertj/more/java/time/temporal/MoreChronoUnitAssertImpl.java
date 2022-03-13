package com.github.jinahya.assertj.more.java.time.temporal;

import java.time.temporal.ChronoUnit;

class MoreChronoUnitAssertImpl
        extends AbstractMoreChronoUnitAssert<MoreChronoUnitAssertImpl> {

    MoreChronoUnitAssertImpl(final ChronoUnit actual) {
        super(actual, MoreChronoUnitAssertImpl.class);
    }
}
