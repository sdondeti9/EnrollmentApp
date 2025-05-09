package edu.bellevue.student_enrollment.dto;

import java.time.LocalDateTime;

// import lombok.Getter;
// import lombok.Setter;

// @Getter
// @Setter

public class EnrollmentDTO {
    private String studentName;
    private String courseName;
    private LocalDateTime enrollmentDate;

      // Constructor
      public EnrollmentDTO(String studentName, String courseName, LocalDateTime enrollmentDate) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.enrollmentDate = enrollmentDate;
    }

    // Getters and Setters
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDateTime getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDateTime enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
    
}
