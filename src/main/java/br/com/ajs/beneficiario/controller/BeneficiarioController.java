package br.com.ajs.beneficiario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ajs.beneficiario.model.Beneficiario;
import br.com.ajs.beneficiario.model.Documento;
import br.com.ajs.beneficiario.service.BeneficiarioService;

@RestController
@RequestMapping("/api/beneficiario")
public class BeneficiarioController {

	@Autowired
	private BeneficiarioService service;
	
	@GetMapping("/")
	public List<Beneficiario> findAll() {
		return service.findAll();
	}
	
	@PostMapping("/")
	public ResponseEntity<Beneficiario> include(@RequestBody Beneficiario beneficiario) {
		return service.save(beneficiario)
			.map(resultado -> ResponseEntity.ok().body(resultado))
			.orElse(ResponseEntity.badRequest().build());
	}

	

	@GetMapping("/{id}")
	public List<Documento> findAllDocuments(@PathVariable Long id) {
		return service.findAllDocuments(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Beneficiario> update(@PathVariable Long id, @RequestBody Beneficiario beneficiario) {
		return service.update(id, beneficiario)
		  	.map(reg -> ResponseEntity.ok().body(reg))
		  	.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> exclude(@PathVariable Long id) {
		return service.exclude(id)
			  	.map(reg -> ResponseEntity.noContent().build())
			  	.orElse(ResponseEntity.notFound().build());
	}
	
}
