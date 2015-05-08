package br.com.yaw.querydsl.persistence;

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
	
	public static BooleanExpression likeWithLowerCase(StringExpression field, String expression) {
		String filterValue = String.format("%s%s",expression.toLowerCase(), "%");
		return field.toLowerCase().like(filterValue);
	}
}
