import java.util.Date;
import java.util.List;


public class Pedido {
    private Usuario solicitante;
    private Departamento departamento;
    private Date dataPedido;
    private Date dataConclusao;
    private String status;
    private List<Item> itens;
    private double valorTotal;

    public Pedido(Usuario solicitante, Departamento departamento, Date dataPedido, Date dataConclusao,
            String status, List<Item> itens, double valorTotal) {
        this.solicitante = solicitante;
        this.departamento = departamento;
        this.dataPedido = dataPedido;
        this.dataConclusao = dataConclusao;
        this.status = status;
        this.itens = itens;
        this.valorTotal = valorTotal;
    }
}
