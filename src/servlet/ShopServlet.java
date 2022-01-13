package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ShopDAO;
import model.Shop;

/**
 * Servlet implementation class ShopServlet
 */
@WebServlet("/")
public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShopDAO shopDAO;

	public void init() {

		// DAOの生成
		shopDAO = new ShopDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getServletPath();

		try {
			switch (action) {

			// 新規追加フォーム
			case "/new":
				showNewForm(request, response);
				break;

			// 新規追加処理
			case "/insert":
				insertShop(request, response);
				break;

			// 削除処理
			case "/delete":
				deleteShop(request, response);
				break;

			// 編集フォーム
			case "/edit":
				showEditForm(request, response);
				break;

			// 更新処理
			case "/update":
				updateShop(request, response);
				break;

			// ランダム処理
			case "/random":
				randShop(request, response);
				break;

			// 全表示
			default:
				listShop(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listShop(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Shop> listShop = shopDAO.selectAllShops();
		request.setAttribute("listShop", listShop);
		RequestDispatcher dispatcher = request.getRequestDispatcher("shop-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("shop-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Shop existingShop = shopDAO.selectShop(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("shop-form.jsp");
		request.setAttribute("user", existingShop);
		dispatcher.forward(request, response);
	}

	private void insertShop(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String url = request.getParameter("url");
		String comment = request.getParameter("comment");
		Shop newShop = new Shop(name, url, comment);
		shopDAO.insertShop(newShop);
		response.sendRedirect("list");
	}

	private void updateShop(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String url = request.getParameter("url");
		String comment = request.getParameter("comment");

		Shop book = new Shop(id, name, url, comment);
		shopDAO.updateShop(book);
		response.sendRedirect("list");
	}

	private void deleteShop(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		shopDAO.deleteShop(id);
		response.sendRedirect("list");
	}

	private void randShop(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Shop> randShop = shopDAO.randShops();
		request.setAttribute("randShop", randShop);
		RequestDispatcher dispatcher = request.getRequestDispatcher("shop-random.jsp");
		dispatcher.forward(request, response);
	}
}
