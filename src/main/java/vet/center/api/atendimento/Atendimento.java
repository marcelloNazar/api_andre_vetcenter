package vet.center.api.atendimento;

import jakarta.persistence.*;
import lombok.*;
import vet.center.api.domain.animal.Animal;
import vet.center.api.domain.produto.Produto;
import vet.center.api.domain.proprietario.Proprietario;
import vet.center.api.domain.servico.Servico;
import vet.center.api.domain.veterinario.Veterinario;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "atendimentos")
@Entity(name = "Atendimento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "veterinario_id", nullable = false)
    private Veterinario veterinario;

    @ManyToOne
    @JoinColumn(name = "proprietario_id", nullable = false)
    private Proprietario proprietario;

    @ManyToOne
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;

    @ManyToMany
    @JoinTable(
            name = "atendimento_produto",
            joinColumns = @JoinColumn(name = "atendimento_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private List<Produto> produtos = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "atendimento_servico",
            joinColumns = @JoinColumn(name = "atendimento_id"),
            inverseJoinColumns = @JoinColumn(name = "servico_id"))
    private List<Servico> servicos = new ArrayList<>();



    public Atendimento(Veterinario veterinario, Proprietario proprietario, Animal animal, List<Produto> produtos, List<Servico> servicos) {
        this.veterinario = veterinario;
        this.proprietario = proprietario;
        this.animal = animal;
        this.produtos = produtos;
        this.servicos = servicos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }
}
