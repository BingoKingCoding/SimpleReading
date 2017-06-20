package com.king.simplereading.di.scopes;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;


/**
 * <设置范围>
 * Created by adou on 2017/6/20:22:39.
 *
 * @Email:634051075@qq.com
 */


@Scope
@Retention(RUNTIME)
public @interface ActivityScope
{
}
