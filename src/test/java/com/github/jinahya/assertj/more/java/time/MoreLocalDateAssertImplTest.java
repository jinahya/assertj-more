package com.github.jinahya.assertj.more.java.time;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
abstract class MoreLocalDateAssertImplTest
        extends MoreJavaTimeAssertTest<MoreLocalDateAssertImpl, LocalDate> {

    protected MoreLocalDateAssertImplTest() {
        super(MoreLocalDateAssertImpl.class, LocalDate.class);
    }
}