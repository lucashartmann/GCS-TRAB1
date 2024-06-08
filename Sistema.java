import java.util.ArrayList;
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

    public void adicionarDepartamento(Departamento departamento) {
        departamentos.add(departamento);
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public Usuario encontrarUsuarioPorId(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    public Departamento encontrarDepartamentoPorNome(String nomeDepartamento) {
        for (Departamento departamento : departamentos) {
            if (departamento.getNome().equalsIgnoreCase(nomeDepartamento)) {
                return departamento;
            }
        }
        return null;
    }

    public Pedido encontrarPedidosPorSolicitante(Usuario solicitante) {
        for (Pedido pedido : pedidos) {
            if (pedido.getSolicitante().equals(solicitante)) {
                return pedido;
            }
        }
        return null;
    }

}