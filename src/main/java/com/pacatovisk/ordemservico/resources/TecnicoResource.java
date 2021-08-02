package com.pacatovisk.ordemservico.resources;

import com.pacatovisk.ordemservico.dtos.TecnicoDto;
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
    public ResponseEntity<TecnicoDto> findById(@PathVariable Integer id) {
        TecnicoDto objDto = new TecnicoDto(tecnicoService.findById(id));
      return ResponseEntity.ok().body(objDto);
    }
}
