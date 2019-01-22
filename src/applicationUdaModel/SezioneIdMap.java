package applicationUdaModel;

import java.util.HashMap;
import java.util.Map;

public class SezioneIdMap {
	
	private Map<Integer,Sezione> map;
	
	public SezioneIdMap() {
		map=new HashMap<>();
	}
	
	public Sezione get(Sezione sezione) {
		Sezione old = map.get(sezione.getCodSezione());
		if(old == null) {
			//vuole dire che nella mappa non c'è questa sezione 
			//e devo aggiungerlo
			map.put(sezione.getCodSezione(), sezione);
			return sezione;
		}
		return old;
	}
	//inserisco una classe nella mappa
	public void put (Integer codSezione, Sezione sezione) {
		map.put(codSezione, sezione);
	}

}
