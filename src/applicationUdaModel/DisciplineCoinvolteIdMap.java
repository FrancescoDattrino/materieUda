package applicationUdaModel;

import java.util.HashMap;
import java.util.Map;

public class DisciplineCoinvolteIdMap {
	
		
		private Map<Integer,DisciplineCoinvolte> map;
		
		public DisciplineCoinvolteIdMap() {
			map=new HashMap<>();
		}
		
		public DisciplineCoinvolte get(DisciplineCoinvolte disciplinecoinvolte) {
			DisciplineCoinvolte old = map.get(disciplinecoinvolte.getCodDisciplineCoinvolte());
			if(old == null) {
				//vuole dire che nella mappa non c'è questa classe 
				//e devo aggiungerlo
				map.put(disciplinecoinvolte.getCodDisciplineCoinvolte(), disciplinecoinvolte);
				return disciplinecoinvolte;
			}
			return old;
		}
		//inserisco una classe nella mappa
		public void put (Integer codDisciplineCoinvolte, DisciplineCoinvolte disciplinacoinvolta) {
			map.put(codDisciplineCoinvolte, disciplinacoinvolta);
		}
	

}
