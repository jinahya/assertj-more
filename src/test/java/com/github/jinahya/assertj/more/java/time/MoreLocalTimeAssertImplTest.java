package com.github.jinahya.assertj.more.java.time;

import java.time.LocalTime;

class MoreLocalTimeAssertImplTest
        extends MoreJavaTimeAssertTest<MoreLocalTimeAssertImpl, LocalTime> {

    MoreLocalTimeAssertImplTest() {
        super(MoreLocalTimeAssertImpl.class, LocalTime.class);
    }
}