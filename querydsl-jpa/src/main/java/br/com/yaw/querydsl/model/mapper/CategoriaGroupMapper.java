package br.com.yaw.querydsl.model.mapper;

import br.com.yaw.querydsl.model.CategoriaGroup;
import br.com.yaw.querydsl.model.QCategoria;
import br.com.yaw.querydsl.model.QMercadoria;

import com.mysema.query.Tuple;
import com.mysema.query.types.MappingProjection;

/**
 * Mapper QueryDSL responsavel por converter <code>Tuple</code> em <code>CategoriaGroup</code>.
 * 
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
public class CategoriaGroupMapper extends MappingProjection<CategoriaGroup> {
	
	public CategoriaGroupMapper(QCategoria categoria, QMercadoria mercadoria) {
		super(CategoriaGroup.class, categoria.descricao, mercadoria.count(), 
				mercadoria.preco.min(), mercadoria.preco.max());
	}
	
	@Override
	protected CategoriaGroup map(Tuple t) {
		String categoria = t.get(0, String.class);
		Long qtd = t.get(1, Long.class);
		Double menorPreco = t.get(2, Double.class);
		Double maiorPreco = t.get(3, Double.class);
		return new CategoriaGroup(categoria, qtd, menorPreco, maiorPreco);
	}
	
}