package applicationUdaModel;

import java.util.ArrayList;
import java.util.List;

public class TestModel {

	public static void main(String[] args) {
	//List<CompetenzeSecondarie> competenzesecondarie=new ArrayList<>();
	Model model= new Model();
	
	for(Competenze c:model.getCompetenze()) {
		for(CompetenzeSecondarie cs:c.getCompetenzeSecondarie()) {
			System.out.println(cs.toString());
		}
		
	}
	}
}
	
	

