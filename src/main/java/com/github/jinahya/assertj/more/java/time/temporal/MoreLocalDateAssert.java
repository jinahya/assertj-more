package com.github.jinahya.assertj.more.java.time.temporal;

import java.time.LocalDate;

public interface MoreLocalDateAssert<SELF extends MoreTemporalAssert<SELF, LocalDate>>
        extends MoreTemporalAssert<SELF, LocalDate> {

    default SELF test() {
        return isNotNull();
    }
}
