package com.github.jinahya.assertj.more.java.time.chrono;

import com.github.jinahya.assertj.more.MoreAssertTest;

abstract class MoreJavaTimeChronoAssertTest<S extends MoreJavaTimeChronoAssert<S, A>, A>
        extends MoreAssertTest<S, A> {

    protected MoreJavaTimeChronoAssertTest(final Class<S> assertClass, final Class<A> actualClass) {
        super(assertClass, actualClass);
    }
}