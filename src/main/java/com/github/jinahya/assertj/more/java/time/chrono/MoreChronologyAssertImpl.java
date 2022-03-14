package com.github.jinahya.assertj.more.java.time.chrono;

import java.time.chrono.Chronology;

class MoreChronologyAssertImpl
        extends AbstractMoreChronologyAssert<MoreChronologyAssertImpl, Chronology> {

    MoreChronologyAssertImpl(final Chronology actual) {
        super(actual, MoreChronologyAssertImpl.class);
    }
}
