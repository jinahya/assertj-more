package com.github.jinahya.assertj.more;

import java.util.Objects;

public abstract class AbstractMoreAssertionsTest<T extends AbstractMoreAssertions> {

    protected AbstractMoreAssertionsTest(final Class<T> assertionsClass) {
        super();
        this.assertionsClass = Objects.requireNonNull(assertionsClass, "assertionsClass is null");
    }

    protected final Class<T> assertionsClass;
}