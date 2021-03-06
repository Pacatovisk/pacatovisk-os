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

    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<TecnicoDto> findById(@PathVariable String cpf) {
        TecnicoDto objDto = new TecnicoDto(tecnicoService.findByCpff(cpf));
        return ResponseEntity.ok().body(objDto);
    }

    @GetMapping("/filter/custom")
    public ResponseEntity<TecnicoDto>findTecnicoByCustom(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "nome", required = false) String nome,
            @RequestParam(value = "cpf", required = false) String cpf
    ) {
        TecnicoDto objDto = new TecnicoDto(tecnicoService.filter(id, nome, cpf));
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

    @PutMapping(value = "/{id}")
    public ResponseEntity<TecnicoDto> update(@PathVariable Integer id, @Valid @RequestBody TecnicoDto objDto) {
        TecnicoDto newObj = new TecnicoDto(tecnicoService.update(id, objDto));
        return ResponseEntity.ok().body(newObj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        tecnicoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
