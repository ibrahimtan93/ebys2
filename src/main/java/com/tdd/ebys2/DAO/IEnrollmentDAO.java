package com.tdd.ebys2.DAO;

import com.tdd.ebys2.Enrollment.Enrollment;

import java.util.List;

/**
 * Created by darthvader on 29.01.2017.
 */
public interface IEnrollmentDAO {
    List<Enrollment> getAllEnrollment();
    Enrollment getEnrollmentByID(int ID);
    boolean addEnrollment(Enrollment enrollment);
    boolean updateEnrollment(Enrollment enrollment);
    boolean deleteEnrollment(Enrollment enrollment);
}
