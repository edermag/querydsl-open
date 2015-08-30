package br.com.yaw.querydsl.web;

import static br.com.yaw.querydsl.persistence.MercadoriaQuery.countByCriterio;
import static br.com.yaw.querydsl.persistence.MercadoriaQuery.findAllByCriterio;
import static br.com.yaw.querydsl.persistence.MercadoriaQuery.findAllGroupedByCategoria;
import static br.com.yaw.querydsl.persistence.MercadoriaQuery.updatePrecosByCriterio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.yaw.querydsl.model.CategoriaGroup;
import br.com.yaw.querydsl.model.FiltrosPesquisaMercadoria;
import br.com.yaw.querydsl.model.Mercadoria;
import br.com.yaw.querydsl.model.PesquisaMercadorias;

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
	
	@RequestMapping(method = RequestMethod.GET)
	public PesquisaMercadorias list(FiltrosPesquisaMercadoria filtros) {
		long total = countByCriterio(em, filtros);
		
		List<Mercadoria> mercadorias = findAllByCriterio(em, filtros);
		return new PesquisaMercadorias(total, mercadorias);
	}
	
	@RequestMapping(value="/group-by-categoria", method = RequestMethod.GET)
	public List<CategoriaGroup> groupByCategorias() {
		return findAllGroupedByCategoria(em);
	}
	
	@Transactional(rollbackFor = Exception.class)
	@RequestMapping(value="/increase", method = RequestMethod.POST)
	public Long incresePrecos(FiltrosPesquisaMercadoria filtros) {
		double dezPorCento = 1.1;
		
		return updatePrecosByCriterio(em, dezPorCento, filtros);
	}
	
}
