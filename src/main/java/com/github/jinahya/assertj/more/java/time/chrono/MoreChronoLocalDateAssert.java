package com.github.jinahya.assertj.more.java.time.chrono;

import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAdjusterAssert;
import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAssert;

import java.time.chrono.ChronoLocalDate;

/**
 * An interface for verifying values of {@link ChronoLocalDate} interface.
 *
 * @param <SELF>   self type parameter
 * @param <ACTUAL> actual type parameter
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
public interface MoreChronoLocalDateAssert<
        SELF extends MoreChronoLocalDateAssert<SELF, ACTUAL>,
        ACTUAL extends ChronoLocalDate>
        extends MoreJavaTimeChronoAssert<SELF, ACTUAL>,
                MoreTemporalAssert<SELF, ACTUAL>,
                MoreTemporalAdjusterAssert<SELF, ACTUAL> {

    // ------------------------------------------------------------------------------ until(ChronoLocalDate)ChronoPeriod
}
