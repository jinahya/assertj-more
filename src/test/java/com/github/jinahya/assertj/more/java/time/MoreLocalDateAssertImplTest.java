package com.github.jinahya.assertj.more.java.time;

import java.time.LocalDate;

class MoreLocalDateAssertImplTest
        extends MoreJavaTimeAssertTest<MoreLocalDateAssertImpl, LocalDate> {

    MoreLocalDateAssertImplTest() {
        super(MoreLocalDateAssertImpl.class, LocalDate.class);
    }
}