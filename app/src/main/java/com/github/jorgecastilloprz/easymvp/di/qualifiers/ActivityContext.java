package com.github.jorgecastilloprz.easymvp.di.qualifiers;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Dagger qualifier created to allow classes to inject Activity Context.
 * Created by jorge on 10/01/15.
 */
@Qualifier
@Retention(RUNTIME)
public @interface ActivityContext {
}
