package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Dao.GuitarDao;
import Enum.builder;
import Enum.type;
import Enum.wood;
import Factory.DaoFactory;
import Model.Guitar;
import Model.GuitarSpec;
import jdbc.lianjie;

public class GuitarDaoImpl implements GuitarDao {
	DaoFactory daoFactory = new DaoFactory();
	Connection conn = daoFactory.createLianjie("sqlite").getConnection();
	PreparedStatement pstmt = null;
	
	@Override
	public List<Guitar> findALL() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from guitar order by id DESC";
		List guitars = new ArrayList();
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
			guitar.setId(rs.getInt("id"));
			System.out.println(rs.getInt("id"));
			guitar.setGuitarSpec(gs);
			guitars.add(guitar);
		}
		return guitars;
	}



	@Override
	public void addGuitar(Guitar guitar) throws Exception{
		// TODO Auto-generated method stub
		String model =null,builder = null,type=null,backwood=null,topwood=null,serialNumber=null;
		double price= guitar.getPrice();
		model=guitar.getGuitarSpec().getModel();
		serialNumber=guitar.getSerialNumber();
		if(guitar.getGuitarSpec()!=null){
			builder = guitar.getGuitarSpec().getBuilder().toString();
			type = guitar.getGuitarSpec().getType().toString();
			backwood = guitar.getGuitarSpec().getBackWood().toString();
			topwood = guitar.getGuitarSpec().getTopWood().toString();
		}
		String sql = "insert into guitar(builder,backwood,topwood,model,type,price,serialNumber) values(?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,builder);
		pstmt.setString(2,backwood);
		pstmt.setString(3,topwood);
		pstmt.setString(4,model);
		pstmt.setString(5,type);
		pstmt.setDouble(6,price);
		pstmt.setString(7,serialNumber);
		pstmt.executeUpdate();
		
	}
	
	@Override
	public boolean deleteGuitar(int id) throws Exception{
		String sql = "delete from guitar where id=?";
		Boolean test = false;
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		int rs = pstmt.executeUpdate();
		if (rs>0) {
			test=true;
		}
		
		return test;
		// TODO Auto-generated method stub
		

	}





}
