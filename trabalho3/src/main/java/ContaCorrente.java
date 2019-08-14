public class ContaCorrente {
    private int numero;
    private double saldo;

    public ContaCorrente(int numero, double saldoInicial) {
        assert saldoInicial >= 0;
        this.numero = numero;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void retirar(double valor) {
        assert saldo - valor >= 0;
        this.saldo -= valor;
    }

    public void imprimir() {
        System.out.println("Número da conta: "+ numero);
        System.out.println("Saldo da conta: "+ saldo);
    }
}
