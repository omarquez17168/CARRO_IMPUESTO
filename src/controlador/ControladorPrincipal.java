package controlador;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.Vehiculo;
import modelo.CalculadoraImpuestos;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladorPrincipal implements Initializable {

    @FXML
    private TextField txtMarcaModelo;

    @FXML
    private ComboBox<Integer> cmbAnio;

    @FXML
    private ComboBox<Integer> cmbCilindraje;

    @FXML
    private TextField txtAvaluo;

    @FXML
    private ComboBox<String> cmbTipoUso;

    @FXML
    private Label lblResultado;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Llenar lista de años (últimos 30 años)
        for (int i = 2024; i >= 1990; i--) {
            cmbAnio.getItems().add(i);
        }

        // Llenar lista de cilindrajes comunes
        int[] cilindrajes = {1000, 1250, 1500, 1600, 1800, 2000, 2500, 3000, 3500, 4000};
        for (int cil : cilindrajes) {
            cmbCilindraje.getItems().add(cil);
        }

        // Llenar lista de tipos de uso
        cmbTipoUso.getItems().addAll("Particular", "Público");
    }

    @FXML
    private void calcularImpuesto() {
        try {
            String marcaModelo = txtMarcaModelo.getText();
            int anio = cmbAnio.getValue();
            int cilindraje = cmbCilindraje.getValue();
            double avaluo = Double.parseDouble(txtAvaluo.getText().replace(",", "").replace("'", ""));
            String tipoUso = cmbTipoUso.getValue().trim().toLowerCase();

            // Crear objeto Vehiculo
            Vehiculo vehiculo = new Vehiculo(marcaModelo, anio, cilindraje, avaluo, tipoUso);

            // Calcular impuesto
            double impuesto = CalculadoraImpuestos.calcularImpuesto(vehiculo);

            lblResultado.setText("Monto del Impuesto: $" + impuesto);
        } catch (Exception e) {
            lblResultado.setText("Seleccione valores válidos.");
            e.printStackTrace();
        }
    }

    @FXML
    private void limpiarCampos() {
        txtMarcaModelo.clear();
        cmbAnio.getSelectionModel().clearSelection();
        cmbCilindraje.getSelectionModel().clearSelection();
        txtAvaluo.clear();
        cmbTipoUso.getSelectionModel().clearSelection();
        lblResultado.setText("Monto del Impuesto: $0.0");
    }
}
