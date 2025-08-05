import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    CharacterComparator c1 = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } //Uncomment this class once you've created your Palindrome class.

    @Test
    public void testisPalindrome() {
        assertFalse(palindrome.isPalindrome("cat" ));
        assertTrue(palindrome.isPalindrome("windydniw"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a"));
        assertFalse(palindrome.isPalindrome("aA"));

    }

    @Test
    public void testIsPalindromeoffbyone() {
        assertTrue(palindrome.isPalindrome("flake" , c1));
        assertTrue(palindrome.isPalindrome("a" , c1));
        assertTrue(palindrome.isPalindrome("" , c1));
        assertFalse(palindrome.isPalindrome("Flake" , c1));
        assertFalse(palindrome.isPalindrome("caca" , c1));


    }

    @Test
    public void testIsPalindromeoffbyN() {
        assertTrue(palindrome.isPalindrome("flake" , new OffByN(1)));
        assertTrue(palindrome.isPalindrome("a" , new OffByN(2)));
        assertTrue(palindrome.isPalindrome("" , new OffByN(3)));
        assertTrue(palindrome.isPalindrome("ae" , new OffByN(4)));
        assertTrue(palindrome.isPalindrome("aef" , new OffByN(5)));


    }


}
