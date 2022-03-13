package com.github.jinahya.assertj.more.java.time.chrono;

import com.github.jinahya.assertj.more.AbstractMoreAssertions;

import java.time.chrono.Chronology;

public class MoreJavaTimeChronoAssertions
        extends AbstractMoreAssertions {

    public static AbstractChronologyAssert<?, Chronology> assertMore(final Chronology actual) {
        return new DefaultChronologyAssert(actual);
    }

    protected MoreJavaTimeChronoAssertions() {
        super();
    }
}
