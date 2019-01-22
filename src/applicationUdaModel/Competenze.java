
package applicationUdaModel;

import java.util.ArrayList;
import java.util.List;

public class Competenze {
	
	private int codCompetenze ;
	private int  codAllegato;//l'allegato in cui è inserita la competenza
	private String nome;
	private List<CompetenzeSecondarie> competenzeSecondarie;
	/**
	 * codice della competenza
	 * @param codCompetenze
	 */
	public Competenze(int codCompetenze) {
		super();
		this.codCompetenze = codCompetenze;
		this.competenzeSecondarie=new ArrayList<CompetenzeSecondarie>();
	}

	public Competenze(int codCompetenze, int codAllegato, String nome) {
		super();
		this.codCompetenze = codCompetenze;
		this.codAllegato = codAllegato;
		this.nome = nome;
		this.competenzeSecondarie=new ArrayList<CompetenzeSecondarie>();
	}


	public int getCodAllegato() {
		return codAllegato;
	}


	public void setCodAllegato(int codAllegato) {
		this.codAllegato = codAllegato;
	}





	public List<CompetenzeSecondarie> getCompetenzeSecondarie() {
		return competenzeSecondarie;
	}

	public void setCompetenzeSecondarie(List<CompetenzeSecondarie> competenzeSecondarie) {
		this.competenzeSecondarie = competenzeSecondarie;
	}

	public int getCodCompetenze() {
		return codCompetenze;
	}
	public void setCodCompetenze(int codCompetenze) {
		this.codCompetenze = codCompetenze;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return  nome ;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codCompetenze;
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
		Competenze other = (Competenze) obj;
		if (codCompetenze != other.codCompetenze)
			return false;
		return true;
	}
	
	
}
