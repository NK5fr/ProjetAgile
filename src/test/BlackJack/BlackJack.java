package test.BlackJack;

import org.junit.jupiter.api.Test;

import main.BlackJack.BlackJack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


public class BlackJack {
    BlackJack b = new BlackJack(new User(100));

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("Start test series");
    }

    @AfterAll
	public static void afterAllTests() {
        System.out.println("End test series");
    }

    @BeforeEach
	public void beforeATest() {
        b = new BlackJack(new User(100));
	}

    @AfterEach
	public void afterATest() {
        System.out.println("--------- end of a test---------");
    }

    @Test
    public void startingDealTest() {
        assertEquals(u.);;
    }
    
}
