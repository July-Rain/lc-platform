package lc.platform.admin.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色
 * 
 * @author sinorock.net
 * @email ${email}
 * @date 2019-03-23 14:50:54
 */
@TableName("sys_record")
public class SysRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 预约的记录的id
	 */
	@TableId
	private String id;
	/**
	 * 人名
	 */
	private String userName;
	/**
	 * 晚归时间
	 */
	private Date recordTime;
	/**
	 * 晚归原因
	 */
	private String reason;
	/**
	 * 联系电话
	 */
	private String phone;
	/**
	 * 宿舍号
	 */
	private String roomCode;
	/**
	 * 教师联系电话
	 */
	private String teachePone;
	/**
	 * 记录人
	 */
	private String recordName;
	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 设置：预约的记录的id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：预约的记录的id
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：人名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：人名
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：晚归时间
	 */
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
	/**
	 * 获取：晚归时间
	 */
	public Date getRecordTime() {
		return recordTime;
	}
	/**
	 * 设置：晚归原因
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	 * 获取：晚归原因
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * 设置：联系电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：联系电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：宿舍号
	 */
	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}
	/**
	 * 获取：宿舍号
	 */
	public String getRoomCode() {
		return roomCode;
	}
	/**
	 * 设置：教师联系电话
	 */
	public void setTeachePone(String teachePone) {
		this.teachePone = teachePone;
	}
	/**
	 * 获取：教师联系电话
	 */
	public String getTeachePone() {
		return teachePone;
	}
	/**
	 * 设置：记录人
	 */
	public void setRecordName(String recordName) {
		this.recordName = recordName;
	}
	/**
	 * 获取：记录人
	 */
	public String getRecordName() {
		return recordName;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
