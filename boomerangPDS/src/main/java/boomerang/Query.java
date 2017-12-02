package boomerang;

import java.util.List;

import com.beust.jcommander.internal.Lists;

import boomerang.jimple.Statement;
import boomerang.jimple.Val;
import soot.Type;
import sync.pds.solver.nodes.Node;

public abstract class Query{

	private final Statement stmt;
	private final Val variable;

	public Query(Statement stmt, Val variable) {
		this.stmt = stmt;
		this.variable = variable;
	}
	
	public Node<Statement,Val> asNode(){
		return new Node<Statement,Val>(stmt,variable);
	}
	@Override
	public String toString() {
		return new Node<Statement,Val>(stmt,variable).toString();
	}
	
	public Statement stmt(){
		return stmt;
	}
	
	public Val var(){
		return variable;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stmt == null) ? 0 : stmt.hashCode());
		result = prime * result + ((variable == null) ? 0 : variable.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Query other = (Query) obj;
		if (stmt == null) {
			if (other.stmt != null)
				return false;
		} else if (!stmt.equals(other.stmt))
			return false;
		if (variable == null) {
			if (other.variable != null)
				return false;
		} else if (!variable.equals(other.variable))
			return false;
		return true;
	}

	public Type getType() {
		return variable.value().getType();
	}
}