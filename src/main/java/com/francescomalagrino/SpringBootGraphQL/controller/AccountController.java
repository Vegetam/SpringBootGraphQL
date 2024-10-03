package com.francescomalagrino.SpringBootGraphQL.controller;


import com.francescomalagrino.SpringBootGraphQL.domain.BankAccount;
import com.francescomalagrino.SpringBootGraphQL.domain.Client;
import com.francescomalagrino.SpringBootGraphQL.service.BankService;
import com.francescomalagrino.SpringBootGraphQL.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Slf4j
public class AccountController {

    @Autowired
    BankService bankService;

    @Autowired
    ClientService clientService;

    @QueryMapping
    List<BankAccount> accounts() {
        log.info("Getting accounts");
        return bankService.getAccounts();
    }

    @SchemaMapping(typeName = "bankaccount", field= "client")
    Client getClient(BankAccount bankAccount) {
        log.info("Getting client for ", bankAccount.getId());
        return clientService.getClientByAccountId(bankAccount.getId());
    }
}
