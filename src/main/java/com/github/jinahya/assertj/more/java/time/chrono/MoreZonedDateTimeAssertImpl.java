package com.github.jinahya.assertj.more.java.time.chrono;

import java.time.ZonedDateTime;

class MoreZonedDateTimeAssertImpl
        extends AbstractMoreZonedDateTimeAssert<MoreZonedDateTimeAssertImpl> {

    MoreZonedDateTimeAssertImpl(final ZonedDateTime actual) {
        super(actual, MoreZonedDateTimeAssertImpl.class);
    }
}
