package com.github.jinahya.assertj.more.java.lang.reflect;

import java.lang.reflect.Field;

class MoreFieldAssertImpl
        extends AbstractMoreFieldAssert<MoreFieldAssertImpl> {

    MoreFieldAssertImpl(final Field actual) {
        super(actual, MoreFieldAssertImpl.class);
    }
}
