package br.com.ajs.beneficiario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ajs.beneficiario.model.Beneficiario;
import br.com.ajs.beneficiario.model.Documento;
import br.com.ajs.beneficiario.repository.BeneficiarioRepository;

@Service
public class BeneficiarioServiceImpl implements BeneficiarioService{

	@Autowired
	private BeneficiarioRepository beneficiarioRepository;

	@Override
	public Optional<Beneficiario> save(Beneficiario beneficiario) {
		
		return Optional.of(beneficiarioRepository.save(beneficiario));

	}

	@Override
	public List<Beneficiario> findAll() {
		return beneficiarioRepository.findAll();

	}

	@Override
	public List<Documento> findAllDocuments(Long id) {
		return beneficiarioRepository.findById(id)
				.orElseGet(null).getDocumentos();	
				
	}

	@Override
	public Optional<Beneficiario> update(Long id, Beneficiario beneficiario) {
		 return beneficiarioRepository.findById(id)
				 .map(be -> {
					 be.setNome(beneficiario.getNome());
					 be.setTelefone(beneficiario.getTelefone());
					 be.setDataNascimento(beneficiario.getDataNascimento());
					 be.setDataInclusao(beneficiario.getDataInclusao());
					 be.setDataAtualizacao(beneficiario.getDataAtualizacao());

					 return Optional.of(beneficiarioRepository.save(be));})
				 
				 .orElse(Optional.empty());
	}

	@Override
	public Optional<Beneficiario> exclude(Long id) {
		return beneficiarioRepository.findById(id)
				.map(registro -> {
					beneficiarioRepository.deleteById(id);
					ResponseEntity.noContent().build();
					return Optional.of(registro);})
				.orElse(Optional.empty());
	}

}
