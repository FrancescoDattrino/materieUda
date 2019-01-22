package applicationUdaModel;

import java.util.HashMap;
import java.util.Map;

public class ClasseSezioneIdMap {
private Map<Integer,ClasseSezione> map;
	
	public ClasseSezioneIdMap() {
		map=new HashMap<>();
	}
	
	public ClasseSezione get(ClasseSezione classesezione) {
		ClasseSezione old = map.get(classesezione.getCodClasseSezione());
		if(old == null) {
			//vuole dire che nella mappa non c'è questa classe 
			//e devo aggiungerlo
			map.put(classesezione.getCodClasseSezione(), classesezione);
			return classesezione;
		}
		return old;
	}
	//inserisco una classe nella mappa
	public void put (Integer codClasseSezione, ClasseSezione classesezione) {
		map.put(codClasseSezione, classesezione);
	}
}
