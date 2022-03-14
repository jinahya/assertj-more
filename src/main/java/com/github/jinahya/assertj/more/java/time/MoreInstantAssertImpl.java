package com.github.jinahya.assertj.more.java.time;

import java.time.Instant;

class MoreInstantAssertImpl
        extends AbstractMoreInstantAssert<MoreInstantAssertImpl> {

    MoreInstantAssertImpl(final Instant actual) {
        super(actual, MoreInstantAssertImpl.class);
    }
}
