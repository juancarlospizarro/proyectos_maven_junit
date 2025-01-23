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
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	@BeforeEach
	void setUp() throws Exception {
		termometro = new Termometro(5);
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	
	// Test constructor
	@Test
	@DisplayName("Prueba del constructor")
	void testConstructor() {
		Double resultadoEsperado = 5.0;
		Double resultado = termometro.getTemperaturaCelsius();
		
		assertEquals(resultadoEsperado, resultado);
	}
	
	// Test getTemperatura()
	@Test
	@DisplayName("Prueba devolución correcta de temperatura")
	void testTemperaturaDevueltaCorrecta() {
		Double resultadoEsperado = 5.0;
		Double valor = termometro.getTemperaturaCelsius();
		
		assertEquals(resultadoEsperado, valor);
	}
	
	// Test setTemperatura()
	@Test
	@DisplayName("Prueba establecer temperatura correcta")
	void testEstablecerTemperaturaCorrecta() {
		Double valorEsperado = 10.0;
		termometro.setTemperaturaCelsius(valorEsperado);
		
		assertEquals(valorEsperado, termometro.getTemperaturaCelsius());
	}
	
	// Test convertirAFahrenheit()
	@Test
	@DisplayName("Comprobar resultado correcto Fharenheit")
	void testConvertirAFahrenheit() {
		Double valorEsperado = 41.0;
		Double valor = termometro.convertirAFahrenheit();
		
		assertEquals(valorEsperado, valor);
	}
	
	// Test convertirAKelvin()
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

	// Test ajustarTemperatura()
	@Test
	@DisplayName("Ajustar temperatura correctamente")
	void testAjustarTemperaturaCorrecta() {
		Double valorEsperado = 25.0;
		termometro.ajustarTemperatura(20);
		Double valor = termometro.getTemperaturaCelsius();
		
		assertEquals(valorEsperado, valor);
	}
	
	// Test estaEnRango()
	@Test
	@DisplayName("La temperatura se encuentra en rango")
	void testTemperaturaEnRango() {
		assertTrue(termometro.estaEnRango(0, 10));
	}
	
	@Test
	@DisplayName("La temperatura está por encima del rango")
	void testTemperaturaSuperiorAlRango() {
		termometro = new Termometro(15);
		assertFalse(termometro.estaEnRango(0, 10));
	}
	
	@Test
	@DisplayName("La temperatura está por debajo del rango")
	void testTemperaturaInferiorAlRango() {
		termometro = new Termometro(-5);
		assertFalse(termometro.estaEnRango(0, 10));
	}
	
	// Test esCongelacion()
	@Test
	@DisplayName("Temperatura en congelación")
	void testTemperaturaEnCongelacion() {
		termometro = new Termometro(-5);
		assertTrue(termometro.esCongelacion());
	}
	
	@Test
	@DisplayName("Temperatura no en congelación")
	void testTemperaturaNoEnCongelacion() {
		assertFalse(termometro.esCongelacion());
	}
	
	// Test esEbullicion()
	@Test
	@DisplayName("Temperatura en ebullición")
	void testTemperaturaEnEbullicion() {
		termometro = new Termometro(150);
		assertTrue(termometro.esEbullicion());
	}
	
	@Test
	@DisplayName("Temperatura no en ebullición")
	void testTemperaturaNoEnEbullicion() {
		assertFalse(termometro.esEbullicion());
	}
}
