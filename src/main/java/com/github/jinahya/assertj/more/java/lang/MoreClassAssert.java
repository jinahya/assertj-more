package com.github.jinahya.assertj.more.java.lang;

import com.github.jinahya.assertj.more.hidden.ForAssert;
import com.github.jinahya.assertj.more.java.lang.reflect.ModifiersAssertable;

import static org.assertj.core.api.Assertions.assertThat;

public interface MoreClassAssert<S extends MoreClassAssert<S>>
        extends MoreJavaLangAssert<S, Class<?>>,
                ModifiersAssertable<S, Class<?>> {

    /**
     * Verifies that the {@code actual} class is assignable to specified class.
     *
     * @param clazz the class supposed to be assignable from the {@code actual} class.
     * @return this assertion object.
     * @see org.assertj.core.api.AbstractClassAssert#isAssignableFrom(Class[])
     */
    // https://github.com/assertj/assertj-core/issues/2570
    default S isAssignableTo(final Class<?> clazz) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    assertThat(clazz).isAssignableFrom(a);
                    return s;
                }
        );
    }
}
