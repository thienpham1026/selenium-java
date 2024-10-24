package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticesTest {
    @Test
    void verify_ChangeSpecialCharacter(){
        Assert.assertEquals("Hello _Java", Practices.changeSpecialCharacter("Hello @Java"));
    }

    @Test
    void verify_PrintLast4Chars(){
        Assert.assertEquals("neet", Practices.printLast4Chars("Japneet"));
    }

    @Test
    void verify_less4Char_PrintLast4Chars(){
        Assert.assertEquals("String is too short", Practices.printLast4Chars("Hi"));
    }

    @Test
    void verify_findNonRepeatingCharacter(){
        Assert.assertEquals("w", Practices.findNonRepeatingCharacter("swiss"));
    }

    @Test
    void verify_no_findNonRepeatingCharacter(){
        Assert.assertEquals("No non-repeating character found", Practices.findNonRepeatingCharacter("hhhh"));
    }
}
