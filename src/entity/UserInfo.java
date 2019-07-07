package entity;

import java.io.Serializable;

public class UserInfo implements Serializable
{
	/** ユーザID */
	private int userId;

	/** 名前 */
	private String name;

	/** パスワード */
	private String pass;

	/** メールアドレス */
	private String mail;

	/** 住所 */
	private String address;

	public UserInfo ()
	{}

	/**
	 * ユーザIDを取得する。
	 * @return ユーザID
	 */
	public int getUserId ()
	{
		return userId;
	}

	/**
	 * ユーザIDを設定する。
	 * @param ユーザID
	 */
	public void setUserId ( int userId )
	{
		this.userId = userId;
	}

	/**
	 * 名前を取得する。
	 * @return 名前
	 */
	public String getName ()
	{
		return name;
	}

	/**
	 * 名前を設定する。
	 * @param 名前
	 */
	public void setName ( String name )
	{
		this.name = name;
	}

	/**
	 * パスワードを取得する。
	 * @return パスワード
	 */
	public String getPass ()
	{
		return pass;
	}

	/**
	 * パスワードを設定する。
	 * @param パスワード
	 */
	public void setPass ( String pass )
	{
		this.pass = pass;
	}

	/**
	 * メールアドレスを取得する。
	 * @return メールアドレス
	 */
	public String getMail ()
	{
		return mail;
	}

	/**
	 * メールアドレスを設定する。
	 * @param メールアドレス
	 */
	public void setMail ( String mail )
	{
		this.mail = mail;
	}

	/**
	 * 住所を取得する。
	 * @return 住所
	 */
	public String getAddress ()
	{
		return address;
	}

	/**
	 * 住所を設定する。
	 * @param 住所
	 */
	public void setAddress ( String address )
	{
		this.address = address;
	}
}
