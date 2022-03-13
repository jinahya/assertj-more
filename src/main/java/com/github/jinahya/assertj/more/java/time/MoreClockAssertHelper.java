package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.hidden.ForAssert;
import org.assertj.core.api.Assert;

import java.time.Clock;
import java.time.ZoneId;
import java.util.function.Function;

class MoreClockAssertHelper {

    // ------------------------------------------------------------------------------------------------- getZone()ZoneId
    static <SELF extends Assert<SELF, ACTUAL>, ACTUAL extends Clock, R> R getZone(
            final SELF self, final Function<? super SELF, ? extends Function<? super ZoneId, ? extends R>> function) {
        return function.apply(ForAssert.invokeIsNotNull(self))
                .apply(ForAssert.getActual(self).getZone());
    }

    protected MoreClockAssertHelper() {
        super();
    }
}
