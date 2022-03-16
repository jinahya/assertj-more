package com.github.jinahya.assertj.more.api;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.InstanceOfAssertFactories;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;

public class MoreAssertions
        implements InstanceOfAssertFactories {

    // https://github.com/assertj/assertj-core/issues/1652
    public static <V, R> R doesNotThrowAnyException(
            final Callable<? extends V> callable, final Function<? super V, ? extends R> function) {
        final List<V> results = new ArrayList<>(1);
        Assertions.assertThatCode(() -> {
            results.add(callable.call());
        }).doesNotThrowAnyException();
        return function.apply(results.get(0));
    }

    protected MoreAssertions() {
        super();
    }
}
