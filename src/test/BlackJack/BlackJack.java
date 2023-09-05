package test.BlackJack;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import main.BlackJack.User;

public class BlackJack {
    BlackJack j;
    User u;

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
		j = new BlackJack();
        u = new User(100);
	}

    @AfterEach
	public void afterATest() {
        System.out.println("--------- end of a test---------");
    }

    @Test
    public void testBet() {
        
    }
    
}
