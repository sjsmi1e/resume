package com.resume.model;


import java.io.Serializable;

/**
 * @author shiyanlou
 */
public class Resume implements Serializable {
    //基础信息
    //主键，id
    private int id;
    //姓名
    private String name;
    //性别
    private String gender;
    //年龄
    private int age;
    //地址
    private String address;
    //邮件
    private String email;
    //电话
    private String tel;


    //自我介绍
    private String introduce;

//    教育相关
    //专业
    private String major;
    //学历
    private String education;
    //毕业院校
    private String school;
    //毕业时间
    private String graduation;


    //实习经历
    //企业名
    private String company;
    //职位
    private String position;
    //职责
    private String duty;
    //离职时间
    private String departure;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getGraduation() {
        return graduation;
    }

    public void setGraduation(String graduation) {
        this.graduation = graduation;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", introduce='" + introduce + '\'' +
                ", major='" + major + '\'' +
                ", education='" + education + '\'' +
                ", school='" + school + '\'' +
                ", graduation='" + graduation + '\'' +
                ", company='" + company + '\'' +
                ", position='" + position + '\'' +
                ", duty='" + duty + '\'' +
                ", departure='" + departure + '\'' +
                '}';
    }
}
