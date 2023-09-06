package test.Consommable;

import main.Consommable.Nourriture;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class NourritureTest {
    
    Nourriture n;

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
		n = new Nourriture(10, 30, "pizza");
	}

    @AfterEach
	public void afterATest() {
        System.out.println("--------- end of a test---------");
    }

    @Test
    public void effetTest(){
        assertEquals("Ceci est un pizza qui coute 30 pour gagner 10 point de nourriture.",n.effet());
    }
}