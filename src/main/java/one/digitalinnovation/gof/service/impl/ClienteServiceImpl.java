package one.digitalinnovation.gof.service.impl;

import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.model.Endereco;
import one.digitalinnovation.gof.model.ClienteRepository;
import one.digitalinnovation.gof.service.ClienteService;
import one.digitalinnovation.gof.service.strategy.EnderecoStrategy;
import one.digitalinnovation.gof.service.strategy.EnderecoStrategyFactory;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;
    private final EnderecoStrategyFactory strategyFactory;

    public ClienteServiceImpl(ClienteRepository clienteRepository, EnderecoStrategyFactory strategyFactory) {
        this.clienteRepository = clienteRepository;
        this.strategyFactory = strategyFactory;
    }

    @Override
    public Cliente salvarClienteComEndereco(String cep, boolean usarCache) {
        EnderecoStrategy strategy = strategyFactory.getStrategy(usarCache);
        Endereco endereco = strategy.buscarEndereco(cep);

        Cliente cliente = new Cliente();
        cliente.setEndereco(endereco);
        return clienteRepository.save(cliente);
    }

	@Override
	public Iterable<Cliente> buscarTodos() {
		// Buscar todos os Clientes.
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		// Buscar Cliente por ID.
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}

	@Override
	public void inserir(Cliente cliente) {
		salvarClienteComEndereco(null, false);
	}


	@Override
	public void atualizar(Long id, Cliente cliente) {
		// Buscar Cliente por ID, caso exista:
		Optional<Cliente> clienteBd = clienteRepository.findById(id);
		if (clienteBd.isPresent()) {
			salvarClienteComEndereco(null, false);
		}
	}

	@Override
	public void deletar(Long id) {
		// Deletar Cliente por ID.
		clienteRepository.deleteById(id);
	}
}
