package ec.edu.ups.poo;

abstract class Documento {
    protected int id;
    protected String informacion;

    public abstract double calcularTotal();

    public String getInformacion() {
        return informacion;
    }
}