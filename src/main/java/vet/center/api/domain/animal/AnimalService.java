package vet.center.api.domain.animal;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vet.center.api.domain.proprietario.Proprietario;
import vet.center.api.domain.proprietario.ProprietarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private ProprietarioRepository proprietarioRepository;

    public Page<Animal> getAllAnimals(Pageable pageable) {
        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("nome").ascending());
        Page<Animal> animals = animalRepository.findAll(pageRequest);
        animals.getContent().forEach(t -> t.getProprietario().getNome());
        return animals;
    }

    public Animal getAnimalById(Long id) {
        Optional<Animal> animalOpt = animalRepository.findById(id);
        if(animalOpt.isPresent()) {
            Animal animal = animalOpt.get();
            animal.getProprietario().getNome();
            return animal;
        } else {
            throw new EntityNotFoundException("Animal não encontrado");
        }
    }

    public Animal createAnimal(AnimalDTO animalDTO) {
        Proprietario proprietario = proprietarioRepository.findById(animalDTO.getProprietarioId())
                .orElseThrow(() -> new EntityNotFoundException("Proprietario não encontrado"));
        Animal animal = new Animal();
        animal.setProprietario(proprietario);
        animal.setNome(animalDTO.getNome());
        animal.setEspecie(animalDTO.getEspecie());
        animal.setRaca(animalDTO.getRaca());
        animal.setSexo(animalDTO.getSexo());
        animal.setPeso(animalDTO.getPeso());
        animal.setIdade(animalDTO.getIdade());
        animal.setCor(animalDTO.getCor());
        animal.setTemperamento(animalDTO.getTemperamento());
        animal.setCastrado(animalDTO.getCastrado());
        return animalRepository.save(animal);
    }

    public Animal updateAnimal(Long id, AnimalDTO animalDetails) {
        Animal animal = getAnimalById(id);

        if (animalDetails.getNome() != null) {
            animal.setNome(animalDetails.getNome());
        }
        if (animalDetails.getEspecie() != null) {
            animal.setEspecie(animalDetails.getEspecie());
        }
        if (animalDetails.getRaca() != null) {
            animal.setRaca(animalDetails.getRaca());
        }
        if (animalDetails.getSexo() != null) {
            animal.setSexo(animalDetails.getSexo());
        }
        if (animalDetails.getPeso() != null) {
            animal.setPeso(animalDetails.getPeso());
        }
        if (animalDetails.getIdade() != null) {
            animal.setIdade(animalDetails.getIdade());
        }
        if (animalDetails.getCor() != null) {
            animal.setCor(animalDetails.getCor());
        }
        if (animalDetails.getTemperamento() != null) {
            animal.setTemperamento(animalDetails.getTemperamento());
        }
        if (animalDetails.getCastrado() != null) {
            animal.setCastrado(animalDetails.getCastrado());
        }
        if (animalDetails.getProprietarioId() != null) {
            Proprietario proprietario = proprietarioRepository.findById(animalDetails.getProprietarioId())
                    .orElseThrow(() -> new EntityNotFoundException("Proprietario não encontrado"));
            animal.setProprietario(proprietario);
        }
        return animalRepository.save(animal);
    }

    public void deleteAnimal(Long id) {
        Animal animal = getAnimalById(id);
        animalRepository.delete(animal);
    }

    public List<Animal> getAnimalsByProprietarioId(Long proprietarioId) {
        return animalRepository.findByProprietarioId(proprietarioId);
    }

}
