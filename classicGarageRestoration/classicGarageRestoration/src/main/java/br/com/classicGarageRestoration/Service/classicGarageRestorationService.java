package br.com.classicGarageRestoration.Service;

import java.util.List;

import br.com.classicGarageRestoration.Domain.classicGarageRestorationDomain;
import br.com.classicGarageRestoration.Dto.classicGarageRestorationDto;

public interface classicGarageRestorationService {
	classicGarageRestorationDomain findClassicGarageById(Long id);
	classicGarageRestorationDto registerClassic(classicGarageRestorationDto classicDto);
	List<classicGarageRestorationDto>listAll();
	classicGarageRestorationDomain inativaMecanico(Long id);

}
