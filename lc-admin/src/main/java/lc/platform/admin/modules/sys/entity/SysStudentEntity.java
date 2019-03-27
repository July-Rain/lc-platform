package lc.platform.admin.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统用户
 * 
 * @author sinorock.net
 * @email ${email}
 * @date 2019-03-23 15:10:27
 */
@TableName("sys_student")
public class SysStudentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 学生id
	 */
	@TableId
	private String stuId;
	/**
	 * 学生姓名
	 */
	private String stuName;
	/**
	 * 学生学号
	 */
	private String stuCode;
	/**
	 * 学生性别
	 */
	private String stuSex;
	/**
	 * 学生手机号
	 */
	private String stuPhone;
	/**
	 * 宿舍编号
	 */
	private String stuRoomCode;
	/**
	 * 宿舍名称
	 */
	private String stuRoomName;
	/**
	 * 教师名称
	 */
	private String stuTeacher;
	/**
	 * 教师手机号
	 */
	private String teacherPhone;
	/**
	 * 专业
	 */
	private String stuMajor;
	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 设置：学生id
	 */
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	/**
	 * 获取：学生id
	 */
	public String getStuId() {
		return stuId;
	}
	/**
	 * 设置：学生姓名
	 */
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	/**
	 * 获取：学生姓名
	 */
	public String getStuName() {
		return stuName;
	}
	/**
	 * 设置：学生学号
	 */
	public void setStuCode(String stuCode) {
		this.stuCode = stuCode;
	}
	/**
	 * 获取：学生学号
	 */
	public String getStuCode() {
		return stuCode;
	}
	/**
	 * 设置：学生性别
	 */
	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}
	/**
	 * 获取：学生性别
	 */
	public String getStuSex() {
		return stuSex;
	}
	/**
	 * 设置：学生手机号
	 */
	public void setStuPhone(String stuPhone) {
		this.stuPhone = stuPhone;
	}
	/**
	 * 获取：学生手机号
	 */
	public String getStuPhone() {
		return stuPhone;
	}
	/**
	 * 设置：宿舍编号
	 */
	public void setStuRoomCode(String stuRoomCode) {
		this.stuRoomCode = stuRoomCode;
	}
	/**
	 * 获取：宿舍编号
	 */
	public String getStuRoomCode() {
		return stuRoomCode;
	}
	/**
	 * 设置：宿舍名称
	 */
	public void setStuRoomName(String stuRoomName) {
		this.stuRoomName = stuRoomName;
	}
	/**
	 * 获取：宿舍名称
	 */
	public String getStuRoomName() {
		return stuRoomName;
	}
	/**
	 * 设置：教师名称
	 */
	public void setStuTeacher(String stuTeacher) {
		this.stuTeacher = stuTeacher;
	}
	/**
	 * 获取：教师名称
	 */
	public String getStuTeacher() {
		return stuTeacher;
	}
	/**
	 * 设置：教师手机号
	 */
	public void setTeacherPhone(String teacherPhone) {
		this.teacherPhone = teacherPhone;
	}
	/**
	 * 获取：教师手机号
	 */
	public String getTeacherPhone() {
		return teacherPhone;
	}
	/**
	 * 设置：专业
	 */
	public void setStuMajor(String stuMajor) {
		this.stuMajor = stuMajor;
	}
	/**
	 * 获取：专业
	 */
	public String getStuMajor() {
		return stuMajor;
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
