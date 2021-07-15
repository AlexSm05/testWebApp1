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






//    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<UUID> createClient(@RequestBody Client client,Account account){
//        List<Account> list=new ArrayList<>();
//        list.add(account);
//        client.setAccounts(list);
//        jdbcOperations.update("insert into client (id,first_name,last_name,accounts) values (?, ?, ?, ?)",
//                client.getClientId(), client.getFirstName(), client.getLastName(), client.getAccounts());
//        return ResponseEntity.ok(client.getClientId());
//    }
//
//
//    @GetMapping("/{id}")
//    public ResponseEntity<List<Account>> getAccount(@PathVariable UUID id) {
//        try {
//            return ResponseEntity.ok(this.jdbcOperations
//                    .queryForList("select * from account where id = ?"+id+"",List<Account>
//                            (resultSet, i) ->
//                                    new Account(UUID.fromString(resultSet.getString("id")),
//                                            resultSet.getInt("number"),
//                                            AccountType.valueOf(resultSet.getString("type")),
//                                            resultSet.getDouble("balance"))));
//        } catch (IncorrectResultSizeDataAccessException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }

}
