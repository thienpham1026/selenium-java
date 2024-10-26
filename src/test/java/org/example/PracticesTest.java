package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticesTest {
    @Test
    void verify_ChangeSpecialCharacter() {
        Assert.assertEquals("Hello _Java", Practices.changeSpecialCharacter("Hello @Java"));
    }

    @Test
    void verify_PrintLast4Chars() {
        Assert.assertEquals("neet", Practices.printLast4Chars("Japneet"));
    }

    @Test
    void verify_less4Char_PrintLast4Chars() {
        Assert.assertEquals("String is too short", Practices.printLast4Chars("Hi"));
    }

    @Test
    void verify_findNonRepeatingCharacter() {
        Assert.assertEquals("w", Practices.findNonRepeatingCharacter("swiss"));
    }

    @Test
    void verify_no_findNonRepeatingCharacter() {
        Assert.assertEquals("No non-repeating character found", Practices.findNonRepeatingCharacter("hhhh"));
    }

    @Test
    void verify_returnFirstAlphabet() {
        Assert.assertEquals("HIaJ", Practices.returnFirstAlphabet("Hello I am Japneet"));
    }

    @Test
    void verify_removeSpecialCharacters() {
        Assert.assertEquals("Hello Japneet", Practices.removeSpecialCharacters("Hello^^%#$(!)_+ J@apneet"));
    }

    @Test
    void verify_getSentenceWithoutDuplicates() {
        Assert.assertEquals("Hello I", Practices.getSentenceWithoutDuplicates("Hello I am Japneet Japneet am"));
    }

    @Test
    void verify_removeWhiteSpace() {
        Assert.assertEquals("HelloJapneet", Practices.removeWhiteSpace("         Hello              Japne     et         "));
    }

    @Test
    void verify_getReverseOfString() {
        Assert.assertEquals("dlroW olleH", Practices.getReverseOfString("Hello World"));
    }
}
