package model;

/**
 * 店の情報
 */
public class Shop {

	/**
	 * ID
	 */
	protected int id;

	/**
	 * 店名
	 */
	protected String name;

	/**
	 * 食べログURL
	 */
	protected String url;

	/**
	 * コメント
	 */
	protected String comment;

	public Shop() {
	}

	public Shop(String name, String url, String comment) {
		super();
		this.name = name;
		this.url = url;
		this.comment = comment;
	}

	public Shop(int id, String name, String url, String comment) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.comment = comment;
	}

	/**
	 * フィールドidの値を返します。
	 * @return ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * フィールドidの値を設定します。
	 * @param id ID
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * フィールドnameの値を返します。
	 * @return 店名
	 */
	public String getName() {
		return name;
	}

	/**
	 * フィールドnameの値を設定します。
	 * @param name 店名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * フィールドurlの値を返します。
	 * @return 食べログURL
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * フィールドurlの値を設定します。
	 * @param url 食べログURL
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * フィールドcommentの値を返します。
	 * @return コメント
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * フィールドcommentの値を設定します。
	 * @param comment コメント
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
}