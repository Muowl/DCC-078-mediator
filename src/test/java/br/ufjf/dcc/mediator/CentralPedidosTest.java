package br.ufjf.dcc.mediator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CentralPedidosTest {
    @Test void confirmaPedidoEAtualizaEstoque() {
        Estoque estoque = new Estoque(5);
        Cliente cliente = new Cliente(new CentralPedidos(estoque, new Pagamento(100)));
        assertEquals("Pedido confirmado", cliente.comprar(2, 100));
        assertEquals(3, estoque.getQuantidade());
    }

    @Test void recusaQuandoNaoHaEstoque() {
        Estoque estoque = new Estoque(1);
        Cliente cliente = new Cliente(new CentralPedidos(estoque, new Pagamento(100)));
        assertEquals("Estoque insuficiente", cliente.comprar(2, 50));
        assertEquals(1, estoque.getQuantidade());
    }

    @Test void recusaPagamentoSemAlterarEstoque() {
        Estoque estoque = new Estoque(5);
        Cliente cliente = new Cliente(new CentralPedidos(estoque, new Pagamento(20)));
        assertEquals("Pagamento recusado", cliente.comprar(2, 21));
        assertEquals(5, estoque.getQuantidade());
    }

    @Test void rejeitaDadosInvalidos() {
        Estoque estoque = new Estoque(5);
        Cliente cliente = new Cliente(new CentralPedidos(estoque, new Pagamento(100)));
        assertEquals("Pedido invalido", cliente.comprar(0, 10));
        assertEquals("Pedido invalido", cliente.comprar(1, -1));
        assertEquals("Pedido invalido", cliente.comprar(1, Double.NaN));
        assertEquals(5, estoque.getQuantidade());
    }
}
