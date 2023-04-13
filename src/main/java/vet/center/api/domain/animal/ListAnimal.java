package vet.center.api.domain.animal;


public record ListAnimal(
        Long id,
        String nome,
        String raca,
        Especie especie,
        Sexo sexo,
        String peso,
        String idade,
        String cor,
        Temperamento temperamento,
        Boolean castrado) {

    public ListAnimal(Animal animal) {
        this(
                animal.getId(),
                animal.getNome(),
                animal.getRaca(),
                animal.getEspecie(),
                animal.getSexo(),
                animal.getPeso(),
                animal.getIdade(),
                animal.getCor(),
                animal.getTemperamento(),
                animal.getCastrado());
    }


}
