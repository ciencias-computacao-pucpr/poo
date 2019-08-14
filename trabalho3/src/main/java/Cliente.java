public class Cliente {
    private String nome;
    private ContaCorrente contaCorrente;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public void ligarConta(ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public void depositar (double valor) {
        this.contaCorrente.depositar(valor);
    }

    public void retirar(double valor) {
        this.contaCorrente.retirar(valor);
    }

    public void imprimir() {
        System.out.println("Nome: " + this.nome);
        contaCorrente.imprimir();
    }
}
