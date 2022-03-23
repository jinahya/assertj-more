package com.github.jinahya.assertj.more.java.time.temporal;

import org.assertj.core.api.AbstractAssert;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.util.function.Function;

public abstract class AbstractTemporalAdjusterAssert<
        S extends AbstractTemporalAdjusterAssert<S, A>,
        A extends TemporalAdjuster>
        extends AbstractAssert<S, A> {

    protected AbstractTemporalAdjusterAssert(final A actual, final Class<S> selfType) {
        super(actual, selfType);
    }

    // ------------------------------------------------------------------------------------ adjustInto(Temporal)Temporal
    protected <R> R adjustInto(
            final Temporal temporal,
            final Function<? super S, ? extends Function<? super Temporal, ? extends R>> function) {
        return function.apply(isNotNull())
                .apply(actual.adjustInto(temporal));
    }

//    public AbstractTemporalAssert<?, Temporal> extractingAdjustInto(final Temporal temporal) {
//        return adjustInto(temporal, s -> MoreAssertions::assertMore);
//    }
}
