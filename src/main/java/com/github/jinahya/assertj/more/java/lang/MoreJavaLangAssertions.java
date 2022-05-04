package com.github.jinahya.assertj.more.java.lang;

import com.github.jinahya.assertj.more.AbstractMoreAssertions;

public class MoreJavaLangAssertions
        extends AbstractMoreAssertions {

    public static AbstractMoreClassAssert<?> assertMore(final Class<?> actual) {
        return new MoreClassAssertImpl(actual);
    }

    protected MoreJavaLangAssertions() {
        super();
    }
}
