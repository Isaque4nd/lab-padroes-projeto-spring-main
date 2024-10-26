package one.digitalinnovation.gof.service.strategy;

import org.springframework.stereotype.Component;

@Component
public class EnderecoStrategyFactory {
    private final ViaCepStrategy viaCepStrategy;
    private final CacheEnderecoStrategy cacheEnderecoStrategy;

    public EnderecoStrategyFactory(ViaCepStrategy viaCepStrategy, CacheEnderecoStrategy cacheEnderecoStrategy) {
        this.viaCepStrategy = viaCepStrategy;
        this.cacheEnderecoStrategy = cacheEnderecoStrategy;
    }

    public EnderecoStrategy getStrategy(boolean usarCache) {
        return usarCache ? cacheEnderecoStrategy : viaCepStrategy;
    }
}
