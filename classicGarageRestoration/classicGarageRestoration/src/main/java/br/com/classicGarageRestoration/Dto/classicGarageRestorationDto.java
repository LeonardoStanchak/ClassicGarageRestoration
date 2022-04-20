package br.com.classicGarageRestoration.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class classicGarageRestorationDto {
	private Long id;

	private String mecanico;
	private boolean ativo;

}
