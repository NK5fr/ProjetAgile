package test.BlackJack;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import main.Lotterie.Lotterie;

public class BlackJack {
    BlackJack j;

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
	}

    @AfterEach
	public void afterATest() {
        System.out.println("--------- end of a test---------");
    }

    
    
}
