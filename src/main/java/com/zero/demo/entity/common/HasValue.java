package com.zero.demo.entity.common;

/**
 * @author zero
 * @created on 2019-07-28
 */
public interface HasValue<T> {

    default T getValue() {
        return value();
    }

    default T value() {
        return getValue();
    }
}
