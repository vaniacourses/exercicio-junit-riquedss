package carrinho;

import org.junit.jupiter.api.*;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

import static org.junit.jupiter.api.Assertions.*;

public class CarrinhoTest {
    Carrinho carrinho;
    Produto produto1;
    Produto produto2;

    @BeforeEach
    public void inicializa() {
        carrinho = new Carrinho();
        produto1 = new Produto("Celular", 1200);
        produto2 = new Produto("Notebook", 5000);
    }

    @Test
    public void testSetItem(){
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);

        assertEquals(2, carrinho.getQtdeItems());
    }

    @Test
    public void testGetValorTotal(){
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);

        double valor = carrinho.getValorTotal();

        assertEquals(6200, valor);
    }

    @Test
    public void testEsvaziar(){
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);

        carrinho.esvazia();

        assertEquals(0, carrinho.getQtdeItems());
    }

    @Test
    public void removerItem() throws ProdutoNaoEncontradoException {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);

        carrinho.removeItem(produto2);

        assertEquals(1, carrinho.getQtdeItems());
    }
}
