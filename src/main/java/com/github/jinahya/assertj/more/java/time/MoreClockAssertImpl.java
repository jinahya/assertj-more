package com.github.jinahya.assertj.more.java.time;

import java.time.Clock;

class MoreClockAssertImpl
        extends AbstractMoreClockAssert<MoreClockAssertImpl, Clock> {

    MoreClockAssertImpl(final Clock clock) {
        super(clock, MoreClockAssertImpl.class);
    }
}
