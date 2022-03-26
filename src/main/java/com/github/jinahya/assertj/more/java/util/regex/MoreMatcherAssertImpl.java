package com.github.jinahya.assertj.more.java.util.regex;

import java.util.regex.Matcher;

class MoreMatcherAssertImpl
        extends AbstractMoreMatcherAssert<MoreMatcherAssertImpl> {

    MoreMatcherAssertImpl(final Matcher actual) {
        super(actual, MoreMatcherAssertImpl.class);
    }
}
