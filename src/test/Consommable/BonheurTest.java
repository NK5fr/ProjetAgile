package test.Consommable;

import main.Consommable.Bonheur;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BonheurTest {
    
    Bonheur b;

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
		b = new Bonheur(10, 30, "cloche");
	}

    @AfterEach
	public void afterATest() {
        System.out.println("--------- end of a test---------");
    }

    @Test
    public void effetTest(){
        assertEquals("Ceci est un cloche qui coute 30 pour gagner 10 point de bonheur.",b.effet());
    }
}