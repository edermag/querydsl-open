package br.com.yaw.querydsl.model;

/**
 * Bean utilizado para exibir a quantidade de mercadorias agrupadas por Categoria.
 * 
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
public class CategoriaGroup {

	private String categoria;
	
	private Long qtdMercadorias;

	public CategoriaGroup(String categoria, Long qtdMercadorias) {
		this.categoria = categoria;
		this.qtdMercadorias = qtdMercadorias;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public Long getQtdMercadorias() {
		return qtdMercadorias;
	}
	
}
