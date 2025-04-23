package edu.bellevue.student_enrollment.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bellevue.student_enrollment.DTO.EnrollmentDTO;
import edu.bellevue.student_enrollment.Repository.EnrollmentRepository;

import edu.bellevue.student_enrollment.Exception.EnrollmentNotFoundException;

import org.springframework.dao.DataAccessException; 

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public List<EnrollmentDTO> getAllEnrollmentInfo() {
        try {
            List<EnrollmentDTO> enrollments = enrollmentRepository.getEnrollmentInfo();
            
            if (enrollments == null || enrollments.isEmpty()) {
                throw new EnrollmentNotFoundException("No enrollment information found.");
            }
            return enrollments;

        } catch (DataAccessException dae) {
            // Log the exception here if you have a logger
            throw new RuntimeException("Database error occurred while fetching enrollment information.", dae);
        }
    }
}
