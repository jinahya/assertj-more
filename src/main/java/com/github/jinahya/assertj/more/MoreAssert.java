package com.github.jinahya.assertj.more;

import org.assertj.core.api.Assert;

public interface MoreAssert<S extends MoreAssert<S, A>, A>
        extends Assert<S, A> {

}
