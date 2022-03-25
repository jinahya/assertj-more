package com.github.jinahya.assertj.more.java.time;

import java.time.LocalTime;

class MoreLocalTimeAssertImpl
        extends AbstractMoreLocalTimeAssert<MoreLocalTimeAssertImpl> {

    MoreLocalTimeAssertImpl(final LocalTime actual) {
        super(actual, MoreLocalTimeAssertImpl.class);
    }
}
