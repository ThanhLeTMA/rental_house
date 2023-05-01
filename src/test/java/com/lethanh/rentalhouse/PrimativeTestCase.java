package com.lethanh.rentalhouse;

import com.lethanh.rentalhouse.test.Ultils;
import org.junit.jupiter.api.*;

public class PrimativeTestCase {
    @BeforeAll
    public static void beforeAll(){
        System.out.println("BEFORE ALL");
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("AFTER ALL");
    }
    @BeforeEach
    public void beforeEach(){
        System.out.println("BEFORE EACH");
    }
    @AfterEach
    public void afterEach(){
        System.out.println("AFTER EACH");
    }
    @Test
    public void testEvenPrimative(){
        int n = 2;
        boolean expected = true;
        boolean actual = Ultils.PrimativeCheck(n);

        Assertions.assertEquals(expected,actual);

    }
    @Test
    public void testOddPrimative(){
        int n = 5;
        boolean expected = true;
        boolean actual = Ultils.PrimativeCheck(n);

        Assertions.assertTrue(actual);
    }
}
