package vet.center.api.anamnese;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vet.center.api.domain.animal.Animal;
import vet.center.api.domain.animal.AnimalRepository;
import vet.center.api.domain.animal.AnimalService;
import vet.center.api.domain.veterinario.Veterinario;
import vet.center.api.domain.veterinario.VeterinarioRepository;
import vet.center.api.domain.veterinario.VeterinarioService;

@Service
public class AnamneseService {
    @Autowired
    private AnamneseRepository anamneseRepository;
    @Autowired
    private VeterinarioService veterinarioService;
    @Autowired
    private AnimalService animalService;

    public Anamnese createAnamnese(AnamneseDTO anamneseDTO) {
        Anamnese anamnese = new Anamnese();

        anamnese.setVeterinario(veterinarioService.getVeterinarioById(anamneseDTO.getVeterinarioId()));
        anamnese.setAnimal(animalService.getAnimalById(anamneseDTO.getAnimalId()));

        BeanUtils.copyProperties(anamneseDTO, anamnese, "veterinarioId", "animalId");

        return anamneseRepository.save(anamnese);
    }

    public Anamnese updateAnamnese(Long id, AnamneseDTO anamneseDTO) {
        Anamnese anamnese = getAnamneseById(id);

        anamnese.setVeterinario(veterinarioService.getVeterinarioById(anamneseDTO.getVeterinarioId()));
        anamnese.setAnimal(animalService.getAnimalById(anamneseDTO.getAnimalId()));

        BeanUtils.copyProperties(anamneseDTO, anamnese, "veterinarioId", "animalId");

        return anamneseRepository.save(anamnese);
    }

    public Page<Anamnese> getAllAnamneses(Pageable pageable) {return anamneseRepository.findAll(pageable);}

    public Anamnese getAnamneseById(Long id) {
        return anamneseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Anamnese não encontrada"));
    }

    public void deleteAnamnese(Long id) {anamneseRepository.delete(getAnamneseById(id));}
}
