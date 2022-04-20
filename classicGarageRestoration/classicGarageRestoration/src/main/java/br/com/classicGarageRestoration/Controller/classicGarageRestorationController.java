package br.com.classicGarageRestoration.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.classicGarageRestoration.Domain.classicGarageRestorationDomain;
import br.com.classicGarageRestoration.Dto.classicGarageRestorationDto;
import br.com.classicGarageRestoration.Service.classicGarageRestorationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api/v1/ClassicGarageRestoration", produces = {MediaType.APPLICATION_JSON_VALUE})
@Api(value = "ClassicGarareRestoration", tags = {"ClassicGarareRestoration"})
public class classicGarageRestorationController {
	
	@Autowired
	private classicGarageRestorationService classicService;
	
	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Traz todos os mecanicos que trabalham na mecanica")
	public ResponseEntity<classicGarageRestorationDomain>findByClassicGarageById(@PathVariable Long id){
		classicGarageRestorationDomain clas = classicService.findClassicGarageById(id);
		return ResponseEntity.ok(clas);
	}
	
	@GetMapping(value = "/listaTodosOsMecanicos")
	@ApiOperation(value = "Lista todos os mecaninos")
	public ResponseEntity<List<classicGarageRestorationDto>>listAll(){
		List<classicGarageRestorationDto>claList = classicService.listAll();
		return ResponseEntity.ok().body(claList);
	}
	
	@PostMapping
	@ApiOperation(value = "Inseri um novo mecanico")
	public ResponseEntity<classicGarageRestorationDto>novoMecanico(@Valid @RequestBody classicGarageRestorationDto clasDto){
		clasDto = classicService.registerClassic(clasDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(clasDto);
	}
	
	@DeleteMapping(value = "/{id}")
	@ApiOperation(value = "Inativa um mecanico")
	public ResponseEntity<classicGarageRestorationDomain>inativaMecanico(@PathVariable Long id){
		return ResponseEntity.ok().body(classicService.inativaMecanico(id));
	}
}