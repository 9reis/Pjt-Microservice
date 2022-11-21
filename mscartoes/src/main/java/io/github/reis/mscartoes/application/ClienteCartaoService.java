package io.github.reis.mscartoes.application;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.reis.mscartoes.domain.ClienteCartao;
import io.github.reis.mscartoes.infra.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {
	
	private final ClienteCartaoRepository repository; 
	
	
	public List<ClienteCartao> listCartoesByCpf(String cpf){
		return repository.findByCpf(cpf);
	}
}
