package com.gtu.EngBook.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student")
public class StudentModel implements Serializable {
    @Id
    @Column(name = "enroll_no")
    private long enroll_no;

    @Column(name = "dept_id")
    private int dept_id;

    @Column(name = "colg_id")
    private int colg_id;

    @Column(name = "univ_id")
    private int univId;

    public int getUnivId() {
        return univId;
    }

    public void setUnivId(int univId) {
        this.univId = univId;
    }

    @Column(name = "year_of_passing")
    private int year_of_passing;

    @Column(name = "ranking")
    private int rank;

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    UserModel userModel;

    /**
     *

     * @param enroll_no
     * @param dept_id
     * @param colg_id
     * @param univId
     * @param year_of_passing
     * @param rank
     * @param userModel
     */
    public StudentModel(long enroll_no, int dept_id, int colg_id, int univId, int year_of_passing, int rank, UserModel userModel) {
        this.enroll_no = enroll_no;
        this.dept_id = dept_id;
        this.colg_id = colg_id;
        this.univId = univId;
        this.year_of_passing = year_of_passing;
        this.rank = rank;
        this.userModel = userModel;
    }


    public StudentModel() {
    }



    public long getEnroll_no() {
        return enroll_no;
    }

    public void setEnroll_no(long enroll_no) {
        this.enroll_no = enroll_no;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public int getColg_id() {
        return colg_id;
    }

    public void setColg_id(int colg_id) {
        this.colg_id = colg_id;
    }

    public int getYear_of_passing() {
        return year_of_passing;
    }

    public void setYear_of_passing(int year_of_passing) {
        this.year_of_passing = year_of_passing;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}