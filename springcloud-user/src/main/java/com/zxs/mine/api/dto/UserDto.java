package com.zxs.mine.api.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

//@Getter
//@Setter
@ToString
@Entity
@Table(name = "user")
public class UserDto implements java.io.Serializable {
    /**
     * 唯一主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 登录名
     */
//    @Excel(name = "登录名", height = 20, width = 30, isImportField = "true_st")
    private String code;

    /**
     * 密码
     */
//    @Excel(name = "密码", height = 20, width = 30, isImportField = "true_st")
    private String passwd;

    /**
     * 姓名
     */
    @Excel(name = "姓名", orderNum = "0")
    private String name;

    /**
     * 性别
     */
//    @Excel(name = "性别", height = 20, width = 30, isImportField = "true_st")
    private String sex;

    /**
     * 地址
     */
//    @Excel(name = "地址", height = 20, width = 30, isImportField = "true_st")
    @Column(name = "home_address")
    private String homeAddress;

    /**
     * 现居地
     */
    @Column(name = "current_residence")
    private String currentResidence;

    /**
     * 月薪
     */
    @Column(name = "monthly_salary")
    private BigDecimal monthlySalary;

    /**
     * 工作
     */
    private String work;

    /**
     * 手机1
     */
//    @Excel(name = "手机", height = 20, width = 30, isImportField = "true_st")
    private String mobile1;

    /**
     * 手机2
     */
    private String mobile2;

    /**
     * 手机3
     */
    private String mobile3;

    /**
     * 家庭座机
     */
    @Column(name = "tel_home")
    private String telHome;

    /**
     * 工作座机
     */
    @Column(name = "tel_work")
    private String telWork;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 生日
     */
//    @Excel(name = "出生日期", databaseFormat = "yyyy-MM-dd", format = "yyyy-MM-dd", isImportField = "true_st", width = 20)
    private Date birthday;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 身高
     */
    private Double height;

    /**
     * 体重
     */
    private Double weight;

    /**
     * 学历
     */
    private String education;

    /**
     * 毕业院校
     */
    @Column(name = "graduated_school")
    private String graduatedSchool;

    /**
     * QQ
     */
    private String qq;

    /**
     * 微信
     */
    private String wechat;

    /**
     * 爱好
     */
    private String hobby;

    /**
     * 与我的亲属关系
     */
    private String relationship;

    /**
     * 扩展1
     */
    private String ext1;

    /**
     * 扩展2
     */
    private String ext2;

    /**
     * 扩展3
     */
    private String ext3;

    /**
     * 登记人
     */
    @Column(name = "input_man")
    private String inputMan;

    /**
     * 登记时间
     */
    @Column(name = "input_time")
    private Date inputTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getCurrentResidence() {
        return currentResidence;
    }

    public void setCurrentResidence(String currentResidence) {
        this.currentResidence = currentResidence;
    }

    public BigDecimal getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(BigDecimal monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getMobile1() {
        return mobile1;
    }

    public void setMobile1(String mobile1) {
        this.mobile1 = mobile1;
    }

    public String getMobile2() {
        return mobile2;
    }

    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    public String getMobile3() {
        return mobile3;
    }

    public void setMobile3(String mobile3) {
        this.mobile3 = mobile3;
    }

    public String getTelHome() {
        return telHome;
    }

    public void setTelHome(String telHome) {
        this.telHome = telHome;
    }

    public String getTelWork() {
        return telWork;
    }

    public void setTelWork(String telWork) {
        this.telWork = telWork;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getGraduatedSchool() {
        return graduatedSchool;
    }

    public void setGraduatedSchool(String graduatedSchool) {
        this.graduatedSchool = graduatedSchool;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }

    public String getInputMan() {
        return inputMan;
    }

    public void setInputMan(String inputMan) {
        this.inputMan = inputMan;
    }

    public Date getInputTime() {
        return inputTime;
    }

    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}