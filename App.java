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

    private void inicializar() {
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
}