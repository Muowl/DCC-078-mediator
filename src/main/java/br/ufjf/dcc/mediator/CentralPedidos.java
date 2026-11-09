package br.ufjf.dcc.mediator;

public class CentralPedidos implements MediadorPedido {
    private final Estoque estoque;
    private final Pagamento pagamento;

    public CentralPedidos(Estoque estoque, Pagamento pagamento) {
        this.estoque = estoque;
        this.pagamento = pagamento;
    }

    public String realizarPedido(int quantidade, double valor) {
        if (quantidade <= 0 || !Double.isFinite(valor) || valor <= 0) {
            return "Pedido invalido";
        }
        if (!estoque.disponivel(quantidade)) { return "Estoque insuficiente"; }
        if (!pagamento.autorizar(valor)) { return "Pagamento recusado"; }
        estoque.retirar(quantidade);
        return "Pedido confirmado";
    }
}
