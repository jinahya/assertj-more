package com.github.jinahya.assertj.more.api;

import org.assertj.core.api.ComparableAssert;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.function.Function;

/**
 * A helper class for {@link ComparableAssertProxy}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
final class ComparableAssertProxyHelper {

    private static final String NAME = "comparableAssertDelegate";

    private static Field getField(final Class<?> clazz) throws NoSuchFieldException {
        Objects.requireNonNull(clazz, "clazz is null");
        try {
            return clazz.getDeclaredField(NAME);
        } catch (final NoSuchFieldException nsfe) {
            final Class<?> superclass = clazz.getSuperclass();
            if (superclass == null) {
                throw nsfe;
            }
            return getField(superclass);
        }
    }

//    private static <S extends ComparableAssert<S, A>, A extends Comparable<? super A>>
//    ComparableAssert<?, A> comparableAssertDelegate(final S self) {
//        Objects.requireNonNull(self, "self is null");
//        try {
//            final Field field = field(self.getClass());
//            field.setAccessible(true);
//            @SuppressWarnings({"unchecked"})
//            final S value = (S) field.get(self);
//            return value;
//        } catch (final ReflectiveOperationException roe) {
//            throw new RuntimeException("failed to get the value of '" + NAME + "' field", roe);
//        }
//    }

    private static <A extends Comparable<? super A>> ComparableAssert<?, A> getFieldValue(final Object self) {
        Objects.requireNonNull(self, "self is null");
        try {
            final Field field = getField(self.getClass());
            field.setAccessible(true);
            @SuppressWarnings({"unchecked"})
            final ComparableAssert<?, A> value = (ComparableAssert<?, A>) field.get(self);
            return value;
        } catch (final ReflectiveOperationException roe) {
            throw new RuntimeException("failed to get the value of '" + NAME + "' field", roe);
        }
    }

    static <S extends ComparableAssert<S, A>, A extends Comparable<? super A>, R> R comparableAssertDelegate(
            final S self,
            final Function<? super S, ? extends Function<? super ComparableAssert<?, A>, ? extends R>> function) {
        Objects.requireNonNull(self, "self is null");
        Objects.requireNonNull(function, "function is null");
        return function.apply(self)
                .apply(getFieldValue(self));
    }

    private ComparableAssertProxyHelper() {
        throw new AssertionError("instantiation is not allowed");
    }
}
