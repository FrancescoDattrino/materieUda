package applicationUDAdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import applicationUdaModel.Classe;
import applicationUdaModel.Sezione;
import applicationUdaModel.SezioneIdMap;

public class SezioneDAO {
	
	public List<Sezione> listaSezioni(SezioneIdMap sezionemap) {
		String sql= "select codSezione,nomeSezione from sezione";
		List<Sezione> result=new ArrayList<>();
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql) ;
			
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				
				Sezione s=new Sezione(res.getInt("codSezione"),res.getString("nomeSezione"));
					result.add(sezionemap.get(s));
				
			}
			
			conn.close();
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e) ;
		}
	}
	
/*	public boolean verificaCodiceSezione(int codSezione) {
		String sql= "select codSezione,nomeSezione from sezione where codSezione = ?";
		boolean  v=false;
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql) ;
			st.setInt(1,codSezione );
			ResultSet res = st.executeQuery() ;
			
			if(res.next()) {
				
				return v=true;
				
			}
			
			conn.close();
			return v;
		} catch (SQLException e) {
			throw new RuntimeException(e) ;
		}
		
	}*/

	public List<Sezione> getSezioniFromClassi(Classe classe, SezioneIdMap sezionemap) {
		String sql="select s.codSezione,s.nomeSezione from sezione as s, classisezionimaterie as cs where s.codSezione = cs.codSezione and cs.codClasse=?";
		List<Sezione> result =null;
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql) ;
			st.setInt(1,classe.getCodClasse() );
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				
				Sezione s=new Sezione(res.getInt("codSezione"),res.getString("nomeSezione"));
				classe.getSezioni().add(sezionemap.get(s));
				
			}
			
			conn.close();
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e) ;
		}
	}

}
