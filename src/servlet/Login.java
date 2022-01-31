package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.UserLogin;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		// UserLoginインスタンス（ユーザー情報）の生成
		UserLogin userLogin = new UserLogin(name, pass);

		// ログイン処理
		LoginLogic loginLogic = new LoginLogic();
		boolean isLogin = loginLogic.execute(userLogin);

		// ログイン成功時の処理
		if (isLogin) {
			// ユーザー情報をセッションスコープに保存
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", userLogin);

			// ログイン結果画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("ShopServlet");
			dispatcher.forward(request, response);
		} else { // ログイン失敗時
		    // リダイレクト
			response.sendRedirect("/Jisyuseisaku/");
		}
	}
}
