package io.github.reis.mscartoes.application;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.reis.mscartoes.application.representation.CartaoSaveRequest;
import io.github.reis.mscartoes.domain.Cartao;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cartoes")
@RequiredArgsConstructor
public class CartoesResource {
	
	private final CartaoService service; 

	@GetMapping
	public String status() {
		return "<h1> MSCartoes OK </h>";
	}
	
	@PostMapping
	public ResponseEntity cadastra(@RequestBody CartaoSaveRequest request) {
		Cartao cartao = request.toModel();
		service.save(cartao);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
}
