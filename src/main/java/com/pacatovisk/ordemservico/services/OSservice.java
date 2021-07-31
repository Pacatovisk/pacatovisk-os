package com.pacatovisk.ordemservico.services;

import com.pacatovisk.ordemservico.domain.OrdemServico;
import com.pacatovisk.ordemservico.repositories.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OSservice {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    public List<OrdemServico> findAll() {
        return ordemServicoRepository.findAll();
    }

    public OrdemServico findById(Integer id) {
        Optional<OrdemServico> obj = ordemServicoRepository.findById(id);
        return obj.orElse(null);
    }
}
