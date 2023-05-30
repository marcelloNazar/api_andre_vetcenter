package vet.center.api.domain.proprietario;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProprietarioService {

    @Autowired
    private ProprietarioRepository proprietarioRepository;

    public Page<Proprietario> getAllProprietarios(Pageable pageable) {
        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("nome").ascending());

        return proprietarioRepository.findAll(pageRequest);
    }

    public Proprietario getProprietarioById(Long id) {
        Optional<Proprietario> proprietario = proprietarioRepository.findById(id);
        if(proprietario.isPresent()) {
            return proprietario.get();
        } else {
            throw new EntityNotFoundException("Proprietario não encontrado");
        }
    }

    public Proprietario createProprietario(Proprietario proprietario) {
        return proprietarioRepository.save(proprietario);
    }

    public Proprietario updateProprietario(Long id, Proprietario proprietarioDetails) {
        Proprietario proprietario = getProprietarioById(id);
        if (proprietarioDetails.getNome() != null) {
            proprietario.setNome(proprietarioDetails.getNome());
        }
        if (proprietarioDetails.getTelefone() != null) {
            proprietario.setTelefone(proprietarioDetails.getTelefone());
        }
        if (proprietarioDetails.getCpf() != null) {
            proprietario.setCpf(proprietarioDetails.getCpf());
        }
        if (proprietarioDetails.getNascimento() != null) {
            proprietario.setNascimento(proprietarioDetails.getNascimento());
        }
        if (proprietarioDetails.getNomeMae() != null) {
            proprietario.setNomeMae(proprietarioDetails.getNomeMae());
        }
        if (proprietarioDetails.getEndereco() != null) {
            proprietario.setEndereco(proprietarioDetails.getEndereco());
        }
        return proprietarioRepository.save(proprietario);
    }

    public void deleteProprietario(Long id) {
        Proprietario proprietario = getProprietarioById(id);
        proprietarioRepository.delete(proprietario);
    }
}
