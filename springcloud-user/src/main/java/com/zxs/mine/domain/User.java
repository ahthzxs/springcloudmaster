package com.zxs.mine.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@ToString
@Table(name = "user")
public class User implements Serializable {
    /**
     * 唯一主键
     */

    @Excel(name = "id" ,orderNum = "0")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 登录名
     */
    private String code;

    /**
     * 密码
     */
    private String passwd;

    /**
     * 姓名
     */
    @Excel(name = "姓名" ,orderNum = "1")
    private String name;

    /**
     * 性别
     */
    @Excel(name = "性别" ,replace = { "男_1", "女_2" },orderNum = "2")
    private String sex;

    /**
     * 地址
     */
    @Excel(name = "地址" ,orderNum = "3",width = 50)
    @Column(name = "home_address")
    private String homeAddress;

    /**
     * 现居地
     */
    @Excel(name = "现居地" ,orderNum = "4")
    @Column(name = "current_residence")
    private String currentResidence;

    /**
     * 月薪
     */
    @Excel(name = "月薪" ,orderNum = "5")
    @Column(name = "monthly_salary")
    private BigDecimal monthlySalary;

    /**
     * 工作
     */
    @Excel(name = "工作" ,orderNum = "6")
    private String work;

    /**
     * 手机1
     */
    @Excel(name = "手机1" ,orderNum = "7")
    private String mobile1;

    /**
     * 手机2
     */
    @Excel(name = "手机2" ,orderNum = "8")
    private String mobile2;

    /**
     * 手机3
     */
    @Excel(name = "手机3" ,orderNum = "9")
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
    @Excel(name = "邮箱" ,orderNum = "10")
    private String email;

    /**
     * 生日
     */
    @Excel(name = "生日" ,orderNum = "11",importFormat = "yyyy-MM-dd",exportFormat = "yyyy-MM-dd")//
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
    @Excel(name = "QQ" ,orderNum = "12")
    private String qq;

    /**
     * 微信
     */
    @Excel(name = "微信" ,orderNum = "13")
    private String wechat;

    /**
     * 爱好
     */
    @Excel(name = "爱好" ,orderNum = "14")
    private String hobby;

    /**
     * 与我的亲属关系
     */
    @Excel(name = "与我的亲属关系" ,orderNum = "15")
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
    @Excel(name = "创建日期" ,orderNum = "2",importFormat = "yyyy-MM-dd",exportFormat = "yyyy-MM-dd")//exportFormat = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "input_time")
    private Date inputTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取唯一主键
     *
     * @return id - 唯一主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置唯一主键
     *
     * @param id 唯一主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取登录名
     *
     * @return code - 登录名
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置登录名
     *
     * @param code 登录名
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取密码
     *
     * @return passwd - 密码
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * 设置密码
     *
     * @param passwd 密码
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取地址
     *
     * @return home_address - 地址
     */
    public String getHomeAddress() {
        return homeAddress;
    }

    /**
     * 设置地址
     *
     * @param homeAddress 地址
     */
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    /**
     * 获取现居地
     *
     * @return current_residence - 现居地
     */
    public String getCurrentResidence() {
        return currentResidence;
    }

    /**
     * 设置现居地
     *
     * @param currentResidence 现居地
     */
    public void setCurrentResidence(String currentResidence) {
        this.currentResidence = currentResidence;
    }

    /**
     * 获取月薪
     *
     * @return monthly_salary - 月薪
     */
    public BigDecimal getMonthlySalary() {
        return monthlySalary;
    }

    /**
     * 设置月薪
     *
     * @param monthlySalary 月薪
     */
    public void setMonthlySalary(BigDecimal monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    /**
     * 获取工作
     *
     * @return work - 工作
     */
    public String getWork() {
        return work;
    }

    /**
     * 设置工作
     *
     * @param work 工作
     */
    public void setWork(String work) {
        this.work = work;
    }

    /**
     * 获取手机1
     *
     * @return mobile1 - 手机1
     */
    public String getMobile1() {
        return mobile1;
    }

    /**
     * 设置手机1
     *
     * @param mobile1 手机1
     */
    public void setMobile1(String mobile1) {
        this.mobile1 = mobile1;
    }

    /**
     * 获取手机2
     *
     * @return mobile2 - 手机2
     */
    public String getMobile2() {
        return mobile2;
    }

    /**
     * 设置手机2
     *
     * @param mobile2 手机2
     */
    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    /**
     * 获取手机3
     *
     * @return mobile3 - 手机3
     */
    public String getMobile3() {
        return mobile3;
    }

    /**
     * 设置手机3
     *
     * @param mobile3 手机3
     */
    public void setMobile3(String mobile3) {
        this.mobile3 = mobile3;
    }

    /**
     * 获取家庭座机
     *
     * @return tel_home - 家庭座机
     */
    public String getTelHome() {
        return telHome;
    }

    /**
     * 设置家庭座机
     *
     * @param telHome 家庭座机
     */
    public void setTelHome(String telHome) {
        this.telHome = telHome;
    }

    /**
     * 获取工作座机
     *
     * @return tel_work - 工作座机
     */
    public String getTelWork() {
        return telWork;
    }

    /**
     * 设置工作座机
     *
     * @param telWork 工作座机
     */
    public void setTelWork(String telWork) {
        this.telWork = telWork;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取生日
     *
     * @return birthday - 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置生日
     *
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取头像地址
     *
     * @return avatar - 头像地址
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置头像地址
     *
     * @param avatar 头像地址
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取身高
     *
     * @return height - 身高
     */
    public Double getHeight() {
        return height;
    }

    /**
     * 设置身高
     *
     * @param height 身高
     */
    public void setHeight(Double height) {
        this.height = height;
    }

    /**
     * 获取体重
     *
     * @return weight - 体重
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * 设置体重
     *
     * @param weight 体重
     */
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    /**
     * 获取学历
     *
     * @return education - 学历
     */
    public String getEducation() {
        return education;
    }

    /**
     * 设置学历
     *
     * @param education 学历
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * 获取毕业院校
     *
     * @return graduated_school - 毕业院校
     */
    public String getGraduatedSchool() {
        return graduatedSchool;
    }

    /**
     * 设置毕业院校
     *
     * @param graduatedSchool 毕业院校
     */
    public void setGraduatedSchool(String graduatedSchool) {
        this.graduatedSchool = graduatedSchool;
    }

    /**
     * 获取QQ
     *
     * @return qq - QQ
     */
    public String getQq() {
        return qq;
    }

    /**
     * 设置QQ
     *
     * @param qq QQ
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 获取微信
     *
     * @return wechat - 微信
     */
    public String getWechat() {
        return wechat;
    }

    /**
     * 设置微信
     *
     * @param wechat 微信
     */
    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    /**
     * 获取爱好
     *
     * @return hobby - 爱好
     */
    public String getHobby() {
        return hobby;
    }

    /**
     * 设置爱好
     *
     * @param hobby 爱好
     */
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    /**
     * 获取与我的亲属关系
     *
     * @return relationship - 与我的亲属关系
     */
    public String getRelationship() {
        return relationship;
    }

    /**
     * 设置与我的亲属关系
     *
     * @param relationship 与我的亲属关系
     */
    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    /**
     * 获取扩展1
     *
     * @return ext1 - 扩展1
     */
    public String getExt1() {
        return ext1;
    }

    /**
     * 设置扩展1
     *
     * @param ext1 扩展1
     */
    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    /**
     * 获取扩展2
     *
     * @return ext2 - 扩展2
     */
    public String getExt2() {
        return ext2;
    }

    /**
     * 设置扩展2
     *
     * @param ext2 扩展2
     */
    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    /**
     * 获取扩展3
     *
     * @return ext3 - 扩展3
     */
    public String getExt3() {
        return ext3;
    }

    /**
     * 设置扩展3
     *
     * @param ext3 扩展3
     */
    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }

    /**
     * 获取登记人
     *
     * @return input_man - 登记人
     */
    public String getInputMan() {
        return inputMan;
    }

    /**
     * 设置登记人
     *
     * @param inputMan 登记人
     */
    public void setInputMan(String inputMan) {
        this.inputMan = inputMan;
    }

    /**
     * 获取登记时间
     *
     * @return input_time - 登记时间
     */
    public Date getInputTime() {
        return inputTime;
    }

    /**
     * 设置登记时间
     *
     * @param inputTime 登记时间
     */
    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}