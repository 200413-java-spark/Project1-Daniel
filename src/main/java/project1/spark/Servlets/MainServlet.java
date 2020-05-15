package project1.spark.Servlets;

import java.io.IOException;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project1.spark.io.SqlDataSource;
import project1.spark.io.SqlSparkRepository;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("FIFA 20 Database Analysis");
		
		SqlDataSource dataSource = SqlDataSource.getInstance();
		SqlSparkRepository sqlData = new SqlSparkRepository(dataSource);
		sqlData.readAll();
		LinkedHashMap<String, String> playerData = sqlData.readAll();
		
		for (String name : playerData.keySet()) {
			resp.getWriter().println(playerData.get(name));
		}
	}
}
