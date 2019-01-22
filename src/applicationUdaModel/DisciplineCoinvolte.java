package applicationUdaModel;

import java.time.LocalDate;

public class DisciplineCoinvolte {
	private int codDisciplineCoinvolte;
	private String uda;
	private int ore;
	private int peso;
	private String argomento;
	private LocalDate dataInizio;
	private LocalDate dataFine;
	private int codClasse;
	private int codSezione;
	private int idMateria;
	private int codCompetenzaSecondarie;
	public DisciplineCoinvolte() {
		super();
	}
	
	
	public DisciplineCoinvolte(int ore, int peso, String argomento, LocalDate dataInizio, LocalDate dataFine,
			int codClasse, int codSezione, int idMateria, int codCompetenzaSecondarie, String uda) {
		super();
		this.ore = ore;
		this.peso = peso;
		this.argomento = argomento;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.codClasse = codClasse;
		this.codSezione = codSezione;
		this.idMateria = idMateria;
		this.codCompetenzaSecondarie = codCompetenzaSecondarie;
		this.uda=uda;
	}


	public DisciplineCoinvolte(int codDisciplineCoinvolte, int ore, int peso, String argomento, LocalDate dataInizio,
			LocalDate dataFine, int codClasse, int codSezione, int idMateria, int codCompetenzaSecondarie, String uda) {
		super();
		this.codDisciplineCoinvolte = codDisciplineCoinvolte;
		this.ore = ore;
		this.peso = peso;
		this.argomento = argomento;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.codClasse = codClasse;
		this.codSezione = codSezione;
		this.idMateria = idMateria;
		this.codCompetenzaSecondarie = codCompetenzaSecondarie;
		this.uda=uda;
	}

	public String getUda() {
		return uda;
	}


	public void setUda(String uda) {
		this.uda = uda;
	}


	public int getCodDisciplineCoinvolte() {
		return codDisciplineCoinvolte;
	}
	public void setCodDisciplineCoinvolte(int codDisciplineCoinvolte) {
		this.codDisciplineCoinvolte = codDisciplineCoinvolte;
	}
	public int getOre() {
		return ore;
	}
	public void setOre(int ore) {
		this.ore = ore;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
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
	public void setCodSezione(int codSezione) {
		this.codSezione = codSezione;
	}
	public String getArgomento() {
		return argomento;
	}
	public void setArgomento(String argomento) {
		this.argomento = argomento;
	}
	public LocalDate getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}
	public LocalDate getDataFine() {
		return dataFine;
	}
	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}
	public int getCodCompetenzaSecondarie() {
		return codCompetenzaSecondarie;
	}
	public void setCodCompetenzaSecondarie(int codCompetenzaSecondarie) {
		this.codCompetenzaSecondarie = codCompetenzaSecondarie;
	}
	public int getIdMateria() {
		return idMateria;
	}
	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codDisciplineCoinvolte;
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
		DisciplineCoinvolte other = (DisciplineCoinvolte) obj;
		if (codDisciplineCoinvolte != other.codDisciplineCoinvolte)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DisciplineCoinvolte [uda = "+uda+", ore=" + ore + ", peso=" + peso + ", argomento=" + argomento + ", dataInizio="
				+ dataInizio + ", dataFine=" + dataFine + "]";
	}
	
	
}