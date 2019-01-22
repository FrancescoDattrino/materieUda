package applicationUdaModel;

import java.util.ArrayList;
import java.util.List;

public class CompetenzeSecondarie {
	
	private int codCompetenzaSecondaria;
	private int codCompetenzaPrimaria;
	private String competenzaSecondaria;
	List<DisciplineCoinvolte> disciplineCoinvolte;
	
	public CompetenzeSecondarie(List<DisciplineCoinvolte> disciplineCoincolte) {
		super();
		this.disciplineCoinvolte = new ArrayList<DisciplineCoinvolte>();
	}
	
	


	public CompetenzeSecondarie(int codCompetenzaPrimaria, int codCompetenzaSecondaria, String competenzaSecondaria,
			List<DisciplineCoinvolte> disciplineCoincolte) {
		super();
		
		this.codCompetenzaSecondaria = codCompetenzaSecondaria;
		this.codCompetenzaPrimaria = codCompetenzaPrimaria;
		this.competenzaSecondaria = competenzaSecondaria;
		this.disciplineCoinvolte = new ArrayList<DisciplineCoinvolte>();
	}




	public CompetenzeSecondarie(int codCompetenzaPrimaria, String competenzaSecondaria) {
		super();
		this.codCompetenzaPrimaria = codCompetenzaPrimaria;
		this.competenzaSecondaria = competenzaSecondaria;
		this.disciplineCoinvolte = new ArrayList<DisciplineCoinvolte>();
	}




	public CompetenzeSecondarie(int codCompetenzaSecondaria, int codCompetenzaPrimaria, String competenzaSecondaria) {
		super();
		
		this.codCompetenzaSecondaria = codCompetenzaSecondaria;
		this.codCompetenzaPrimaria = codCompetenzaPrimaria;
		this.competenzaSecondaria = competenzaSecondaria;
		this.disciplineCoinvolte = new ArrayList<DisciplineCoinvolte>();
	}




	public int getCodCompetenzaPrimaria() {
		return codCompetenzaPrimaria;
	}




	public void setCodCompetenzaPrimaria(int codCompetenzaPrimaria) {
		this.codCompetenzaPrimaria = codCompetenzaPrimaria;
	}




	public int getCodCompetenzaSecondaria() {
		return codCompetenzaSecondaria;
	}
	public void setCodCompetenzaSecondaria(int codCompetenzaSecondaria) {
		this.codCompetenzaSecondaria = codCompetenzaSecondaria;
	}
	public String getCompetenzaSecondaria() {
		return competenzaSecondaria;
	}
	public void setCompetenzaSecondaria(String competenzaSecondaria) {
		this.competenzaSecondaria = competenzaSecondaria;
	}
	public List<DisciplineCoinvolte> getDisciplineCoinvolte() {
		return disciplineCoinvolte;
	}
	public void setDisciplineCoincolte(List<DisciplineCoinvolte> disciplineCoincolte) {
		this.disciplineCoinvolte = disciplineCoincolte;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codCompetenzaSecondaria;
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
		CompetenzeSecondarie other = (CompetenzeSecondarie) obj;
		if (codCompetenzaSecondaria != other.codCompetenzaSecondaria)
			return false;
		return true;
	}




	@Override
	public String toString() {
		return competenzaSecondaria ;
	}

	
	

}
