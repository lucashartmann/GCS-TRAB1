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
}
