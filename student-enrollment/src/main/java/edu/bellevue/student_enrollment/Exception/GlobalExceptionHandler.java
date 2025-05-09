package edu.bellevue.student_enrollment.exception;



    @org.springframework.web.bind.annotation.ControllerAdvice
    public class GlobalExceptionHandler {

        @org.springframework.web.bind.annotation.ExceptionHandler(EnrollmentNotFoundException.class)
        public org.springframework.http.ResponseEntity<ErrorResponse> handleEnrollmentNotFoundException(EnrollmentNotFoundException ex) {
            ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), 404);
            return new org.springframework.http.ResponseEntity<>(errorResponse, org.springframework.http.HttpStatus.NOT_FOUND);
        }

        @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
        public org.springframework.http.ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
            ErrorResponse errorResponse = new ErrorResponse("An unexpected error occurred.", 500);
            return new org.springframework.http.ResponseEntity<>(errorResponse, org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // Add more exception handlers as needed


