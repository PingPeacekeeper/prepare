package com.example.prepare.service.impl;

import com.example.prepare.dto.EmployeeDTO;
import com.example.prepare.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Service
public class EmployeeService {
    private final RestTemplate restTemplate;

    private final Executor executor = Executors.newFixedThreadPool(2);

    @Autowired
    public EmployeeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Employee> getAllEmp() {
        String url = "https://dummy.restapiexample.com/api/v1/employees";
        EmployeeDTO res = restTemplate.getForObject(url, EmployeeDTO.class);
        System.out.println(res);
        if (res == null) return new ArrayList<>();
        System.out.println(res.getData());
        return res.getData();
    }

    public int compute() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("f1 finish");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 100;
        }, executor);

        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("f2 finish");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 200;
        }, executor);

        CompletableFuture<Void> f = CompletableFuture.allOf(f1, f2);
        f.join();
        System.out.println(f1.get() + f2.get());

        return f1.get()+f2.get();
    }
}
