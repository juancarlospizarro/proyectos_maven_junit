package com.endes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TermometroTest {

	Termometro termometro;
	
	/* @BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	*/
	
	@BeforeEach
	void setUp() throws Exception {
		termometro = new Termometro(5);
	}

	/* @AfterEach
	void tearDown() throws Exception {
	}
	*/
	
	@Test
	@DisplayName("Comprobar resultado correcto Fharenheit")
	void testConvertirAFahrenheit() {
		Double valorEsperado = 41.0;
		Double valor = termometro.convertirAFahrenheit();
		
		assertEquals(valorEsperado, valor);
	}
	
	@Test
	@DisplayName("Temperatura Kelvin no válida")
	void testTemperaturaKelvinNoValida() {
		termometro = new Termometro(-300);
		String mensajeEsperado = "La temperatura no puede estar por debajo del cero absoluto.";
		Exception e = assertThrows(IllegalArgumentException.class, () -> termometro.convertirAKelvin());
		String mensaje = e.getMessage();
		
		assertEquals(mensajeEsperado, mensaje);
	}
	
	@Test
	@DisplayName("Temperatura Kelvin válida")
	void testTemperaturaKelvinValida() {
		Double valorEsperado = 278.15;
		Double valor = termometro.convertirAKelvin();
		
		assertEquals(valorEsperado, valor);
	}

	@Test
	@DisplayName("Ajustar temperatura correctamente")
	void testAjustarTemperaturaCorrecta() {
		Double valorEsperado = 25.0;
		termometro.ajustarTemperatura(20);
		Double valor = termometro.getTemperaturaCelsius();
		
		assertEquals(valorEsperado, valor);
	}
	
	@Test
	@DisplayName("La temperatura se encuentra en rango")
	void testTemperaturaEnRango() {
		assertTrue(termometro.estaEnRango(0, 10));
	}
	
	@Test
	@DisplayName("La temperatura no se encuentra en rango")
	void testTemperaturaNoEnRango() {
		assertFalse(termometro.estaEnRango(10, 20));
	}
	
	
}
