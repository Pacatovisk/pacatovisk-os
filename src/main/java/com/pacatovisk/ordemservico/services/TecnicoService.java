package com.pacatovisk.ordemservico.services;

import com.pacatovisk.ordemservico.domain.Pessoa;
import com.pacatovisk.ordemservico.domain.Tecnico;
import com.pacatovisk.ordemservico.dtos.TecnicoDto;
import com.pacatovisk.ordemservico.repositories.PessoaRepository;
import com.pacatovisk.ordemservico.repositories.TecnicoCustomRepository;
import com.pacatovisk.ordemservico.repositories.TecnicoRepository;
import com.pacatovisk.ordemservico.services.exceptions.DataIntegrityViolationException;
import com.pacatovisk.ordemservico.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private TecnicoCustomRepository tecnicCustomRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Tecnico findById(Integer id){
        Optional<Tecnico> obj = tecnicoRepository.findById(id);
      return obj.orElseThrow(() -> new ObjectNotFoundException(
              "Objeto não encontrado! Id: " + id + ", Tipo: " + Tecnico.class.getName()));
    }

    public Tecnico filter(Integer id, String nome, String cpf){
        Optional<Tecnico> obj = tecnicCustomRepository.find(id, nome, cpf);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Técnico não encontrado! Id: " + id + ", Nome: " + nome + "Cpf: " + cpf));
    }

    public Tecnico findByCpff(String cpf){
        Optional<Tecnico> obj = Optional.ofNullable(tecnicoRepository.findByCPF(cpf));
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Cpf: " + cpf ));
    }

    public List<Tecnico> findAll() {
       return tecnicoRepository.findAll();
    }

    public Tecnico create(TecnicoDto objDto){
        if(findByCPF(objDto) != null) {
            throw new DataIntegrityViolationException("CPF já cadastrado na base de dados!");
        }
        return tecnicoRepository.save(new Tecnico(null, objDto.getNome(), objDto.getCpf(), objDto.getTelefone()));
    }

    public Pessoa findByCPF(TecnicoDto objDto) {
        Pessoa obj = pessoaRepository.findByCPF(objDto.getCpf());
        if(obj != null) {
            return obj;
        }
        return null;
    }

    public Tecnico update(Integer id, TecnicoDto objDto) {
        Tecnico oldObj = findById(id);

        if(findByCPF(objDto) != null && findByCPF(objDto).getId() != id) {
            throw new DataIntegrityViolationException("CPF já cadastrado na base de dados!");
        }

        oldObj.setNome(objDto.getNome());
        objDto.setCpf(objDto.getCpf());
        objDto.setTelefone(objDto.getTelefone());

        return tecnicoRepository.save(oldObj);
    }

    public void delete(Integer id) {
       Tecnico obj = findById(id);
       if (obj.getList().size() > 0){
           throw new DataIntegrityViolationException("Técnico possui Ordens de Serviço, não pode ser deletado!");
       }
         tecnicoRepository.deleteById(id);
    }
}
