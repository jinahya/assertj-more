package com.github.jinahya.assertj.more.java.util.regex;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MoreMatcherAssertImplTest
        extends MoreJavaUtilRegexAssertTest<MoreMatcherAssertImpl, Matcher> {

    MoreMatcherAssertImplTest() {
        super(MoreMatcherAssertImpl.class, Matcher.class);
    }

    @DisplayName("appendsReplacement")
    @Nested
    class AppendsReplacementTest {

        @Test
        void test1__() {
            final Pattern pattern = Pattern.compile("cat");
            final String input = "one cat two cats in the yard";
            final String replacement = "dog";
            final String expected = "one dog two dogs in the yard";
            {
                final Matcher matcher = pattern.matcher(input);
                final StringBuffer sb = new StringBuffer();
                while (matcher.find()) {
                    matcher.appendReplacement(sb, replacement);
                }
                matcher.appendTail(sb);
                Assertions.assertThat(sb)
                        .hasToString(expected);
            }
            {
                final MoreMatcherAssert<?> more = assertInstance(pattern.matcher(input));
                final StringBuffer sb = new StringBuffer();
                while (true) {
                    try {
                        more.finds();
                    } catch (final AssertionError ae) {
                        break;
                    }
                    more.appendsReplacement(sb, replacement);
                }
                more.appendsTail(sb);
                Assertions.assertThat(sb)
                        .hasToString(expected);
            }
            {
                final MoreMatcherAssert<?> more = assertInstance(pattern.matcher(input));
                final StringBuilder sb = new StringBuilder();
                while (true) {
                    try {
                        more.finds();
                    } catch (final AssertionError ae) {
                        break;
                    }
                    more.appendsReplacement(sb, replacement);
                }
                more.appendsTail(sb);
                Assertions.assertThat(sb)
                        .hasToString(expected);
            }
        }
    }

    @DisplayName("appendsTail")
    @Nested
    class AppendsTailTest {

    }

    @Nested
    class LookingAtTest {

        // https://www.geeksforgeeks.org/matcher-lookingat-method-in-java-with-examples/#:~:text=The%20lookingAt()%20method%20of,the%20start%20of%20the%20pattern.
        @Test
        void test1__() {
            {
                final String regex = "Geeks";
                final Pattern pattern = Pattern.compile(regex);
                final String stringToBeMatched = "GeeksForGeeks";
                final Matcher matcher = pattern.matcher(stringToBeMatched);
                final MoreMatcherAssert<?> more = assertInstance(matcher);
                more.matchesLookingAt();
            }
            {
                final String regex = "GFG";
                final Pattern pattern = Pattern.compile(regex);
                final String stringToBeMatched = "GFGFGFGFGFGFGFGFGFG";
                final Matcher matcher = pattern.matcher(stringToBeMatched);
                final MoreMatcherAssert<?> more = assertInstance(matcher);
                more.matchesLookingAt();
            }
        }

        // https://www.javatpoint.com/post/java-matcher-lookingat-method
        @Test
        void test2__() {
            {
                final Pattern pattern = Pattern.compile("This is", Pattern.CASE_INSENSITIVE);
                final Matcher matcher = pattern.matcher("this is java language");
                final MoreMatcherAssert<?> more = assertInstance(matcher);
                more.matchesLookingAt();
            }
            {
                final String input = "java programming language Write once run anywhere";
                final String regex = "java programm";
                final Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
                final Matcher matcher = pattern.matcher(input);
                final MoreMatcherAssert<?> more = assertInstance(matcher);
                more.matchesLookingAt();
            }
            {
                final String input = "java programming language Write once run anywhere";
                final String regex = "java programm";
                final Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
                final Matcher matcher = pattern.matcher(input);
                final MoreMatcherAssert<?> more = assertInstance(matcher);
                more.matchesLookingAt();
            }
        }
    }
}