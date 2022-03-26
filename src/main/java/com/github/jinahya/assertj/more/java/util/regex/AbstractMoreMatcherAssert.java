package com.github.jinahya.assertj.more.java.util.regex;

import org.assertj.core.api.AbstractAssert;

import java.util.regex.Matcher;

// https://github.com/assertj/assertj-core/issues/2081
public abstract class AbstractMoreMatcherAssert<S extends AbstractMoreMatcherAssert<S>>
        extends AbstractAssert<S, Matcher>
        implements MoreMatcherAssert<S> {

    protected AbstractMoreMatcherAssert(final Matcher actual, final Class<S> selfType) {
        super(actual, selfType);
    }
}
