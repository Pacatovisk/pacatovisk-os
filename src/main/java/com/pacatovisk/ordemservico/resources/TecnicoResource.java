package com.pacatovisk.ordemservico.resources;

import com.pacatovisk.ordemservico.domain.Tecnico;
import com.pacatovisk.ordemservico.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoResource {

    @Autowired
    private TecnicoService tecnicoService;

    //localhost:8080/tecnicos/1
    @GetMapping(value = "/{id}")
    public ResponseEntity<Tecnico> findById(@PathVariable Integer id) {
      Tecnico obj = tecnicoService.findById(id);
      return ResponseEntity.ok().body(obj);
    }
}
