
//arrumar 
public class Conta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @JsonProperty(access = Access.WRITE_ONLY, value = "saldo_inicial")
    private BigDecimal saldoInicial;

    private String icone;
    
}