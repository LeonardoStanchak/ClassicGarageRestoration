package br.com.classicGarageRestoration.Mapper;

import org.springframework.stereotype.Component;

import br.com.classicGarageRestoration.Domain.classicGarageRestorationDomain;
import br.com.classicGarageRestoration.Dto.classicGarageRestorationDto;
@Component
public class classicGarageRestorationMapper {
	
	public classicGarageRestorationDto toDto (classicGarageRestorationDomain clas) {
		if(clas == null) return null;
		
		return classicGarageRestorationDto.builder()
				.id(clas.getId())
				.ativo(clas.isAtivo())
				.mecanico(clas.getMecanico())
				.build();
	}
	
	public classicGarageRestorationDomain toEntity (classicGarageRestorationDto dto) {
		if(dto == null) return null;
		
		return classicGarageRestorationDomain.builder()
				.id(dto.getId())
				.ativo(dto.isAtivo())
				.mecanico(dto.getMecanico())
				.build();
	}

}
