package com.github.jinahya.assertj.more.java.lang.reflect;

import org.assertj.core.api.AbstractAssert;

import java.lang.reflect.Field;

public abstract class AbstractMoreFieldAssert<S extends AbstractMoreFieldAssert<S>>
        extends AbstractAssert<S, Field>
        implements MoreJavaLangReflectAssert<S, Field> {

    protected AbstractMoreFieldAssert(final Field actual, final Class<?> selfType) {
        super(actual, selfType);
    }
}
