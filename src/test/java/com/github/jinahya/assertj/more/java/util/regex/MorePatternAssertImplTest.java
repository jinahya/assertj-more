package com.github.jinahya.assertj.more.java.util.regex;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.DefaultArgumentsAccessor;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.regex.Pattern;
import java.util.stream.Stream;

class MorePatternAssertImplTest
        extends MoreJavaUtilRegexAssertTest<MorePatternAssertImpl, Pattern> {

    MorePatternAssertImplTest() {
        super(MorePatternAssertImpl.class, Pattern.class);
    }

    @Nested
    class HasFlagsTest {

        // https://www.geeksforgeeks.org/pattern-flags-method-in-java-with-examples/
        @Test
        void test1__() {
            {
                final String REGEX = "(.*)(for)(.*)?";
                final Pattern actual = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);
                final int expected = actual.flags();
                final MorePatternAssert<?> more = assertInstance(actual);
                more.hasFlags(expected);
            }
            {
                final String REGEX = "(.*)(ee)(.*)?";
                final Pattern actual = Pattern.compile(REGEX, Pattern.MULTILINE);
                final int expected = actual.flags();
                final MorePatternAssert<?> more = assertInstance(actual);
                more.hasFlags(expected);
            }
        }
    }

    @Nested
    class HasPatternTest {

        @Test
        void test1__() {
            final String expected = ".+";
            final Pattern actual = Pattern.compile(expected);
            final MorePatternAssert<?> more = assertInstance(actual);
            more.hasPattern(expected);
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class SplitsTest {

        Stream<Arguments> splitArgumentsStream() {
            return Stream.of(
                    Arguments.of("\\s", "Pattern Split Method in Java regex"),
                    // https://java2novice.com/java-collections-and-util/regex/split/
                    Arguments.of("(cat|rat|mat|bat)", "I have a cat. I play cricket with bat. I dont like rat," +
                                                      "i hate mats, now break it"),
                    Arguments.of("[ ,.!]", "one two,asdf9 12!done. this is a 1 431*&^*&^ test.")
            );
        }

        Stream<Arguments> splitWithResultArgumentsStream() {
            return splitArgumentsStream()
                    .map(a -> {
                        final ArgumentsAccessor accessor = new DefaultArgumentsAccessor(a.get());
                        final String regex = accessor.get(0, String.class);
                        final String input = accessor.get(1, String.class);
                        return Arguments.of(regex, input, input.split(regex));
                    });
        }

        Stream<Arguments> splitWithIndexArguments() {
            return Stream.of(

            );
        }

        @MethodSource({"splitWithResultArgumentsStream"})
        @ParameterizedTest
        void split__(final String regex, final String input, final String[] result) {
            final Pattern actual = Pattern.compile(regex);
            final MorePatternAssert<?> more = assertInstance(actual);
            more.splits(input, result);
        }

        @Test
        void test1__() {
            {
                final String[] tokens = new String[]{
                        "Pattern", "Split", "Method", "in", "Java", "regex"
                };
                final Pattern actual = Pattern.compile("\\s");
                final MorePatternAssert<?> more = assertInstance(actual);
                final String input = String.join(" ", tokens);
                more.splits(input, tokens);
            }
            {
                final String regex = ":";
                final Pattern actual = Pattern.compile(regex);
                final MorePatternAssert<?> more = assertInstance(actual);
                more.splits("Java:programming:Language", 3, new String[]{"Java", "programming", "Language"});
            }
        }
    }
}