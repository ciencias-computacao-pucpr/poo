package matematica;

public class Retangulo {
    private static float ladoH;
    private static float ladoV;


    public static void definir_lados(float ladoH, float ladoV) {
        assert (ladoH > 0 && ladoV > 0);
        Retangulo.ladoH = ladoH;
        Retangulo.ladoV = ladoV;
    }

    public static float area() {
        return ladoH*ladoV;
    }

    public static float perimetro() {
        return 2*(ladoV+ladoH);
    }
}
