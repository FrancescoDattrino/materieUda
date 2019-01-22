package applicationUDAdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import applicationUdaModel.Classe;
import applicationUdaModel.ClasseSezione;
import applicationUdaModel.Materia;
import applicationUdaModel.MateriaIdMap;
import applicationUdaModel.Sezione;

public class MateriaDAO {

	public List<Materia> listaMaterie(MateriaIdMap materiamap) {
		String sql= "select idMateria, nomeMateria, idAsse from materia";
		List<Materia> result=new ArrayList<>();
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql) ;
			
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				
				Materia m=new Materia(res.getInt("idMateria"),res.getString("nomeMateria"),res.getInt("idAsse"));
				//verifico che la lista non esista già  nella mappa prima di aggiornarla	
				result.add(materiamap.get(m));
				
			}
			
			conn.close();
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e) ;
		}
	}

	public void getMaterieFromClasseSezione(ClasseSezione cs, MateriaIdMap materiamap,Classe classe, Sezione sezione) {
		String sql ="select distinct  m.idMateria,m.nomeMateria,m.idAsse from materia as m,classisezionimaterie as csm  where csm.codClasse=? and csm.codSezione=? and csm.codMateria=m.idMateria ";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql) ;
			st.setInt(1, classe.getCodClasse() );
			st.setInt(2, sezione.getCodSezione());
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				
				Materia m=new Materia(res.getInt("idMateria"),res.getString("nomeMateria"),res.getInt("idAsse"));
				cs.getMaterie().add(materiamap.get(m));
				
			}
			
			conn.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e) ;
		}
		
	}


		
	

}
