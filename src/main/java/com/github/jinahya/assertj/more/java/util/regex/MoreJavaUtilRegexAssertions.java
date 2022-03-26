package com.github.jinahya.assertj.more.java.util.regex;

import com.github.jinahya.assertj.more.AbstractMoreAssertions;

import java.util.regex.Matcher;

public class MoreJavaUtilRegexAssertions
        extends AbstractMoreAssertions {

    public static AbstractMoreMatcherAssert<?> assertMore(final Matcher actual) {
        return new MoreMatcherAssertImpl(actual);
    }

    protected MoreJavaUtilRegexAssertions() {
        super();
    }
}
