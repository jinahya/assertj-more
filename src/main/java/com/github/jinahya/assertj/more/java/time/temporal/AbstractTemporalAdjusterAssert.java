package com.github.jinahya.assertj.more.java.time.temporal;

import org.assertj.core.api.AbstractAssert;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.util.function.Function;

public abstract class AbstractTemporalAdjusterAssert<
        SELF extends AbstractTemporalAdjusterAssert<SELF, ACTUAL>,
        ACTUAL extends TemporalAdjuster>
        extends AbstractAssert<SELF, ACTUAL> {

    protected AbstractTemporalAdjusterAssert(final ACTUAL actual, final Class<SELF> selfType) {
        super(actual, selfType);
    }

    // ------------------------------------------------------------------------------------ adjustInto(Temporal)Temporal
    protected <R> R adjustInto(
            final Temporal temporal,
            final Function<? super SELF, ? extends Function<? super Temporal, ? extends R>> function) {
        return function.apply(isNotNull())
                .apply(actual.adjustInto(temporal));
    }

//    public AbstractTemporalAssert<?, Temporal> extractingAdjustInto(final Temporal temporal) {
//        return adjustInto(temporal, s -> MoreAssertions::assertMore);
//    }
}
