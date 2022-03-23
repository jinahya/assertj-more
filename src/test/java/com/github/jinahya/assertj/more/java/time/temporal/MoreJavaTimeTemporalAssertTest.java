package com.github.jinahya.assertj.more.java.time.temporal;

import com.github.jinahya.assertj.more.MoreAssertTest;

abstract class MoreJavaTimeTemporalAssertTest<S extends MoreJavaTimeTemporalAssert<S, A>, A>
        extends MoreAssertTest<S, A> {

    protected MoreJavaTimeTemporalAssertTest(final Class<S> assertClass,
                                             final Class<A> actualClass) {
        super(assertClass, actualClass);
    }
}