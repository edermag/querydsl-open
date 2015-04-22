package br.com.yaw.querydsl.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entidade representa a categoria de uma Mercadoria: Automotivo, Comida, Bebida, Eletrônico...
 * 
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
@Entity
public class Categoria implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String descricao;

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
