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

    public void iniciarSistema() {
        mostrarMenuPrincipal();
    }

    private void mostrarMenuPrincipal() {
        while (true) {
            System.out.println("\n===== SISTEMA DE COMPRAS ERP =====");
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
        } }
}
