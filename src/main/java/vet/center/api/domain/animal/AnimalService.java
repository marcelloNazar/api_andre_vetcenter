package vet.center.api.domain.animal;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vet.center.api.domain.proprietario.Proprietario;
import vet.center.api.domain.proprietario.ProprietarioService;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private ProprietarioService proprietarioService;

    public Animal createAnimal(AnimalDTO animalDTO) {
        Animal animal = new Animal();

        animal.setProprietario(proprietarioService.getProprietarioById(animalDTO.getProprietarioId()));

        BeanUtils.copyProperties(animalDTO, animal, "prorietarioId");

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
            Proprietario proprietario = proprietarioService.getProprietarioById(animalDetails.getProprietarioId());
            animal.setProprietario(proprietario);
        }
        return animalRepository.save(animal);
    }

    public Page<Animal> getAllAnimals(Pageable pageable) {return animalRepository.findAll(pageable);}

    public Animal getAnimalById(Long id) {
        return animalRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Animal não encontrado"));
    }

    public void deleteAnimal(Long id) {
        animalRepository.delete(getAnimalById(id));
    }

    public List<Animal> getAnimalsByProprietarioId(Long proprietarioId) {
        return animalRepository.findByProprietarioId(proprietarioId);
    }

}
