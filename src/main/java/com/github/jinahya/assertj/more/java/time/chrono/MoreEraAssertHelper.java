package com.github.jinahya.assertj.more.java.time.chrono;

import com.github.jinahya.assertj.more.hidden.ForAssert;

import java.time.chrono.Era;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.IntFunction;

final class MoreEraAssertHelper {

    static <S extends MoreEraAssert<S, A>, A extends Era, R> R getValue(
            final S self, final Function<? super S, ? extends IntFunction<? extends R>> function) {
        return function.apply(ForAssert.assertActualIsNotNull(self))
                .apply(ForAssert.getActual(self).getValue());
    }

    static <S extends MoreEraAssert<S, A>, A extends Era, R> R getDisplayName(
            final TextStyle style, final Locale locale, final S self,
            final Function<? super S, ? extends Function<? super String, ? extends R>> function) {
        return function.apply(ForAssert.assertActualIsNotNull(self))
                .apply(ForAssert.getActual(self).getDisplayName(style, locale));
    }

    private MoreEraAssertHelper() {
        throw new AssertionError("instantiation is not allowed");
    }
}
