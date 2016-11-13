package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;



/**
 * ユーザーマスタエンティティクラス
 *
 */
@Entity
@Table(name = "user_master")
public class UserMaster extends Model {

	/**
	 * ユーザーID
	 */
	@Id
	@Column(name = "user_id")
	private String userId;

	/**
	 * ユーザー名
	 */
	@Column(name = "user_name")
	private String userName;

	/**
	 * パスワード
	 */
	@Column(name = "password")
	private String password;

	/**
	 * 登録日時
	 */
	@CreatedTimestamp
	@Column(name = "regist_time")
	private Timestamp registTime;

	/**
	 * 更新日時
	 */
	@UpdatedTimestamp
	@Column(name = "update_time")
	private Timestamp updateTime;

	/**
	 * find
	 */
	private static Find<Long, UserMaster> find = new Find<Long, UserMaster>() {
	};

	/**
	 * ユーザーID取得
	 *
	 * @return ユーザーID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * ユーザーID設定
	 *
	 * @param userId
	 *            ユーザーID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * ユーザー名取得
	 *
	 * @return ユーザー名
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * ユーザー名設定
	 *
	 * @param userName
	 *            ユーザー名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * パスワード取得
	 *
	 * @return パスワード
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * パスワード設定
	 *
	 * @param password
	 *            パスワード
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 登録日時取得
	 *
	 * @return 登録日時
	 */
	public Timestamp getRegistTime() {
		return registTime;
	}

	/**
	 * 登録日時設定
	 *
	 * @param registTime
	 *            登録日時
	 */
	public void setRegistTime(Timestamp registTime) {
		this.registTime = registTime;
	}

	/**
	 * 更新日時取得
	 *
	 * @return 更新日時
	 */
	public Timestamp getUpdateTime() {
		return updateTime;
	}

	/**
	 * 更新日時設定
	 *
	 * @param updateTime
	 *            更新日時
	 */
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * find取得
	 *
	 * @return find
	 */
	public static Find<Long, UserMaster> getFind() {
		return find;
	}

	/**
	 * find設定
	 *
	 * @param find
	 *            find
	 */
	public static void setFind(Find<Long, UserMaster> find) {
		UserMaster.find = find;
	}
}