package edu.bellevue.student_enrollment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.bellevue.student_enrollment.dto.EnrollmentDTO;
import edu.bellevue.student_enrollment.entities.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {


    @Query("SELECT new edu.bellevue.student_enrollment.dto.EnrollmentDTO(" +
    "e.student.name, e.course.courseName, e.enrollmentDate) " +
    "FROM Enrollment e")
        List<EnrollmentDTO> getEnrollmentInfo();

        




}

