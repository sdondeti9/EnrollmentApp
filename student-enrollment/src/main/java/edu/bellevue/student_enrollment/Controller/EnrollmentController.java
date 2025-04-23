package edu.bellevue.student_enrollment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bellevue.student_enrollment.DTO.EnrollmentDTO;
import edu.bellevue.student_enrollment.Exception.EnrollmentNotFoundException;
import edu.bellevue.student_enrollment.Service.EnrollmentService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping("/info")
    public List<EnrollmentDTO> getEnrollmentInfo() {
        //return enrollmentService.getAllEnrollmentInfo();


        List<EnrollmentDTO> enrollments = enrollmentService.getAllEnrollmentInfo();

        if (enrollments == null || enrollments.isEmpty()) {
            throw new EnrollmentNotFoundException("No enrollment records found.");
        }
        return enrollments;
         // GET enrollments by student ID
    // @GetMapping("/student/{studentId}")
    // public List<EnrollmentDTO> getEnrollmentByStudent(@PathVariable Long studentId) {
    //     return enrollmentService.getEnrollmentInfoByStudent(studentId);
    // }

    // // GET enrollments by course ID
    // @GetMapping("/course/{courseId}")
    // public List<EnrollmentDTO> getEnrollmentByCourse(@PathVariable Long courseId) {
    //     return enrollmentService.getEnrollmentInfoByCourse(courseId);
    // }
    }
}

