package applicationUdaModel;

import java.util.ArrayList;
import java.util.List;

public class Classe {
	
	private int CodClasse;
	private String nomeClasse;
	private List<Sezione> sezioni;
	
	public Classe() {
		super();
		sezioni=new ArrayList<Sezione>();
	}
	public Classe(int codClasse, String nomeClasse) {
		super();
		this.CodClasse = codClasse;
		this.nomeClasse = nomeClasse;
		sezioni=new ArrayList<Sezione>();
	}
	
	public List<Sezione> getSezioni() {
		return sezioni;
	}
	public void setSezioni(List<Sezione> sezioni) {
		this.sezioni = sezioni;
	}
	public int getCodClasse() {
		return CodClasse;
	}
	public void setCodClasse(int codClasse) {
		this.CodClasse = codClasse;
	}
	public String getNomeClasse() {
		return nomeClasse;
	}
	public void setNomeClasse(String nomeClasse) {
		this.nomeClasse = nomeClasse;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + CodClasse;
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
		Classe other = (Classe) obj;
		if (CodClasse != other.CodClasse)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return  nomeClasse ;
	}
	
	
	

}
