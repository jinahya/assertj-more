package com.github.jinahya.assertj.more.java.time.temporal;

import java.time.temporal.TemporalAccessor;

class DefaultMoreTemporalAccessorAssertTest
        extends MoreJavaTimeTemporalAssertTest<MoreTemporalAccessorAssertImpl, TemporalAccessor> {

    DefaultMoreTemporalAccessorAssertTest() {
        super(MoreTemporalAccessorAssertImpl.class, TemporalAccessor.class);
    }


}