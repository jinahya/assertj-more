package com.github.jinahya.assertj.more.java.time.chrono;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.time.chrono.Era;
import java.time.chrono.HijrahEra;
import java.time.chrono.IsoEra;
import java.time.chrono.JapaneseEra;
import java.time.chrono.MinguoEra;
import java.time.chrono.ThaiBuddhistEra;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

class MoreEraAssertImpl_Test
        extends MoreJavaTimeChronoAssertTest<MoreEraAssertImpl_, Era> {

    MoreEraAssertImpl_Test() {
        super(MoreEraAssertImpl_.class, Era.class);
    }

    void extractingValue__(final Era era) {
        final int expected = era.getValue();
        Assertions.assertThatCode(() -> {
                    assertInstance(era)
                            .extractingValue()
                            .isEqualTo(expected);
                })
                .doesNotThrowAnyException();
    }

    void hasValue__(final Era era) {
        final int expected = era.getValue();
        Assertions.assertThatCode(() -> {
                    assertInstance(era)
                            .hasValue(expected);
                })
                .doesNotThrowAnyException();
    }

    void extractingDisplayName__(final Era era, final TextStyle style, final Locale locale) {
        final String expected = era.getDisplayName(style, locale);
        Assertions.assertThatCode(() -> {
                    assertInstance(era)
                            .extractingDisplayName(style, locale)
                            .isEqualTo(expected);
                })
                .doesNotThrowAnyException();
    }

    void hasDisplayName__(final Era era, final TextStyle style, final Locale locale) {
        final String expected = era.getDisplayName(style, locale);
        Assertions.assertThatCode(() -> {
                    assertInstance(era)
                            .hasDisplayName(style, locale, expected);
                })
                .doesNotThrowAnyException();
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    abstract class AbstractNestedTest<T extends Era> {

        Stream<Arguments> styleAndLocaleArguments() {
            return Arrays.stream(TextStyle.values())
                    .flatMap(s -> Arrays.stream(Locale.getAvailableLocales()).map(l -> Arguments.of(s, l)));
        }

        abstract Stream<T> eraStream();

        @MethodSource({"eraStream"})
        @ParameterizedTest
        void extractingValue___(final T era) {
            extractingValue__(era);
        }

        @MethodSource({"eraStream"})
        @ParameterizedTest
        void hasValue___(final T era) {
            hasValue__(era);
        }

        @MethodSource({"styleAndLocaleArguments"})
        @ParameterizedTest
        void extractingDisplayName___(final TextStyle style, final Locale locale) {
            eraStream().forEach(v -> {
                extractingDisplayName__(v, style, locale);
            });
        }

        @MethodSource({"styleAndLocaleArguments"})
        @ParameterizedTest
        void hasDisplayName___(final TextStyle style, final Locale locale) {
            eraStream().forEach(v -> {
                hasDisplayName__(v, style, locale);
            });
        }
    }

    @Nested
    class IsoEraTest
            extends AbstractNestedTest<IsoEra> {

        @Override
        Stream<IsoEra> eraStream() {
            return Arrays.stream(IsoEra.values());
        }
    }

    @Nested
    class JapaneseEraTest
            extends AbstractNestedTest<JapaneseEra> {

        private volatile List<JapaneseEra> eraList = null;

        @Override
        Stream<JapaneseEra> eraStream() {
            List<JapaneseEra> result = eraList;
            if (result == null) {
                result = new ArrayList<>();
                for (final Field field : JapaneseEra.class.getFields()) {
                    if (!Modifier.isStatic(field.getModifiers())) {
                        continue;
                    }
                    if (field.getType() != JapaneseEra.class) {
                        continue;
                    }
                    try {
                        result.add((JapaneseEra) field.get(null));
                    } catch (final ReflectiveOperationException roe) {
                        throw new RuntimeException(roe);
                    }
                }
                eraList = result = Collections.unmodifiableList(result);
            }
            return result.stream();
        }
    }

    @Nested
    class HijrahEraTest
            extends AbstractNestedTest<HijrahEra> {

        @Override
        Stream<HijrahEra> eraStream() {
            return Arrays.stream(HijrahEra.values());
        }
    }

    @Nested
    class MinguoEraTest
            extends AbstractNestedTest<MinguoEra> {

        @Override
        Stream<MinguoEra> eraStream() {
            return Arrays.stream(MinguoEra.values());
        }
    }

    @Nested
    class ThaiBuddhistEraTest
            extends AbstractNestedTest<ThaiBuddhistEra> {

        @Override
        Stream<ThaiBuddhistEra> eraStream() {
            return Arrays.stream(ThaiBuddhistEra.values());
        }
    }
}