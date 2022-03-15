package com.github.jinahya.assertj.more.java.time.chrono;

import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAdjusterAssert;
import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAssert;
import org.assertj.core.api.Assert;

import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;

/**
 * An interface for verifying values of {@link ChronoLocalDate} interface.
 *
 * @param <S>   self type parameter
 * @param <A> actual type parameter
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
public interface MoreChronoLocalDateAssert<
        S extends MoreChronoLocalDateAssert<S, A>,
        A extends ChronoLocalDate>
        extends MoreJavaTimeChronoAssert<S, A>,
                MoreTemporalAssert<S, A>,
                MoreTemporalAdjusterAssert<S, A> {

    // ---------------------------------------------------------------------------- atTime(LocalTime)ChronoLocalDateTime
    Assert<?, ? extends ChronoLocalDateTime<?>> extractingAtTime(LocalTime localTime);
}
