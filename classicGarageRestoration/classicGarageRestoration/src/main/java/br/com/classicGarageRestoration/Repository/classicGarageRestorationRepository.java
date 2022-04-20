package br.com.classicGarageRestoration.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.classicGarageRestoration.Domain.classicGarageRestorationDomain;

public interface classicGarageRestorationRepository extends JpaRepository<classicGarageRestorationDomain, Long>{

}
