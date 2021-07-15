package controller;


import domein.Account;
import domein.AccountType;
import dto.AccountCreateDTO;
import dto.ClientCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.web.bind.annotation.*;
import domein.Client;
import org.springframework.web.server.ResponseStatusException;
import service.ClientService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {


    @Autowired
    private ClientService clientService;

    @GetMapping("/{id}")
    public Client getClient(@PathVariable UUID id){
        try {
            return clientService.getClient(id);
        }catch (
    InputMismatchException e){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"validation input exception");
    }catch (Exception e){
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);

    }
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public  Client createClient(@RequestBody ClientCreateDTO createDTO, AccountCreateDTO accountCreateDTO){
     try {
         return  clientService.createClient(createDTO,accountCreateDTO);
     }catch (InputMismatchException e){
         throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"validation input exception");
     }catch (Exception e){
         throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);

     }
    }

    @GetMapping("/account/{id}")
    public List<Account> getClientAcc(@PathVariable Iterable<UUID> id){
        try {
            return  clientService.getAccounts(id);
        }catch (InputMismatchException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"validation input exception");
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }



}
