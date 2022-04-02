package com.github.jinahya.assertj.more.java.time;

import java.time.Instant;

abstract class MoreInstantAssertImplTest
        extends MoreJavaTimeAssertTest<MoreInstantAssertImpl, Instant> {

    MoreInstantAssertImplTest() {
        super(MoreInstantAssertImpl.class, Instant.class);
    }
}