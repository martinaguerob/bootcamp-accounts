package com.nttdata.accounts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "bank-account")
public class BankAccount {

    @Id
    private String id;
    private String type;
    private String numberAccount;
    private String customer;
    private Boolean status;

}
