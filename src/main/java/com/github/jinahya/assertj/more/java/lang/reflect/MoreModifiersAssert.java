package com.github.jinahya.assertj.more.java.lang.reflect;

import com.github.jinahya.assertj.more.hidden.ForAssert;

import java.lang.reflect.Modifier;

import static org.assertj.core.api.Assertions.assertThat;

public interface MoreModifiersAssert<S extends MoreModifiersAssert<S>>
        extends MoreJavaLangReflectAssert<S, Integer> {

    /**
     * Verifies that the {@code actual} modifiers includes the {@code abstract} modifier.
     *
     * @return this assertion object.
     * @see Modifier#isAbstract(int)
     */
    default S includesAbstract() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    assertThat(Modifier.isAbstract(a))
                            .as("result of Modifier.isAbstract(%d)", a)
                            .isTrue();
                    return s;
                }
        );
    }

    /**
     * Verifies that the {@code actual} modifiers does not include the {@code abstract} modifier.
     *
     * @return this assertion object.
     * @see Modifier#isAbstract(int)
     */
    default S doesNotIncludeAbstract() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    assertThat(Modifier.isAbstract(a))
                            .as("result of Modifier.isAbstract(%d)", a)
                            .isFalse();
                    return s;
                }
        );
    }

    default S includesFinal() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    assertThat(Modifier.isFinal(a))
                            .as("result of Modifier.isFinal(%d)", a)
                            .isTrue();
                    return s;
                }
        );
    }

    default S doesNotIncludeFinal() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    assertThat(Modifier.isFinal(a))
                            .as("result of Modifier.isFinal(%d)", a)
                            .isTrue();
                    return s;
                }
        );
    }

    // TODO: 2022/05/04 add more!
}
