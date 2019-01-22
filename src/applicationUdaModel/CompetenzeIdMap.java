package applicationUdaModel;

import java.util.HashMap;
import java.util.Map;

public class CompetenzeIdMap {
private Map<Integer,Competenze> map;
	
	public CompetenzeIdMap() {
		map=new HashMap<>();
	}
	
	public Competenze get(Competenze competenza) {
		Competenze old = map.get(competenza.getCodCompetenze());
		if(old == null) {
			//vuole dire che nella mappa non c'è questa classe 
			//e devo aggiungerlo
			map.put(competenza.getCodCompetenze(), competenza);
			return competenza;
		}
		return old;
	}
	//inserisco una classe nella mappa
	public void put (Integer codCompetenza, Competenze competenza) {
		map.put(codCompetenza, competenza);
	}
}
