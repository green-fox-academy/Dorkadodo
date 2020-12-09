import org.junit.Test;

import static org.junit.Assert.*;

public class AnagramTest {
Anagram anagram;
    @Test
    public void anagramHappy() {
        anagram = new Anagram();
        assertTrue(anagram.anagram("getter", "retteg"));
    }

    @Test
    public void anagramEmptyString() {
        anagram = new Anagram();
        assertTrue(anagram.anagram("", ""));
    }

    @Test (expected = NullPointerException.class)
    public void anagramNullString() {
        anagram = new Anagram();
        assertTrue(anagram.anagram(null, null));
    }

    @Test
    public void anagramStringWithSpace() {
        anagram = new Anagram();
        assertTrue(anagram.anagram("ada get", "get ada"));
    }

}