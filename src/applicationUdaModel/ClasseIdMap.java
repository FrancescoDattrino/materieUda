package applicationUdaModel;

import java.util.HashMap;
import java.util.Map;

public class ClasseIdMap {
	
	private Map<Integer,Classe> map;
	
	public ClasseIdMap() {
		map=new HashMap<>();
	}
	
	public Classe get(Classe classe) {
		Classe old = map.get(classe.getCodClasse());
		if(old == null) {
			//vuole dire che nella mappa non c'è questa classe 
			//e devo aggiungerlo
			map.put(classe.getCodClasse(), classe);
			return classe;
		}
		return old;
	}
	//inserisco una classe nella mappa
	public void put (Integer codClasse, Classe classe) {
		map.put(codClasse, classe);
	}

}
