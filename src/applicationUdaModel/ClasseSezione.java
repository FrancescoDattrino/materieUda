package applicationUdaModel;

import java.util.ArrayList;
import java.util.List;

public class ClasseSezione {
	private int codClasseSezione;
	private int codClasse;
	private int codSezione;
	private List<Materia> materie;
	
	
	
	public ClasseSezione() {
		super();
		this.materie = new ArrayList<Materia>();
	}



	public ClasseSezione(int codClasseSezione, int nomeClasse, int nomeSezione) {
		super();
		this.codClasseSezione = codClasseSezione;
		this.codClasse = nomeClasse;
		this.codSezione = nomeSezione;
		this.materie = new ArrayList<Materia>();
	}

	public int getCodClasseSezione() {
		return codClasseSezione;
	}

	public void setCodClasseSezione(int codClasseSezione) {
		this.codClasseSezione = codClasseSezione;
	}

	public int getCodClasse() {
		return codClasse;
	}

	public void setCodClasse(int codClasse) {
		this.codClasse = codClasse;
	}

	public int getCodSezione() {
		return codSezione;
	}

	public void setNomeSezione(int codSezione) {
		this.codSezione = codSezione;
	}

	public List<Materia> getMaterie() {
		return materie;
	}

	public void setMaterie(List<Materia> materie) {
		this.materie = materie;
	}







	



	@Override
	public String toString() {
		return "ClasseSezione [materie=" + materie + "]";
	}



	public void setCodSezione(int codSezione) {
		this.codSezione = codSezione;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codClasseSezione;
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
		ClasseSezione other = (ClasseSezione) obj;
		if (codClasseSezione != other.codClasseSezione)
			return false;
		return true;
	}
	
	
	

}
