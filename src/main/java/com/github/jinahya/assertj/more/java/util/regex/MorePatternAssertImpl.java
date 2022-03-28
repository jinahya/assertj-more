package com.github.jinahya.assertj.more.java.util.regex;

import java.util.regex.Pattern;

class MorePatternAssertImpl
        extends AbstractMorePatternAssert<MorePatternAssertImpl> {

    MorePatternAssertImpl(final Pattern actual) {
        super(actual, MorePatternAssertImpl.class);
    }
}
