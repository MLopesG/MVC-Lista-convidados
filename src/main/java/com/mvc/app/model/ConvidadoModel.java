package com.mvc.app.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
public class ConvidadoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
	private Long id;

	@NotEmpty(message = "Preencha o campo corretamente!")
	private String nome;

	@Min(1)
    private Integer quantidadeAcompanhantes;

	public Long getId() {
		return id;
	}
	public void setId(Long id) { 
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getQuantidadeAcompanhantes() {
		return quantidadeAcompanhantes;
	}
	public void setQuantidadeAcompanhantes(Integer quantidadeAcompanhantes) {
		this.quantidadeAcompanhantes = quantidadeAcompanhantes;
	}
}
