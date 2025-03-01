package modelo;

public class CalculadoraImpuestos {
    public static double calcularImpuesto(Vehiculo vehiculo) {
        double tasa = 0.0;

        // 🚗 Vehículos particulares
        if (vehiculo.getTipoUso().equals("particular")) {
            if (vehiculo.getAvaluo() <= 54057000) {
                tasa = 0.015;
            } else if (vehiculo.getAvaluo() <= 121625000) {
                tasa = 0.025;
            } else {
                tasa = 0.035;
            }
        }
        // 🚕 Vehículos públicos
        else if (vehiculo.getTipoUso().equals("público")) {
            tasa = 0.015;
        }
        // ❌ Si no es un tipo válido, devuelve 0
        else {
            return 0;
        }

        double impuesto = vehiculo.getAvaluo() * tasa;
        return Math.round(impuesto * 100.0) / 100.0;
    }
}
