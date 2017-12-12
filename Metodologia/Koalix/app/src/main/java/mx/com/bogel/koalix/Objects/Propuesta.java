package mx.com.bogel.koalix.Objects;


public class Propuesta {

    private String modelo;
    private String marca;
    private String puertas;
    private String plazas;
    private String motor;
    private String gama;

    public Propuesta(String modelo, String marca, String puertas, String plazas, String motor, String gama) {
        this.modelo = modelo;
        this.marca = marca;
        this.puertas = puertas;
        this.plazas = plazas;
        this.motor = motor;
        this.gama = gama;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getPuertas() {
        return puertas;
    }

    public String getPlazas() {
        return plazas;
    }

    public String getMotor() {
        return motor;
    }

    public String getGama() {
        return gama;
    }
}
