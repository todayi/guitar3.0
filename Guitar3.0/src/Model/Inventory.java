package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Dao.GuitarDao;
import DaoImpl.GuitarDaoImpl;


public class Inventory {
		private List guitars =new ArrayList<>();
		

		public List<Guitar> getGuitars() {
			return guitars;
		}

		public void setGuitars(List guitars) {
			this.guitars = guitars;
		}
		
		
		public void addGuitar(Guitar guitar){
			Guitar g = new Guitar();
			if(guitar.getPrice()>0)
				g.setPrice(guitar.getPrice());
			if(guitar.getSerialNumber().length()>0)
				g.setSerialNumber(guitar.getSerialNumber());
			if(guitar.getGuitarSpec()!=null)
				g.setGuitarSpec(guitar.getGuitarSpec());
				guitars.add(g);
		}
		
		public List FindGuitars(Guitar guitar) throws Exception{
			List matchingGuitars = new ArrayList();
			GuitarDao guitarDao = new GuitarDaoImpl();
			for(Iterator i = guitarDao.findALL().iterator(); i.hasNext();){
				Guitar exGuitar = (Guitar)i.next();	
				System.out.println(exGuitar.getId());
				if(exGuitar.getGuitarSpec().matches(guitar.getGuitarSpec())){
				if(exGuitar.getPrice()!=guitar.getPrice() || guitar.getPrice()==0){
				matchingGuitars.add(exGuitar);
				}
				}
			}
			return matchingGuitars;
		}
}
