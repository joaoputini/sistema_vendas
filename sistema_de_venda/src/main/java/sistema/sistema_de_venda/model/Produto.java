package sistema.sistema_de_venda.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "produtos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "nome é obrigatorio")
    @Column(nullable = false, length = 100)
    private String nome;

    
    @NotBlank(message = "descrição é obrigatorio")
    @Column(nullable = false, length = 250)
    private String descricao;


    
    @NotNull(message = "preço é obrigatorio")
    @Positive(message = "o valor deve ser maior que zero")
    @Column(nullable = false)
    private BigDecimal preco;

    @NotNull(message = "Quantidade é obrigatorio")
    @Positive(message = "o valor deve ser maior ou igual a zero")
    @Column(nullable = false)
    private Integer quantidadeEmEstoque;

    
    
}