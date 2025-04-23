package edu.bellevue.student_enrollment.controller;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import edu.bellevue.student_enrollment.Controller.EnrollmentController;
import edu.bellevue.student_enrollment.DTO.EnrollmentDTO;
import edu.bellevue.student_enrollment.Service.EnrollmentService;

@WebMvcTest(controllers = EnrollmentController.class) // ✅ Correct Controller
public class EnrollmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EnrollmentService enrollmentService;

    @Test
    void testGetEnrollmentInfo_Success() throws Exception {
        
   EnrollmentDTO enrollment1 = new EnrollmentDTO(
            "John Doe", 
            "Math", 
            LocalDateTime.of(2024, 4, 18, 10, 0) // ✅ Updated to LocalDateTime
        );
        EnrollmentDTO enrollment2 = new EnrollmentDTO(
            "Jane Smith", 
            "Science", 
            LocalDateTime.of(2024, 4, 19, 14, 30) // ✅ Updated to LocalDateTime
        );

        when(enrollmentService.getAllEnrollmentInfo()).thenReturn(Arrays.asList(enrollment1, enrollment2));

        mockMvc.perform(get("/info"))
               .andExpect(status().isOk());
    }

    @Test
    void testGetEnrollmentInfo_NoDataFound() throws Exception {
        when(enrollmentService.getAllEnrollmentInfo()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/info"))
               .andExpect(status().isNotFound());
    }
}

