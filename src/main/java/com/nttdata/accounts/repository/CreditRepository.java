package com.nttdata.accounts.repository;

import com.nttdata.accounts.model.Credit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CreditRepository extends ReactiveMongoRepository<Credit, String> {

}
