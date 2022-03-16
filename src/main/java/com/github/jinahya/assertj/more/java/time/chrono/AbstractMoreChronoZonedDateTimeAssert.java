package com.github.jinahya.assertj.more.java.time.chrono;

import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoZonedDateTime;

public abstract class AbstractMoreChronoZonedDateTimeAssert<
        S extends AbstractMoreChronoZonedDateTimeAssert<S, A, D>,
        A extends ChronoZonedDateTime<D>,
        D extends ChronoLocalDate>
        implements MoreChronoZonedDateTimeAssert<S, A, D> {

}
