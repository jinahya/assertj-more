package com.github.jinahya.assertj.more.java.time.chrono;

import com.github.jinahya.assertj.more.AbstractMoreAssertions;

import java.time.chrono.Chronology;
import java.time.chrono.Era;

public class MoreJavaTimeChronoAssertions
        extends AbstractMoreAssertions {

    public static AbstractMoreChronologyAssert<?, Chronology> assertMore(final Chronology actual) {
        return new MoreChronologyAssertImpl(actual);
    }

    public static AbstractMoreEraAssert<?, Era> assertMore(final Era actual) {
        return new MoreEraAssertImpl_(actual);
    }

    protected MoreJavaTimeChronoAssertions() {
        super();
    }
}
