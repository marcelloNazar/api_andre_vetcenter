package vet.center.api.domain.proprietario;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vet.center.api.domain.endereco.Endereco;

import java.util.List;
import java.util.Optional;

@Service
public class ProprietarioService {
    @Autowired
    private ProprietarioRepository proprietarioRepository;

    public Proprietario createProprietario(Proprietario proprietario) {return proprietarioRepository.save(proprietario);}

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
            Endereco enderecoDetails = proprietarioDetails.getEndereco();
            Endereco endereco = proprietario.getEndereco();

            if (endereco == null) {
                proprietario.setEndereco(enderecoDetails);
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
        return proprietarioRepository.save(proprietario);
    }

    public Page<Proprietario> getAllProprietarios(Pageable pageable) {return proprietarioRepository.findAll(pageable);}

    public Proprietario getProprietarioById(Long id) {
        return proprietarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Proprietario não encontrado"));
    }

    public void deleteProprietario(Long id) {proprietarioRepository.delete(getProprietarioById(id));}
}
