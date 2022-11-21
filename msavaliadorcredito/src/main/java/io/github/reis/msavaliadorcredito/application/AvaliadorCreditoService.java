package io.github.reis.msavaliadorcredito.application;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.github.reis.msavaliadorcredito.domain.model.CartaoCliente;
import io.github.reis.msavaliadorcredito.domain.model.DadosCliente;
import io.github.reis.msavaliadorcredito.domain.model.SituacaoCliente;
import io.github.reis.msavaliadorcredito.infra.clients.CartoesResourceClient;
import io.github.reis.msavaliadorcredito.infra.clients.ClienteResourceClient;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {

	private final ClienteResourceClient clientesClient; 
	private final CartoesResourceClient cartoesClient;
	
	public SituacaoCliente obterSituacaoCliente(String cpf) {
		
		ResponseEntity<DadosCliente> dadosClienteResponse = clientesClient.dadosCliente(cpf);
		ResponseEntity<List<CartaoCliente>> cartoesResponse = cartoesClient.getCartoesByCliente(cpf);
		return SituacaoCliente
				.builder()
				.cliente(dadosClienteResponse.getBody())
				.cartoes(cartoesResponse.getBody())
				.build();
		
		
	}
}
