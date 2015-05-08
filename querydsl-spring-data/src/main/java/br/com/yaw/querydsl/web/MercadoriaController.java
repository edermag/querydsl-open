package br.com.yaw.querydsl.web;

import static br.com.yaw.querydsl.persistence.CriteriaUtil.buildPageRequest;
import static br.com.yaw.querydsl.persistence.MercadoriaQuery.whereByCriterio;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.yaw.querydsl.model.CategoriaGroup;
import br.com.yaw.querydsl.model.FiltrosPesquisaMercadoria;
import br.com.yaw.querydsl.model.Mercadoria;
import br.com.yaw.querydsl.model.PesquisaMercadorias;
import br.com.yaw.querydsl.persistence.MercadoriaRepository;

/**
 * Controller das funcionalidade sobre a <code>Mercadoria</code>.
 * 
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
@RestController
@RequestMapping(value="/")
public class MercadoriaController {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private MercadoriaRepository repository;
	
	@RequestMapping(method = RequestMethod.GET)
	public PesquisaMercadorias list(FiltrosPesquisaMercadoria filtros) {
		Pageable page = buildPageRequest(filtros.getPagina(), 
				filtros.getLinhas(), filtros.getOrdem());
		
		long total = repository.count(whereByCriterio(filtros));
		List<Mercadoria> mercadorias = toList(repository.findAll(whereByCriterio(filtros), page));
		return new PesquisaMercadorias(total, mercadorias);
	}
	
	@RequestMapping(value="/group/by-categoria", method = RequestMethod.GET)
	public List<CategoriaGroup> groupByCategorias() {
		return repository.groupByCategorias(em);
	}
	
	@Transactional(rollbackFor = Exception.class)
	@RequestMapping(value="/increase", method = RequestMethod.POST)
	public Long incresePrecos(FiltrosPesquisaMercadoria filtros) {
		double dezPorCento = 1.1;
		return repository.updateAllPrecos(em, dezPorCento, whereByCriterio(filtros));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void save(Mercadoria m) {
		repository.save(m);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(Long mercadoriaId) {
		repository.delete(mercadoriaId);
	}
	
	static <T> List<T> toList(Iterable<T> iterable) {
		return StreamSupport.stream(iterable.spliterator(), false)
				.collect(Collectors.toList());
	}
	
}
