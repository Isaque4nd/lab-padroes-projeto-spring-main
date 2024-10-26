package one.digitalinnovation.gof.service.strategy;

import one.digitalinnovation.gof.model.Endereco;

public interface EnderecoStrategy {
    Endereco buscarEndereco(String cep);
}
