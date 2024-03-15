package com.rest.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class ValidateUtils {

    /**
     * Validate check null or empty
     *
     * @param object input
     * @return true if null or empty
     */
    public static boolean isNullOrEmpty(Object object) {
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

    public static boolean isNotNullOrEmpty(Object object) {
        return !isNullOrEmpty(object);
    }

    /**
     * validate input by pattern
     *
     * @param input from request
     * @param regex regex of pattern
     * @return result validation
     */
    public static boolean isMatchPattern(String input, String regex) {
        if (StringUtils.isEmpty(input) || StringUtils.isEmpty(regex)) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(input).matches();
    }

    /**
     * validate length of string
     *
     * @param str    from request
     * @param length regex of pattern
     * @return result validation
     */
    public static boolean isValidLengthStr(String str, int length) {
        return StringUtils.isNotEmpty(str) && str.length() <= length;
    }

}
