package com.github.jinahya.assertj.more.java.time.temporal;

import com.github.jinahya.assertj.more.MoreAssertTest;

import java.time.temporal.TemporalAccessor;

abstract class MoreJavaTimeTemporalAssertTest<
        ASSERT extends MoreJavaTimeTemporalAssert<ASSERT, ACTUAL>,
        ACTUAL extends TemporalAccessor>
        extends MoreAssertTest<ASSERT, ACTUAL> {

    protected MoreJavaTimeTemporalAssertTest(final Class<ASSERT> assertClass,
                                             final Class<ACTUAL> actualClass) {
        super(assertClass, actualClass);
    }
}