package com.github.jinahya.assertj.more.java.time.temporal;

import java.time.temporal.TemporalAdjuster;

public interface MoreTemporalAdjusterAssert<
        SELF extends MoreTemporalAdjusterAssert<SELF, ACTUAL>,
        ACTUAL extends TemporalAdjuster>
        extends MoreJavaTimeTemporalAssert<SELF, ACTUAL> {

}
