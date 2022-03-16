package com.github.jinahya.assertj.more.api;

import org.assertj.core.api.ComparableAssert;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.function.Function;

final class ComparableAssertProxyHelper {

    private static final String NAME = "comparableAssertDelegate";

    private static Field field(final Class<?> clazz) throws NoSuchFieldException {
        Objects.requireNonNull(clazz, "clazz is null");
        try {
            return clazz.getDeclaredField(NAME);
        } catch (final NoSuchFieldException nsfe) {
            final Class<?> superclass = clazz.getSuperclass();
            if (superclass == null) {
                throw nsfe;
            }
            return field(superclass);
        }
    }

    static <S extends ComparableAssert<S, A>,
            A extends Comparable<? super A>>
    ComparableAssert<?, A> comparableAssertDelegate(final S self) {
        Objects.requireNonNull(self, "self is null");
        try {
            final Field field = field(self.getClass());
            field.setAccessible(true);
            @SuppressWarnings({"unchecked"})
            final S value = (S) field.get(self);
            return value;
        } catch (final ReflectiveOperationException roe) {
            throw new RuntimeException(roe);
        }
    }

    static <S extends ComparableAssert<S, A>,
            A extends Comparable<? super A>,
            R>
    R comparableAssertDelegate(
            final S self,
            final Function<? super S, ? extends Function<? super ComparableAssert<?, A>, ? extends R>> function) {
        Objects.requireNonNull(function, "function is null");
        return function.apply(self)
                .apply(comparableAssertDelegate(self));
    }

    private ComparableAssertProxyHelper() {
        throw new AssertionError("instantiation is not allowed");
    }
}
