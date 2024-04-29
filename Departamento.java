public class Departamento {

    private String nome;
    private int valorMaximo;

    public Departamento(String nome, int valorMaximo) {
        this.nome = nome;
        this.valorMaximo = valorMaximo;
    }

    public String getNome() {
        return nome;
    }

    public int getValorMaximo() {
        return valorMaximo;
    }
}