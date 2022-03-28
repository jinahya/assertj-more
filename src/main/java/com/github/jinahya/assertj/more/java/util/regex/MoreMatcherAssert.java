package com.github.jinahya.assertj.more.java.util.regex;

import com.github.jinahya.assertj.more.api.MoreAssertions;
import com.github.jinahya.assertj.more.hidden.ForAssert;
import org.assertj.core.api.Assertions;

import java.lang.reflect.Method;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface MoreMatcherAssert<S extends MoreMatcherAssert<S>>
        extends MoreMatchResultAssert<S, Matcher> {

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
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApply(
                        () -> a.appendReplacement(sb, replacement),
                        r -> s
                )
        );
    }

    default S appendsReplacement(final StringBuilder sb, final String replacement) {
        try {
            final Method method = Matcher.class.getMethod("appendReplacement", StringBuilder.class, String.class);
            return ForAssert.applyActual2(
                    isNotNull(),
                    s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApply(
                            () -> method.invoke(a, sb, replacement),
                            r -> s
                    )
            );
        } catch (final NoSuchMethodException nsme) {
            final StringBuffer b = new StringBuffer();
            try {
                return appendsReplacement(b, replacement);
            } finally {
                sb.append(b);
            }
        }
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
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApply(
                        () -> a.appendTail(sb),
                        r -> s
                )
        );
    }

    default S appendsTail(final StringBuilder sb) { // Java 9
        try {
            final Method method = Matcher.class.getMethod("appendTail", StringBuilder.class);
            return ForAssert.applyActual2(
                    isNotNull(),
                    s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApply(
                            () -> method.invoke(a, sb),
                            r -> s
                    )
            );
        } catch (final NoSuchMethodException nsme) {
            final StringBuffer b = new StringBuffer();
            try {
                return appendsTail(b);
            } finally {
                sb.append(b);
            }
        }
    }

    default S hasEndSatisfying(final String name, final IntConsumer consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApply(
                        () -> a.end(name),
                        r -> {
                            consumer.accept(r);
                            return s;
                        }
                )
        );
    }

    default S hasEnd(final String name, final int expected) {
        return hasEndSatisfying(name, r -> Assertions.assertThat(r).isEqualTo(expected));
    }

    /**
     * Verifies that the {@link Matcher#find()} method, invoked on the {@code actual}, results {@code true}.
     *
     * @return this assertion instance.
     * @see #doesNotFind()
     * @see #finds(int)
     */
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

    /**
     * Verifies that the {@link Matcher#find()} method, invoked on the {@code actual}, results {@code false}.
     *
     * @return this assertion instance.
     * @see #finds()
     */
    @SuppressWarnings({"unchecked"})
    default S doesNotFind() {
        Assertions.assertThatThrownBy(this::finds)
                .isInstanceOf(AssertionError.class);
        return (S) this;
    }

    /**
     * Verifies that the {@link Matcher#find(int)} method, invoked on the {@code actual} with specified argument,
     * results {@code true}.
     *
     * @param start a value for the {@code start} parameter.
     * @return this assertion instance.
     * @see #doesNotFind(int)
     * @see #finds()
     */
    default S finds(final int start) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApply(
                        () -> a.find(start),
                        v -> {
                            Assertions.assertThat(v)
                                    .isTrue();
                            return s;
                        }
                )
        );
    }

    /**
     * Verifies that the {@link Matcher#find(int)} method, invoked on the {@code actual} with specified argument,
     * results {@code false}.
     *
     * @param start a value for the {@code start} parameter.
     * @return this assertion instance.
     * @see #finds(int)
     */
    @SuppressWarnings({"unchecked"})
    default S doesNotFind(final int start) {
        Assertions.assertThatThrownBy(() -> finds(start))
                .isInstanceOf(AssertionError.class);
        return (S) this;
    }

    default S hasGroupSatisfying(final String name, final Consumer<? super String> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApply(
                        () -> a.group(name),
                        r -> {
                            consumer.accept(r);
                            return s;
                        }
                )
        );
    }

    default S hasGroup(final String name, final String expected) {
        return hasGroupSatisfying(name, r -> Assertions.assertThat(r).isEqualTo(expected));
    }

    /**
     * Verifies that the {@link Matcher#hasAnchoringBounds()} method, invokes on the {@code actual}, returns {@code
     * true}.
     *
     * @return this assertion instance.
     */
    default S usesAnchoringBounds() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.hasAnchoringBounds())
                            .isTrue();
                    return s;
                }
        );
    }

    /**
     * Verifies that the {@link Matcher#hasAnchoringBounds()} method, invokes on the {@code actual}, returns {@code
     * false}.
     *
     * @return this assertion instance.
     */
    @SuppressWarnings({"unchecked"})
    default S doesNotUseAnchoringBounds() {
        Assertions.assertThatThrownBy(this::usesAnchoringBounds)
                .isInstanceOf(AssertionError.class);
        return (S) this;
    }

    default S usesTransparentBounds() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.hasTransparentBounds())
                            .isTrue();
                    return s;
                }
        );
    }

    @SuppressWarnings({"unchecked"})
    default S doesNotUseTransparentBounds() {
        Assertions.assertThatThrownBy(this::usesTransparentBounds)
                .isInstanceOf(AssertionError.class);
        return (S) this;
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

    @SuppressWarnings({"unchecked"})
    default S didNotHitEnd() {
        Assertions.assertThatThrownBy(this::hitEnd)
                .isInstanceOf(AssertionError.class);
        return (S) this;
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
        Assertions.assertThatThrownBy(this::matchesLookingAt)
                .isInstanceOf(AssertionError.class);
        return (S) this;
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

    @SuppressWarnings({"unchecked"})
    default S doesNotMatch() {
        Assertions.assertThatThrownBy(this::matches)
                .isInstanceOf(AssertionError.class);
        return (S) this;
    }

    default S hasPatternSatisfying(final Consumer<? super Pattern> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    consumer.accept(a.pattern());
                    return s;
                }
        );
    }

    /**
     * Verifies that the {@link Matcher#region(int, int)} method, invoked on the {@code actual} with specified
     * arguments, does not throw any exception.
     *
     * @param start a value for {@code start} parameter.
     * @param end   a value for {@code end} parameter.
     * @return this assertion instance.
     */
    default S setsRegion(final int start, final int end) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApply(
                        () -> a.region(start, end),
                        r -> s
                )
        );
    }

    default S reportsRegionEndSatisfying(final IntConsumer consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    consumer.accept(a.regionEnd());
                    return s;
                }
        );
    }

    default S reportsRegionEnd(final int expected) {
        return reportsRegionEndSatisfying(r -> Assertions.assertThat(r).isEqualTo(expected));
    }

    default S reportsRegionStartSatisfying(final IntConsumer consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    consumer.accept(a.regionStart());
                    return s;
                }
        );
    }

    default S reportsRegionStart(final int expected) {
        return reportsRegionStartSatisfying(r -> Assertions.assertThat(r).isEqualTo(expected));
    }

    default S replacesAllSatisfying(final String replacement, final Consumer<? super String> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApply(
                        () -> a.replaceAll(replacement),
                        r -> {
                            consumer.accept(r);
                            return s;
                        }
                )
        );
    }

    default S replacesAll(final String replacement, final String expected) {
        return replacesAllSatisfying(replacement, r -> Assertions.assertThat(r).isEqualTo(expected));
    }

    default S replacesFirstSatisfying(final String replacement, final Consumer<? super String> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApply(
                        () -> a.replaceFirst(replacement),
                        r -> {
                            consumer.accept(r);
                            return s;
                        }
                )
        );
    }

    default S replacesFirst(final String replacement, final String expected) {
        return replacesFirstSatisfying(replacement, r -> Assertions.assertThat(r).isEqualTo(expected));
    }

    default S requiresEnd() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.requireEnd()).isTrue();
                    return s;
                }
        );
    }

    default S doesNotRequireEnd() {
        Assertions.assertThatThrownBy(this::requiresEnd)
                .isInstanceOf(AssertionError.class);
        return (S) this;
    }

    default S resets() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    a.reset();
                    return s;
                }
        );
    }

    default S resets(final CharSequence input) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    a.reset(input);
                    return s;
                }
        );
    }

    default S hasStartSatifying(final String name, final IntConsumer consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApply(
                        () -> a.start(name),
                        r -> {
                            consumer.accept(r);
                            return s;
                        }
                )
        );
    }

    default S hasStart(final String name, final int expected) {
        return hasStartSatifying(name, r -> Assertions.assertThat(r).isEqualTo(expected));
    }

    default S toMatchResultSatisfies(final Consumer<? super MatchResult> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    consumer.accept(a.toMatchResult());
                    return s;
                }
        );
    }

    default S setsAnchoringBounds(final boolean b) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    a.useAnchoringBounds(b);
                    return s;
                }
        );
    }

    default S usingAnchoringBounds(final boolean b) {
        return setsAnchoringBounds(b);
    }

    /**
     * Verifies that the {@link Matcher#usePattern(Pattern)} method, invoked on the {@code actual} with specified
     * argument, does not throw any exception.
     *
     * @param newPattern a value for {@code newPattern} parameter of {@link Matcher#usePattern(Pattern)} method.
     * @return this assertion instance.
     * @see #usingPattern(Pattern)
     */
    default S setsPattern(final Pattern newPattern) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApply(
                        () -> a.usePattern(newPattern),
                        r -> s
                )
        );
    }

    /**
     * An alias of {@link #setsPattern(Pattern)} method.
     *
     * @param newPattern a value for {@code newPattern} parameter of {@link Matcher#usePattern(Pattern)} method.
     * @return this assertion instance.
     */
    default S usingPattern(final Pattern newPattern) {
        return setsPattern(newPattern);
    }

    default S setsTransparentBounds(final boolean b) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    a.useTransparentBounds(b);
                    return s;
                }
        );
    }

    default S usingTransparentBounds(final boolean b) {
        return setsTransparentBounds(b);
    }
}
