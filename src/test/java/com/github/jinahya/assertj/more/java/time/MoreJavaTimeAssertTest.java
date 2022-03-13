package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.MoreAssertTest;

public abstract class MoreJavaTimeAssertTest<ASSERT extends MoreJavaTimeAssert<ASSERT, ACTUAL>, ACTUAL>
        extends MoreAssertTest<ASSERT, ACTUAL> {

    protected MoreJavaTimeAssertTest(final Class<ASSERT> assertClass, final Class<ACTUAL> actualClass) {
        super(assertClass, actualClass);
    }
}