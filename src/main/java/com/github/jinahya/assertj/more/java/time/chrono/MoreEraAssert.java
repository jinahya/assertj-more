package com.github.jinahya.assertj.more.java.time.chrono;

import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAccessorAssert;
import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAdjusterAssert;
import org.assertj.core.api.AbstractIntegerAssert;
import org.assertj.core.api.AbstractStringAssert;
import org.assertj.core.api.Assertions;

import java.time.chrono.Era;
import java.time.format.TextStyle;
import java.util.Locale;

public interface MoreEraAssert<S extends MoreEraAssert<S, A>, A extends Era>
        extends MoreJavaTimeChronoAssert<S, A>,
                MoreTemporalAccessorAssert<S, A>,
                MoreTemporalAdjusterAssert<S, A> {

    @SuppressWarnings({"unchecked"})
    default AbstractIntegerAssert<?> extractingValue() {
        return MoreEraAssertHelper.getValue((S) this, s -> Assertions::assertThat);
    }

    @SuppressWarnings({"unchecked"})
    default S hasValue(final int expected) {
        return MoreEraAssertHelper.getValue((S) this, s -> r -> {
            Assertions.assertThat(r).isEqualTo(expected);
            return s;
        });
    }

    default AbstractStringAssert<?> extractingDisplayName(final TextStyle style, final Locale locale) {
        return MoreEraAssertHelper.getDisplayName(style, locale, (S) this, s -> Assertions::assertThat);
    }

    default S hasDisplayName(final TextStyle style, final Locale locale, final String expected) {
        return MoreEraAssertHelper.getDisplayName(style, locale, (S) this, s -> r -> {
            Assertions.assertThat(r).isEqualTo(expected);
            return s;
        });
    }
}
