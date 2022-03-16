package com.github.jinahya.assertj.more.java.time.chrono;

import com.github.jinahya.assertj.more.api.ComparableAssertProxy;

import java.time.chrono.Chronology;

public interface MoreChronologyAssert<S extends MoreChronologyAssert<S, A>, A extends Chronology>
        extends MoreJavaTimeChronoAssert<S, A>,
                ComparableAssertProxy<S, A> {

}
