package br.com.yaw.querydsl.model;

import com.google.common.base.Strings;

/**
 * Bean mantém os dados do formulário de pesquisa de mercadoria.
 * 
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
public class FiltrosPesquisaMercadoria {

	private static final String CAMPO_ORDEM_DEFAULT = "id";
	
	private static final int QTD_LINHAS_TABELA = 10;
	
	private String categoria;
	
	private String nomeMercadoria;
	
	private String descricaoMercadoria;
	
	private Double precoDe;
	
	private Double precoAte;
	
	private Integer pagina;
	
	private String ordem;
	
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
	
	public String getOrdem() {
		if (Strings.isNullOrEmpty(ordem)) {
			return CAMPO_ORDEM_DEFAULT;
		}
		return ordem;
	}
	
	public void setOrdem(String ordem) {
		this.ordem = ordem;
	}
	
	public Integer getPagina() {
		if (this.pagina == null) {
			return 0;
		}
		return pagina;
	}
	
	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}
	
	public Integer getLinhas() {
		return QTD_LINHAS_TABELA;
	}

}
