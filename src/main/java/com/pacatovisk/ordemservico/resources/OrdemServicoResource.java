package com.pacatovisk.ordemservico.resources;

import com.pacatovisk.ordemservico.domain.OrdemServico;
import com.pacatovisk.ordemservico.services.OSservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/os")
public class OrdemServicoResource {

    @Autowired
    private OSservice oSservice;

    @GetMapping
    public ResponseEntity<List<OrdemServico>>  findAll() {
        List<OrdemServico> list = oSservice.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrdemServico> findById(@PathVariable Integer id) {
       OrdemServico obj = oSservice.findById(id);
       return ResponseEntity.ok().body(obj);
    }

}
