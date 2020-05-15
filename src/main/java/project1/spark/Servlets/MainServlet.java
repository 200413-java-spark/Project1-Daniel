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
		resp.getWriter().println();
		resp.getWriter().println("The output below is formatted in the following format:");
		resp.getWriter().println();
		resp.getWriter().println("1. The total number of players in the database excluding GK");
		resp.getWriter().println("2. The average age of all players");
		resp.getWriter().println("3. The count of all nationalities");
		resp.getWriter().println("4. The count of all overall ratings");
		resp.getWriter().println("5. The count of all potential ratings");
		resp.getWriter().println("6. The average value in Euros of all players");
		resp.getWriter().println("7. The number of 5 star, 4 star, 3 star, 2 star, 1 star weak foot players");
		resp.getWriter().println("8. The number of  5 star, 4 star, 3 star, 2 star, 1 star skill moves players");
		resp.getWriter().println("9. The count of all positions in the game");
		resp.getWriter().println("10. The average pace attribute/stat of all players");
		resp.getWriter().println("11. The average shooting attribute/stat of all players");
		resp.getWriter().println("12. The average passing attribute/stat of all players");
		resp.getWriter().println("13. The average dribbling attribute/stat of all players");
		resp.getWriter().println("14. The average defending attribute/stat of all players");
		resp.getWriter().println("15. The average physical attribute/stat of all players");
		resp.getWriter().println();
		resp.getWriter().println();
		resp.getWriter().println("Data Retrieved from Database");
		resp.getWriter().println();
		// Reading the content from the database
		SqlDataSource dataSource = SqlDataSource.getInstance();
		SqlSparkRepository sqlData = new SqlSparkRepository(dataSource);
		sqlData.readAll();
		LinkedHashMap<String, String> playerData = sqlData.readAll();
		
		for (String name : playerData.keySet()) {
			resp.getWriter().println(playerData.get(name));
		}
	}
}
