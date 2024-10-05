package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExerciseTest {
    @Test
    void verify_10_is_EvenNumber(){
        Assert.assertTrue(Exercise.isEven(10));
    }

    @Test
    void verify_11_is_OddNumber(){
        Assert.assertFalse(Exercise.isEven(11));
    }

    @Test
    void verify_0_is_OddNumber(){
        Assert.assertTrue(Exercise.isEven(0));
    }

    @Test
    void verify_2024_is_leap_year(){
        Assert.assertTrue(Exercise.isLeapYear(2024));
    }

    @Test
    void verify_2023_is_not_leap_year(){
        Assert.assertFalse(Exercise.isLeapYear(2023));
    }

    @Test
    void u_is_vowel(){
        Assert.assertTrue(Exercise.isVowels("u"));
    }

    @Test
    void e_is_vowel(){
        Assert.assertTrue(Exercise.isVowels("e"));
    }

    @Test
    void o_is_vowel(){
        Assert.assertTrue(Exercise.isVowels("o"));
    }

    @Test
    void a_is_vowel(){
        Assert.assertTrue(Exercise.isVowels("a"));
    }

    @Test
    void i_is_vowel(){
        Assert.assertTrue(Exercise.isVowels("i"));
    }

    @Test
    void U_is_vowel(){
        Assert.assertTrue(Exercise.isVowels("U"));
    }

    @Test
    void E_is_vowel(){
        Assert.assertTrue(Exercise.isVowels("E"));
    }

    @Test
    void O_is_vowel(){
        Assert.assertTrue(Exercise.isVowels("O"));
    }

    @Test
    void A_is_vowel(){
        Assert.assertTrue(Exercise.isVowels("A"));
    }

    @Test
    void I_is_vowel(){
        Assert.assertTrue(Exercise.isVowels("I"));
    }

    @Test
    void b_is_not_vowel(){
        Assert.assertFalse(Exercise.isVowels("b"));
    }

    @Test
    void B_is_not_vowel(){
        Assert.assertFalse(Exercise.isVowels("B"));
    }

    @Test
    void verify_exception(){
        try{
            Exercise.isVowels("");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(),"input string length must be equals 1");
        }
    }

}