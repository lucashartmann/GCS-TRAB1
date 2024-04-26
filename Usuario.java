public class Usuario {
private int id;
private String nome;

private Boolean tipo;

    public Usuario(int id, String nome, Boolean tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Boolean getTipo() {
        return tipo;
    }
}
