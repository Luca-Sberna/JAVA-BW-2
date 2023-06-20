package BEBuildWeek2.Epic_Energy_Services_CRM.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BEBuildWeek2.Epic_Energy_Services_CRM.entities.Cliente;
import BEBuildWeek2.Epic_Energy_Services_CRM.repositories.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public List<Cliente> getAllClienti() {
		return clienteRepository.findAll();
	}

	public Cliente getClienteById(UUID idCliente) {
		return clienteRepository.findById(idCliente).orElse(null);
	}
	
	public List<Cliente> findClientiByFatturatoAnnuale(Double fatturatoAnnuale) {
	    if (fatturatoAnnuale != 0) {
	        return clienteRepository.findClientiByFatturatoAnnuale(fatturatoAnnuale);
	    } else {
	        return new ArrayList<>();
	    }
	}

//	public List<Cliente> findClientiByDataInserimento(Date dataInserimento) {
//	    // Implementazione simile per la ricerca per data di inserimento
//	}
//
//	public List<Cliente> findClientiByUltimoContatto(Date ultimoContatto) {
//	    // Implementazione simile per la ricerca per ultimo contatto
//	}
//
//	public List<Cliente> findClientiByNome(String nome) {
//	    // Implementazione simile per la ricerca per nome
//	}

	
	public Cliente createCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Cliente updateCliente(UUID idCliente, Cliente cliente) {
		if (clienteRepository.existsById(idCliente)) {
			cliente.setIdCliente(idCliente);
			return clienteRepository.save(cliente);
		}
		return null;
	}

	public void deleteCliente(UUID idCliente) {
		clienteRepository.deleteById(idCliente);
	}
}
