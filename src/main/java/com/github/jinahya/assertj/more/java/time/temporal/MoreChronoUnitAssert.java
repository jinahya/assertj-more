package com.github.jinahya.assertj.more.java.time.temporal;

import org.assertj.core.api.ComparableAssert;

import java.time.temporal.ChronoUnit;

public interface MoreChronoUnitAssert<S extends MoreChronoUnitAssert<S>>
        extends MoreTemporalUnitAssert<S, ChronoUnit>,
                ComparableAssert<S, ChronoUnit> {

}
