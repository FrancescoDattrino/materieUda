package applicationUdaModel;

import java.time.LocalDate;

public class UdaFromMateria {
	private String uda;
	private String competenzaSecondaria;
	private String nomeMateria;
	private int ore;
	private int peso;
	private LocalDate dataInizio;
	private LocalDate dataFine;
	private String nomeClasse;
	private String nomeSezione;
	public UdaFromMateria(String uda, String competenzaSecondaria, String nomeMateria, int ore, int peso,
			LocalDate dataInizio, LocalDate dataFine, String nomeClasse, String nomeSezione) {
		super();
		this.uda = uda;
		this.competenzaSecondaria = competenzaSecondaria;
		this.nomeMateria = nomeMateria;
		this.ore = ore;
		this.peso = peso;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.nomeClasse = nomeClasse;
		this.nomeSezione = nomeSezione;
	}
	public String getUda() {
		return uda;
	}
	public String getCompetenzaSecondaria() {
		return competenzaSecondaria;
	}
	public String getNomeMateria() {
		return nomeMateria;
	}
	public int getOre() {
		return ore;
	}
	public int getPeso() {
		return peso;
	}
	public LocalDate getDataInizio() {
		return dataInizio;
	}
	public LocalDate getDataFine() {
		return dataFine;
	}
	public String getNomeClasse() {
		return nomeClasse;
	}
	public String getNomeSezione() {
		return nomeSezione;
	}
	@Override
	public String toString() {
		return "uda=" + uda + ", competenzaSecondaria=" + competenzaSecondaria + ","
				+ nomeMateria + ", ore=" + ore + ", peso=" + peso + ", dataInizio=" + dataInizio + ", dataFine="
				+ dataFine + "," + nomeClasse + ","+ nomeSezione ;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uda == null) ? 0 : uda.hashCode());
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
		UdaFromMateria other = (UdaFromMateria) obj;
		if (uda == null) {
			if (other.uda != null)
				return false;
		} else if (!uda.equals(other.uda))
			return false;
		return true;
	}
	
	
	

}
