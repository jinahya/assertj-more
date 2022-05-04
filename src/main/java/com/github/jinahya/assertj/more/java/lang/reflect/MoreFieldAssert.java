package com.github.jinahya.assertj.more.java.lang.reflect;

import java.lang.reflect.Field;

public interface MoreFieldAssert<S extends MoreFieldAssert<S>>
        extends MoreJavaLangReflectAssert<S, Field>,
                ModifiersAssertable<S, Field> {

}
