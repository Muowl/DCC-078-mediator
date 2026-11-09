package br.ufjf.dcc.mediator;

public class Pagamento {
    private final double saldo;

    public Pagamento(double saldo) { this.saldo = saldo; }
    public boolean autorizar(double valor) { return valor <= saldo; }
}
