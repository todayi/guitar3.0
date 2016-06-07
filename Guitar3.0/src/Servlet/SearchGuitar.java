package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.GuitarDao;
import DaoImpl.GuitarDaoImpl;
import Enum.builder;
import Enum.type;
import Enum.wood;
import Factory.DaoFactory;
import Model.Guitar;
import Model.GuitarSpec;
import Model.Inventory;
import jdbc.lianjie;

/**
 * Servlet implementation class SearchGuitar
 */
@WebServlet("/SearchGuitar")
public class SearchGuitar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchGuitar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Inventory inventory = null;
		try {
			inventory = initialize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String model1 =null,builder1 = null,type1=null,backwood1=null,topwood1=null;
		Guitar tg = new Guitar();
		GuitarSpec guitarSpec = new GuitarSpec();
		if(!request.getParameter("model").equals("")){
			model1=request.getParameter("model");
			guitarSpec.setModel(model1);
		}
		if(request.getParameter("type")!=null){
			type1=request.getParameter("type");
			guitarSpec.setType(type.valueOf(type1));
		}
		if(request.getParameter("builder")!=null){
			builder1=request.getParameter("builder");
			guitarSpec.setBuilder(builder.valueOf(builder1));
		}
		if(request.getParameter("backwood")!=null){
			
			backwood1=request.getParameter("backwood");
			guitarSpec.setBackWood(wood.valueOf(backwood1));
		}
		if(request.getParameter("topwood")!=null){
			topwood1=request.getParameter("topwood");
			guitarSpec.setTopWood(wood.valueOf(topwood1));
		}
		
		
		tg.setGuitarSpec(guitarSpec);
		try {
			inventory.FindGuitars(tg);
			inventory.setGuitars(inventory.FindGuitars(tg));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("result", inventory);
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}
	
	public Inventory initialize() throws Exception {
		GuitarDao guitarDao = new GuitarDaoImpl();
		List<Guitar> guitars = guitarDao.findALL();
		Iterator<Guitar> iguitar = guitars.iterator();
		Inventory inventory = new Inventory();
		while (iguitar.hasNext()) {
			Guitar guitar = iguitar.next();
			inventory.addGuitar(guitar);
		}
		return inventory;
	}

}
