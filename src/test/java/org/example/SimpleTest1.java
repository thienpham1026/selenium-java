
package org.example;

import org.testng.annotations.*;

public class SimpleTest1 {
    @BeforeSuite
    void beforeSuite(){
        System.out.println("BeforeSuite::Class1Test");
    }

    @BeforeTest
    void beforeTest(){
        System.out.println("BeforeTest::Class1Test");
    }

    @BeforeClass
    void beforeClass(){
        System.out.println("BeforeClass::Class1Test");
    }

    @BeforeMethod
    void beforeMethod(){
        System.out.println("BeforeMethod::Class1Test");
    }

    @Test
    void tc01(){
        System.out.println("Class1Test::tc01");
    }

    @Test(groups = {"smoke-test"})
    void tc02(){
        System.out.println("Class1Test::tc02");
    }

    @Test(groups = {"smoke-test"})
    void tc03(){
        System.out.println("Class1Test::tc03");
    }
    @Test
    void tc04(){
        System.out.println("Class1Test::tc04");
    }
    @Test
    void tc05(){
        System.out.println("Class1Test::tc05");
    }
    @AfterMethod
    void afterMethod(){
        System.out.println("AfterMethod::Class1Test");
    }

    @AfterClass
    void afterClass(){
        System.out.println("AfterClass::Class1Test");
    }

    @AfterTest
    void afterTest(){
        System.out.println("AfterTest::Class1Test");
    }

    @AfterSuite
    void afterSuite(){
        System.out.println("AfterSuite::Class1Test");
    }
}