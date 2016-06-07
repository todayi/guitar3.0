package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Enum.builder;
import Enum.type;
import Enum.wood;
import Factory.DaoFactory;
import Model.Guitar;
import Model.GuitarSpec;
import Model.Inventory;
import jdbc.lianjie;



public class test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		DaoFactory daoFactory = new DaoFactory();
		Inventory inventory = new Inventory();
		List guitars = new ArrayList();
		
		Connection conn = daoFactory.createLianjie("sqlite").getConnection();
		PreparedStatement pstmt = null;
		String sql = "select * from guitar";
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Guitar guitar = new Guitar();
			GuitarSpec gs= new GuitarSpec();
			gs.setBuilder(builder.valueOf(rs.getString("builder")));
			gs.setBackWood(wood.valueOf(rs.getString("backwood")));
			gs.setTopWood(wood.valueOf(rs.getString("topwood")));
			gs.setModel(rs.getString("model"));
			gs.setType(type.valueOf(rs.getString("type")));
			guitar.setPrice(rs.getDouble("price"));
			guitar.setSerialNumber(rs.getString("serialNumber"));
			guitar.setGuitarSpec(gs);
			guitars.add(guitar);
		}
		inventory.setGuitars(guitars);
		System.out.print(inventory.getGuitars().size());
		
//		GuitarSpec guitarSpec = new GuitarSpec();
//		guitarSpec.setBackWood(wood.a);
//		guitarSpec.setBuilder(builder.a);
//		guitarSpec.setModel("a");
//		guitarSpec.setTopWood(wood.a);
//		guitarSpec.setType(type.a);
//		Guitar guitar =new Guitar();
//		guitar.setGuitarSpec(guitarSpec);
//		guitar.setPrice(1);
//		guitars.add(guitar);
//		inventory.setGuitars(guitars);
//
//		GuitarSpec guitarSpec1 = new GuitarSpec();
//		guitarSpec1.setBackWood(wood.b);
//		guitarSpec1.setBuilder(builder.b);
//		guitarSpec1.setModel("b");
//		guitarSpec1.setTopWood(wood.b);
//		guitarSpec1.setType(type.b);
//		Guitar guitar1 = new Guitar();
//		guitar1.setGuitarSpec(guitarSpec1);
//		guitar1.setPrice(1);
//		inventory.addGuitar(guitar1);
//
//		
//		
//		System.out.println("fir:"+inventory.FindGuitars(guitar1).size());
//		guitarSpec1.setType(type.c);
//		guitar1.setGuitarSpec(guitarSpec1);
//		System.out.print("sec:"+inventory.FindGuitars(guitar1).size());
	}

}
