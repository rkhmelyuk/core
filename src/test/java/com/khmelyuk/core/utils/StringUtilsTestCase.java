package com.khmelyuk.core.utils;

import com.khmelyuk.core.BaseTestCase;

/**
 * @author Ruslan Khmelyuk
 * @since 2008-9-1 11:4
 */
public class StringUtilsTestCase extends BaseTestCase {

    public void testCutShorter() {
        String text = "This text  is used to test StringUtils cut() method.";
        String result = StringUtils.cut(text, 100, "...");
        assertEquals(result, text);
    }

    public void testCutLonger() {
        String text = "This text is used to test StringUtils cut() method.";
        String result = StringUtils.cut(text, 12, "...");
        assertEquals(result, "This text...");
    }

    public void testCutLongerWithoutLastSpace() {
        String text = "This text is used to test StringUtils cut() method.";
        String result = StringUtils.cut(text, 8, "...");
        assertEquals(result, "This...");
    }

    public void testCutLongerWithoutSpacs() {
        String text = "Thistextisusedtotest StringUtils cut() method.";
        String result = StringUtils.cut(text, 8, "...");
        assertEquals(result, "Thistext...");
    }

    public void testCutStringShorter() {
        String text = "This is just a test.";
        String result = StringUtils.cut(text, 100);
        assertEquals(result, text);
        assertSame(result, text);
    }

    public void testCutStringLonger() {
        String text = "This is just a test.";
        String result = StringUtils.cut(text, 10);
        assertEquals(result, "This is ju");
    }

    public void testStringWithPrefixValue() {
        String text = "prefix:the-value";
        assertEquals("the-value", StringUtils.getStringWithPrefixValue(text, "prefix:"));
        assertNull(StringUtils.getStringWithPrefixValue(text, "xifepr:"));

        try {
            StringUtils.getStringWithPrefixValue("text", null);
        }
        catch (IllegalArgumentException e) {
            // that's OK
        }
        catch (Exception e) {
            unexpectedException(e.getMessage());
        }

        try {
            StringUtils.getStringWithPrefixValue(null, "text");
        }
        catch (IllegalArgumentException e) {
            // that's OK
        }
        catch (Exception e) {
            unexpectedException(e.getMessage());
        }
    }

    public void testEquals() {
        assertTrue(StringUtils.equals("Test", "Test", "Test", "Test"));
        assertFalse(StringUtils.equals("Test", "test", "Test", "Test"));
        assertFalse(StringUtils.equals("Test", null, "Test"));
        assertFalse(StringUtils.equals());
    }

    public void testConcat() {
        assertEquals(
                StringUtils.concatStrings(
                        "Hello", " ", "world", "!"), "Hello world!");
    }

    public void testEmpty() {
        assertTrue(StringUtils.isEmpty(""));
        assertTrue(StringUtils.isEmpty(null));
        assertFalse(StringUtils.isEmpty(" "));
        assertFalse(StringUtils.isEmpty("t"));
    }

    public void testTrimmedEmpty() {
        assertTrue(StringUtils.isEmptyTrimmed(""));
        assertTrue(StringUtils.isEmptyTrimmed(null));
        assertTrue(StringUtils.isEmptyTrimmed(" "));
        assertFalse(StringUtils.isEmptyTrimmed("t"));
    }

    public void testBlank() {
        assertTrue(StringUtils.isBlank(""));
        assertFalse(StringUtils.isBlank(" "));
        assertFalse(StringUtils.isBlank("t"));

        assertFalse(StringUtils.isBlank(null));
    }

    public void testTrimmedBlank() {
        assertTrue(StringUtils.isBlankTrimmed(""));
        assertTrue(StringUtils.isBlankTrimmed(" "));
        assertFalse(StringUtils.isBlankTrimmed("t"));

        assertFalse(StringUtils.isBlankTrimmed(null));
    }

    public void testNotEmpty() {
        assertFalse(StringUtils.isNotEmpty(""));
        assertFalse(StringUtils.isNotEmpty(null));
        assertTrue(StringUtils.isNotEmpty(" "));
        assertTrue(StringUtils.isNotEmpty("t"));
    }

    public void testNotTrimmedEmpty() {
        assertFalse(StringUtils.isNotEmptyTrimmed(""));
        assertFalse(StringUtils.isNotEmptyTrimmed(null));
        assertFalse(StringUtils.isNotEmptyTrimmed(" "));
        assertTrue(StringUtils.isNotEmptyTrimmed("t"));
    }

    public void testNotBlankTrimmed() {
        assertFalse(StringUtils.isNotBlankTrimmed(""));
        assertFalse(StringUtils.isNotBlankTrimmed(" "));
        assertTrue(StringUtils.isNotBlankTrimmed("t"));

        assertFalse(StringUtils.isNotBlankTrimmed(null));
    }
}
