package br.com.aweb.sistema_vendas.model;

import org.hibernate.validator.constraints.br.CPF;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size; // Importe o @Size
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // --- Dados Pessoais ---
    @NotBlank(message = "Nome é obrigatório")
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Formato de email inválido") 
    @Column(nullable = false, length = 255, unique = true)
    private String email;

    @NotBlank(message = "CPF é obrigatório.")
    @CPF(message = "CPF inválido") 
    @Column(nullable = false, length = 14, unique = true) 
    private String cpf;

    @NotBlank(message = "Telefone é obrigatório.")
    @Column(nullable = false, length = 20) 
    private String telefone;


    @NotBlank(message = "CEP é obrigatório.")
    @Size(max = 9, message = "O CEP deve ter no máximo 9 caracteres.") 
    @Column(nullable = false, length = 9)
    private String cep;
    
    @NotBlank(message = "Logradouro é obrigatório.")
    @Column(nullable = false, length = 255)
    private String logradouro;

    @Column(length = 50) 
    private String numero;

    @Column(length = 100) 
    private String complemento;

    @NotBlank(message = "Bairro é obrigatório.")
    @Column(nullable = false, length = 100)
    private String bairro;

    @NotBlank(message = "Cidade é obrigatória.")
    @Column(nullable = false, length = 100)
    private String cidade;

    @NotBlank(message = "UF é obrigatório.")
    @Size(min = 2, max = 2, message = "UF deve ter 2 caracteres.")
    @Column(nullable = false, length = 2)
    private String uf;
}