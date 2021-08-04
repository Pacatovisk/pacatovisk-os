package com.pacatovisk.ordemservico.services;

import com.pacatovisk.ordemservico.domain.Tecnico;
import com.pacatovisk.ordemservico.repositories.TecnicoRepository;
import com.pacatovisk.ordemservico.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
