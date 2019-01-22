package applicationUDAdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import applicationUdaModel.Allegato;
import applicationUdaModel.Classe;
import applicationUdaModel.Competenze;
import applicationUdaModel.CompetenzeIdMap;
import applicationUdaModel.Sezione;


public class CompetenzeDAO {
	
	/**
	 * lista di tutte le competenze
	 * @param competenzamap 
	 */
public  List<Competenze> listaCompetenze (CompetenzeIdMap competenzamap) {
		
		String sql= "select idCompetenzaPrimaria,codAllegati,competenzaPrimaria from competenzeprimarie";
		List<Competenze> result=new ArrayList<>();
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql) ;
			
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				
				Competenze c=new Competenze(res.getInt("idCompetenzaPrimaria"),
						res.getInt("codAllegati"),
						res.getString("competenzaPrimaria"));
					result.add(competenzamap.get(c));
				
			}
			
			conn.close();
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e) ;
		}
		
		
	
	}
/**
 * 	trova la lista competenze dato l'allegato
 * @param allegato
 * @return
 */
public  List<Competenze> listaCompetenzeFromAllegato (Allegato allegato) {
		
		String sql= "select c.idCompetenzaPrimaria,c.allegato,c.competenzaPrimaria " + 
				"from competenzeprimarie as c, allegati as a " + 
				"where a.codAllegati=? and a.allegato=c.allegato";
		List<Competenze> result=new ArrayList<>();
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql) ;
			st.setInt(1,allegato.getCodAllegato() );
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				
				Competenze c=new Competenze(res.getInt("idCompetenzaPrimaria"),
						res.getInt("allegato"),
						res.getString("competenzaPrimaria"));
					result.add(c);
				
			}
			
			conn.close();
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e) ;
		}
		
		
	
	}
/**
 * trova la competenza dato il codice della competenza
 * @param codCompetenze
 * @return
 */
	
	public  Competenze cerca (int codCompetenze) {
		
		String sql= "select idCompetenzaPrimaria,allegati,competenzaPrimaria from competenzeprimarie where idCompetenzaPrimaria= ? ";
		Competenze result=null;
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql) ;
			st.setInt(1,codCompetenze );
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				if(res!=null) {
				result=new Competenze(res.getInt("idCompetenzaPrimaria"),
						res.getInt("allegati"),
						res.getString("competenzaPrimaria"));}
				
			}
			
			conn.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e) ;
		}
		
		return result;
	
	}
	/**
	 * trova la lista string delle competenze solo il nome
	 * @return
	 */
public  ArrayList<String> listaNomeCompetenze () {
		
		String sql= "select competenzaPrimaria from competenzeprimarie";
		ArrayList<String> result=new ArrayList<>();
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql) ;
			
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				
				String s=new String(res.getString("competenzaPrimaria"));
					result.add(s);
				
			}
			
			conn.close();
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e) ;
		}
		
		
	
	}
	public void getCompetenzeFromAllegato(Allegato allegato, CompetenzeIdMap competenzamap) {
		String sql="Select idCompetenzaPrimaria,codAllegati,competenzaPrimaria from competenzeprimarie,allegati where codAllegato=codAllegati and codAllegato=?";
		
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql) ;
			st.setInt(1, allegato.getCodAllegato());
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				
				Competenze c=new Competenze(res.getInt("idCompetenzaPrimaria"),
						res.getInt("codAllegati"),
						res.getString("competenzaPrimaria"));
					allegato.getCompetenze().add(competenzamap.get(c));
				
			}
			
			conn.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e) ;
		}
		
		
	}



}
