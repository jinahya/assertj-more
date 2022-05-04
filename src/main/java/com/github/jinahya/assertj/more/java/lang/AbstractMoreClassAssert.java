package com.github.jinahya.assertj.more.java.lang;

import org.assertj.core.api.AbstractClassAssert;

public class AbstractMoreClassAssert<S extends AbstractMoreClassAssert<S>>
        extends AbstractClassAssert<S>
        implements MoreClassAssert<S> {

    protected AbstractMoreClassAssert(final Class<?> actual, final Class<?> selfType) {
        super(actual, selfType);
    }
}
