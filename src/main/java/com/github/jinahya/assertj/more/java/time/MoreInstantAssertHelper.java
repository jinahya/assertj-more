package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.hidden.ForAssert;
import org.assertj.core.api.Assert;

import java.time.Instant;
import java.util.function.Function;
import java.util.function.LongFunction;

final class MoreInstantAssertHelper {

    // ----------------------------------------------------------------------------------------------- getEpochSecond()J
    static <SELF extends Assert<SELF, ACTUAL>, ACTUAL extends Instant, R> R getEpochSecond(
            final SELF self,
            final Function<? super SELF, ? extends LongFunction<? extends R>> function) {
        return function.apply(ForAssert.assertActualIsNotNull(self))
                .apply(ForAssert.getActual(self).getEpochSecond());
    }

    private MoreInstantAssertHelper() {
        throw new AssertionError("instantiation is not allowed");
    }
}
