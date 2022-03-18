package com.github.jinahya.assertj.more.java.time;

import java.time.LocalDate;

class MoreLocalDateAssertImpl
        extends AbstractMoreLocalDateAssert<MoreLocalDateAssertImpl> {

    MoreLocalDateAssertImpl(final LocalDate actual) {
        super(actual, MoreLocalDateAssertImpl.class);
    }
}
