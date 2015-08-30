package br.com.yaw.querydsl.persistence;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import br.com.yaw.querydsl.model.CategoriaGroup;
import br.com.yaw.querydsl.model.Mercadoria;

/**
 * Contrato de persistência da entidade Mercadoria.
 * 
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
public interface MercadoriaRepository
	extends MongoRepository<Mercadoria, Long>, QueryDslPredicateExecutor<Mercadoria> {

	List<Mercadoria> findByDescricaoLike(String descricao);
	
	@Query(value="{ 'quantidade': { $gte: ?0 } }")
	List<Mercadoria> findByQuantidadeEqualOrGreather(Integer quantidade);

	default List<CategoriaGroup> groupByCategorias(MongoTemplate template) {
		Aggregation agg = newAggregation(group("categoria.descricao").count().as("qtdMercadorias"),
				project("qtdMercadorias").and("categoria.descricao").previousOperation(),
				sort(Sort.Direction.DESC, "qtdMercadorias"));
		
		AggregationResults<CategoriaGroup> groupResults = template.aggregate(agg, Mercadoria.class, CategoriaGroup.class);
		return groupResults.getMappedResults();
	}

}
