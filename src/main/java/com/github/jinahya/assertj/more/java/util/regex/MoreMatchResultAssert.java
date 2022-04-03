package com.github.jinahya.assertj.more.java.util.regex;

import com.github.jinahya.assertj.more.api.MoreAssertions;
import com.github.jinahya.assertj.more.hidden.ForAssert;
import org.assertj.core.api.Assertions;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.regex.MatchResult;

/**
 * An interface for verifying instances of {@link MatchResult}.
 *
 * @param <S> self type parameter
 * @param <A> type of value to verify
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
public interface MoreMatchResultAssert<S extends MoreMatchResultAssert<S, A>, A extends MatchResult>
        extends MoreJavaUtilRegexAssert<S, A> {

    /**
     * Verifies that the {@link MatchResult#end()} method, invoked on the {@code actual}, does not throw any exception
     * and the result is verified with specified consumer.
     *
     * @param consumer the consumer verifies the value of {@code actual.end()}.
     * @return this assertion instance.
     */
    default S hasEndSatisfying(final IntConsumer consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        a::end,
                        v -> {
                            consumer.accept(v);
                            return s;
                        }
                )
        );
    }

    /**
     * Verifies that the {@link MatchResult#end()} method, invoked on the {@code actual}, returns specified value with
     * no exception thrown.
     *
     * @param expected the expected value of {@code actual.end()}.
     * @return this assertion instance.
     */
    default S hasEnd(final int expected) {
        return hasEndSatisfying(r -> Assertions.assertThat(r).isEqualTo(expected));
    }

    /**
     * Verifies that the {@link MatchResult#end(int)} method, invoked on the {@code actual} with specified argument,
     * does not throw any exception and the result satisfies by being accepted to specified consumer.
     *
     * @param group    a value for the {@code group} parameter.
     * @param consumer the consumer verifies the result.
     * @return this assertion instance.
     */
    default S hasEndSatisfying(final int group, final IntConsumer consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.end(group),
                        r -> {
                            consumer.accept(r);
                            return s;
                        }
                )
        );
    }

    /**
     * Verifies that the {@link MatchResult#end(int)} method, invoked on the {@code actual} with specified argument,
     * returns specified value with no exception thrown.
     *
     * @param expected the expected value of {@code actual.end()}.
     * @return this assertion instance.
     */
    default S hasEnd(final int group, final int expected) {
        return hasEndSatisfying(group, r -> Assertions.assertThat(r).isEqualTo(expected));
    }

    /**
     * Verifies that the {@link MatchResult#group()} method, invokes on the {@code actual}, does not throw an exception
     * and the result satisfies by being accepted to specified consumer.
     *
     * @param consumer the consumer verifies the result of {@code actual.group()}.
     * @return this assertion instance.
     */
    default S hasGroupSatisfying(final Consumer<? super String> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        a::group,
                        v -> {
                            consumer.accept(v);
                            return s;
                        }
                )
        );
    }

    /**
     * Verifies that the {@link MatchResult#group()} method, invoked on the {@code actual}, does not throw any exception
     * and the result equals to specified value.
     *
     * @param expected the expected value of {@code actual.group()}.
     * @return this assertion instance.
     * @see MatchResult#group()
     */
    default S hasGroup(final String expected) {
        return hasGroupSatisfying(r -> Assertions.assertThat(r).isEqualTo(expected));
    }

    /**
     * Verifies that the {@link MatchResult#group(int)} method, invokes on the {@code actual} with specified argument,
     * does not throw an exception and the result satisfies by being accepted to specified consumer.
     *
     * @param group    a value for the {@code group} parameter.
     * @param consumer the consumer verifies the result of {@code actual.group()}.
     * @return this assertion instance.
     * @see MatchResult#group(int)
     */
    default S hasGroupSatisfying(int group, final Consumer<? super String> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.group(group),
                        v -> {
                            consumer.accept(v);
                            return s;
                        }
                )
        );
    }

    /**
     * Verifies that the {@link MatchResult#group(int)} method, invoked on the {@code actual} with specified argument,
     * does not throw any exception and the result equals to specified value.
     *
     * @param group    a value for the {@code group} parameter.
     * @param expected the expected value of {@code actual.group(group)}.
     * @return this assertion instance.
     * @see MatchResult#group(int)
     */
    default S hasGroup(final int group, final String expected) {
        return hasGroupSatisfying(group, r -> Assertions.assertThat(r).isEqualTo(expected));
    }

    /**
     * Verifies that the {@link MatchResult#groupCount()} method, invokes on the {@code actual}, does not throw an
     * exception and the result satisfies by being accepted to specified consumer.
     *
     * @param consumer the consumer verifies the result of {@code actual.groupCount()}.
     * @return this assertion instance.
     * @see MatchResult#groupCount()
     */
    default S hasGroupCountSatisfying(final IntConsumer consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        a::groupCount,
                        v -> {
                            consumer.accept(v);
                            return s;
                        }
                )
        );
    }

    /**
     * Verifies that the {@link MatchResult#groupCount()} method, invoked on the {@code actual}, does not throw any
     * exception and the result equals to specified value.
     *
     * @param expected the expected value of {@code actual.groupCount()}.
     * @return this assertion instance.
     * @see MatchResult#groupCount()
     */
    default S hasGroupCount(final int expected) {
        return hasGroupCountSatisfying(r -> Assertions.assertThat(r).isEqualTo(expected));
    }

    /**
     * Verifies that the {@link MatchResult#start()} method, invoked on the {@code actual}, does not throw any exception
     * and the result is verified by being accepted to specified consumer.
     *
     * @param consumer the consumer accepts the result of {@code actual.start()}.
     * @return this assertion instance.
     */
    default S hasStartSatisfying(final IntConsumer consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        a::start,
                        v -> {
                            consumer.accept(v);
                            return s;
                        }
                )
        );
    }

    /**
     * Verifies that the {@link MatchResult#start(int)} method, invoked on the {@code actual}, does not throw any
     * exception and the result equal to specified value.
     *
     * @param expected the expected value of {@code actual.start()}.
     * @return this assertion instance.
     */
    default S hasStartSatisfying(final int expected) {
        return hasStartSatisfying(r -> Assertions.assertThat(r).isEqualTo(expected));
    }

    /**
     * Verifies that the {@link MatchResult#start(int)} method, invoked on the {@code actual} with specified argument,
     * does not throw any exception and the result is verified by being accepted to specified consumer.
     *
     * @param group    a value for the {@code group} parameter.
     * @param consumer the consumer accepts the result of {@code actual.start(group)}.
     * @return this assertion instance.
     */
    default S hasStartSatisfying(final int group, final IntConsumer consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.start(group),
                        v -> {
                            consumer.accept(v);
                            return s;
                        }
                )
        );
    }

    /**
     * Verifies that the {@link MatchResult#start(int)} method, invoked on the {@code actual} with specified argument,
     * does not throw any exception and the result equal to specified value.
     *
     * @param group    a value for the {@code group} parameter.
     * @param expected the expected value of {@code actual.start(group)}.
     * @return this assertion instance.
     */
    default S hasStartSatisfying(final int group, final int expected) {
        return hasStartSatisfying(group, r -> Assertions.assertThat(r).isEqualTo(expected));
    }
}
