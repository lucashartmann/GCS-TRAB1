public class Item {
    private String descricao;
    private double valorUnitario;
    private int quantidade;

    public Item(String descricao, double valorUnitario, int quantidade) {
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    }

    public double calcularTotal() {
        return valorUnitario * quantidade;
    }

    @Override
    public String toString() {
        return "Item: " + descricao + ", Valor Unitário: " + valorUnitario + ", Quantidade: " + quantidade + ", Total: " + calcularTotal();
    }

    // Métodos getters 

    
}
