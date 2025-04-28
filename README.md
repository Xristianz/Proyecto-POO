# Proyecto POO Sistema de Compras
**Cristian Moscoso**
---

## Índice

1. [Descripción General](#descripción-general)  
2. [Clases y Métodos](#clases-y-métodos)  
3. [Enums](#enums)  
---

## Descripción General

Este proyecto implementa un **Sistema básico de compras** que corre en consola. Permite:

- **Registrar** usuarios (con diferentes roles), proveedores y productos.  
- **Listar** y **buscar** esas entidades mediante identificadores o atributos.  
- **Crear solicitudes de compra** asociando un usuario con productos y cantidades.  
- **Cambiar el estado** de una solicitud (pendiente, aprobada, rechazada, en revisión).  
- **Calcular el total** de cada solicitud.

---

## Clases y Métodos

### SistemaComprasERP

Clase central que orquesta la aplicación y contiene el flujo de interacción.

- **Atributos**  
  - `List<Proveedor> proveedores`  
  - `List<Producto> productos`  
  - `List<Usuario> usuarios`  
  - `List<Solicitud> solicitudes`  
  - `Scanner scanner` – para lectura de consola.

- **`main(String[] args)`**  
  Punto de entrada: crea una instancia y llama a `iniciarSistema()`.

- **`iniciarSistema()`**  
  Lanza el bucle principal con el menú de opciones.

- **`mostrarMenuPrincipal()`**  
  Bucle que muestra opciones numeradas (1–15), lee la elección y llama al método correspondiente.

- **Registro y listado**  
  - `registrarUsuario()`: solicita datos (cédula, nombre, apellido, teléfono, rol, departamento) y añade un `Usuario`.  
  - `listarUsuarios()`: imprime cédula, nombre completo y rol para cada usuario.  
  - `registrarProveedor()`, `listarProveedores()`: análogo para `Proveedor`.  
  - `registrarProducto()`: pide id, nombre, precio y cantidad; asocia producto a un proveedor y lo añade al sistema.  
  - `listarProductos()`: muestra id, nombre y precio unitario.

- **Búsqueda**  
  - `buscarUsuario(String cedula)`: recorre la lista y devuelve el usuario o `null`.  
  - `buscarUsuario()`: lee cédula, llama al anterior y muestra el resultado.  
  - Métodos equivalentes: `buscarProveedor(String)`, `buscarProveedor()`, `buscarProducto(String)`, `buscarProducto()` (búsqueda por nombre parcial).

- **Gestión de Solicitudes**  
  - `crearSolicitud()`: valida usuarios y productos existentes; lee cédula de usuario y descripción; crea `Solicitud`; en bucle agrega productos y cantidades; guarda la solicitud.  
  - `listarSolicitudes()`: imprime id, usuario, estado y detalla cada `ItemSolicitud` (nombre, cantidad, precio, subtotal).  
  - `buscarSolicitud(int id)`: devuelve la solicitud o `null`.  
  - `buscarSolicitud()`: lee id y muestra detalle.  
  - `cambiarEstadoSolicitud()`: lee id, solicita acción (aprobar, rechazar, revisión) y actualiza el estado.  
  - `mostrarTotalSolicitud()`: lee id, calcula e imprime el total con dos decimales.

---

### Usuario

Modelo de un usuario del sistema.

- **Atributos**: `String cedula, nombre, apellido, telefono`; `Rol rol`; `String departamento`.  
- **Constructor**: inicializa todos los atributos.  
- **Getters**: `getCedula()`, `getNombre()`, `getApellido()`, `getTelefono()`, `getRol()`, `getDepartamento()`.

---

### Proveedor

Representa un proveedor.

- **Atributos**: `String cedula, nombre, apellido, telefono`; `List<Producto> catalogo`.  
- **Constructor**: recibe datos básicos.  
- **Método**: `agregarProducto(Producto p)` – añade al catálogo.  
- **Getters**: `getCedula()`, `getNombre()`, `getApellido()`, `getTelefono()`, `getCatalogo()`.

---

### Producto

Define un artículo disponible para compra.

- **Atributos**: `String idProducto, nombre`; `double precioUnidad`; `int cantidad`.  
- **Constructor**: inicializa todos los campos.  
- **Getters**: `getIdProducto()`, `getNombre()`, `getPrecioUnidad()`, `getCantidad()`.

---

### Solicitud

Agrupa items solicitados por un usuario.

- **Atributos**:  
  - `static int contador` – genera IDs únicos.  
  - `int id`; `Usuario usuario`; `String informacion`;  
  - `Estado estado` (por defecto PENDIENTE);  
  - `List<ItemSolicitud> items`.  
- **Constructor**: asigna ID, usuario e información.

- **Métodos**:  
  - `agregarItem(Producto p, int cantidad)`: crea y añade un `ItemSolicitud`.  
  - `calcularTotal()`: suma `precioUnidad × cantidad` de todos los items.  
  - `cambiarEstado(Estado e)`: modifica el estado.  
  - Getters: `getId()`, `getUsuario()`, `getInformacion()`, `getEstado()`, `getItems()`.

---

### ItemSolicitud

Elemento simple que relaciona producto y cantidad.

- **Atributos**: `Producto producto`; `int cantidad`.  
- **Constructor**: recibe producto y cantidad.  
- **Getters**: `getProducto()`, `getCantidad()`.

---

## Enums

### Rol

Define roles de usuario:

```java
public enum Rol {
    ADMIN,
    EMPLEADO
}
```
### Estado

Define los posibles estados de una solicitud:

```java
public enum Estado {
    PENDIENTE,
    APROBADA,
    RECHAZADA,
    ENREVISION
}
