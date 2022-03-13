package com.github.jinahya.assertj.more.java.time.temporal;

import java.time.LocalDateTime;

class MoreLocalDateTimeAssertImpl
        extends AbstractMoreLocalDateTimeAssert<MoreLocalDateTimeAssertImpl> {

    MoreLocalDateTimeAssertImpl(final LocalDateTime actual) {
        super(actual, MoreLocalDateTimeAssertImpl.class);
    }
}
