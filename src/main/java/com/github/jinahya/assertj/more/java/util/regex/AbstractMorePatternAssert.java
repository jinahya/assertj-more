package com.github.jinahya.assertj.more.java.util.regex;

import org.assertj.core.api.AbstractAssert;

import java.util.regex.Pattern;

public abstract class AbstractMorePatternAssert<S extends AbstractMorePatternAssert<S>>
        extends AbstractAssert<S, Pattern>
        implements MorePatternAssert<S> {

    protected AbstractMorePatternAssert(final Pattern actual, final Class<S> selfType) {
        super(actual, selfType);
    }
}
