package com.nttdata.accounts.controller;

import com.nttdata.accounts.model.BankAccount;
import com.nttdata.accounts.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/bank-account")
public class BankAccountController {

    @Autowired
    BankAccountService bankAccountService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<BankAccount> getBankAccount(){
        System.out.println("Listar cuentas bancarias");
        return bankAccountService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<BankAccount> saveBankAccount(@RequestBody BankAccount bankAccount){
        System.out.println("Guardar cuenta bancaria");
        return bankAccountService.save(bankAccount);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Mono<BankAccount> updateBankAccount(@RequestBody BankAccount bankAccount, @PathVariable String id){
        System.out.println("Actualizar cuenta bancaria");
        return bankAccountService.update(bankAccount);
    }

    @PutMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<BankAccount> deleteBankAccount(@PathVariable String id){
        System.out.println("Eliminar cuenta bancaria");
        return bankAccountService.deleteById(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  Mono<BankAccount> findAccountBankId(@PathVariable String id){
        System.out.println("Buscar cuenta bancaria");
        return bankAccountService.findById(id);
    }

    @GetMapping("/{customer}/{type}")
    @ResponseStatus(HttpStatus.OK)
    public  Mono<BankAccount> findAccountBankTypeCustomer(@PathVariable String type, @PathVariable String customer){
        System.out.println("Buscar cuenta bancaria por tipo y cliente");
        return bankAccountService.findByTypeAndCustomer(type, customer);
    }
}