package com.github.jinahya.assertj.more;

import java.lang.reflect.Constructor;
import java.util.Objects;

public abstract class MoreAssertTest<S extends MoreAssert<S, A>, A> {

    protected MoreAssertTest(final Class<S> assertClass, final Class<A> actualClass) {
        super();
        this.assertClass = Objects.requireNonNull(assertClass, "assertClass is null");
        this.actualClass = Objects.requireNonNull(actualClass, "actualClass is null");
    }

    protected S assertInstance(final A actual) {
        try {
            final Constructor<S> constructor = assertClass.getDeclaredConstructor(actualClass);
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            return constructor.newInstance(actual);
        } catch (final ReflectiveOperationException roe) {
            throw new RuntimeException(roe);
        }
    }

    protected final Class<S> assertClass;

    protected final Class<A> actualClass;
}