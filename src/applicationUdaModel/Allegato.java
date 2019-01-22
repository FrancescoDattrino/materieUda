package applicationUdaModel;

import java.util.ArrayList;
import java.util.List;

public class Allegato {
	
	private int codAllegato ;
	private String Allegato;
	private List<Competenze> competenze;
	public Allegato() {
		super();
		competenze = new ArrayList<Competenze>();
	}
	public Allegato(String allegato) {
		super();
		Allegato = allegato;
		competenze = new ArrayList<Competenze>();
	}
	public Allegato(int codAllegato, String allegato) {
		super();
		this.codAllegato = codAllegato;
		Allegato = allegato;
		competenze = new ArrayList<Competenze>();
	}
	
	
	public List<Competenze> getCompetenze() {
		return competenze;
	}
	public void setCompetenze(List<Competenze> competenze) {
		this.competenze = competenze;
	}
	@Override
	public String toString() {
		return Allegato ;
	}
	public int getCodAllegato() {
		return codAllegato;
	}
	public void setCodAllegato(int codAllegato) {
		this.codAllegato = codAllegato;
	}
	public String getAllegato() {
		return Allegato;
	}
	public void setAllegato(String allegato) {
		Allegato = allegato;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Allegato == null) ? 0 : Allegato.hashCode());
		result = prime * result + codAllegato;
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
		Allegato other = (Allegato) obj;
		if (Allegato == null) {
			if (other.Allegato != null)
				return false;
		} else if (!Allegato.equals(other.Allegato))
			return false;
		if (codAllegato != other.codAllegato)
			return false;
		return true;
	}
	
	

}
