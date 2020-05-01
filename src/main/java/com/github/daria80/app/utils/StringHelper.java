package com.github.daria80.app.utils;

import java.util.UUID;

/**
 * Helper class for working with strings
 */
public class StringHelper {
    /**
     * Generates string for identification
     *
     * @return String Generated string for identification
     */

    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}
