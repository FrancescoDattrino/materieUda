package applicationUdaModel;


	import java.util.HashMap;
	import java.util.Map;

	public class CompetenzaSecondariaIdMap {
		
		private Map<Integer,CompetenzeSecondarie> map;
		
		public CompetenzaSecondariaIdMap() {
			map=new HashMap<>();
		}
		
		public CompetenzeSecondarie get(CompetenzeSecondarie competenzasecondaria) {
			CompetenzeSecondarie old = map.get(competenzasecondaria.getCodCompetenzaSecondaria());
			if(old == null) {
				//vuole dire che nella mappa non c'è questa classe 
				//e devo aggiungerlo
				map.put(competenzasecondaria.getCodCompetenzaSecondaria(), competenzasecondaria);
				return competenzasecondaria;
			}
			return old;
		}
		//inserisco una classe nella mappa
		public void put (Integer codCompetenzaSecondaria, CompetenzeSecondarie competenzasecondaria) {
			map.put(codCompetenzaSecondaria, competenzasecondaria);
		}
	}

	
