package io.github.jinahya.assertj.more.api;

public final class JinahyaAssertions {

    public static JinahyaInstantAssert<?> assertMore(final java.time.Instant actual) {
        return new JinahyaInstantAssert<>(actual, JinahyaInstantAssert.class) {
        };
    }

    private JinahyaAssertions() {
        super();
    }
}
