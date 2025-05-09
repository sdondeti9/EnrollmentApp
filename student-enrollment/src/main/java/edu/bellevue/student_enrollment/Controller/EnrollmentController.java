package edu.bellevue.student_enrollment.controller;



import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bellevue.student_enrollment.dto.EnrollmentDTO;
import edu.bellevue.student_enrollment.exception.EnrollmentNotFoundException;
import edu.bellevue.student_enrollment.service.EnrollmentService;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping("/info")
    public List<EnrollmentDTO> getEnrollmentInfo() {


        List<EnrollmentDTO> enrollments = enrollmentService.getAllEnrollmentInfo();

        if (enrollments == null || enrollments.isEmpty()) {
            throw new EnrollmentNotFoundException("No enrollment records found.");
        }
        return enrollments;
   
    }
}

