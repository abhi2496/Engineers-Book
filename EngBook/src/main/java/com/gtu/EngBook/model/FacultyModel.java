package com.gtu.EngBook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class FacultyModel implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private long user_id;

    @Column(name = "enroll_no")
    private long enroll_no;

    @Column(name = "dept_id")
    private int dept_id;

    @Column(name = "colg_id")
    private int colg_id;

    @Column(name = "ranking")
    private int rank;

    public FacultyModel(long user_id, long enroll_no, int dept_id, int colg_id, int rank) {
        this.user_id = user_id;
        this.enroll_no = enroll_no;
        this.dept_id = dept_id;
        this.colg_id = colg_id;
        this.rank = rank;
    }

    public FacultyModel() {
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
