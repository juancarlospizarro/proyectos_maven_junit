package com.endes;

/**
 * Clase que representa un termómetro para gestionar temperaturas en diferentes unidades.
 */
public class Termometro {

    private double temperatura; // Temperatura en grados Celsius.

    /**
     * Constructor que inicializa el termómetro con una temperatura en grados Celsius.
     *
     * @param temperaturaInicial La temperatura inicial. Puede ser cualquier valor.
     */
    public Termometro(double temperaturaInicial) {
        this.temperatura = temperaturaInicial;
    }

    /**
     * Obtiene la temperatura actual en grados Celsius.
     *
     * @return La temperatura en grados Celsius.
     */
    public double getTemperaturaCelsius() {
        return temperatura;
    }

    /**
     * Establece la temperatura en grados Celsius.
     *
     * @param nuevaTemperatura La nueva temperatura en grados Celsius.
     */
    public void setTemperaturaCelsius(double nuevaTemperatura) {
        this.temperatura = nuevaTemperatura;
    }

    /**
     * Convierte la temperatura actual a grados Fahrenheit.
     *
     * @return La temperatura en grados Fahrenheit.
     */
    public double convertirAFahrenheit() {
        return (temperatura * 9 / 5) + 32;
    }

    /**
     * Convierte la temperatura actual a grados Kelvin.
     *
     * @return La temperatura en grados Kelvin.
     * @throws IllegalArgumentException Si la temperatura en Celsius es menor que -273.15 (cero absoluto).
     */
    public double convertirAKelvin() {
        if (temperatura < -273.15) {
            throw new IllegalArgumentException("La temperatura no puede estar por debajo del cero absoluto.");
        }
        return temperatura + 273.15;
    }

    /**
     * Ajusta la temperatura sumando o restando un valor.
     *
     * @param ajuste El valor a ajustar (puede ser positivo o negativo).
     */
    public void ajustarTemperatura(double ajuste) {
        this.temperatura += ajuste;
    }

    /**
     * Verifica si la temperatura actual está en un rango seguro.
     *
     * @param min El límite inferior del rango.
     * @param max El límite superior del rango.
     * @return True si la temperatura está en el rango, false en caso contrario.
     */
    public boolean estaEnRango(double min, double max) {
        return temperatura >= min && temperatura <= max;
    }

    /**
     * Determina si la temperatura actual representa congelación en agua.
     *
     * @return True si la temperatura está en o por debajo de 0°C, false en caso contrario.
     */
    public boolean esCongelacion() {
        return temperatura <= 0;
    }

    /**
     * Determina si la temperatura actual representa ebullición en agua.
     *
     * @return True si la temperatura está en o por encima de 100°C, false en caso contrario.
     */
    public boolean esEbullicion() {
        return temperatura >= 100;
    }
}
