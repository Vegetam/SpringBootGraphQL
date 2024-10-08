package com.francescomalagrino.SpringBootGraphQL.service;

import com.francescomalagrino.SpringBootGraphQL.domain.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class ClientService {

    public Client getClientByAccountId (String accountId) {

        List <Client> clients = Arrays.asList(
                new Client ("C100", "A100", "aaaa", "bbb", "cccc"),
                new Client ("C200", "A102", "1111", "222", "333"),
                new Client ("C300", "A102", "ppp", "qqq", "rrrr")
        );

        return clients.stream().filter(c->c.getAccountId().equals(accountId)).findFirst().orElse(null);
    }
}