package especialista;

import matematica.Retangulo;

public class EngenheiroCivil {
    private static String nome = "Régis Bittencourt";
    private static int idade=2000;

    private static void exibir_dados_pessoais() {
        System.out.println(nome);
        System.out.println(idade + " anos");
    }

    public static void main(String[] args) {
        exibir_dados_pessoais();
        Retangulo.definir_lados(4.7f, 8.2f);
        System.out.println("area = " + Retangulo.area());
        System.out.println("perimetro = " + Retangulo.perimetro());
    }
}
