package com.github.jinahya.assertj.more.api;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.InstanceOfAssertFactories;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.Function;

public class MoreAssertions
        implements InstanceOfAssertFactories {

    /**
     * Asserts that specified callable returns without any exception thrown, applies the result to specified function,
     * and return the result.
     *
     * @param callable the callable.
     * @param function the function.
     * @param <V>      the type of the result of the {@code callable}
     * @param <R>      the type of the result of the {@code function}
     * @return the result of the {@code function}.
     * @deprecated Prematurely deprecated; Keep checking the status of the <a href="https://github.com/assertj/assertj-core/issues/1652">related
     * issue</a>.
     */
    @Deprecated // https://github.com/assertj/assertj-core/issues/1652
    public static <V, R> R assertThatCodeDoesNotThrowAnyExceptionAndApply(
            final Callable<? extends V> callable, final Function<? super V, ? extends R> function) {
        Objects.requireNonNull(callable, "callable is null");
        Objects.requireNonNull(function, "function is null");
        final List<V> results = new ArrayList<>(1);
        Assertions.assertThatCode(() -> results.add(callable.call()))
                .doesNotThrowAnyException();
        return function.apply(results.get(0));
    }

    protected MoreAssertions() {
        super();
    }
}
