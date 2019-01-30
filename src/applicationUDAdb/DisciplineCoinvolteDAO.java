package applicationUDAdb;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import applicationUdaModel.Classe;
import applicationUdaModel.ClasseSezione;
import applicationUdaModel.CompetenzeSecondarie;
import applicationUdaModel.DisciplineCoinvolte;
import applicationUdaModel.DisciplineCoinvolteIdMap;
import applicationUdaModel.Materia;
import applicationUdaModel.MateriaIdMap;
import applicationUdaModel.Sezione;
import applicationUdaModel.UdaFromMateria;

public class DisciplineCoinvolteDAO {

	public List<DisciplineCoinvolte> listaDisciplineCoinvolte(DisciplineCoinvolteIdMap disciplinecoinvoltemap) {
		String sql= "select codDisciplineCoinvolte,ore,peso,argomento,dataInizio,dataFine,codClasse,codSezione,codMateria,codCompetenzaSecondaria,uda " + 
				"from disciplinecoinvolte";
		List<DisciplineCoinvolte> result=new ArrayList<>();
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql) ;
			
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				
				DisciplineCoinvolte c=new DisciplineCoinvolte(res.getInt("codDisciplineCoinvolte"),res.getInt("ore"),res.getInt("peso"),
						res.getString("argomento"),res.getDate("dataInizio").toLocalDate(),res.getDate("dataFine").toLocalDate(),res.getInt("codClasse"),res.getInt("codSezione"),
						res.getInt("codMateria"),res.getInt("codCompetenzaSecondaria"),res.getString("uda"));
				//verifico che la lista non esista già  nella mappa prima di aggiornarla	
				result.add(disciplinecoinvoltemap.get(c));
				
			}
			
			conn.close();
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e) ;
		}
	}

	public void getDisciplinecoinvolteFromCompetenzaSecondaria(CompetenzeSecondarie cs,
			DisciplineCoinvolteIdMap disciplinecoinvoltemap) {
		String sql="select dc.codDisciplineCoinvolte,dc.ore,dc.peso,dc.argomento,dc.dataInizio,dc.dataFine,dc.codClasse,dc.codSezione,dc.codMateria,dc.codCompetenzaSecondaria,dc.uda " + 
				"from disciplinecoinvolte as dc, competenzesecondarie as cs " + 
				"where dc.codCompetenzaSecondaria=cs.codCompetenzaSecondaria and cs.codCompetenzaSecondaria=?";
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql) ;
			st.setInt(1,cs.getCodCompetenzaSecondaria() );
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				
				DisciplineCoinvolte dc=new DisciplineCoinvolte(res.getInt("codDisciplineCoinvolte"),res.getInt("ore"),res.getInt("peso"),
						res.getString("argomento"),res.getDate("dataInizio").toLocalDate(),res.getDate("dataFine").toLocalDate(),res.getInt("codClasse"),res.getInt("codSezione"),
						res.getInt("codMateria"),res.getInt("codCompetenzaSecondaria"),res.getString("uda"));
					 cs.getDisciplineCoinvolte().add(disciplinecoinvoltemap.get(dc));
				
			}
			
			conn.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e) ;
		}
	
	}

	public boolean creaDisciplinaCoinvolta(DisciplineCoinvolte dc) {
		String sql="INSERT IGNORE INTO udaipsia.disciplinecoinvolte ( ore,peso,argomento,dataInizio,dataFine,codClasse,codSezione,codMateria,codCompetenzaSecondaria,uda) VALUES (?,?,?,?,?,?,?,?,?,?)";
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql) ;
			st.setInt(1,dc.getOre() );
			st.setInt(2, dc.getPeso());
			st.setString(3, dc.getArgomento());
			st.setDate(4, Date.valueOf(dc.getDataInizio()));
			st.setDate(5, Date.valueOf(dc.getDataFine()));
			st.setInt(6, dc.getCodClasse());
			st.setInt(7, dc.getCodSezione());
			st.setInt(8, dc.getIdMateria());
			st.setInt(9,dc.getCodCompetenzaSecondarie() );
			st.setString(10, dc.getUda());
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

	public List<UdaFromMateria> getUda(DisciplineCoinvolte dc) {
		String sql="select dc.uda,cs.competenzaSecondaria,m.nomeMateria,dc.ore,dc.peso,dc.dataInizio,dc.dataFine,c.nomeClasse,s.nomeSezione " + 
				" from competenzesecondarie as cs,disciplinecoinvolte as dc,materia as m,classe as c,sezione as s " + 
				" where m.idMateria=dc.codMateria and cs.codCompetenzaSecondaria=dc.codCompetenzaSecondaria and c.CodClasse=dc.codClasse " + 
				" and s.codSezione=dc.codSezione and dc.codDisciplineCoinvolte=?";
		List<UdaFromMateria> result=new ArrayList<>();
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql) ;
			st.setInt(1, dc.getCodDisciplineCoinvolte() );
			ResultSet res = st.executeQuery() ;
			while(res.next()) {				
				UdaFromMateria udaFromMateria=new UdaFromMateria(res.getString("uda"),res.getString("competenzaSecondaria"),
						res.getString("nomeMateria"),res.getInt("ore"),res.getInt("peso"),res.getDate("dataInizio").toLocalDate(),
						res.getDate("dataFine").toLocalDate(),res.getString("nomeclasse"),res.getString("nomeSezione"));
				
				result.add(udaFromMateria);
			}			
			conn.close();
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e) ;
		}
				
	}
		
	
}