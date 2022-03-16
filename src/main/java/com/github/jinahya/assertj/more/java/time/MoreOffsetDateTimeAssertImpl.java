package com.github.jinahya.assertj.more.java.time;

import java.time.OffsetDateTime;

class MoreOffsetDateTimeAssertImpl
        extends AbstractMoreOffsetDateTimeAssert<MoreOffsetDateTimeAssertImpl> {

    MoreOffsetDateTimeAssertImpl(final OffsetDateTime actual) {
        super(actual, MoreOffsetDateTimeAssertImpl.class);
    }
}
