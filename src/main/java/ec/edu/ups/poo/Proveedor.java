package ec.edu.ups.poo;

import java.util.ArrayList;
import java.util.List;

class Proveedor extends Persona {
    private List<Producto> productos;

    public Proveedor(String cedula, String nombre, String apellido, String telefono) {
        super(cedula, nombre, apellido, telefono);
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> getProductos() {
        return productos;
    }
}

