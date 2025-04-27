package ec.edu.ups.poo;

class ItemSolicitud {
    private Producto producto;
    private int cantidad;

    public ItemSolicitud(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }
    public int getCantidad() {
        return cantidad;
    }
}
