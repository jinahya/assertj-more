package com.github.jinahya.assertj.more.java.time.chrono;

import com.github.jinahya.assertj.more.MoreAssertTest;

abstract class MoreJavaTimeChronoAssertTest<ASSERT extends MoreJavaTimeChronoAssert<ASSERT, ACTUAL>, ACTUAL>
        extends MoreAssertTest<ASSERT, ACTUAL> {

    protected MoreJavaTimeChronoAssertTest(final Class<ASSERT> assertClass, final Class<ACTUAL> actualClass) {
        super(assertClass, actualClass);
    }
}