import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public void listarPedidosEntreDatas(Date dataInicial, Date dataFinal) {
        List<Pedido> pedidosEntreDatas = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            Date dataPedido = pedido.getDataPedido();
            if (dataPedido.after(dataInicial) && dataPedido.before(dataFinal)) {
                pedidosEntreDatas.add(pedido);
            } else {
                System.out.println("Nenhum pedido nesse periodo de datas");
            }
        }
        if (pedidosEntreDatas.isEmpty()) {
            System.out.println("Nenhum pedido nesse periodo de datas");
        } else {
            for (Pedido pedido : pedidosEntreDatas) {
                System.out.println(pedido.toString());
            }
        }
    }

    public void buscarPedidosPorFuncionario(Usuario funcionario) {
        List<Pedido> pedidosDoFuncionario = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getSolicitante().equals(funcionario)) {
                pedidosDoFuncionario.add(pedido);
            }
        }
        if (pedidosDoFuncionario.isEmpty()) {
            System.out.println("Nenhum pedido encontrado");
        } else {
            for (Pedido pedido : pedidosDoFuncionario) {
                System.out.println(pedido.toString());
            }
        }
    }

    public void buscarPedidosPelaDescricaoItem(String descricaoItem) {
        List<Pedido> pedidosComItem = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            for (Item item : pedido.getItens()) {
                if (item.getDescricao().contains(descricaoItem)) {
                    pedidosComItem.add(pedido);
                    break;
                }
            }
        }
        if (pedidosComItem.isEmpty()) {
            System.out.println("Nenhum pedido encontrado com a descrição do item: " + descricaoItem);
        } else {
            for (Pedido pedido : pedidosComItem) {
                System.out.println(pedido.toString());
            }
        }
    }

    public void visualizarDetalhesPedido(Usuario solicitante) {
        Pedido pedido = encontrarPedidosPorSolicitante(solicitante);
        if (pedido == null) {
            System.out.println("Pedido não encontrado.");
            return;
        }

        System.out.println("Detalhes do Pedido:");
        System.out.println(pedido);

        if (pedido.getStatus().equalsIgnoreCase("aberto")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Deseja aprovar (A) ou rejeitar (R) o pedido? ");
            String resposta = scanner.next();
            if (resposta.equalsIgnoreCase("A")) {
                pedido.setStatus("Aprovado");
                System.out.println("Pedido aprovado com sucesso!");
            } else if (resposta.equalsIgnoreCase("R")) {
                pedido.setStatus("Rejeitado");
                System.out.println("Pedido rejeitado com sucesso!");
            } else {
                System.out.println("Opção inválida.");
            }
        }
    }

}