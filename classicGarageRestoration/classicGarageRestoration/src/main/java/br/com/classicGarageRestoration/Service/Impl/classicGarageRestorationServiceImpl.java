package br.com.classicGarageRestoration.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.classicGarageRestoration.Domain.classicGarageRestorationDomain;
import br.com.classicGarageRestoration.Dto.classicGarageRestorationDto;
import br.com.classicGarageRestoration.Mapper.classicGarageRestorationMapper;
import br.com.classicGarageRestoration.Repository.classicGarageRestorationRepository;
import br.com.classicGarageRestoration.Service.classicGarageRestorationService;
@Service
public class classicGarageRestorationServiceImpl implements classicGarageRestorationService {

	@Autowired
	private classicGarageRestorationRepository classRepos;
	
	@Autowired
	private classicGarageRestorationMapper  classMapper;
	
	@Transactional
	public classicGarageRestorationDomain findClassicGarageById(Long id) {
		return classRepos.findById(id).orElseThrow();
	}
	
	@Transactional
	public List<classicGarageRestorationDto> listAll() {
		List<classicGarageRestorationDomain>clasList = classRepos.findAll();
		return clasList.stream().map(x -> classMapper.toDto(x)).collect(Collectors.toList());
	}

	@Transactional
	public classicGarageRestorationDto registerClassic(classicGarageRestorationDto classicDto) {
		if (classicDto.getId() == null) {
			return AdicionaNovoMecanico(classicDto);
		}else {
			return AtualizaMecanicoParaInativo(classicDto);
		}
	}

	private classicGarageRestorationDto AtualizaMecanicoParaInativo(classicGarageRestorationDto classicDto) {
		classicGarageRestorationDomain cls = findClassicGarageById(classicDto.getId());
		cls.setAtivo(classicDto.isAtivo());
		cls = salvarNovoMecanico(cls);
		return classMapper.toDto(cls);
	}

	private classicGarageRestorationDto AdicionaNovoMecanico(classicGarageRestorationDto classicDto) {
		classicGarageRestorationDomain cl = classMapper.toEntity(classicDto);
		cl.setAtivo(classicDto.isAtivo());
		cl.setMecanico(classicDto.getMecanico());
		cl = salvarNovoMecanico(cl);
		return classMapper.toDto(cl);
	}

	private classicGarageRestorationDomain salvarNovoMecanico(classicGarageRestorationDomain cl) {
		return classRepos.save(cl);
	}

	@Transactional
	public classicGarageRestorationDomain inativaMecanico(Long id) {
		classicGarageRestorationDomain cls = findClassicGarageById(id);
		classRepos.delete(cls);
		return cls;
	}

}
