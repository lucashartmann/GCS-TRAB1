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
}