package br.com.ajs.beneficiario.service;

import java.util.List;
import java.util.Optional;

import br.com.ajs.beneficiario.model.Beneficiario;
import br.com.ajs.beneficiario.model.Documento;


public interface BeneficiarioService {
	
	public Optional<Beneficiario> save(Beneficiario beneficiario);

	public List<Beneficiario> findAll();
	
	public List<Documento> findAllDocuments(Long id);

	public Optional<Beneficiario> update(Long id, Beneficiario tarefa);

	public Optional<Beneficiario> exclude(Long id);

}
