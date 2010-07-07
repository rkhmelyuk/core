package com.prutsoft.core.test.asserts;

import com.prutsoft.core.test.BaseTestCase;
import com.prutsoft.core.asserts.ArgumentAssert;
import com.prutsoft.core.utils.StringUtils;

/**
 * @author Ruslan Khmelyuk
 * @version $Rev: 16 $
 * @since 2008-8-23 2:50
 */
public class ArgumentAssertTestCase extends BaseTestCase {

    public void testIsTrueOnTrue() {
        try {
            ArgumentAssert.isTrue(true, "Message");
        }
        catch (Exception e) {
            unexpectedException(e.getClass());
        }
    }

    public void testIsTrueOnFalse() {
        try {
            ArgumentAssert.isTrue(false, "Message");
            unexpected("Assert should fail.");
        }
        catch (IllegalArgumentException e) {
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
            ArgumentAssert.isFalse(false, "Message");
        }
        catch (Exception e) {
            unexpectedException(e.getClass());
        }
    }

    public void testIsFalseOnTrue() {
        try {
            ArgumentAssert.isFalse(true, "Message");
            unexpected("Assert should fail.");
        }
        catch (IllegalArgumentException e) {
            if (!StringUtils.equals(e.getMessage(), "Message")) {
                fail("Wrong message.");
            }
        }
        catch (Exception e) {
            unexpectedException(e.getClass());
        }
    }
    
}
