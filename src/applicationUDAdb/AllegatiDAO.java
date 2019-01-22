package applicationUDAdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import applicationUdaModel.Allegato;
import applicationUdaModel.AllegatoIdMap;
import applicationUdaModel.Competenze;


public class AllegatiDAO {
	
	
	/**
	 * lista allegati
	 * @param allegatomap 
	 * @return
	 */
public  List<Allegato> listaAllegati (AllegatoIdMap allegatomap) {
		
		String sql= "Select codAllegato,allegato from allegati";
		List<Allegato> result=new ArrayList<>();
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql) ;
			
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				
				Allegato a=new Allegato(res.getInt("codAllegato"),res.getString("allegato"));
					result.add(allegatomap.get(a));
				
			}
			
			conn.close();
		
		} catch (SQLException e) {
			throw new RuntimeException(e) ;
		}
		
		
		return result;
	}

	public ArrayList<String> listaNomeAllegati() {
		String sql= "select allegato from allegati";
		ArrayList<String> result=new ArrayList<>();
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql) ;
			
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				
				String a=new String(res.getString("allegato"));
					result.add(a);
				
			}
			
			conn.close();
		
		} catch (SQLException e) {
			throw new RuntimeException(e) ;
		}
		
		
		return result;
	}

	public List<Allegato> listAllegati() {
		String sql= "select allegato from allegati";
		List<Allegato> result=new ArrayList<>();
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql) ;
			
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				
				result.add(new Allegato(res.getInt("codAllegati"),res.getString("allegato")));
					
				
			}
			
			conn.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null ;
		}
		
		
		
	}

}
