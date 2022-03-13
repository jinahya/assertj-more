package com.github.jinahya.assertj.more.java.time.temporal;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assert;
import org.assertj.core.api.AssertFactory;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;
import java.util.function.Function;

/**
 * An abstract assert class for verifying values of {@link TemporalField}.
 *
 * @param <SELF>   self type parameter.
 * @param <ACTUAL> actual type parameter.
 * @author Jin Kwon &lt;onacit_at_wemakeprice.com&gt;
 */
public abstract class AbstractTemporalFieldAssert<
        SELF extends AbstractTemporalFieldAssert<SELF, ACTUAL>,
        ACTUAL extends TemporalField
        >
        extends AbstractAssert<SELF, ACTUAL> {

    /**
     * Creates a new instance with specified actual value and self type.
     *
     * @param actual   the actual value to verify.
     * @param selfType the self type.
     */
    protected AbstractTemporalFieldAssert(final ACTUAL actual, final Class<?> selfType) {
        super(actual, selfType);
    }

    // ---------------------------------------------------------------------------------- adjustInto(Temporal,J)Temporal
    protected <R extends Temporal, U> U adjustInto(
            final R temporal, final long newValue,
            final Function<? super SELF, ? extends Function<? super R, ? extends U>> function) {
        return function.apply(isNotNull())
                .apply(actual.adjustInto(temporal, newValue));
    }

    public <R extends Temporal, A extends Assert<A, R>> A extractingAdjustIntoApplying(
            final R temporal, final long newValue, final Function<? super R, ? extends A> function) {
        return adjustInto(temporal, newValue, s -> function);
    }

    public <R extends Temporal, A extends Assert<A, R>> A extractingAdjustIntoCreating(
            final R temporal, final long newValue, final AssertFactory<? super R, ? extends A> factory) {
        return extractingAdjustIntoApplying(temporal, newValue, factory::createAssert);
    }

//    public AbstractTemporalAssert<?, Temporal> extractingAdjustInto(final Temporal temporal, final long newValue) {
//        return extractingAdjustIntoCreating(temporal, newValue, DefaultMoreTemporalAssert::new);
//    }
}
