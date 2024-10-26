package one.digitalinnovation.gof.service.strategy;

import one.digitalinnovation.gof.model.Endereco;
import org.springframework.stereotype.Service;

@Service
public class ViaCepStrategy implements EnderecoStrategy {
    @Override
    public Endereco buscarEndereco(String cep) {
        // Lógica de chamada ao serviço ViaCEP.
        // Exemplo simplificado:
        System.out.println("Buscando endereço no ViaCEP...");
        return new Endereco();
    }
}
