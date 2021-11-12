package br.com.udemy.helpdesk.service;

import br.com.udemy.helpdesk.domain.Chamado;
import br.com.udemy.helpdesk.domain.Cliente;
import br.com.udemy.helpdesk.domain.Tecnico;
import br.com.udemy.helpdesk.domain.enums.Perfil;
import br.com.udemy.helpdesk.domain.enums.Prioridade;
import br.com.udemy.helpdesk.domain.enums.Status;
import br.com.udemy.helpdesk.repository.ChamadoRepository;
import br.com.udemy.helpdesk.repository.ClienteRepository;
import br.com.udemy.helpdesk.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ChamadoRepository chamadoRepository;

    public void instanciaDB(){
        Tecnico tec1 = new Tecnico(
                null, "Natalia Ferreira", "12345678911", "natalia@email.com", "123");
        tec1.addPerfil(Perfil.ADMIN);

        Cliente cli1 = new Cliente(
                null, "Rodrigo DAngelo", "12345678922", "rodrigo@email.com", "123");

        Chamado chamado1 = new Chamado(
                null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);

        tecnicoRepository.saveAll(Arrays.asList(tec1));

        clienteRepository.saveAll(Arrays.asList(cli1));

        chamadoRepository.saveAll(Arrays.asList(chamado1));
    }

}
