package com.github.jinahya.assertj.more.java.time;

import java.time.Duration;

class MoreDurationAssertImpl
        extends AbstractMoreDurationAssert<MoreDurationAssertImpl> {

    MoreDurationAssertImpl(final Duration actual) {
        super(actual, MoreDurationAssertImpl.class);
    }
}
