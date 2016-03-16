package com.senacor.springboot;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author David Schmitz
 */


@Repository
public interface HelloWorldRepository
    extends CrudRepository<HelloWorld, String> {
}

