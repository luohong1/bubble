package org.bubble.domain;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author luohong
 * @since 2018-12-26
 */
@TableName("sys_user")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	@TableId(value="ID", type= IdType.AUTO)
	private Long id;
    /**
     * 创建时间
     */
	@TableField("CREATE_TIME")
	private Date createTime;
    /**
     * 版本号
     */
	@TableField("VERSION")
	private Integer version;
    /**
     * 账号
     */
	@TableField("USER_CODE")
	private String userCode;
    /**
     * 用户名
     */
	@TableField("USER_NAME")
	private String userName;
    /**
     * 密码
     */
	@TableField("USER_PWD")
	private String userPwd;
    /**
     * 用户类型（0:超级管理员，1:普通操作员）
     */
	@TableField("USER_TYPE")
	private String userType;
    /**
     * 状态（0:正常，1:冻结）
     */
	@TableField("STATUS")
	private Integer status;
    /**
     * 最后输错密码时间
     */
	@TableField("PWD_ERROR_TIME")
	private Date pwdErrorTime;
    /**
     * 连续输错密码次数(连续5次输错就冻结帐号)
     */
	@TableField("PWD_ERROR_COUNT")
	private Integer pwdErrorCount;
    /**
     * 最后登录时间
     */
	@TableField("LAST_LOGIN_TIME")
	private Date lastLoginTime;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getPwdErrorTime() {
		return pwdErrorTime;
	}

	public void setPwdErrorTime(Date pwdErrorTime) {
		this.pwdErrorTime = pwdErrorTime;
	}

	public Integer getPwdErrorCount() {
		return pwdErrorCount;
	}

	public void setPwdErrorCount(Integer pwdErrorCount) {
		this.pwdErrorCount = pwdErrorCount;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	@Override
	public String toString() {
		return "SysUser{" +
			"id=" + id +
			", createTime=" + createTime +
			", version=" + version +
			", userCode=" + userCode +
			", userName=" + userName +
			", userPwd=" + userPwd +
			", userType=" + userType +
			", status=" + status +
			", pwdErrorTime=" + pwdErrorTime +
			", pwdErrorCount=" + pwdErrorCount +
			", lastLoginTime=" + lastLoginTime +
			"}";
	}
}
