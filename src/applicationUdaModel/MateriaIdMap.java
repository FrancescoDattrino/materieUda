package applicationUdaModel;

import java.util.HashMap;
import java.util.Map;

public class MateriaIdMap {

private Map<Integer,Materia> map;
	
	public MateriaIdMap() {
		map=new HashMap<>();
	}
	
	public Materia get(Materia materia) {
		Materia old = map.get(materia.getIdMateria());
		if(old == null) {
			//vuole dire che nella mappa non c'è questa classe 
			//e devo aggiungerlo
			map.put(materia.getIdMateria(), materia);
			return materia;
		}
		return old;
	}
	//inserisco una classe nella mappa
	public void put (Integer idMateria, Materia materia) {
		map.put(idMateria, materia);
	}
}
