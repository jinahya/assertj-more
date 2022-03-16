package com.github.jinahya.assertj.more.java.time.chrono;

import com.github.jinahya.assertj.more.AbstractMoreAssertions;

import java.time.chrono.ChronoPeriod;
import java.time.chrono.Chronology;
import java.time.chrono.Era;

public class MoreJavaTimeChronoAssertions
        extends AbstractMoreAssertions {

    public static AbstractMoreChronoPeriodAssert<?, ChronoPeriod> assertMore(final ChronoPeriod actual) {
        return new MoreChronoPeriodAssertImpl(actual);
    }

    public static AbstractMoreChronologyAssert<?, Chronology> assertMore(final Chronology actual) {
        return new DefaultChronologyAssert(actual);
    }

    public static AbstractMoreEraAssert<?, Era> assertMore(final Era actual) {
        return new MoreEraAssertImpl_(actual);
    }

    protected MoreJavaTimeChronoAssertions() {
        super();
    }
}
