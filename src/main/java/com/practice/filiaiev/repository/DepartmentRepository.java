package com.practice.filiaiev.repository;

import com.practice.filiaiev.model.DepartmentEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Repository
public class DepartmentRepository {

    private final WebClient webClient;

    public DepartmentRepository(@Value("${department-service.base-url}") String url) {
        webClient = WebClient.builder()
                .baseUrl(url)
                .build();
    }

    public List<DepartmentEntity> getDepartments(List<Integer> ids) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/departments")
                        .queryParam("ids", ids)
                        .build()
                )
                .retrieve()
                .bodyToFlux(DepartmentEntity.class)
                .collectList()
                .block();
    }
}
