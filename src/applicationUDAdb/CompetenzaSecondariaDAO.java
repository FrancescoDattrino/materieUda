package applicationUDAdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import applicationUdaModel.Allegato;
import applicationUdaModel.CompetenzaSecondariaIdMap;
import applicationUdaModel.Competenze;
import applicationUdaModel.CompetenzeIdMap;
import applicationUdaModel.CompetenzeSecondarie;


public class CompetenzaSecondariaDAO {
	

	public List<CompetenzeSecondarie> listaCompetenzeSecondarie(CompetenzaSecondariaIdMap competenzasecondariamap){
	String sql= "select codCompetenzaSecondaria,codCompetenzaPrimaria,competenzaSecondaria from competenzesecondarie";
	List<CompetenzeSecondarie> result=new ArrayList<>();
	try {
		Connection conn = ConnectDB.getConnection();
		PreparedStatement st = conn.prepareStatement(sql) ;
		
		ResultSet res = st.executeQuery() ;
		
		while(res.next()) {
			
			CompetenzeSecondarie cs=new CompetenzeSecondarie(res.getInt("codCompetenzaSecondaria"),res.getInt("codCompetenzaPrimaria"),res.getString("competenzaSecondaria"));
				result.add(competenzasecondariamap.get(cs));
			
		}
		
		conn.close();
		return result;
	} catch (SQLException e) {
		throw new RuntimeException(e) ;
	}
	}
	
	//ottenere la lista di competenze secondarie dato la competenza primaria
public  void listaCompetenzeSecondarieFromCompetenzaPrimaria (Competenze competenzaprimaria,CompetenzaSecondariaIdMap  competenzasecondariamap) {//CompetenzeIdMap competenzamap
		
		String sql= "select s.codCompetenzaSecondaria,s.codCompetenzaPrimaria,s.competenzaSecondaria " + 
				"from competenzesecondarie as s,competenzeprimarie as p " + 
				"where p.idCompetenzaPrimaria=s.codCompetenzaPrimaria and s.codCompetenzaPrimaria=? ";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql) ;
			st.setInt(1,competenzaprimaria.getCodCompetenze() );
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				
				CompetenzeSecondarie c=new CompetenzeSecondarie(res.getInt("codCompetenzaSecondaria"),
						res.getInt("codCompetenzaPrimaria"),
						res.getString("competenzaSecondaria"));
					 competenzaprimaria.getCompetenzeSecondarie().add(competenzasecondariamap.get(c));
				
			}
			
			conn.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e) ;
		}
	
	}

public boolean create(CompetenzeSecondarie c) {
	String sql = "INSERT INTO `udaipsia`.`competenzesecondarie` (`codCompetenzaPrimaria`, `competenzaSecondaria`) VALUES ( ? , ?);" ;

	try {
		Connection conn = ConnectDB.getConnection();
		PreparedStatement st = conn.prepareStatement(sql) ;
		st.setInt(1,c.getCodCompetenzaPrimaria() );
		st.setString(2,c.getCompetenzaSecondaria() );
		int result = st.executeUpdate() ;//restituisce il numero di query modificate
		
		conn.close();
		
		if(result==1) {
			return true ;
		} else {
			return false ;
		}
		
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	return false ;
	
}


}
