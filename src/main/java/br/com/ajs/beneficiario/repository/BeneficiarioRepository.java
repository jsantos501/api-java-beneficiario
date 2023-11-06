package br.com.ajs.beneficiario.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ajs.beneficiario.model.Beneficiario;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long>{

}
