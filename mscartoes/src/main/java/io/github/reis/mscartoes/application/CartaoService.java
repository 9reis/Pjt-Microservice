package io.github.reis.mscartoes.application;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import io.github.reis.mscartoes.domain.Cartao;
import io.github.reis.mscartoes.infra.repository.CartaoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartaoService {

	private final CartaoRepository repository;
	
	@Transactional
	public Cartao save(Cartao cartao) {
		return repository.save(cartao);
	}
	
	public List<Cartao> getCartoesResdaMenorIgual(Long renda){
		var rendaBigDecial = BigDecimal.valueOf(renda); 
		return repository.findByRendaLessThanEqual(rendaBigDecial);
	}
	
}
