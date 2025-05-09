package edu.bellevue.student_enrollment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.bellevue.student_enrollment.dto.EnrollmentDTO;
import edu.bellevue.student_enrollment.repository.EnrollmentRepository;
import edu.bellevue.student_enrollment.exception.EnrollmentNotFoundException;
import org.springframework.dao.DataAccessException; 
import edu.bellevue.student_enrollment.exception.DatabaseException;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public List<EnrollmentDTO> getAllEnrollmentInfo() {
        try {
            List<EnrollmentDTO> enrollments = enrollmentRepository.getEnrollmentInfo();
            
            if (enrollments == null || enrollments.isEmpty()) {
                throw new EnrollmentNotFoundException("No enrollment information found.");
            }
            return enrollments;

        } catch (DataAccessException dae) {
            // Log the exception here if you have a logger
            throw new DatabaseException("Database error occurred while fetching enrollment information.", dae);
        }
    }
}
