package com.github.jinahya.assertj.more.java.lang.reflect;

import com.github.jinahya.assertj.more.hidden.ForAssert;
import org.assertj.core.api.Assert;

import java.util.Objects;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * An interface for asserting {@code modifiers} of actuals.
 *
 * @param <S> self type parameter
 * @param <A> actual type parameter
 */
public interface ModifiersAssertable<S extends Assert<S, A> & ModifiersAssertable<S, A>, A>
        extends Assert<S, A> {

    /**
     * Verifies that the {@code actual}'s {@link Class#getModifiers() modifiers} is equal to specified value.
     *
     * @param expected the expected value of {@code actual.modifiers}.
     * @return this assertion object.
     */
    default S hasModifiers(final int expected) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    final int modifiers = ModifiersAssertible.getModifiers(a);
                    assertThat(modifiers).isEqualTo(expected);
                    return s;
                }
        );
    }

    /**
     * Verifies that the {@code actual}'s {@link Class#getModifiers() modifiers} satisfies with an instance of
     * {@link MoreModifiersAssert}.
     *
     * @param requirements a consumer accepts an instance of {@link MoreModifiersAssert} initialized with
     *                     {@code actual.modifiers}.
     * @return this assertion object.
     */
    default S hasModifiersSatisfying(final Consumer<? super MoreModifiersAssert<?>> requirements) {
        Objects.requireNonNull(requirements, "requirements is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    final var modifiers = ModifiersAssertible.getModifiers(a);
                    final var wrapper = ModifiersWrapper.of(modifiers);
                    requirements.accept(MoreJavaLangReflectAssertions.assertMore(wrapper));
                    return s;
                }
        );
    }

    default S isAbstract() {
        return hasModifiersSatisfying(MoreModifiersAssert::includesAbstract);
    }

    default S isNotAbstract() {
        return hasModifiersSatisfying(MoreModifiersAssert::doesNotIncludeAbstract);
    }

    default S isFinal() {
        return hasModifiersSatisfying(MoreModifiersAssert::includesFinal);
    }

    default S isNotFinal() {
        return hasModifiersSatisfying(MoreModifiersAssert::doesNotIncludeFinal);
    }
}
