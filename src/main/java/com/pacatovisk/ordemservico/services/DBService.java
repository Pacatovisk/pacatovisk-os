package com.pacatovisk.ordemservico.services;

import com.pacatovisk.ordemservico.domain.Cliente;
import com.pacatovisk.ordemservico.domain.OrdemServico;
import com.pacatovisk.ordemservico.domain.Tecnico;
import com.pacatovisk.ordemservico.domain.enums.Prioridade;
import com.pacatovisk.ordemservico.domain.enums.Status;
import com.pacatovisk.ordemservico.repositories.ClienteRepository;
import com.pacatovisk.ordemservico.repositories.OrdemServicoRepository;
import com.pacatovisk.ordemservico.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TecnicoRepository tecnicoRepository;

    public void IntanciaBaseDeDados() {

        Tecnico t1 = new Tecnico(null, "Leandro Dias","641.000.040-88", "(11)94000-0005");
        Tecnico t2 = new Tecnico(null, "Linus Torvalds", "641.760.040-88", "(88) 94545-4545");
        Tecnico t3 = new Tecnico(null, "Alan Turing", "332.040.820-83", "(88) 96345-9874");
        Tecnico t4 = new Tecnico(null, "Richard Stallman", "756.192.280-96", "(88) 98745-8542");
        Tecnico t5 = new Tecnico(null, "Tim Berners-Lee", "926.076.200-66", "(88) 98545-3685");

        Cliente c1 = new Cliente(null, "Betina Campos", "598.508.200-80", "(88) 98888-7777");
        Cliente c2 = new Cliente(null, "Galileu Galilei", "089.637.320-70", "(88) 97854-6985");
        Cliente c3 = new Cliente(null, "Isaac Newton", "422.876.280-88", "(88) 95555-6541");
        Cliente c4 = new Cliente(null, "Marie Curie", "420.724.490-57", "(88) 96666-8523");
        Cliente c5 = new Cliente(null, "Albert Einstein", "047.166.710-20", "(88) 98755-4412");

        OrdemServico os1 = new OrdemServico(null, Prioridade.ALTA, "Trocar fonte do notebook", Status.ANDAMENTO, t1, c1);
        OrdemServico os2 = new OrdemServico(null, Prioridade.BAIXA, "Trocar placa mãe", Status.ANDAMENTO, t2, c2);
        OrdemServico os3 = new OrdemServico(null, Prioridade.ALTA, "Formatar para linux", Status.ANDAMENTO, t3, c3);
        OrdemServico os4 = new OrdemServico(null, Prioridade.MEDIA, "Ativar antivirus", Status.ANDAMENTO, t4, c4);
        OrdemServico os5 = new OrdemServico(null, Prioridade.MEDIA, "Criar sistema full stack", Status.ANDAMENTO, t5, c5);
        OrdemServico os6 = new OrdemServico(null, Prioridade.BAIXA, "Trocar pasta térmica", Status.ANDAMENTO, t1, c1);

        t1.getList().add(os1);
        t1.getList().add(os6);
        t2.getList().add(os2);
        t3.getList().add(os3);
        t4.getList().add(os4);
        t5.getList().add(os5);

        c1.getList().add(os1);
        c2.getList().add(os2);
        c3.getList().add(os3);
        c4.getList().add(os4);
        c5.getList().add(os5);
        c1.getList().add(os6);

        tecnicoRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5));
        clienteRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));
        ordemServicoRepository.saveAll(Arrays.asList(os1, os2, os3, os4, os5, os6));

    }
}
