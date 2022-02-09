package com.nttdata.accounts.service.impl;

import com.nttdata.accounts.model.Credit;
import com.nttdata.accounts.repository.CreditRepository;
import com.nttdata.accounts.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditServiceImpl implements CreditService {

    @Autowired
    CreditRepository creditRepository;

    @Override
    public Flux<Credit> findAll() {
        return creditRepository.findAll();
    }

    @Override
    public Mono<Credit> save(Credit entity) {
        entity.setStatus(true);
        return creditRepository.save(entity);
    }

    @Override
    public Mono<Credit> update(Credit entity) {
        return  creditRepository.findById(entity.getId())
                .switchIfEmpty(Mono.empty())
                .flatMap(origin -> {
                    origin.setCustomer(entity.getCustomer());
                    origin.setType(entity.getType());
                    origin.setAmount(entity.getAmount());
                    origin.setTea(entity.getTea());
                    origin.setMonthlyTime(entity.getMonthlyTime());
                    origin.setFeeMonthly(entity.getFeeMonthly());
                    origin.setStatus(entity.getStatus());
                    return creditRepository.save(origin);
                });
    }

    @Override
    public Mono<Credit> deleteById(String id) {
        return creditRepository.findById(id)
                .switchIfEmpty(Mono.empty())
                .flatMap(origin -> {
                    origin.setStatus(false);
                    return creditRepository.save(origin);
                });
    }

    @Override
    public Mono<Credit> findById(String id) {
        return creditRepository.findById(id);
    }
}
