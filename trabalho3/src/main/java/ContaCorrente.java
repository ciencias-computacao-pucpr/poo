
public class ContaCorrente {
    private int numero;
    private double saldo;

    public ContaCorrente(int numero, double saldoInicial) {
        assert saldoInicial >= 0;
        this.numero = numero;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        if (valor <= 0) throw new ValorInvalido("Valor de depósito deve ser positivo");
        this.saldo += valor;
    }

    public void retirar(double valor) {
        if (valor <= 0) throw new ValorInvalido("Valor de retirada deve ser positivo");
        if ((saldo - valor) < 0) throw new SaldoInsuficiente(saldo, valor);
        this.saldo -= valor;
    }

    public void imprimir() {
        System.out.println("Número da conta: "+ numero);
        System.out.println("Saldo da conta: "+ saldo);
    }

    public static class SaldoInsuficiente extends IllegalArgumentException {
        public SaldoInsuficiente(double saldo, double valorPedido) {
            super(String.format("Saldo insuficiente. Foi pedido %.2f, mas tem somente %.2f disponível", valorPedido, saldo));
        }
    }

    public static class ValorInvalido extends IllegalArgumentException {
        public ValorInvalido() {
            super("valor inválido");
        }

        public ValorInvalido(String s) {
            super(s);
        }
    }
}
