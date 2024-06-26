package com.bevis.fileservice.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ValidateUtils {

    /**
     * Validate check null or empty
     *
     * @param object input
     * @return true if null or empty
     */
    public static <T> boolean isNullOrEmpty(T object) {
        if (null == object) {
            return true;
        }
        if (object instanceof String) {
            if (((String) object).isEmpty()) {
                return true;
            }
        }
        if (object instanceof List<?>) {
            if (((List<?>) object).isEmpty()) {
                return true;
            }
        }
        if (object instanceof Set<?>) {
            if (((Set<?>) object).isEmpty()) {
                return true;
            }
        }
        if (object instanceof Map<?, ?>) {
            if (((Map<?, ?>) object).isEmpty()) {
                return true;
            }
        }
        if (object instanceof String[]) {
            if (((String[]) object).length == 0) {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean isNotNullOrEmpty(T object) {
        return !isNullOrEmpty(object);
    }

}
