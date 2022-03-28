package com.github.jinahya.assertj.more.java.util.regex;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

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

    @Nested
    class SplitsTest {

        // https://www.javatpoint.com/java-pattern-split-method
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