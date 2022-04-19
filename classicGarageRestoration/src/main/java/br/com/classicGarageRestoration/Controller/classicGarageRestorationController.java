package br.com.classicGarageRestoration.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.classicGarageRestoration.Domain.classicGarageDomain;
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
	public ResponseEntity<classicGarageDomain>findByClassicGarageById(@PathVariable Long id){
		classicGarageDomain clas = classicService.findClassicGarageById(id);
		return ResponseEntity.ok(clas);
	}
}