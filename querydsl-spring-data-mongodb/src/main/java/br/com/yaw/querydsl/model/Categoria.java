package br.com.yaw.querydsl.model;


/**
 * Entidade representa a categoria de uma Mercadoria: Automotivo, Comida, Bebida, Eletrônico...
 * 
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
public class Categoria {
	
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
