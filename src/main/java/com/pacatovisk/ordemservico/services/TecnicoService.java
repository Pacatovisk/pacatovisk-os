package com.pacatovisk.ordemservico.services;

import com.pacatovisk.ordemservico.domain.Tecnico;
import com.pacatovisk.ordemservico.dtos.TecnicoDto;
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

    public Tecnico findById(Integer id){
        Optional<Tecnico> obj = tecnicoRepository.findById(id);
      return obj.orElseThrow(() -> new ObjectNotFoundException(
              "Objeto não encontrado! Id: " + id + ", Tipo: " + Tecnico.class.getName()));
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

    public Tecnico findByCPF(TecnicoDto objDto) {
        Tecnico obj = tecnicoRepository.findByCPF(objDto.getCpf());
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
}
