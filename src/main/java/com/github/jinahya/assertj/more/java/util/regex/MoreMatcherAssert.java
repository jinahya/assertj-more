package com.github.jinahya.assertj.more.java.util.regex;

import com.github.jinahya.assertj.more.api.MoreAssertions;
import com.github.jinahya.assertj.more.hidden.ForAssert;
import org.assertj.core.api.AbstractStringAssert;
import org.assertj.core.api.Assertions;

import java.util.regex.Matcher;

public interface MoreMatcherAssert<S extends MoreMatcherAssert<S>>
        extends MoreJavaUtilRegexAssert<S, Matcher> {

    /**
     * Verifies that the {@link Matcher#appendReplacement(StringBuffer, String)} method, invoked on the {@code actual}
     * with specified arguments, does not throw any exception.
     *
     * @param sb          the {@code sb} argument.
     * @param replacement the {@code replacement} argument.
     * @return this assertion instance.
     */
    default S appendsReplacement(final StringBuffer sb, final String replacement) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApply(() -> {
                    a.appendReplacement(sb, replacement);
                    return s;
                })
        );
    }

    /**
     * Verifies that {@link Matcher#appendTail(StringBuffer)} method, invoked on the {@code actual} with specified
     * buffer, does not throw any exception.
     *
     * @param sb the buffer.
     * @return this assertion instance.
     */
    default S appendsTail(final StringBuffer sb) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApply(() -> {
                    a.appendTail(sb);
                    return s;
                })
        );
    }

    default S hasEnd(final int expected) {
        return ForAssert.applyActual2(
                matches(),
                s -> a -> {
                    Assertions.assertThat(a.end())
                            .isEqualTo(expected);
                    return s;
                }
        );
    }

    default S hasEnd(final int group, final int expected) {
        return ForAssert.applyActual2(
                matches(),
                s -> a -> {
                    return MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApply(
                            () -> a.end(group),
                            v -> {
                                Assertions.assertThat(v)
                                        .isEqualTo(expected);
                                return s;
                            }
                    );
                }
        );
    }

    default S hasEnd(final String name, final int expected) {
        return ForAssert.applyActual2(
                matches(),
                s -> a -> {
                    return MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApply(
                            () -> a.end(name),
                            v -> {
                                Assertions.assertThat(v)
                                        .isEqualTo(expected);
                                return s;
                            }
                    );
                }
        );
    }

    default S finds() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.find())
                            .isTrue();
                    return s;
                }
        );
    }

    default S doesNotFind() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.find())
                            .isFalse();
                    return s;
                }
        );
    }

    default S finds(final int start) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    return MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApply(
                            () -> a.find(start),
                            v -> {
                                Assertions.assertThat(v)
                                        .isTrue();
                                return s;
                            }
                    );
                }
        );
    }

    default S doesNotFind(final int start) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    return MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApply(
                            () -> a.find(start),
                            v -> {
                                Assertions.assertThat(v)
                                        .isFalse();
                                return s;
                            }
                    );
                }
        );
    }

    default AbstractStringAssert<?> extractingGroup() {
        return ForAssert.applyActual2(
                matches(),
                s -> a -> {
                    return MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApply(
                            a::group,
                            Assertions::assertThat
                    );
                }
        );
    }

    @SuppressWarnings({"unchecked"})
    default S hasGroup(final String expected) {
        extractingGroup()
                .isEqualTo(expected);
        return (S) this;
    }

    default AbstractStringAssert<?> extractingGroup(final int group) {
        return ForAssert.applyActual2(
                matches(),
                s -> a -> {
                    return MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApply(
                            () -> a.group(group),
                            Assertions::assertThat
                    );
                }
        );
    }

    @SuppressWarnings({"unchecked"})
    default S hasGroup(final int group, final String expected) {
        extractingGroup(group)
                .isEqualTo(expected);
        return (S) this;
    }

    default AbstractStringAssert<?> extractingGroup(final String name) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    return MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApply(
                            () -> a.group(name),
                            Assertions::assertThat
                    );
                }
        );
    }

    @SuppressWarnings({"unchecked"})
    default S hasGroup(final String name, final String expected) {
        extractingGroup(name)
                .isEqualTo(expected);
        return (S) this;
    }

    default S hasGroupCount(final int expected) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.groupCount())
                            .isEqualTo(expected);
                    return s;
                }
        );
    }

    default S hasAnchoringBounds() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.hasAnchoringBounds())
                            .isTrue();
                    return s;
                }
        );
    }

    default S doesNotHaveAnchoringBounds() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.hasAnchoringBounds())
                            .isFalse();
                    return s;
                }
        );
    }

    default S hasTransparentBounds() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.hasTransparentBounds())
                            .isTrue();
                    return s;
                }
        );
    }

    default S doesNotHaveTransparentBounds() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.hasTransparentBounds())
                            .isFalse();
                    return s;
                }
        );
    }

    default S hitEnd() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.hitEnd())
                            .isTrue();
                    return s;
                }
        );
    }

    default S didNotHitEnd() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.hitEnd())
                            .isFalse();
                    return s;
                }
        );
    }

    default S matchesLookingAt() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.lookingAt())
                            .isTrue();
                    return s;
                }
        );
    }

    default S doesNotMatchLookingAt() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.lookingAt())
                            .isFalse();
                    return s;
                }
        );
    }

    default S matches() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.matches())
                            .isTrue();
                    return s;
                }
        );
    }

    default S doesNotMatch() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.matches())
                            .isFalse();
                    return s;
                }
        );
    }
}
