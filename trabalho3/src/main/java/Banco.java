public class Banco {
    public static void main(String[] args) {
        Cliente jandira = new Cliente("Jandira Silva");
        jandira.ligarConta(new ContaCorrente(84037, 2500));

        Cliente sandra = new Cliente("Sandra Rodrigues");
        sandra.ligarConta(new ContaCorrente(70662, 1800));

        Cliente luciana = new Cliente("Luciana Teixeira");
        luciana.ligarConta(new ContaCorrente(20718, 5000));

        jandira.imprimir();
        sandra.imprimir();
        luciana.imprimir();

        jandira.retirar(1000);
        jandira.imprimir();

        sandra.retirar(2000);
        sandra.depositar(500);
        sandra.imprimir();
        sandra.retirar(2000);
        sandra.imprimir();

        luciana.depositar(1000);
        luciana.imprimir();
    }
}
