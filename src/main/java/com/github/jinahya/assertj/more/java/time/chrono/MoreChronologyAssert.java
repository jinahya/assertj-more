package com.github.jinahya.assertj.more.java.time.chrono;

import java.time.chrono.Chronology;

public interface MoreChronologyAssert<
        SELF extends MoreChronologyAssert<SELF, ACTUAL>,
        ACTUAL extends Chronology>
        extends MoreJavaTimeChronoAssert<SELF, ACTUAL> {

}
