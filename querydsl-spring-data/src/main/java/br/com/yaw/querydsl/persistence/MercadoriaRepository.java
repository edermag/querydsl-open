package br.com.yaw.querydsl.persistence;

import static br.com.yaw.querydsl.persistence.MercadoriaQuery.findAllGroupedByCategoria;
import static br.com.yaw.querydsl.persistence.MercadoriaQuery.updatePrecosByCriterio;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.mysema.query.types.Predicate;

import br.com.yaw.querydsl.model.CategoriaGroup;
import br.com.yaw.querydsl.model.Mercadoria;

/**
 * Contrato de persistência da entidade Mercadoria.
 * 
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
@Repository
public interface MercadoriaRepository
	extends JpaRepository<Mercadoria, Long>, QueryDslPredicateExecutor<Mercadoria> {

	default long updateAllPrecos(EntityManager em, double percentual, Predicate where) {
		return updatePrecosByCriterio(em, percentual, where);
	}
	
	default public List<CategoriaGroup> groupByCategorias(EntityManager em) {
		return findAllGroupedByCategoria(em);
	}
	
}
