package com.kwler.legacy.api.admin.repository;

import com.kwler.legacy.api.admin.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
        path = "customers",
        itemResourceRel = "customer",
        collectionResourceRel = "customers"
)
public interface CustomerRestRepository extends MongoRepository<Customer, String> {
}
