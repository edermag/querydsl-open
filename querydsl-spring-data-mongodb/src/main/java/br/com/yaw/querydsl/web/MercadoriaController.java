package br.com.yaw.querydsl.web;


import static br.com.yaw.querydsl.persistence.CriteriaUtil.buildPageRequest;
import static br.com.yaw.querydsl.persistence.MercadoriaQuery.whereByCriterio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.yaw.querydsl.model.CategoriaGroup;
import br.com.yaw.querydsl.model.FiltrosPesquisaMercadoria;
import br.com.yaw.querydsl.model.Mercadoria;
import br.com.yaw.querydsl.model.PesquisaMercadorias;
import br.com.yaw.querydsl.persistence.MercadoriaRepository;

import com.google.common.collect.Lists;
import com.mysema.query.types.Predicate;

/**
 * Controller das funcionalidade sobre a <code>Mercadoria</code>.
 * 
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
@RestController
@RequestMapping(value="/")
public class MercadoriaController {
	
	@Autowired
	private MercadoriaRepository repository;
	
	@Autowired
	private MongoTemplate template;
	
	@RequestMapping(method = RequestMethod.GET)
	public PesquisaMercadorias list(FiltrosPesquisaMercadoria filtros) {
		Pageable page = buildPageRequest(filtros.getPagina(), 
				filtros.getLinhas(), filtros.getOrdem());
		
		Predicate predicate = whereByCriterio(filtros);
		long total = repository.count(predicate);
		List<Mercadoria> mercadorias = Lists.newArrayList(repository.findAll(predicate, page));
		return new PesquisaMercadorias(total, mercadorias);
	}
	
	@RequestMapping(value="/by-descricao", method = RequestMethod.GET)
	public List<Mercadoria> findByDescricao(String descricao) {
		return repository.findByDescricaoLike(descricao);
	}
	
	@RequestMapping(value="/by-quantidade", method = RequestMethod.GET)	
	public List<Mercadoria> findByQuantidade(Integer quantidade) {
		return repository.findByQuantidadeEqualOrGreather(quantidade);
	}
	
	@RequestMapping(value="/group/by-categoria", method = RequestMethod.GET)
	public List<CategoriaGroup> groupByCategorias() {
		return repository.groupByCategorias(template);
	}
	
	@Transactional(rollbackFor = Exception.class)
	@RequestMapping(value="/increase", method = RequestMethod.POST)
	public Long incresePrecos(FiltrosPesquisaMercadoria filtros) {
		double dezPorCento = 1.1;
		Predicate predicate = whereByCriterio(filtros);
		List<Mercadoria> mercadorias = Lists.newArrayList(repository.findAll(predicate));
		mercadorias.forEach(m -> m.aumentarPreco(dezPorCento));
		repository.save(Lists.newArrayList(mercadorias));
		return (long) mercadorias.size();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void save(Mercadoria m) {
		repository.save(m);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(Long mercadoriaId) {
		repository.delete(mercadoriaId);
	}
	
}
