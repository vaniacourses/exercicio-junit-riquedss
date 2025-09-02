package carrinho;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

import static org.junit.jupiter.api.Assertions.*;

public class CarrinhoGptTest {

    private Carrinho carrinho;

    @BeforeEach
    public void setUp() {
        carrinho = new Carrinho();
    }

    // --- TESTE INICIAL ---
    @Test
    public void testCarrinhoInicialmenteVazio() {
        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal());
    }

    // --- TESTES DE ADD ITEM ---
    @Test
    public void testAdicionarUmItem() {
        Produto p = new Produto("Caneca", 10.0);
        carrinho.addItem(p);

        assertEquals(1, carrinho.getQtdeItems());
        assertEquals(10.0, carrinho.getValorTotal());
    }

    @Test
    public void testAdicionarVariosItens() {
        Produto p1 = new Produto("Camiseta", 50.0);
        Produto p2 = new Produto("Boné", 30.0);

        carrinho.addItem(p1);
        carrinho.addItem(p2);

        assertEquals(2, carrinho.getQtdeItems());
        assertEquals(80.0, carrinho.getValorTotal());
    }

    // --- TESTES DE REMOVE ITEM ---
    @Test
    public void testRemoverItemExistente() throws ProdutoNaoEncontradoException {
        Produto p = new Produto("Chaveiro", 5.0);
        carrinho.addItem(p);

        carrinho.removeItem(p);

        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal());
    }

    @Test
    public void testRemoverItemInexistenteLancaExcecao() {
        Produto p = new Produto("Adesivo", 2.0);

        assertThrows(ProdutoNaoEncontradoException.class, () -> carrinho.removeItem(p));
    }

    // --- TESTES DE ESVAZIAR ---
    @Test
    public void testEsvaziaCarrinho() {
        carrinho.addItem(new Produto("Produto1", 15.0));
        carrinho.addItem(new Produto("Produto2", 20.0));

        carrinho.esvazia();

        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal());
    }

    // --- TESTES DE VALOR TOTAL ---
    @Test
    public void testValorTotalComProdutosDePrecoZero() {
        carrinho.addItem(new Produto("Brinde", 0.0));

        assertEquals(1, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal());
    }
}


