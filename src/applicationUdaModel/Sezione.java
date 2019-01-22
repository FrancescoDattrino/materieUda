package applicationUdaModel;

import java.util.ArrayList;
import java.util.List;

public class Sezione {
	private int codSezione;
	private String nome;
	private List<Classe> classi;
	public Sezione() {
		super();
		classi=new ArrayList<Classe>();
	}
	public Sezione(int codSezione, String nome) {
		super();
		this.codSezione = codSezione;
		this.nome = nome;
		classi=new ArrayList<Classe>();
	}
	
	public Sezione(int codSezione) {
		super();
		this.codSezione = codSezione;
	}
	public int getCodSezione() {
		return codSezione;
	}
	public void setCodSezione(int codSezione) {
		this.codSezione = codSezione;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public List<Classe> getClassi() {
		return classi;
	}
	public void setClassi(List<Classe> classi) {
		this.classi = classi;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codSezione;
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
		Sezione other = (Sezione) obj;
		if (codSezione != other.codSezione)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return  nome ;
	}
	
	

}
