package com.github.jinahya.assertj.more.java.lang.reflect;

import com.github.jinahya.assertj.more.AbstractMoreAssertions;

import java.lang.reflect.Field;
import java.util.Objects;

public class MoreJavaLangReflectAssertions
        extends AbstractMoreAssertions {

    public static AbstractMoreModifiersAssert<?> assertMore(final ModifiersWrapper wrapper) {
        Objects.requireNonNull(wrapper, "wrapper is null");
        return new MoreModifiersAssertImpl(wrapper.getActual());
    }

    public static AbstractMoreFieldAssert<?> assertMore(final Field actual) {
        return new MoreFieldAssertImpl(actual);
    }

    protected MoreJavaLangReflectAssertions() {
        super();
    }
}
