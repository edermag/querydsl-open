package br.com.yaw.querydsl.model;

/**
 * Bean utilizado para exibir a quantidade de mercadorias agrupadas por Categoria.
 * 
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
public class CategoriaGroup {

	private String categoria;
	
	private Long qtdMercadorias;
	
	private Double menorPreco;
	
	private Double maiorPreco;

	public CategoriaGroup(String categoria, Long qtdMercadorias,
			Double menorPreco, Double maiorPreco) {
		this.categoria = categoria;
		this.qtdMercadorias = qtdMercadorias;
		this.menorPreco = menorPreco;
		this.maiorPreco = maiorPreco;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public Long getQtdMercadorias() {
		return qtdMercadorias;
	}
	
	public Double getMenorPreco() {
		return menorPreco;
	}
	
	public Double getMaiorPreco() {
		return maiorPreco;
	}

}
