package ec.edu.ups.poo;

class Usuario extends Persona {
    private Rol rol;
    private String departamento;

    public Usuario(String cedula, String nombre, String apellido, String telefono, Rol rol, String departamento) {
        super(cedula, nombre, apellido, telefono);
        this.rol = rol;
        this.departamento = departamento;
    }

    public Rol getRol() {
        return rol;
    }
    public String getDepartamento() {
        return departamento;
    }
}

