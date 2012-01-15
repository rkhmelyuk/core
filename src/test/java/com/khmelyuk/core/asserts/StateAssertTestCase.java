package com.khmelyuk.core.asserts;

import com.khmelyuk.core.BaseTestCase;
import com.khmelyuk.core.utils.StringUtils;

/**
 * @author Ruslan Khmelyuk
 * @since 2008-8-23 2:50
 */
public class StateAssertTestCase extends BaseTestCase {

    public void testIsTrueOnTrue() {
        try {
            StateAssert.isTrue(true, "Message");
        }
        catch (Exception e) {
            unexpectedException(e.getClass());
        }
    }

    public void testIsTrueOnFalse() {
        try {
            StateAssert.isTrue(false, "Message");
            unexpected("Assert should fail.");
        }
        catch (IllegalStateException e) {
            if (!StringUtils.equals(e.getMessage(), "Message")) {
                fail("Wrong message.");
            }
        }
        catch (Exception e) {
            unexpectedException(e.getClass());
        }
    }

    public void testIsFalseOnFalse() {
        try {
            StateAssert.isFalse(false, "Message");
        }
        catch (Exception e) {
            unexpectedException(e.getClass());
        }
    }

    public void testIsFalseOnTrue() {
        try {
            StateAssert.isFalse(true, "Message");
            unexpected("Assert should fail.");
        }
        catch (IllegalStateException e) {
            if (!StringUtils.equals(e.getMessage(), "Message")) {
                fail("Wrong message.");
            }
        }
        catch (Exception e) {
            unexpectedException(e.getClass());
        }
    }

}