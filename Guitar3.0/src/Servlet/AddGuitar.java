package Servlet;

import java.io.IOException;
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
import Model.Guitar;
import Model.GuitarSpec;
import Model.Inventory;

/**
 * Servlet implementation class AddGuitar
 */
@WebServlet("/AddGuitar")
public class AddGuitar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGuitar() {
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
		
		Guitar guitar = new Guitar();
		GuitarDao guitarDao = new GuitarDaoImpl();
		String model =null,backwood=null,topwood=null,serialNumber=null;
		builder builder= null;
		type type=null;
		Double price = 0.00;
		GuitarSpec guitarSpec = new GuitarSpec();
		if(!request.getParameter("model").equals("")){
			model=request.getParameter("model");
			guitarSpec.setModel(model);
		}
		if(request.getParameter("type")!=null){
			type=type.valueOf(request.getParameter("type"));
			guitarSpec.setType(type);
		}
		if(request.getParameter("builder")!=null){
			builder=builder.valueOf(request.getParameter("builder"));
			guitarSpec.setBuilder(builder);
		}
		if(request.getParameter("backwood")!=null){
			backwood=request.getParameter("backwood");
			guitarSpec.setBackWood(wood.valueOf(backwood));
		}
		if(request.getParameter("topwood")!=null){
			topwood=request.getParameter("topwood");
			guitarSpec.setTopWood(wood.valueOf(topwood));
		}
		price = Double.valueOf(request.getParameter("price"));
		if(request.getParameter("serialNumber")!=null){
			serialNumber=request.getParameter("serialNumber");
		}
		guitar.setPrice(price);
		guitar.setSerialNumber(serialNumber);
		guitar.setGuitarSpec(guitarSpec);
		try {
			guitarDao.addGuitar(guitar);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("notice", "成功添加吉他");
		request.getRequestDispatcher("notice.jsp").forward(request, response);
	}

}
