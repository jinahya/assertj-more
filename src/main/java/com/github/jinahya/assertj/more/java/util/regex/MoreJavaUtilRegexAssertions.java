package com.github.jinahya.assertj.more.java.util.regex;

import com.github.jinahya.assertj.more.AbstractMoreAssertions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoreJavaUtilRegexAssertions
        extends AbstractMoreAssertions {

    public static AbstractMoreMatcherAssert<?> assertMore(final Matcher actual) {
        return new MoreMatcherAssertImpl(actual);
    }

    public static AbstractMorePatternAssert<?> assertMore(final Pattern actual) {
        return new MorePatternAssertImpl(actual);
    }

    protected MoreJavaUtilRegexAssertions() {
        super();
    }
}
