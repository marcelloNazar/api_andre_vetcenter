package vet.center.api.domain.animal;

public record DadosDetalhadosAnimal(Long id, String nome, Especie especie, String raca, Sexo sexo, String peso, String idade, String cor, Temperamento temperamento, Boolean castrado, Long proprietarioId) {

    public DadosDetalhadosAnimal(Animal animal) {
        this(animal.getId(), animal.getNome(), animal.getEspecie(), animal.getRaca(), animal.getSexo(), animal.getPeso(), animal.getIdade(), animal.getCor(), animal.getTemperamento(), animal.getCastrado(), animal.getProprietario().getId());
    }

}
