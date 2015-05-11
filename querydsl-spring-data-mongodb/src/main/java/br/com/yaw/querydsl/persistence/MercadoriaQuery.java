package br.com.yaw.querydsl.persistence;


import br.com.yaw.querydsl.model.FiltrosPesquisaMercadoria;
import br.com.yaw.querydsl.model.QMercadoria;

import com.google.common.base.Strings;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;

/**
 * Componente responsável por construir as consultas da entidade <code>Mercadoria</code>.
 * 
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
public final class MercadoriaQuery {

	private MercadoriaQuery() {	
	}
	
	public static Predicate whereByCriterio(FiltrosPesquisaMercadoria filtros) {
		QMercadoria mercadoria = QMercadoria.mercadoria;
		
		BooleanBuilder builder = new BooleanBuilder();
		
		if (!Strings.isNullOrEmpty(filtros.getDescricaoMercadoria())) {
			builder.and(mercadoria.descricao.startsWithIgnoreCase(filtros.getDescricaoMercadoria()));
		}
		
		if (!Strings.isNullOrEmpty(filtros.getNomeMercadoria())) {
			builder.and(mercadoria.nome.startsWithIgnoreCase(filtros.getNomeMercadoria()));
		}
		
		if (filtros.getPrecoDe() != null && filtros.getPrecoDe() > 0) {
			builder.and(mercadoria.preco.goe(filtros.getPrecoDe()));
		}
		
		if (filtros.getPrecoAte() != null && filtros.getPrecoAte() > 0) {
			builder.and(mercadoria.preco.loe(filtros.getPrecoAte()));
		}
		
		if (!Strings.isNullOrEmpty(filtros.getCategoria())) {
			builder.and(mercadoria.categoria.descricao.startsWithIgnoreCase(filtros.getCategoria()));
		}
		
		return builder;
	}
	
}
