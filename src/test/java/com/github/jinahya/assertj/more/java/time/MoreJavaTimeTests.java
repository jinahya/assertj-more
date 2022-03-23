package com.github.jinahya.assertj.more.java.time;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public final class MoreJavaTimeTests {

    public static Stream<Duration> durationStream() {
        return Arrays.stream(ChronoUnit.values())
                .flatMap(u -> LongStream.rangeClosed(-2L, 2L)
                        .mapToObj(a -> {
                            try {
                                return Duration.of(a, u);
                            } catch (final DateTimeException dte) {
                                return null;
                            }
                        })
                )
                .filter(Objects::nonNull);
    }

    public static List<Period> periodList() {
        final List<Period> list = new ArrayList<>();
        for (int i = -2; i < 3; i++) {
            list.add(Period.ofYears(i));
            list.add(Period.ofMonths(i));
            list.add(Period.ofDays(i));
        }
        return list;
    }

    public static Stream<Period> periodStream() {
        return periodList().stream();
    }

    private MoreJavaTimeTests() {
        throw new AssertionError("instantiation is not allowed");
    }
}
