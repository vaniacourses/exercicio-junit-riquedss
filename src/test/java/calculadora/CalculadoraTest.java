package calculadora;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {

    private Calculadora calc;

    @BeforeEach
    public void inicializa() {
        calc = new Calculadora();
    }

    @DisplayName("Testa a soma de dois números")
    @Test
    public void testSomaDoisNumeros() {
        int soma = calc.soma(4, 5);
        Assertions.assertEquals(9, soma);
    }

    @DisplayName("Testa a subtração de dois números")
    @Test
    public void testSubtracaoDoisNumeros() {
        int subtracao = calc.subtracao(10, 5);
        Assertions.assertEquals(5, subtracao);
    }

    @DisplayName("Testa a divisão de dois números")
    @Test
    public void testDivisaoDoisNumeros() {
        int divisao = calc.divisao(8, 4);
        assertTrue(divisao == 2);
    }

    @DisplayName("Testa a multiplicação de dois números")
    @Test
    public void testMultiplicacaoDoisNumeros() {
        int multiplicacao = calc.multiplicacao(8, 2);
        assertEquals(16, multiplicacao);
    }

    @Test
    public void testDivisaoPorZero() {
        try {
            int divisao = calc.divisao(8, 0);
            fail("Exceção não lançada");
        }catch (ArithmeticException e) {
            assertEquals("/ by zero", e.getMessage());
        }
    }

    @Test
    public void testDivisaoPorZeroComAssertThrows() {
        assertThrows(ArithmeticException.class,
                () -> calc.divisao(8, 0));
    }

    @DisplayName("Testa o somatório zero até n")
    @Test
    public void testSomatorio() {
        int somatorio = calc.somatoria(8);
        assertEquals(36, somatorio);
    }

    @DisplayName("Testa se um número é positivo")
    @Test
    public void testEhPositivo() {
        assertTrue(calc.ehPositivo(8));
    }

    @DisplayName("Testa se um número é negativo")
    @Test
    public void testEhNegativo() {
        assertFalse(calc.ehPositivo(-1));
    }

    @DisplayName("Testa a comparação entre dois valores")
    @Test
    public void testCompare() {
        int maior = calc.compara(4, 3);
        int menor = calc.compara(3, 4);
        int igual = calc.compara(3, 3);

        assertEquals(1, maior);
        assertEquals(-1, menor);
        assertEquals(0, igual);

    }
}