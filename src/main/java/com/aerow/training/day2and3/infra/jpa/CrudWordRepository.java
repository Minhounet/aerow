package com.aerow.training.day2and3.infra.jpa;

import org.springframework.data.repository.CrudRepository;

public interface CrudWordRepository extends CrudRepository<WordEntity, String> {
}
