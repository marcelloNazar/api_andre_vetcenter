package vet.center.api.domain.veterinario;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vet.center.api.domain.endereco.Endereco;

@Service
public class VeterinarioService {
    @Autowired
    private VeterinarioRepository veterinarioRepository;

    public Veterinario createVeterinario(Veterinario veterinario) {
        return veterinarioRepository.save(veterinario);
    }

    public Veterinario updateVeterinario(Long id, Veterinario veterinarioDetails) {
        Veterinario veterinario = getVeterinarioById(id);

        if (veterinarioDetails.getNome() != null) {
            veterinario.setNome(veterinarioDetails.getNome());
        }
        if (veterinarioDetails.getEmail() != null) {
            veterinario.setEmail(veterinarioDetails.getEmail());
        }
        if (veterinarioDetails.getTelefone() != null) {
            veterinario.setTelefone(veterinarioDetails.getTelefone());
        }
        if (veterinarioDetails.getCrv() != null) {
            veterinario.setCrv(veterinarioDetails.getCrv());
        }
        if (veterinarioDetails.getEspecialidade() != null) {
            veterinario.setEspecialidade(veterinarioDetails.getEspecialidade());
        }
        if (veterinarioDetails.getEndereco() != null) {
            Endereco enderecoDetails = veterinarioDetails.getEndereco();
            Endereco endereco = veterinario.getEndereco();

            if (endereco == null) {
                veterinario.setEndereco(enderecoDetails);
            } else {
                if (enderecoDetails.getRua() != null) {
                    endereco.setRua(enderecoDetails.getRua());
                }
                if (enderecoDetails.getNumero() != null) {
                    endereco.setNumero(enderecoDetails.getNumero());
                }
                if (enderecoDetails.getCidade() != null) {
                    endereco.setCidade(enderecoDetails.getCidade());
                }
                if (enderecoDetails.getUf() != null) {
                    endereco.setUf(enderecoDetails.getUf());
                }
                if (enderecoDetails.getCep() != null) {
                    endereco.setCep(enderecoDetails.getCep());
                }
                if (enderecoDetails.getBairro() != null) {
                    endereco.setBairro(enderecoDetails.getBairro());
                }
                if (enderecoDetails.getComplemento() != null) {
                    endereco.setComplemento(enderecoDetails.getComplemento());
                }
            }
        }

        return veterinarioRepository.save(veterinario);
    }

    public Page<Veterinario> getAllVeterinarios(Pageable pageable) {
        return veterinarioRepository.findAll(pageable);
    }

    public Veterinario getVeterinarioById(Long id) {
        return veterinarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Veterinario não encontrado"));
    }

    public void deleteVeterinario(Long id) {veterinarioRepository.delete(getVeterinarioById(id));}
}
