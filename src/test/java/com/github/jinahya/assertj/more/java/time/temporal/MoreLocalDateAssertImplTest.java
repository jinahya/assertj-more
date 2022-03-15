package com.github.jinahya.assertj.more.java.time.temporal;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class MoreLocalDateAssertImplTest
        extends MoreJavaTimeTemporalAssertTest<MoreLocalDateTimeAssertImpl, LocalDateTime> {

    MoreLocalDateAssertImplTest() {
        super(MoreLocalDateTimeAssertImpl.class, LocalDateTime.class);
    }

    @Test
    void extractingAtTime__LocalTime() {
    }
}