package br.com.yaw.querydsl.model;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;


/**
 * Entidade principal da demonstração, representa uma mercadoria.
 * 
 * <p><b>Nota:</b> qualquer modificação nessa classe gera impacto para o QueryDSL (generated-sources).</p>
 * 
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
@Entity
public class Mercadoria {

	@Id
	private Long id;
	
	private String nome;
	
	private String descricao;
	
	private Integer quantidade;
	
	private Double preco;
	
	@Embedded
	private Categoria categoria;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public void aumentarPreco(double percentual) {
		if (this.preco != null) {
			this.preco = this.preco * percentual;			
		}
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}
