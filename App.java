import java.util.List;
import java.util.Scanner;

public class App {

    Sistema sistema = new Sistema();;
    Usuario usuarioAtual;
    Scanner scanner = new Scanner(System.in);

    public void executar() {
        inicializar();
        selecionarUsuarioAtual();
        menu();
    }

    public void inicializar() {
        Departamento Financeiro = new Departamento("Financeiro", 1000.0);
        Departamento RH = new Departamento("RH", 1500.0);
        Departamento Engenharia = new Departamento("Engenharia", 2000.0);
        Departamento Manutencao = new Departamento("Manutenção", 1200.0);
        Departamento TI = new Departamento("TI", 1800.0);
        sistema.adicionarDepartamento(TI);
        sistema.adicionarDepartamento(RH);
        sistema.adicionarDepartamento(Financeiro);
        sistema.adicionarDepartamento(Engenharia);
        sistema.adicionarDepartamento(Manutencao);
        Usuario Alice = new Usuario(1, "Alice", false, Financeiro);
        Usuario Bob = new Usuario(2, "Bob", false, TI);
        Usuario Carol = new Usuario(3, "Carol", true, Manutencao);
        sistema.adicionarUsuario(Alice);
        sistema.adicionarUsuario(Bob);
        sistema.adicionarUsuario(Carol);
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\n----- Menu -----");
            System.out.println("1 -- Registrar um novo pedido de aquisição");
            System.out.println("2 -- Avaliar um pedido que esteja aberto para aprová-lo ou rejeitá-lo");
            System.out.println("3 -- Listar todos os pedidos entre duas datas");
            System.out.println("4 -- Buscar pedidos por funcionário solicitante");
            System.out.println("5 -- Buscar pedidos pela descrição de um item");
            System.out.println("6 -- Visualizar os detalhes de um pedido para aprová-lo ou rejeitá-lo");
            System.out.println("7 -- Estatísticas Gerais");
            System.out.println("8 -- Trocar o usuário atual");
            System.out.println("9 -- Criar um usuário");
            System.out.println("10 -- Criar um departamento");
            System.out.println("0 -- Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    registrarNovoPedido();
                    break;
                case 2:
                    avaliarPedido();
                    break;
                case 3:
                    listarPedidosEntreDatas();
                    break;
                case 4:
                    buscarPedidosPorFuncionario();
                    break;
                case 5:
                    buscarPedidosPelaDescricaoItem();
                    break;
                case 6:
                    visualizarDetalhesPedido();
                    break;
                case 7:
                    exibirEstatisticasGerais();
                    break;
                case 8:
                    selecionarUsuarioAtual();
                    break;
                case 9:
                    criarNovoUsuario();
                    break;
                case 10:
                    criarNovoDepartamento();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (opcao != 0);
        scanner.close();
    }

    public void criarNovoDepartamento() {
        System.out.println("Criar Novo Departamento:");
        System.out.print("Nome do Departamento: ");
        String nome = scanner.nextLine();
        if (sistema.encontrarDepartamentoPorNome(nome) != null) {
            System.out.println("Departamento já existe.");
            return;
        }
        System.out.print("Valor Máximo Permitido por Pedido: ");
        double valorMaximo = scanner.nextDouble();
        Departamento novoDepartamento = new Departamento(nome, valorMaximo);
        sistema.adicionarDepartamento(novoDepartamento);
        System.out.println("Departamento criado com sucesso!");
    }

    public void criarNovoUsuario() {
        System.out.println("Criar Novo Usuário:");
        System.out.print("Identificador: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Tipo (funcionário ou administrador): ");
        String tipoString = scanner.nextLine();
        boolean isAdmin = tipoString.equalsIgnoreCase("administrador");
        System.out.print("Departamento: ");
        String nomeDepartamento = scanner.nextLine();
        Departamento departamento = sistema.encontrarDepartamentoPorNome(nomeDepartamento);
        if (departamento == null) {
            System.out.println("Departamento não encontrado.");
            return;
        }
        Usuario novoUsuario = new Usuario(id, nome, isAdmin, departamento);
        sistema.adicionarUsuario(novoUsuario);
        System.out.println("Usuário criado com sucesso!");
    }

    public void selecionarUsuarioAtual() {
        System.out.println("Usuários Disponíveis:");
        List<Usuario> usuarios = sistema.getUsuarios();
        for (Usuario usuario : usuarios) {
            System.out.println("Id: " + usuario.getId() + ", " + usuario.getNome());
        }
        System.out.print("Escolha o usuário digitando o Id: ");
        int userId = scanner.nextInt();
        Usuario novoUsuario = sistema.encontrarUsuarioPorId(userId);
        if (novoUsuario == null) {
            System.out.println("Usuário não encontrado.");
            System.exit(userId);
        } else {
            usuarioAtual = novoUsuario;
            System.out.println("Usuário atual alterado para: " + usuarioAtual.getNome());
        }
    }
}