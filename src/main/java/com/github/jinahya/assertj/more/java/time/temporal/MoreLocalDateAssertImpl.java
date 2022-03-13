package com.github.jinahya.assertj.more.java.time.temporal;

import java.time.LocalDate;

class MoreLocalDateAssertImpl
        extends AbstractMoreLocalDateAssert<MoreLocalDateAssertImpl> {

    MoreLocalDateAssertImpl(LocalDate actual) {
        super(actual, MoreLocalDateAssertImpl.class);
    }
}
