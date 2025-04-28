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


}
