package isw2.server;

import isw2.client.UseCaseService;
import isw2.server.UseCaseServiceImpl;
import isw2.shared.TechnicalDTO;


public class TestUseCaseService {
	
	public static void main(String[] args) {
		
		UseCaseService ucs = new UseCaseServiceImpl();
		
		/*
		// probar validateUser()
		boolean l = ucs.validateUser("simo163", "545fsbvvcb");
		System.out.println("logeado : "+l);
		*/
		
		/*
		// probar getTechnicals()
		ArrayList<TechnicalDTO> result = ucs.getTechnicals();

		System.out.println("numero de tecnicos: "+result.size());
		System.out.println("1er: "+ result.get(0));
		System.out.println("1er user: "+ result.get(0).getUser());
		System.out.println("1er password: "+ result.get(0).getPassword());
		*/
		
		/*
		// probar addTechnical
		TechnicalDTO t = new TechnicalDTO();
		t.setUser("adil");
		t.setPassword("321");
		t.setDNI("0987");
		t.setFistName("adil");
		t.setSurName("boukro");
		t.setEmail("dsadsa");
		t.setPhone("fdsfsd");
		ucs.addTechnical(t);
		*/
		
		
		// probar addTechnical
		TechnicalDTO t = new TechnicalDTO();
		t = ucs.getTechnical("simo163");
		t.setEmail("simo163@hotmail.com");
		t.setPhone("9898098");
		ucs.updateTechncial(t);
		
		
		
		
	}

}
