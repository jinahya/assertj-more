package com.github.jinahya.assertj.more.java.time;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
abstract class AbstractMoreLocalDateAssertImplTest
        extends MoreJavaTimeAssertTest<MoreLocalDateAssertImpl, LocalDate> {

    protected AbstractMoreLocalDateAssertImplTest() {
        super(MoreLocalDateAssertImpl.class, LocalDate.class);
    }
}