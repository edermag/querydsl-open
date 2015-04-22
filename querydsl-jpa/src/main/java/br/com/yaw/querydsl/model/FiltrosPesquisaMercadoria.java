package br.com.yaw.querydsl.model;

/**
 * Bean mantém os dados do formulário de pesquisa de mercadoria.
 * 
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
public class FiltrosPesquisaMercadoria {

	private static final int QTD_LINHAS_TABELA = 20;
	
	private String categoria;
	
	private String nomeMercadoria;
	
	private String descricaoMercadoria;
	
	private Double precoDe;
	
	private Double precoAte;
	
	private Integer pagina;
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNomeMercadoria() {
		return nomeMercadoria;
	}

	public void setNomeMercadoria(String nomeMercadoria) {
		this.nomeMercadoria = nomeMercadoria;
	}

	public String getDescricaoMercadoria() {
		return descricaoMercadoria;
	}

	public void setDescricaoMercadoria(String descricaoMercadoria) {
		this.descricaoMercadoria = descricaoMercadoria;
	}

	public Double getPrecoDe() {
		return precoDe;
	}

	public void setPrecoDe(Double precoDe) {
		this.precoDe = precoDe;
	}

	public Double getPrecoAte() {
		return precoAte;
	}

	public void setPrecoAte(Double precoAte) {
		this.precoAte = precoAte;
	}
	
	public Integer getPagina() {
		return pagina;
	}
	
	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}
	
	public Integer getLinhas() {
		return QTD_LINHAS_TABELA;
	}
	
	public int getOffset() {
		return pagina > 0 ? pagina * getLinhas() : 0;
	}

}
