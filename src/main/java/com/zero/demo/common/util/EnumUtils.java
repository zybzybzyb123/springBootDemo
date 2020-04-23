package com.zero.demo.common.util;

import com.zero.demo.entity.common.HasIntValue;
import com.zero.demo.entity.common.HasValue;
import org.springframework.lang.NonNull;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.apache.commons.lang3.StringUtils.substringAfterLast;
import static org.apache.commons.lang3.StringUtils.substringBeforeLast;

/**
 * @author zero
 * @created on 2019-07-28
 */
public class EnumUtils {

    public static <T extends Enum<T>> void checkDuplicate(T[] values, Function<T, ?> uniqueMap) {
        if (Stream.of(values).map(uniqueMap).distinct().count() != values.length) {
            throw new IllegalStateException("found duplicate value:" + values[0].getClass());
        }
    }

    public static <T extends Enum & HasIntValue> T fromValue(Class<T> clazz, int value) {
        return fromValue(clazz, value, null);
    }

    public static <T extends Enum & HasIntValue> T fromValue(Class<T> clazz, int value, T defaultValue) {
        return Arrays.stream(clazz.getEnumConstants()) //
                .filter(e -> Objects.equals(e.getValue(), value)) //
                .findFirst() //
                .orElse(defaultValue);
    }

    public static <V, T extends Enum & HasValue<V>> T fromValue(Class<T> clazz, V value) {
        return fromValue(clazz, value, null);
    }

    public static <V, T extends Enum & HasValue<V>> T fromValue(Class<T> clazz, V value, T defaultValue) {
        return Arrays.stream(clazz.getEnumConstants()) //
                .filter(e -> Objects.equals(e.getValue(), value)) //
                .findFirst() //
                .orElse(defaultValue);
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public static <T extends Enum<T>> T fromFQCN(String name) {
        String className = substringBeforeLast(name, ".");
        String enumInstanceName = substringAfterLast(name, ".");
        try {
            Class<?> cls = Class.forName(className);
            return (T) Enum.valueOf((Class) cls, enumInstanceName);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e); // align to normal valueOf method signature.
        }
    }
}
