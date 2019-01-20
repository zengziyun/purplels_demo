package com.example.one.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * 对象工具类
 * 判断是否为空
 * */
public class ObjectUtil {

    /**
     * 判断是否为空
     * */
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    /**
     * 判断是否不为空
     * */
    public static boolean isNotNull(Object obj) {
        return !isNull(obj);
    }

    /**
     * 判断是否为空
     * */
    public static boolean isEmpty(Object obj) {
        if (obj == null) return true;
        else if (obj instanceof CharSequence) return ((CharSequence) obj).length() == 0;
        else if (obj instanceof Collection) return ((Collection) obj).isEmpty();
        else if (obj instanceof Map) return ((Map) obj).isEmpty();
        else if (obj.getClass().isArray()) return Array.getLength(obj) == 0;

        return false;
    }

    /**
     * 判断是否不为空
     * */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }
}
