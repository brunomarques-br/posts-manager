package br.com.sisblog.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sisblog.domain.User;
import br.com.sisblog.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    /**
     * @TODO
     * Implementar a conversão do DTO na requisição e resposta
     *  */ 

    @Autowired
    private UserService service;

    @GetMapping(value = "/")
    public ResponseEntity<List<User>> findAll() {
        List<User> users = service.findAll();
        List<User> usersDTO = users.stream().map(User::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(usersDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> find(@PathVariable Integer id) {
        User user = service.find(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<User> insert(@Valid @RequestBody User user) {
        User newUser = service.insert(user);
        return ResponseEntity.status(200).body(newUser);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@Valid @RequestBody User oldUser, @PathVariable Integer id) {
        oldUser.setId(id);
        User newUser = service.update(oldUser);
        return ResponseEntity.status(200).body(newUser);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}