package controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControladorPrincipal {

    @FXML
    private TextField txtMarcaModelo;

    @FXML
    private TextField txtAnio;

    @FXML
    private TextField txtCilindraje;

    @FXML
    private TextField txtAvaluo;

    @FXML
    private TextField txtTipoVehiculo;

    @FXML
    private Label lblResultado;

    @FXML
    private void calcularImpuesto() {
        try {
            // 📌 Limpiar formato del avalúo (quitar comas y apóstrofes)
            double avaluo = Double.parseDouble(txtAvaluo.getText().replace(",", "").replace("'", ""));
            int cilindraje = Integer.parseInt(txtCilindraje.getText());
            String tipoVehiculo = txtTipoVehiculo.getText().trim().toLowerCase();

            // 🚀 Depuración - Mostrar valores ingresados en la consola
            System.out.println("Avalúo: " + avaluo);
            System.out.println("Cilindraje: " + cilindraje);
            System.out.println("Tipo de Vehículo: " + tipoVehiculo);

            // 🔥 Calcular el impuesto
            double impuesto = calcularMontoImpuesto(avaluo, cilindraje, tipoVehiculo);

            System.out.println("Impuesto Calculado: $" + impuesto); // 🛠 Verificar cálculo

            lblResultado.setText("Monto del Impuesto: $" + impuesto);
        } catch (NumberFormatException e) {
            lblResultado.setText("Entrada inválida. Ingrese los datos correctamente.");
            e.printStackTrace();
        }
    }

    private double calcularMontoImpuesto(double avaluo, int cilindraje, String tipoVehiculo) {
        double tasaImpuesto = 0.0;

        // 🚗 Vehículos particulares
        if (tipoVehiculo.equals("particular") || tipoVehiculo.equals("privado")) {
            if (avaluo <= 54057000) {
                tasaImpuesto = 0.015;  // 1.5%
            } else if (avaluo <= 121625000) {
                tasaImpuesto = 0.025;  // 2.5%
            } else {
                tasaImpuesto = 0.035;  // 3.5%
            }
        }
        // 🏍️ Motocicletas de más de 125 cm³
        else if (tipoVehiculo.equals("moto") && cilindraje > 125) {
            tasaImpuesto = 0.015; // 1.5% para motos de más de 125 cm³
        }
        // 🚕 Vehículos públicos
        else if (tipoVehiculo.equals("publico") || tipoVehiculo.equals("público")) {
            tasaImpuesto = 0.015; // 1.5% para vehículos públicos
        }
        // ❌ Si el tipo de vehículo no es válido, devolver 0
        else {
            return 0;
        }

        // 💰 Calcular el impuesto
        double montoImpuesto = avaluo * tasaImpuesto;
        return Math.round(montoImpuesto * 100.0) / 100.0;
    }

    @FXML
    private void limpiarCampos() {
        txtMarcaModelo.clear();
        txtAnio.clear();
        txtCilindraje.clear();
        txtAvaluo.clear();
        txtTipoVehiculo.clear();
        lblResultado.setText("Monto del Impuesto: $0.0");
    }
}
