package br.com.yaw.querydsl.persistence;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.expr.StringExpression;

/**
 * Métodos uteis para manipulação do mecanismo de persistência.
 * 
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
public final class CriteriaUtil {

	private CriteriaUtil() {
	}
	
	public static Pageable buildPageRequest(int page, int rows, String sortBy) {
		Sort sort = new Sort(Sort.Direction.ASC, sortBy);
		return new PageRequest(page, rows, sort);
    }
	
	public static BooleanExpression likeWithLowerCase(StringExpression field, String expression) {
		String filterValue = String.format("%s%s",expression.toLowerCase(), "%");
		return field.toLowerCase().like(filterValue);
	}
}
