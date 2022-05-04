package com.github.jinahya.assertj.more.java.lang.reflect;

import com.github.jinahya.assertj.more.api.ActualWrapper;

public final class ModifiersWrapper
        extends ActualWrapper.IntegerWrapper {

    public static ModifiersWrapper of(final int modifiers) {
        return new ModifiersWrapper(modifiers);
    }

    private ModifiersWrapper(final Integer actual) {
        super(actual);
    }
}
