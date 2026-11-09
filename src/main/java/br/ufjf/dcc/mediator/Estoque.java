package br.ufjf.dcc.mediator;

public class Estoque {
    private int quantidade;

    public Estoque(int quantidade) { this.quantidade = quantidade; }
    public boolean disponivel(int solicitada) { return solicitada <= quantidade; }
    public void retirar(int solicitada) { quantidade -= solicitada; }
    public int getQuantidade() { return quantidade; }
}
