import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    private Main Jokenpo;

    @BeforeEach
    public void inicializa() {
        Jokenpo = new Main();
    }

    @Test
    public void empate() {
        int jogador1 = 2;
        int jogador2 = 2;

        int retorno = Jokenpo.jogar(jogador1, jogador2);

        assertEquals(0, retorno);
    }

    @Test
    public void acoesInvalidasJogador1() {
        int jogador1 = 4;
        int jogador2 = 2;

        int retorno = Jokenpo.jogar(jogador1, jogador2);

        assertEquals(-1, retorno);
    }

    @Test
    public void acoesInvalidasJogador2() {
        int jogador1 = 1;
        int jogador2 = 0;

        int retorno = Jokenpo.jogar(jogador1, jogador2);

        assertEquals(-1, retorno);
    }

    @Test
    public void acoesInvalidasDeAmbosOsJogadores() {
        int jogador1 = 0;
        int jogador2 = 4;

        int retorno = Jokenpo.jogar(jogador1, jogador2);

        assertEquals(-1, retorno);
    }

    @Test
    public void winJogador1() {
        int jogador1Acao1 = 1;
        int jogador2Acao1 = 2;

        int jogador1Acao2 = 3;
        int jogador2Acao2 = 1;

        int rodada1 = Jokenpo.jogar(jogador1Acao1, jogador2Acao1);
        int rodada2 = Jokenpo.jogar(jogador1Acao2, jogador2Acao2);

        assertEquals(1, rodada1);
        assertEquals(1, rodada2);
    }

    @Test
    public void winJogador2() {
        int jogador1Acao1 = 1;
        int jogador2Acao1 = 3;

        int jogador1Acao2 = 2;
        int jogador2Acao2 = 1;

        int rodada1 = Jokenpo.jogar(jogador1Acao1, jogador2Acao1);
        int rodada2 = Jokenpo.jogar(jogador1Acao2, jogador2Acao2);

        assertEquals(2, rodada1);
        assertEquals(2, rodada2);
    }
}
