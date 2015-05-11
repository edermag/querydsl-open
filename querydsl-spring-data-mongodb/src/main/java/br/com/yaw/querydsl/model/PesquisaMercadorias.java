package br.com.yaw.querydsl.model;

import java.util.List;

/**
 * Bean usado como retorno para o front-end.
 * 
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
public class PesquisaMercadorias {

	private long quantidade;
	
	private List<Mercadoria> mercadorias;
	
	public PesquisaMercadorias(long quantidade, List<Mercadoria> mercadorias) {
		this.quantidade = quantidade;
		this.mercadorias = mercadorias;
	}
	
	public List<Mercadoria> getMercadorias() {
		return mercadorias;
	}
	
	public long getQuantidade() {
		return quantidade;
	}
	
}
