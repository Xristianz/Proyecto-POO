package ec.edu.ups.poo;

import java.util.ArrayList;
import java.util.List;

class Solicitud extends Documento implements Calculable {
    private static int contador = 1;
    private Usuario usuario;
    private Estado estado;
    private List<ItemSolicitud> items;

    private int id;

    public Solicitud(Usuario usuario, String information) {
        this.id = contador++;
        this.usuario = usuario;
        this.estado = Estado.SOLICITADA;
        this.items = new ArrayList<>();
    }

    public void agregarItem(Producto producto, int cantidad) {
        items.add(new ItemSolicitud(producto, cantidad));
    }

    @Override
    public double calculatorCostoTotal() {
        double total = 0;
        for (ItemSolicitud item : items) {
            total += item.getProducto().getPrecioUnidad() * item.getCantidad();
        }
        return total;
    }

    @Override
    public double calcularTotal() {
        return calculatorCostoTotal();
    }

    public void cambiarEstado(Estado nuevoEstado) {
        this.estado = nuevoEstado;
    }


    public int getId() {
        return id;
    }
    public Estado getEstado() {
        return estado;
    }
    public List<ItemSolicitud> getItems() {
        return items;
    }

    public static int getContador() {
        return contador;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}