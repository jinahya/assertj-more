package com.github.jinahya.assertj.more.java.lang;

import com.github.jinahya.assertj.more.MoreAssertTest;

public abstract class MoreJavaLangAssertTest<S extends MoreJavaLangAssert<S, A>, A>
        extends MoreAssertTest<S, A> {

    protected MoreJavaLangAssertTest(final Class<S> assertClass, final Class<A> actualClass) {
        super(assertClass, actualClass);
    }
}