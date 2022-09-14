package com.lookup.client;

import com.lookup.client.model.ErrorResponse;
import com.lookup.client.model.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class TestParallelStream {
    public static void main(String[] args) {
        StudentsClient studentsClient = new StudentsClient();
        List<String> ids = new ArrayList<>();
        IntStream.range(1, 71).forEach(value -> ids.add(String.valueOf(value)));
        System.out.println(ids);

        List<ErrorResponse> errors = new ArrayList<>();
        ids.parallelStream().forEach(id -> {
            try {
                Response response = studentsClient.getStudent(id);
                errors.add(response.getErrorResponse());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        for(ErrorResponse e: errors) {
            Optional.ofNullable(e).ifPresent(error ->
                    System.out.println(e.toString()));
        }
    }
}
