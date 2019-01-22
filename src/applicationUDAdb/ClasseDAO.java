package applicationUDAdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import applicationUdaModel.Classe;
import applicationUdaModel.ClasseIdMap;
import applicationUdaModel.Materia;
import applicationUdaModel.Sezione;

public class ClasseDAO {
	
	public List<Classe> mostraClassi(ClasseIdMap classemap) {
		String sql= "select CodClasse,nomeClasse from classe";
		List<Classe> result=new ArrayList<>();
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql) ;
			
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				
				Classe c=new Classe(res.getInt("CodClasse"),res.getString("nomeClasse"));
				//verifico che la lista non esista già  nella mappa prima di aggiornarla	
				result.add(classemap.get(c));
				
			}
			
			conn.close();
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e) ;
		}
	}
	public boolean verificaCodiceClasse(int codClasse) {
		String sql= "select CodClasse,nomeClasse from classe where CodClasse = ?";
		boolean  v=false;
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql) ;
			st.setInt(1,codClasse );
			ResultSet res = st.executeQuery() ;
			
			if(res.next()) {
				
				return v=true;
				
			}
			
			conn.close();
			return v;
		} catch (SQLException e) {
			throw new RuntimeException(e) ;
		}
	}
	public List<Classe> getClassiFromSezione(Sezione sezione, ClasseIdMap classemap) {
		String sql="select c.CodClasse,c.nomeClasse from classe as c ,classisezionimaterie as cs where cs.codClasse=c.CodClasse and  cs.codSezione = ?";
		List<Classe> result = null;
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql) ;
			st.setInt(1,sezione.getCodSezione() );
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				
				Classe c=new Classe(res.getInt("CodClasse"),res.getString("nomeClasse"));
				sezione.getClassi().add(classemap.get(c));
				
			}
			
			conn.close();
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e) ;
		}
	}
	public List<Classe> getClassiFromMateria(Materia materia, ClasseIdMap classemap) {
		String sql="select distinct c.CodClasse,c.nomeClasse from classe as c,classisezionimaterie as csm where csm.codClasse=c.CodClasse and csm.codMateria=?";
		List<Classe> result = null;
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql) ;
			st.setInt(1,materia.getIdMateria() );
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				
				Classe c=new Classe(res.getInt("CodClasse"),res.getString("nomeClasse"));
				materia.getClassi().add(classemap.get(c));
				
			}
			
			conn.close();
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e) ;
		}
		
	}

}
