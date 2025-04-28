package ec.edu.ups.poo;

import java.util.ArrayList;
import java.util.List;

class Solicitud extends Documento implements Calculable {
    private static int contador = 1;
    private Usuario usuario;
    private Estado estado;
    private List<ItemSolicitud> items;

    public Solicitud(Usuario usuario, String informacion) {
        this.id = contador++;
        this.usuario = usuario;
        this.informacion = informacion;
        this.estado = Estado.SOLICITADA;
        this.items = new ArrayList<>();
    }

    @Override
    public double calcularSubTotal(ItemSolicitud item) {
        return item.getProducto().getPrecioUnidad() * item.getCantidad();
    }

    @Override
    public double calcularTotal() {
        double total = 0;
        for (ItemSolicitud item : items) {
            total += this.calcularSubTotal(item);
        }
        return total;
    }

    public void agregarItem(Producto producto, int cantidad) {
        items.add(new ItemSolicitud(producto, cantidad));
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
    public Usuario getUsuario() {
        return usuario;
    }
}