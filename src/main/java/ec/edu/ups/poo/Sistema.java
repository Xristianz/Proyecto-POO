package ec.edu.ups.poo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    private List<Proveedor> proveedores = new ArrayList<>();
    private List<Producto> productos = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Solicitud> solicitudes = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.iniciarSistema();
    }

    public void mostrarMenuPrincipal() {
        while (true) {
            System.out.println("\n===== SISTEMA DE COMPRA =====");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Registrar proveedor");
            System.out.println("3. Registrar producto");
            System.out.println("4. Crear solicitud");
            System.out.println("5. Listar usuarios");
            System.out.println("6. Listar proveedores");
            System.out.println("7. Listar productos");
            System.out.println("8. Listar solicitudes");
            System.out.println("9. Buscar usuario");
            System.out.println("10. Buscar proveedor");
            System.out.println("11. Buscar producto");
            System.out.println("12. Buscar solicitud");
            System.out.println("13. Cambiar estado solicitud");
            System.out.println("14. Mostrar total solicitud");
            System.out.println("15. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarUsuario();
                    break;
                case 2:
                    registrarProveedor();
                    break;
                case 3:
                    registrarProducto();
                    break;
                case 4:
                    crearSolicitud();
                    break;
                case 5:
                    listarUsuarios();
                    break;
                case 6:
                    listarProveedores();
                    break;
                case 7:
                    listarProductos();
                    break;
                case 8:
                    listarSolicitudes();
                    break;
                case 9:
                    buscarUsuario();
                    break;
                case 10:
                    buscarProveedor();
                    break;
                case 11:
                    buscarProducto();
                    break;
                case 12:
                    buscarSolicitud();
                    break;
                case 13:
                    cambiarEstadoSolicitud();
                    break;
                case 14:
                    mostrarTotalSolicitud();
                    break;
                case 15:
                    System.exit(0);
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
    public void iniciarSistema() {
        mostrarMenuPrincipal();
    }
    // METODOS DE USUSARIO
    public void registrarUsuario() {
        System.out.println("\n=== REGISTRAR USUARIO ===");
        System.out.print("Cédula: ");
        String cedula = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        System.out.println("Roles disponibles:");
        for (Rol rol : Rol.values()) {
            System.out.println("- " + rol);
        }
        System.out.print("Rol: ");
        Rol rol = Rol.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Departamento: ");
        String departamento = scanner.nextLine();

        usuarios.add(new Usuario(cedula, nombre, apellido, telefono, rol, departamento));
        System.out.println("Usuario registrado exitosamente");
    }

    public void listarUsuarios() {
        System.out.println("\n=== LISTA DE USUARIOS ===");
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.getCedula() + " - " + usuario.getNombre() +
                    " " + usuario.getApellido() + " (" + usuario.getRol() + ")");
        }
    }

    public Usuario buscarUsuario(String cedula) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCedula().equals(cedula)) {
                return usuario;
            }
        }
        return null;
    }

    public void buscarUsuario() {
        System.out.print("\nIngrese cédula: ");
        String cedula = scanner.nextLine();
        Usuario usuario = buscarUsuario(cedula);

        if (usuario != null) {
            System.out.println("Usuario encontrado:");
            System.out.println("Nombre: " + usuario.getNombre() + " " + usuario.getApellido());
            System.out.println("Rol: " + usuario.getRol());
        } else {
            System.out.println("Usuario no encontrado");
        }
    }
    public void registrarProveedor() {
        System.out.println("\n=== REGISTRAR PROVEEDOR ===");
        System.out.print("Cédula: ");
        String cedula = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        proveedores.add(new Proveedor(cedula, nombre, apellido, telefono));
        System.out.println("Proveedor registrado exitosamente");
    }
    // METODOS DE PROVEEDOR
    public void listarProveedores() {
        System.out.println("\n=== LISTA DE PROVEEDORES ===");
        for (Proveedor proveedor : proveedores) {
            System.out.println(proveedor.getCedula() + " - " + proveedor.getNombre() +
                    " " + proveedor.getApellido());
        }
    }

    public Proveedor buscarProveedor(String cedula) {
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getCedula().equals(cedula)) {
                return proveedor;
            }
        }
        return null;
    }

    public void buscarProveedor() {
        System.out.print("\nIngrese cédula: ");
        String cedula = scanner.nextLine();
        Proveedor proveedor = buscarProveedor(cedula);

        if (proveedor != null) {
            System.out.println("Proveedor encontrado:");
            System.out.println("Nombre: " + proveedor.getNombre() + " " + proveedor.getApellido());
        } else {
            System.out.println("Proveedor no encontrado");
        }
    }
    public void registrarProducto() {
        System.out.println("\n=== REGISTRAR PRODUCTO ===");
        System.out.print("ID Producto: ");
        String id = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio unitario: ");
        double precio = scanner.nextDouble();
        System.out.print("Cantidad inicial: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Seleccione proveedor:");
        listarProveedores();
        System.out.print("Cédula proveedor: ");
        Proveedor proveedor = buscarProveedor(scanner.nextLine());
        if (proveedor != null) {
            Producto producto = new Producto(id, nombre, precio, cantidad);
            proveedor.agregarProducto(producto);
            productos.add(producto);
            System.out.println("Producto registrado exitosamente");
        } else {
            System.out.println("Proveedor no encontrado");
        }
    }
    // METODOS DE PRODUCTO
    public void listarProductos() {
        System.out.println("\n=== LISTA DE PRODUCTOS ===");
        for (Producto producto : productos) {
            System.out.println(producto.getIdProducto() + " - " + producto.getNombre() +
                    " ($" + producto.getPrecioUnidad() + ")");
        }
    }

    public Producto buscarProducto(String id) {
        for (Producto producto : productos) {
            if (producto.getIdProducto().equals(id)) {
                return producto;
            }
        }
        return null;
    }

    public void buscarProducto() {
        System.out.print("\nIngrese nombre: ");
        String nombre = scanner.nextLine().toLowerCase();
        System.out.println("Resultados:");
        for (Producto producto : productos) {
            if (producto.getNombre().toLowerCase().contains(nombre)) {
                System.out.println(producto.getIdProducto() + " - " + producto.getNombre() +
                        " ($" + producto.getPrecioUnidad() + ")");
            }
        }
    }
    public void crearSolicitud() {
        System.out.println("\n=== CREAR SOLICITUD ===");
        if (usuarios.isEmpty() || productos.isEmpty()) {
            System.out.println("Primero registre usuarios y productos");
            return;
        }

        System.out.print("Cédula usuario: ");
        Usuario usuario = buscarUsuario(scanner.nextLine());

        if (usuario == null) {
            System.out.println("Usuario no encontrado");
            return;
        }

        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();

        Solicitud solicitud = new Solicitud(usuario, descripcion);
        boolean agregando = true;

        while (agregando) {
            System.out.println("\nProductos disponibles:");
            listarProductos();
            System.out.print("ID Producto (o 'fin' para terminar): ");
            String idProducto = scanner.nextLine();

            if (idProducto.equalsIgnoreCase("fin")) {
                agregando = false;
            } else {
                Producto producto = buscarProducto(idProducto);
                if (producto != null) {
                    System.out.print("Cantidad: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine();
                    solicitud.agregarItem(producto, cantidad);
                    System.out.println("Producto agregado. Subtotal: $" +
                            (producto.getPrecioUnidad() * cantidad));
                } else {
                    System.out.println("Producto no encontrado");
                }
            }
        }

        if (!solicitud.getItems().isEmpty()) {
            solicitudes.add(solicitud);
            System.out.println("Solicitud #" + solicitud.getId() + " creada");
        } else {
            System.out.println("No se creó la solicitud (sin productos)");
        }
    }
    //METODOS DE SOLICITUDES
    public void listarSolicitudes() {
        System.out.println("\n=== LISTA DE SOLICITUDES ===");
        for (Solicitud solicitud : solicitudes) {
            System.out.println("\nSolicitud #" + solicitud.getId());
            System.out.println("Usuario: " + solicitud.getUsuario().getNombre());
            System.out.println("Estado: " + solicitud.getEstado());
            System.out.println("Productos:");
            for (ItemSolicitud item : solicitud.getItems()) {
                System.out.printf("-Subtotal: \n",
                        item.getProducto().getNombre(),
                        item.getCantidad(),
                        item.getProducto().getPrecioUnidad(),
                        (item.getProducto().getPrecioUnidad() * item.getCantidad()));
            }
        }
    }

    public Solicitud buscarSolicitud(int id) {
        for (Solicitud solicitud : solicitudes) {
            if (solicitud.getId() == id) {
                return solicitud;
            }
        }
        return null;
    }

    public void buscarSolicitud() {
        System.out.print("\nNúmero de solicitud: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Solicitud solicitud = buscarSolicitud(id);
        if (solicitud != null) {
            System.out.println("\nSolicitud #" + solicitud.getId());
            System.out.println("Descripción: " + solicitud.getInformacion());
            System.out.println("Estado: " + solicitud.getEstado());
            System.out.println("Productos:");
            for (ItemSolicitud item : solicitud.getItems()) {
                System.out.println("- " + item.getProducto().getNombre() +
                        " x" + item.getCantidad() +
                        " ($" + item.getProducto().getPrecioUnidad() + ")");
            }
        } else {
            System.out.println("Solicitud no encontrada");
        }
    }

    public void cambiarEstadoSolicitud() {
        System.out.print("\nNúmero de solicitud: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Solicitud solicitud = buscarSolicitud(id);
        if (solicitud == null) {
            System.out.println("Solicitud no encontrada");
            return;
        }

        System.out.println("1. Aprobar");
        System.out.println("2. Rechazar");
        System.out.println("3. Poner en revisión");
        System.out.print("Seleccione opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1: solicitud.cambiarEstado(Estado.APROBADA); break;
            case 2: solicitud.cambiarEstado(Estado.RECHAZADA); break;
            case 3: solicitud.cambiarEstado(Estado.ENREVISION); break;
            default: System.out.println("Opción no válida");
        }
        System.out.println("Estado actualizado: " + solicitud.getEstado());
    }
    public void mostrarTotalSolicitud() {
        System.out.print("\nNúmero de solicitud: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Solicitud solicitud = buscarSolicitud(id);
        if (solicitud != null) {
            System.out.printf("Total de la solicitud\n", id, solicitud.calcularTotal());
        } else {
            System.out.println("Solicitud no encontrada");
        }
    }
}
