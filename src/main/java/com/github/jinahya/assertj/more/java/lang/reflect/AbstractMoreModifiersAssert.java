package com.github.jinahya.assertj.more.java.lang.reflect;

import org.assertj.core.api.AbstractIntegerAssert;

public abstract class AbstractMoreModifiersAssert<S extends AbstractMoreModifiersAssert<S>>
        extends AbstractIntegerAssert<S>
        implements MoreModifiersAssert<S> {

    protected AbstractMoreModifiersAssert(final Integer actual, final Class<?> selfType) {
        super(actual, selfType);
    }
}
