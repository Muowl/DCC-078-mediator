package br.ufjf.dcc.mediator;

public class Cliente {
    private final MediadorPedido mediador;

    public Cliente(MediadorPedido mediador) { this.mediador = mediador; }

    public String comprar(int quantidade, double valor) {
        return mediador.realizarPedido(quantidade, valor);
    }
}
