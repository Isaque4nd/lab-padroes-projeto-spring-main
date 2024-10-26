package one.digitalinnovation.gof.service.strategy;

import one.digitalinnovation.gof.model.Endereco;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CacheEnderecoStrategy implements EnderecoStrategy {
    private final Map<String, Endereco> cache = new HashMap<>();

    @Override
    public Endereco buscarEndereco(String cep) {
        System.out.println("Buscando endereço no cache...");
        return cache.getOrDefault(cep, null);
    }

    public void adicionarAoCache(String cep, Endereco endereco) {
        cache.put(cep, endereco);
    }
}
