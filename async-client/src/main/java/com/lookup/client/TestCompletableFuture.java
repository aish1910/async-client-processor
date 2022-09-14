package com.lookup.client;

import com.lookup.client.model.ErrorResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class TestCompletableFuture {
    public static void main(String[] args) {
        StudentsClient studentsClient = new StudentsClient();
        List<String> ids = new ArrayList<>();
        IntStream.range(1, 71).forEach(value -> ids.add(String.valueOf(value)));
        System.out.println(ids);

        List<ErrorResponse> errors = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<CompletableFuture> completableFutures = new ArrayList<>();

        ids.stream().forEach(id -> {
            completableFutures.add(CompletableFuture.supplyAsync(() -> {
                try {
                    return studentsClient.getStudent(id);
                } catch (Exception e) {
                  throw new CompletionException(e);
                }
            }, executorService)
                    .handle((response, ex) -> errors.add(response.getErrorResponse())));
        });

        completableFutures.stream().forEach(CompletableFuture::join);

        for(ErrorResponse e: errors) {
            Optional.ofNullable(e).ifPresent(error ->
                    System.out.println(e.toString()));
        }
    }
}
