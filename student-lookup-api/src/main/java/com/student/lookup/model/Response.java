package com.student.lookup.model;

public class Response {
    private Student student;
    private ErrorResponse errorResponse;

    public Response(Student student, ErrorResponse errorResponse) {
        this.student = student;
        this.errorResponse = errorResponse;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }
}
