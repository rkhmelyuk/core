package com.prutsoft.core.test;

import com.prutsoft.core.Pair;
import com.prutsoft.core.ReadOnlyPair;

/**
 * @author Ruslan Khmelyuk
 * @version $Rev: 16 $
 * @since 2008-8-25 19:23
 */
public class PairTestCase extends BaseTestCase {

    public void testConstructor() {
        Pair<Integer, String> pair = new Pair<Integer, String>(10, "23");

        assertEquals("First value", Integer.valueOf(10), pair.getFirst());
        assertEquals("Second value", "23", pair.getSecond());
    }

    public void testUsePairSetters() {
        Pair<String, Integer> pair = new Pair<String, Integer>();

        assertEquals(pair.getFirst(), null);
        assertEquals(pair.getSecond(), null);

        pair.setFirst("First");
        pair.setSecond(2);

        assertEquals(pair.getFirst(), "First");
        assertEquals(pair.getSecond(), Integer.valueOf(2));
    }

    public void testChangePair() {
        Pair<String, Integer> pair = new Pair<String, Integer>();

        pair.setFirst("First");
        pair.setSecond(2);
        assertEquals(pair.getFirst(), "First");
        assertEquals(pair.getSecond(), Integer.valueOf(2));

        pair.setFirst("Hello");
        assertEquals(pair.getFirst(), "Hello");
        assertEquals(pair.getSecond(), Integer.valueOf(2));

        pair.setSecond(23);
        assertEquals(pair.getFirst(), "Hello");
        assertEquals(pair.getSecond(), Integer.valueOf(23));        
    }

    public void testGetReadOnlyFromPair() {
        Pair<Integer, String> pair = new Pair<Integer, String>(12, "hi");
        ReadOnlyPair<Integer, String> roPair = pair.asReadOnly();

        assertEquals(pair.getFirst(), roPair.getFirst());
        assertEquals(pair.getSecond(), roPair.getSecond());
    }

    public void testPairRever() {
        Pair<Integer, String> pair = new Pair<Integer, String>(10, "lo");
        Pair<String, Integer> revertedPair = pair.revert();

        assertEquals(pair.getFirst(), revertedPair.getSecond());
        assertEquals(pair.getSecond(), revertedPair.getFirst());
    }

    public void testEquals() {
        Pair<Integer, String> pair1 = new Pair<Integer, String>(10, "lo");
        Pair<Integer, String> pair2 = new Pair<Integer, String>(10, "lo");

        assertTrue(pair1.equals(pair1));
        assertTrue(pair2.equals(pair2));
        assertTrue(pair1.equals(pair2));
        assertTrue(pair2.equals(pair1));
    }

    public void testNotEquals() {
        Pair [] pairs = new Pair[] {
                new Pair<Integer, String>(10, "lo"),
                new Pair<Integer, String>(11, "lo"),
                new Pair<Integer, String>(11, "hi"),
                new Pair<Integer, String>(10, "hi")
        };

        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < pairs.length; j++) {
                if (i != j) {
                    assertFalse("i=" + i + ";j=" + j + ":", pairs[i].equals(pairs[j]));
                }
            }
        }
    }
}
