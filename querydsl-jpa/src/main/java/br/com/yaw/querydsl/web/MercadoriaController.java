package br.com.yaw.querydsl.web;

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
import br.com.yaw.querydsl.persistence.MercadoriaQuery;

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
	public List<Mercadoria> list(FiltrosPesquisaMercadoria filtros) {
		if (filtros.getPagina() == null) {
			filtros.setPagina(0);
		}
		return MercadoriaQuery.findAllByCriterio(em, filtros);
	}
	
	@RequestMapping(value="/group/by-categoria", method = RequestMethod.GET)
	public List<CategoriaGroup> groupByCategorias() {
		return MercadoriaQuery.findAllGroupedByCategoria(em);
	}
	
	@Transactional(rollbackFor = Exception.class)
	@RequestMapping(value="/increase", method = RequestMethod.POST)
	public Long incresePrecos(FiltrosPesquisaMercadoria filtros) {
		double dezPorCento = 1.1;
		
		return MercadoriaQuery.updatePrecosByCriterio(em, dezPorCento, filtros);
	}
	
}
