package br.com.yaw.querydsl.persistence;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.yaw.querydsl.model.CategoriaGroup;
import br.com.yaw.querydsl.model.FiltrosPesquisaMercadoria;
import br.com.yaw.querydsl.model.Mercadoria;
import br.com.yaw.querydsl.model.QCategoria;
import br.com.yaw.querydsl.model.QMercadoria;
import br.com.yaw.querydsl.model.mapper.CategoriaGroupMapper;

import com.google.common.base.Strings;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.jpa.impl.JPAUpdateClause;
import com.mysema.query.types.Predicate;
import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.expr.StringExpression;

/**
 * Componente responsável por construir as consultas da entidade <code>Mercadoria</code>.
 * 
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
public final class MercadoriaQuery {

	private MercadoriaQuery() {
		
	}
	
	private static BooleanExpression likeWithLowerCase(StringExpression field, String expression) {
		String filterValue = String.format("%s%s",expression.toLowerCase(), "%");
		return field.toLowerCase().like(filterValue);
	}
	
	private static Predicate whereByCriterio(QMercadoria mercadoria, 
			FiltrosPesquisaMercadoria filtros) {
		BooleanBuilder builder = new BooleanBuilder();
		
		if (!Strings.isNullOrEmpty(filtros.getDescricaoMercadoria())) {
			builder.and(likeWithLowerCase(mercadoria.descricao.toLowerCase(), filtros.getDescricaoMercadoria()));
		}
		
		if (!Strings.isNullOrEmpty(filtros.getNomeMercadoria())) {
			builder.and(likeWithLowerCase(mercadoria.nome, filtros.getNomeMercadoria()));
		}
		
		if (filtros.getPrecoDe() != null && filtros.getPrecoDe() > 0) {
			builder.and(mercadoria.preco.goe(filtros.getPrecoDe()));
		}
		
		if (filtros.getPrecoAte() != null && filtros.getPrecoAte() > 0) {
			builder.and(mercadoria.preco.loe(filtros.getPrecoAte()));
		}
		
		if (!Strings.isNullOrEmpty(filtros.getCategoria())) {
			builder.and(likeWithLowerCase(mercadoria.categoria.descricao, filtros.getCategoria()));
		}
		
		return builder;
	}
	
	public static List<Mercadoria> findAllByCriterio(EntityManager em, FiltrosPesquisaMercadoria filtros) {
		JPAQuery query = new JPAQuery(em);
		QMercadoria mercadoria = new QMercadoria("m");
		
		Predicate where = whereByCriterio(mercadoria, filtros);
		
		int offset = filtros.getOffset();
		
		return query.from(mercadoria)
				.where(where)
				.offset(offset)
				.limit(filtros.getLinhas())
				.list(mercadoria);
	}
	
	public static long countByCriterio(EntityManager em, FiltrosPesquisaMercadoria filtros) {
		JPAQuery query = new JPAQuery(em);
		QMercadoria mercadoria = new QMercadoria("m");
		
		Predicate where = whereByCriterio(mercadoria, filtros);
		
		return query.from(mercadoria)
				.where(where)
				.count();
	}
	
	public static List<CategoriaGroup> findAllGroupedByCategoria(EntityManager em) {
		JPAQuery query = new JPAQuery(em);
		QMercadoria mercadoria = new QMercadoria("m");
		QCategoria categoria = new QCategoria("c");
		
		return query.from(mercadoria)
				.innerJoin(mercadoria.categoria, categoria)
				.groupBy(categoria.descricao)
				.list(new CategoriaGroupMapper(categoria, mercadoria));
	}
	
	public static long updatePrecosByCriterio(EntityManager em, double percentual, FiltrosPesquisaMercadoria filtros) {
		QMercadoria mercadoria = new QMercadoria("m");
		Predicate where = whereByCriterio(mercadoria, filtros);
		
		return new JPAUpdateClause(em, mercadoria)
			.where(where)
			.set(mercadoria.preco, mercadoria.preco.doubleValue().multiply(percentual))
			.execute();
	}
	
}
