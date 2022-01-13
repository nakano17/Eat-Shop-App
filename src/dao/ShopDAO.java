package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Shop;

/**
 * test
 * shopテーブルのDAOです。
 */
public class ShopDAO {
	// データベースURL
	private String URL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	// ユーザー
	private String USER = "root";
	// パスワード
	private String PASSWORD = "root";

	// SELECT文の準備(INSERT文のidは自動連番なので指定しなくてよい)
	private static final String INSERT_SHOPS_SQL = "INSERT INTO shop" + "  (name, url, comment) VALUES "
			+ " (?, ?, ?);";
	private static final String SELECT_SHOP_BY_ID = "SELECT id,name,url,comment FROM shop WHERE id = ?";
	private static final String SELECT_ALL_SHOPS = "SELECT * FROM shop";
	private static final String DELETE_SHOPS_SQL = "DELETE FROM shop WHERE id = ?;";
	private static final String UPDATE_SHOPS_SQL = "UPDATE shop SET name = ?,url= ?, comment = ? WHERE id = ?;";
	private static final String SELECT_SHOP_RAND = "SELECT * FROM shop ORDER BY RAND() LIMIT 1;";


	protected Connection getConnection() {
		Connection connection = null;

		// JDBCドライバの読み込みとデータベース接続
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * 店の情報を追加(挿入)します。
	 * @param shop 店オブジェクト
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void insertShop(Shop shop) throws SQLException {

		// データベースへの接続の取得、PreparedStatementの取得、SQLステートメントの実行
		try (Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(INSERT_SHOPS_SQL)) {

			// INSERT文中の「?」に使用する値を設定しSQLを完成
			pstmt.setString(1, shop.getName());
			pstmt.setString(2, shop.getUrl());
			pstmt.setString(3, shop.getComment());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 引数で指定したIDの店オブジェクトを返します。
	 * @return shop
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public Shop selectShop(int id) {
		Shop shop = null;

		// データベースへの接続の取得、PreparedStatementの取得、SQLステートメントの実行
		try (Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(SELECT_SHOP_BY_ID);) {
			pstmt.setInt(1, id);

			// SELECTを実行
			ResultSet rs = pstmt.executeQuery();

			// 店名とURLとコメントそれぞれを格納
			while (rs.next()) {
				String name = rs.getString("name");
				String url = rs.getString("url");
				String comment = rs.getString("comment");
				shop = new Shop(id, name, url, comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shop;
	}

	/**
	 * すべての店のリストを返します。
	 * @return shop
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<Shop> selectAllShops() {

		List<Shop> shop = new ArrayList<>();

		// データベースへの接続の取得、PreparedStatementの取得、SQLステートメントの実行
		try (Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(SELECT_ALL_SHOPS);) {

			// SELECTを実行
			ResultSet rs = pstmt.executeQuery();

			// SELECT文の結果をArrayListに格納
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String url = rs.getString("url");
				String comment = rs.getString("comment");
				shop.add(new Shop(id, name, url, comment));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shop;
	}

	/**
	 * 指定された内容の店の情報を削除します。
	 * @param shop 店オブジェクト
	 * @return rowDeleted
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean deleteShop(int id) throws SQLException {
		boolean rowDeleted;

		// データベースへの接続の取得、PreparedStatementの取得、SQLステートメントの実行
		try (Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(DELETE_SHOPS_SQL);) {
			pstmt.setInt(1, id);
			rowDeleted = pstmt.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	/**
	 * 指定された内容の店の情報を更新します。
	 * @param shop 店オブジェクト
	 * @return rowUpdated
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean updateShop(Shop shop) throws SQLException {
		boolean rowUpdated;

		// データベースへの接続の取得、PreparedStatementの取得、SQLステートメントの実行
		try (Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(UPDATE_SHOPS_SQL);) {

			// UPDATE文中の「?」に使用する値を設定しSQLを完成
			pstmt.setString(1, shop.getName());
			pstmt.setString(2, shop.getUrl());
			pstmt.setString(3, shop.getComment());
			pstmt.setInt(4, shop.getId());

			rowUpdated = pstmt.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	/**
	 * ランダムで選ばれた店のリストを1つ返します。
	 * @return shop
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<Shop> randShops() {

		List<Shop> shop = new ArrayList<>();

		// データベースへの接続の取得、PreparedStatementの取得、SQLステートメントの実行
		try (Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(SELECT_SHOP_RAND);) {

			// SELECTを実行
			ResultSet rs = pstmt.executeQuery();

			// SELECT文の結果をArrayListに格納
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String url = rs.getString("url");
				String comment = rs.getString("comment");
				shop.add(new Shop(id, name, url, comment));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shop;
	}
}
