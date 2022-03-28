package com.github.jinahya.assertj.more.java.util.regex;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

final class MorePatternAssertTests {

    public static IntStream flagStream() {
        return IntStream.of(
                Pattern.CANON_EQ,
                Pattern.CASE_INSENSITIVE,
                Pattern.COMMENTS,
                Pattern.DOTALL,
                Pattern.LITERAL,
                Pattern.MULTILINE,
                Pattern.UNICODE_CASE,
                Pattern.UNICODE_CHARACTER_CLASS,
                Pattern.UNIX_LINES
        );
    }

    private static final int FLAG_COUNT = (int) flagStream().count();

    public static int randomSingleFlag() {
        return flagStream()
                .skip(ThreadLocalRandom.current().nextInt(FLAG_COUNT))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("not gonna happen"));
    }

    public static int allFlags() {
        return flagStream().reduce((f1, f2) -> f1 | f2)
                .orElseThrow(() -> new RuntimeException("not gonna happen"));
    }

    public static int randomFlags() {
        final List<Integer> list = flagStream().boxed().collect(Collectors.toList());
        Collections.shuffle(list);
        final int count = ThreadLocalRandom.current().nextInt(list.size());
        for (int i = 0; i < count; i++) {
            list.remove(0);
        }
        return list.stream().reduce((f1, f2) -> f1 | f2).orElse(0);
    }

    private MorePatternAssertTests() {
        throw new AssertionError("instantiation is not allowed");
    }
}