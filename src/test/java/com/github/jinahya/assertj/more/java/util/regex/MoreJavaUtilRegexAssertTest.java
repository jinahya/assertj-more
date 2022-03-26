package com.github.jinahya.assertj.more.java.util.regex;

import com.github.jinahya.assertj.more.MoreAssertTest;

abstract class MoreJavaUtilRegexAssertTest<S extends MoreJavaUtilRegexAssert<S, A>, A>
        extends MoreAssertTest<S, A> {

    protected MoreJavaUtilRegexAssertTest(final Class<S> assertClass, final Class<A> actualClass) {
        super(assertClass, actualClass);
    }
}