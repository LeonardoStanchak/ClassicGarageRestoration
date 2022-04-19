package br.com.classicGarageRestoration.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.classicGarageRestoration.Domain.classicGarageDomain;
import br.com.classicGarageRestoration.Dto.classicGarageDto;
@Service
public interface classicGarageRestorationService {
	classicGarageDomain findClassicGarageById(Long id);
//	classicGarageDto registerClassic(classicGarageDto classicDto);
//	List<classicGarageDto>lsitAll();
//	classicGarageDomain inativaMecanico(Long id);

}
