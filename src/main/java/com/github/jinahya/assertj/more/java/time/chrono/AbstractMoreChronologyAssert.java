package com.github.jinahya.assertj.more.java.time.chrono;

import org.assertj.core.api.AbstractComparableAssert;

import java.lang.reflect.Constructor;
import java.time.chrono.Chronology;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class AbstractMoreChronologyAssert<
        SELF extends AbstractMoreChronologyAssert<SELF, ACTUAL>,
        ACTUAL extends Chronology>
        extends AbstractComparableAssert<SELF, ACTUAL>
        implements MoreChronologyAssert<SELF, ACTUAL> {

    // chronology classes to assert classes
    private static final Map<Class<?>, Class<?>> ASSERT_CLASSES;

    static {
        final Map<Class<?>, Class<?>> assertClasses = new HashMap<>();
        ASSERT_CLASSES = Collections.unmodifiableMap(assertClasses);
    }

    protected AbstractMoreChronologyAssert(final ACTUAL actual, final Class<SELF> selfType) {
        super(actual, selfType);
    }

    public <C extends Chronology, A extends AbstractMoreChronologyAssert<A, C>> A extracting(final Class<C> chronologyClass,
                                                                                             final Class<A> assertClass) {
        return Optional.ofNullable(ASSERT_CLASSES.get(chronologyClass))
                .map(ac -> {
                    try {
                        final Constructor<? extends A> constructor
                                = ac.asSubclass(assertClass).getConstructor(chronologyClass);
                        return constructor.newInstance(chronologyClass.cast(actual));
                    } catch (final ReflectiveOperationException roe) {
                        throw new RuntimeException(roe);
                    }
                })
                .orElseThrow(() -> new IllegalArgumentException("no assert class for " + chronologyClass));
    }

    @SuppressWarnings({"unchecked"})
    public <C extends Chronology, A extends AbstractMoreChronologyAssert<A, C>> A extracting(
            final Class<C> chronologyClass) {
        return (A) extracting(chronologyClass, AbstractMoreChronologyAssert.class);
    }
}
