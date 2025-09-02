package calculadora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraGptTest {
    private Calculadora calculadora;

    @BeforeEach
    public void setUp() {
        calculadora = new Calculadora();
    }

    // --- TESTES DE SOMA ---
    @Test
    public void testSomaPositivos() {
        assertEquals(5, calculadora.soma(2, 3));
    }

    @Test
    public void testSomaNegativos() {
        assertEquals(-7, calculadora.soma(-2, -5));
    }

    @Test
    public void testSomaComZero() {
        assertEquals(4, calculadora.soma(4, 0));
    }

    // --- TESTES DE SUBTRAÇÃO ---
    @Test
    public void testSubtracaoPositivos() {
        assertEquals(2, calculadora.subtracao(5, 3));
    }

    @Test
    public void testSubtracaoNegativos() {
        assertEquals(3, calculadora.subtracao(-2, -5));
    }

    @Test
    public void testSubtracaoComZero() {
        assertEquals(7, calculadora.subtracao(7, 0));
    }

    // --- TESTES DE MULTIPLICAÇÃO ---
    @Test
    public void testMultiplicacaoPositivos() {
        assertEquals(12, calculadora.multiplicacao(3, 4));
    }

    @Test
    public void testMultiplicacaoComZero() {
        assertEquals(0, calculadora.multiplicacao(9, 0));
    }

    @Test
    public void testMultiplicacaoNegativos() {
        assertEquals(-15, calculadora.multiplicacao(-3, 5));
        assertEquals(20, calculadora.multiplicacao(-4, -5));
    }

    // --- TESTES DE DIVISÃO ---
    @Test
    public void testDivisaoPositivos() {
        assertEquals(2, calculadora.divisao(10, 5));
    }

    @Test
    public void testDivisaoNegativos() {
        assertEquals(-4, calculadora.divisao(-20, 5));
        assertEquals(4, calculadora.divisao(-20, -5));
    }

    @Test
    public void testDivisaoPorZero() {
        assertThrows(ArithmeticException.class, () -> calculadora.divisao(5, 0));
    }

    // --- TESTES DE SOMATÓRIA ---
    @Test
    public void testSomatoriaPositivo() {
        assertEquals(15, calculadora.somatoria(5)); // 0+1+2+3+4+5
    }

    @Test
    public void testSomatoriaZero() {
        assertEquals(0, calculadora.somatoria(0));
    }

    @Test
    public void testSomatoriaNegativo() {
        // while (n >= 0) não executa se n < 0, logo resultado deve ser 0
        assertEquals(0, calculadora.somatoria(-5));
    }

    // --- TESTES DE ehPositivo ---
    @Test
    public void testEhPositivoComPositivo() {
        assertTrue(calculadora.ehPositivo(10));
    }

    @Test
    public void testEhPositivoComZero() {
        assertTrue(calculadora.ehPositivo(0));
    }

    @Test
    public void testEhPositivoComNegativo() {
        assertFalse(calculadora.ehPositivo(-1));
    }

    // --- TESTES DE COMPARA ---
    @Test
    public void testComparaIguais() {
        assertEquals(0, calculadora.compara(5, 5));
    }

    @Test
    public void testComparaMaior() {
        assertEquals(1, calculadora.compara(10, 3));
    }

    @Test
    public void testComparaMenor() {
        assertEquals(-1, calculadora.compara(2, 9));
    }
}
