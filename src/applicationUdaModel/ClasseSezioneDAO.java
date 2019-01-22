package applicationUdaModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import applicationUDAdb.ConnectDB;

public class ClasseSezioneDAO {
	public List<ClasseSezione> listaClassiSezioni(ClasseSezioneIdMap classesezionemap) {
		String sql= "select codClasseSezione,codClasse,codSezione from classisezioni";
		List<ClasseSezione> result=new ArrayList<>();
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql) ;
			
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				
				ClasseSezione cs=new ClasseSezione(res.getInt("codClasseSezione"),res.getInt("codClasse"),res.getInt("codSezione"));
				//verifico che la lista non esista già  nella mappa prima di aggiornarla	
				result.add(classesezionemap.get(cs));
				
			}
			
			conn.close();
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e) ;
		}
	}

}
