package applicationUdaModel;

import java.util.ArrayList;
import java.util.List;

import applicationUDAdb.AllegatiDAO;
import applicationUDAdb.ClasseDAO;
import applicationUDAdb.CompetenzaSecondariaDAO;
import applicationUDAdb.CompetenzeDAO;
import applicationUDAdb.DisciplineCoinvolteDAO;
import applicationUDAdb.MateriaDAO;
import applicationUDAdb.SezioneDAO;
//import applicationUda.UdaFromMateria;



public class Model {

	private ClasseDAO clsdao;
	private SezioneDAO szndao;
	private CompetenzeDAO cmpdao;
	private AllegatiDAO algdao;
	private MateriaDAO mtrdao;
	private ClasseSezioneDAO csdao;
	private CompetenzaSecondariaDAO cmpsdao;
	private DisciplineCoinvolteDAO dscdao;
	
	private List<Allegato> allegati;
	private List<Competenze> competenze;
	private List<Classe> classi;
	private List<Sezione> sezioni;
	private List<Materia> materie;
	private List<ClasseSezione> classisezioni;
	private List<CompetenzeSecondarie>  competenzesecondarie;
	private List<DisciplineCoinvolte> disciplinecoinvolte;
	
	private ClasseIdMap classemap;
	private SezioneIdMap sezionemap;
	private CompetenzeIdMap competenzamap;
	private AllegatoIdMap allegatomap;
	private MateriaIdMap materiamap;
	private ClasseSezioneIdMap classesezionemap;
	private CompetenzaSecondariaIdMap competenzasecondariamap;
	private DisciplineCoinvolteIdMap disciplinecoinvoltemap;
	

	public Model() {
		//creo gli oggetti dao
		algdao=new AllegatiDAO();
		cmpdao = new CompetenzeDAO();
		clsdao=new ClasseDAO();
		szndao = new SezioneDAO();
		mtrdao=new MateriaDAO();
		csdao=new ClasseSezioneDAO();
		cmpsdao=new CompetenzaSecondariaDAO();
		dscdao=new DisciplineCoinvolteDAO();
		
		//prima di chiamare i metodi del dao per ottenere le liste viene popolato l'idmap
		
		classemap=new ClasseIdMap();
		sezionemap= new SezioneIdMap();
		competenzamap = new CompetenzeIdMap();
		allegatomap=new AllegatoIdMap();
		materiamap=new MateriaIdMap();
		classesezionemap=new ClasseSezioneIdMap();
		competenzasecondariamap=new CompetenzaSecondariaIdMap();
		disciplinecoinvoltemap=new DisciplineCoinvolteIdMap();
		
		allegati=algdao.listaAllegati(allegatomap);
		competenze=cmpdao.listaCompetenze(competenzamap);
		classi=clsdao.mostraClassi(classemap);
		sezioni=szndao.listaSezioni(sezionemap);
		materie=mtrdao.listaMaterie(materiamap);
		classisezioni=csdao.listaClassiSezioni(classesezionemap);
		competenzesecondarie=cmpsdao.listaCompetenzeSecondarie(competenzasecondariamap);
		disciplinecoinvolte=dscdao.listaDisciplineCoinvolte(disciplinecoinvoltemap);
		
		
		
		for(Sezione s:sezioni) {
			clsdao.getClassiFromSezione(s,classemap);
		}
		
		for (Classe c:classi) {
			szndao.getSezioniFromClassi(c,sezionemap);
		}
		
		for(Allegato a:allegati) {
			cmpdao.getCompetenzeFromAllegato(a,competenzamap);
		}
		for(Materia m:materie) {
			clsdao.getClassiFromMateria(m,classemap);
		}
		for (ClasseSezione cs:getClassisezioni()) {
			for(Classe classe:getClassi()) {
				for(Sezione sezione:getSezioni()) {
				if(classe.getCodClasse()==cs.getCodClasse() &&  sezione.getCodSezione()==cs.getCodSezione()) {
							 getMtrdao().getMaterieFromClasseSezione(cs,getMateriamap(), classe, sezione);
						}
					}
				}
			
		}
		for(Competenze cmp :competenze) {
			cmpsdao.listaCompetenzeSecondarieFromCompetenzaPrimaria(cmp, competenzasecondariamap);
		}
		
		for(CompetenzeSecondarie cs:competenzesecondarie) {
			dscdao.getDisciplinecoinvolteFromCompetenzaSecondaria(cs, disciplinecoinvoltemap);
		}
		
		
						
		
	}


//ritorna tutte le classi presenti nella mappa 	
public List<Classe> getClassi() {
	if(this.classi==null) {
		ClasseDAO dao=new ClasseDAO();
		this.classi=dao.mostraClassi(classemap);
		if(this.classi==null)
			throw new RuntimeException("Errore con il database");
	}
		return classi;
	}



public List<CompetenzeSecondarie> getCompetenzesecondarie() {
	return competenzesecondarie;
}


public List<Competenze> getCompetenze() {
	return competenze;
}


public MateriaIdMap getMateriamap() {
	return materiamap;
}


public void setMateriamap(MateriaIdMap materiamap) {
	this.materiamap = materiamap;
}


public MateriaDAO getMtrdao() {
	return mtrdao;
}


public void setMtrdao(MateriaDAO mtrdao) {
	this.mtrdao = mtrdao;
}



public List<Sezione> getSezioni() {

	return sezioni;
}

	
	public List<Allegato> getAllegati() {
	return allegati;
}


	public List<ClasseSezione> getClassisezioni() {
		return classisezioni;
	}




	public List<Competenze> trovaCompetenze(Allegato a) {
		CompetenzeDAO dao = new CompetenzeDAO();
		return dao.listaCompetenzeFromAllegato(a);
	}

	

	public boolean verificaCodiceSezione(int codSezione) {
		
		for(Sezione s:sezioni) {
			if(s.getCodSezione()==codSezione) {
				return true;
			}
		}
		return false;
	}
     

	public boolean verificaCodiceClasse(int CodClasse) {
		
		for(Classe c:classi) {
			if(c.getCodClasse()==CodClasse) {
				return true;
			}                                                        
		}
		   return false;                                                          //versione vecchia senza idmap ClasseDAO dao = new ClasseDAO();
		                                                                 //return dao.verificaCodiceClasse(CodClasse);
	}



	public List<Competenze> getCompetenzePrimarieFromAllegato(int codAllegato) {
		List<Competenze> result =new ArrayList<Competenze>();//>null;
		for(Competenze c:competenze) {
			if(c.getCodAllegato()==codAllegato) {
				result.add(c);
			}
			
		}
		return result;
			
	}

//verifico la presenza del codice inserito tra i codici della tabella allegati
	public boolean verificaCodiceAllegato(int allegato) {
		for(Allegato a:allegati) {
			if (a.getCodAllegato()==allegato) {
				return true;
			}
		}
		return false;
	}


	public boolean verificaCodiceCompetenza(int codAllegatoVerificato, int codCompetenza) {
		for(Allegato a:allegati) {
			if(a.getCodAllegato()==codAllegatoVerificato) {
				for(Competenze c:a.getCompetenze()) {
					if(c.getCodCompetenze()==codCompetenza) {
						return true;
					}
				}
			}
		}return false;
	}


	public List<Materia> getMaterieFromClasseSezione(int classe, int sezione) {
		
		for(ClasseSezione cs:classisezioni) {
			if(cs.getCodClasse()==classe && cs.getCodSezione()==sezione) {
				return cs.getMaterie();
			}
		}
		return null;
	}


	public List<CompetenzeSecondarie> getCompetenzeSecodarieFromCompetenzaPrimaria(int codCompetenze) {
		
		List<CompetenzeSecondarie> result =new ArrayList<CompetenzeSecondarie>();//>null;
		for(CompetenzeSecondarie c:competenzesecondarie) {
			if(c.getCodCompetenzaPrimaria()==codCompetenze) {
				result.add(c);
			}
			
		}
		return result;
	}


	public boolean addCompetenzaSecondaria(CompetenzeSecondarie c) {
		//CompetenzaSecondariaDAO dao = new EsameDAO() ;
		boolean result=cmpsdao.create(c);
		if (result){
			competenzesecondarie=cmpsdao.listaCompetenzeSecondarie(competenzasecondariamap);
		}
		return result ;	
	}


	public boolean addDisciplineCoinvolte(DisciplineCoinvolte newdisciplinacoinvolta) {
		boolean result=dscdao.creaDisciplinaCoinvolta(newdisciplinacoinvolta);
		if (result){
			disciplinecoinvolte=dscdao.listaDisciplineCoinvolte(disciplinecoinvoltemap);
		}
		return result ;	
	}


	public void setMaterie(List<Materia> materie) {
		this.materie = materie;
	}


	public List<Materia> getMaterie() {
		
		return this.materie;
	}


	public List<UdaFromMateria> cercaUdaFromMateria(Materia m) {
		MateriaDAO dao=new MateriaDAO();
		return dao.getUdaFromMateria(m);
		
	}


	public List<DisciplineCoinvolte> getDisciplinecoinvolte() {
		return disciplinecoinvolte;
	}


	public List<UdaFromMateria> cercaUda(DisciplineCoinvolte dc) {
		DisciplineCoinvolteDAO dao =new DisciplineCoinvolteDAO();
		return dao.getUda(dc);
	}


	public List<UdaFromMateria> cercaCompetenza(CompetenzeSecondarie cs) {
		CompetenzaSecondariaDAO dao =new CompetenzaSecondariaDAO();
		return dao.getUdaFromCompetenza(cs);
	}
	
}
