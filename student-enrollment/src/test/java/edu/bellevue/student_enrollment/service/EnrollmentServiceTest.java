package edu.bellevue.student_enrollment.service;



import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import edu.bellevue.student_enrollment.DTO.EnrollmentDTO;
import edu.bellevue.student_enrollment.Exception.EnrollmentNotFoundException;
import edu.bellevue.student_enrollment.Repository.EnrollmentRepository;
import edu.bellevue.student_enrollment.Service.EnrollmentService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataAccessException;

class EnrollmentServiceTest {

    @Mock
    private EnrollmentRepository enrollmentRepository;

    @InjectMocks
    private EnrollmentService enrollmentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEnrollmentInfo_Success() {
        // Arrange
        EnrollmentDTO enrollment1 = new EnrollmentDTO(
            "John Doe", 
            "Math", 
            LocalDateTime.of(2024, 4, 18, 10, 0)
        );
        EnrollmentDTO enrollment2 = new EnrollmentDTO(
            "Jane Smith", 
            "Science", 
            LocalDateTime.of(2024, 4, 19, 14, 30)
        );
        when(enrollmentRepository.getEnrollmentInfo()).thenReturn(Arrays.asList(enrollment1, enrollment2));

        // Act
        List<EnrollmentDTO> result = enrollmentService.getAllEnrollmentInfo();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("John Doe", result.get(0).getStudentName());
        assertEquals("Jane Smith", result.get(1).getStudentName());
    }

    @Test
    void testGetAllEnrollmentInfo_NoDataFound() {
        // Arrange
        when(enrollmentRepository.getEnrollmentInfo()).thenReturn(Collections.emptyList());

        // Act & Assert
        EnrollmentNotFoundException exception = assertThrows(
            EnrollmentNotFoundException.class, 
            () -> enrollmentService.getAllEnrollmentInfo()
        );
        assertEquals("No enrollment information found.", exception.getMessage());
    }

    @Test
    void testGetAllEnrollmentInfo_DataAccessException() {
        // Arrange
        when(enrollmentRepository.getEnrollmentInfo()).thenThrow(new DataAccessException("DB error") {});

        // Act & Assert
        RuntimeException exception = assertThrows(
            RuntimeException.class, 
            () -> enrollmentService.getAllEnrollmentInfo()
        );
        assertTrue(exception.getMessage().contains("Database error occurred while fetching enrollment information."));
    }
}
