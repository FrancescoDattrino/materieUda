package applicationUdaModel;

import java.util.ArrayList;
import java.util.List;

public class Materia {
	private  int idMateria ;
	private String nomeMateria;
	private int idAsse;
	private List<Classe> classi;
	private List<Sezione> sezioni;
	
	public Materia() {
		super();
		classi=new ArrayList<Classe>();
		sezioni= new ArrayList<Sezione>();
	}
	public Materia(int idMateria, String materia, int idAsse) {
		super();
		this.idMateria = idMateria;
		this.nomeMateria = materia;
		this.idAsse = idAsse;
		classi=new ArrayList<Classe>();
		sezioni= new ArrayList<Sezione>();
	}
	public int getIdMateria() {
		return idMateria;
	}
	
	public List<Classe> getClassi() {
		return classi;
	}
	public void setClassi(List<Classe> classi) {
		this.classi = classi;
	}
	public List<Sezione> getSezioni() {
		return sezioni;
	}
	public void setSezioni(List<Sezione> sezioni) {
		this.sezioni = sezioni;
	}
	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}
	public String getMateria() {
		return nomeMateria;
	}
	public void setMateria(String materia) {
		this.nomeMateria = materia;
	}
	public int getIdAsse() {
		return idAsse;
	}
	public void setIdAsse(int idAsse) {
		this.idAsse = idAsse;
	}
	@Override
	public String toString() {
		return  nomeMateria ;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idMateria;
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
		Materia other = (Materia) obj;
		if (idMateria != other.idMateria)
			return false;
		return true;
	}
	
	

}
