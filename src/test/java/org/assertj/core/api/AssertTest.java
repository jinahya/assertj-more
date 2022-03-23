package org.assertj.core.api;

import java.lang.reflect.Constructor;
import java.util.Objects;

public abstract class AssertTest<S extends Assert<S, A>, A> {

    protected AssertTest(final Class<S> assertClass, final Class<A> actualClass) {
        super();
        this.assertClass = Objects.requireNonNull(assertClass, "assertClass is null");
        this.actualClass = Objects.requireNonNull(actualClass, "actualClass is null");
    }

    protected S assertInstance(final A actual) {
        try {
            final Constructor<S> constructor = assertClass.getConstructor(actualClass);
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
