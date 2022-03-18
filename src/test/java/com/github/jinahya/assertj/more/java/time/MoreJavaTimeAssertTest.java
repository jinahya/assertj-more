package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.MoreAssertTest;

public abstract class MoreJavaTimeAssertTest<S extends MoreJavaTimeAssert<S, A>, A>
        extends MoreAssertTest<S, A> {

    protected MoreJavaTimeAssertTest(final Class<S> assertClass, final Class<A> actualClass) {
        super(assertClass, actualClass);
    }
}