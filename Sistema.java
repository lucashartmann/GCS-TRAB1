import java.util.List;

public class Sistema {
    private List<Usuario> usuarios;
    private List<Pedido> pedidos;
    private List<Departamento> departamentos;

    public Sistema() {
        this.departamentos = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}