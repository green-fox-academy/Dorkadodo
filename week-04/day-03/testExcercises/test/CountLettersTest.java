import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class CountLettersTest {

    CountLetters countLetters;

    @Test
    public void countLetters() {
        countLetters = new CountLetters();
        HashMap<Character, Integer> dictionaryExpected = new HashMap<>();
        dictionaryExpected.put('a', 2);
        dictionaryExpected.put('b', 2);
        dictionaryExpected.put('c', 3);
        dictionaryExpected.put('G', 1);
        dictionaryExpected.put(' ', 2);
        HashMap<Character, Integer> dictionary = countLetters.countLetters("abab cGc c");
        assertEquals(dictionaryExpected, dictionary);
    }

    @Test
    public void countEmptyString() {
        countLetters = new CountLetters();
        HashMap<Character, Integer> dictionaryExpected = new HashMap<>();
        HashMap<Character, Integer> dictionary = countLetters.countLetters("");
        assertEquals(dictionaryExpected, dictionary);
    }

    @Test (expected = NullPointerException.class)
    public void countNullString() {
        countLetters = new CountLetters();
        HashMap<Character, Integer> dictionaryExpected = new HashMap<>();
        HashMap<Character, Integer> dictionary = countLetters.countLetters(null);
        assertEquals(dictionaryExpected, dictionary);
    }
}