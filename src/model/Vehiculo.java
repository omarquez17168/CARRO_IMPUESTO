package modelo;

public class Vehiculo {
    private String marcaModelo;
    private int anio;
    private int cilindraje;
    private double avaluo;
    private String tipoUso; // "particular" o "público"

    public Vehiculo(String marcaModelo, int anio, int cilindraje, double avaluo, String tipoUso) {
        this.marcaModelo = marcaModelo;
        this.anio = anio;
        this.cilindraje = cilindraje;
        this.avaluo = avaluo;
        this.tipoUso = tipoUso.toLowerCase();
    }

    // Getters y Setters
    public String getMarcaModelo() { return marcaModelo; }
    public int getAnio() { return anio; }
    public int getCilindraje() { return cilindraje; }
    public double getAvaluo() { return avaluo; }
    public String getTipoUso() { return tipoUso; }
}
