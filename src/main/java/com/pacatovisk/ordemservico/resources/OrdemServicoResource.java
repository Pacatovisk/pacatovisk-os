package com.pacatovisk.ordemservico.resources;

import com.pacatovisk.ordemservico.domain.OrdemServico;
import com.pacatovisk.ordemservico.dtos.OrdemServicoDto;
import com.pacatovisk.ordemservico.services.OSservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/os")
public class OrdemServicoResource {

    @Autowired
    private OSservice oSservice;

    @GetMapping
    public ResponseEntity<List<OrdemServicoDto>> findAll() throws IllegalAccessException {
        List<OrdemServicoDto> listDto = new ArrayList<>();
        for (OrdemServico ordemServico : oSservice.findAll()) {
            OrdemServicoDto ordemServicoDto = new OrdemServicoDto(ordemServico);
            listDto.add(ordemServicoDto);
        }
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrdemServico> findById(@PathVariable Integer id) {
       OrdemServico obj = oSservice.findById(id);
       return ResponseEntity.ok().body(obj);
    }

}
