package com.pacatovisk.ordemservico.resources;

import com.pacatovisk.ordemservico.domain.Tecnico;
import com.pacatovisk.ordemservico.dtos.TecnicoDto;
import com.pacatovisk.ordemservico.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


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

    @GetMapping
    public ResponseEntity<List<TecnicoDto>> findAll(){
        List<TecnicoDto> listDto = tecnicoService.findAll()
                .stream().map(TecnicoDto::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<TecnicoDto> create(@Valid @RequestBody TecnicoDto objDto) {
        Tecnico newObj = tecnicoService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
