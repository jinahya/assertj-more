package org.assertj.core.api;

import java.lang.reflect.Constructor;
import java.util.Objects;

public abstract class AssertTest<ASSERT extends Assert<ASSERT, ACTUAL>, ACTUAL> {

    protected AssertTest(final Class<ASSERT> assertClass, final Class<ACTUAL> actualClass) {
        super();
        this.assertClass = Objects.requireNonNull(assertClass, "assertClass is null");
        this.actualClass = Objects.requireNonNull(actualClass, "actualClass is null");
    }

    protected ASSERT assertInstance(final ACTUAL actual) {
        try {
            final Constructor<ASSERT> constructor = assertClass.getConstructor(actualClass);
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            return constructor.newInstance(actual);
        } catch (final ReflectiveOperationException roe) {
            throw new RuntimeException(roe);
        }
    }

    protected final Class<ASSERT> assertClass;

    protected final Class<ACTUAL> actualClass;
}
