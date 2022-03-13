package com.github.jinahya.assertj.more.java.time.chrono;

import java.time.chrono.Chronology;

class DefaultChronologyAssert
        extends AbstractChronologyAssert<DefaultChronologyAssert, Chronology> {

    public DefaultChronologyAssert(final Chronology actual) {
        super(actual, DefaultChronologyAssert.class);
    }
}
