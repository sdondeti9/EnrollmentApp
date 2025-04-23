package edu.bellevue.student_enrollment.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.bellevue.student_enrollment.DTO.EnrollmentDTO;
import edu.bellevue.student_enrollment.Entities.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    // @Query("SELECT new com.example.university.dto.EnrollmentDTO(e.student.name, e.course.courseName, e.enrollmentDate) FROM Enrollment e")
    // List<EnrollmentDTO> getEnrollmentInfo();

    @Query("SELECT new edu.bellevue.student_enrollment.DTO.EnrollmentDTO(" +
    "e.student.name, e.course.courseName, e.enrollmentDate) " +
    "FROM Enrollment e")
        List<EnrollmentDTO> getEnrollmentInfo();

        




}

