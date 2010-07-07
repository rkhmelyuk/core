package com.prutsoft.core;

import com.prutsoft.core.asserts.ArgumentAssert;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Key generator used to generate secret keys and passwords.
 * It supports possibility to generate keys upper and low alpha symbols,
 * numeric and special characters etc.<p>
 * Example:<p>
 * <code>
 *  ... <br>
 *  String key = generateKey(50, WITH_ALPHA_UP | WITH_ALPHA_LOW | WITH_NUMERIC);<br>
 *  ... <br>
 * </code>
 *
 * @author Ruslan Khmelyuk
 * @version $Rev$
 * @since 2009-01-24 00:29
 */
public class KeyGenerator {

    /**
     * Used to setup generation of key with upper alpha symbols.
     */
    public static int WITH_ALPHA_UP         = 0x01;

    /**
     * Used to setup generation of key with low alpha symbols.
     */
    public static int WITH_ALPHA_LOW        = 0x02;

    /**
     * Used to setup generation of key with numeric symbols.
     */
    public static int WITH_NUMERIC          = 0x04;

    /**
     * Used to setup generation of key with special symbols.
     */
    public static int WITH_SPEC             = 0x08;

    private static final char[] ALPHA_UPPER = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
    };

    private static final char[] ALPHA_LOW = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
    };

    private static final char[] NUMERIC = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
    };

    private static final char[] SPEC = {
            '&', ';', '@', '#', '$', '%', '?', '!', ':', '*', '+', '-',
            '=', '<', '>', '[', ']', '^', '`', '_', '{', '|', '}', '~',
    };


    /**
     * Generates the key with specified length.
     * Argument {@code conf} is used to specify types of characters
     * that could be used. Use combination of next values
     * <code>
     *  WITH_ALPHA_LOW, WITH_ALPHA_UP, WITH_NUMERIC, WITH_SPEC
     * </code>
     *
     * @see #WITH_ALPHA_UP
     * @see #WITH_ALPHA_LOW
     * @see #WITH_NUMERIC
     * @see #WITH_SPEC
     *
     * @param length the length of key; can't be 0 or negative.
     * @param conf the configuration for keygen tool, at least one type must be set.
     * @return the generated key.
     */
    public static String generateKey(int length, int conf) {
        ArgumentAssert.isTrue(length > 0, "Length value can't be negative or 0.");

        char[][] def = new char[4][];
        int index = 0;
        if ((conf & WITH_ALPHA_UP) == WITH_ALPHA_UP) {
            def[index++] = ALPHA_UPPER;
        }
        if ((conf & WITH_ALPHA_LOW) == WITH_ALPHA_LOW) {
            def[index++] = ALPHA_LOW;
        }
        if ((conf & WITH_NUMERIC) == WITH_NUMERIC) {
            def[index++] = NUMERIC;
        }
        if ((conf & WITH_SPEC) == WITH_SPEC) {
            def[index++] = SPEC;
        }

        ArgumentAssert.isFalse(index == 0, "Configuration is wrong: " +
                "at least one type of symbols must be defined.");

        Random typeRandom = new SecureRandom();
        Random valueRandom = new SecureRandom();

        char[] result = new char[length];
        for (int i = 0; i < length; i++) {

            int type = typeRandom.nextInt(index);

            char[] currentArray = def[type];
            char ch = currentArray[valueRandom.nextInt(currentArray.length)];

            result[i] = ch;
        }
        return new String(result);
    }

    /**
     * Generates the strong key with specified length.
     * Strong key config is <code>WITH_ALPHA_LOW</code> and <code>WITH_ALPHA_UP</code>
     * and <code>WITH_NUMERIC</code> and <code>WITH_SPEC</code>.
     *
     * @see #generateKey(int, int)
     *
     * @param length the length for the generated key; can't be 0 or negative.
     * @return the generated key.
     */
    public static String generateStrongKey(int length) {
        return generateKey(length, WITH_ALPHA_LOW | WITH_ALPHA_UP | WITH_NUMERIC | WITH_SPEC);
    }

    /**
     * Generates the key of alpha keys only with specified length.
     * Strong key config is <code>WITH_ALPHA_LOW</code> and <code>WITH_ALPHA_UP</code>.
     *
     * @see #generateKey(int, int)
     *
     * @param length the length for the generated key; can't be 0 or negative.
     * @return the generated key.
     */
    public static String generateAlphaKey(int length) {
        return generateKey(length, WITH_ALPHA_LOW | WITH_ALPHA_UP);
    }

    /**
     * Generates the key of alpha keys and numbers with specified length.
     * Strong key config is <code>WITH_ALPHA_LOW</code> and <code>WITH_ALPHA_UP</code>
     * and <code>WITH_NUMERIC</code>.
     *
     * @see #generateKey(int, int)
     *
     * @param length the length for the generated key; can't be 0 or negative.
     * @return the generated key.
     */
    public static String generateSimpleKey(int length) {
        return generateKey(length, WITH_ALPHA_LOW | WITH_ALPHA_UP | WITH_NUMERIC);
    }

}
