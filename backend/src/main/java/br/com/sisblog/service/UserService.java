package br.com.sisblog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sisblog.domain.User;
import br.com.sisblog.exceptions.DataIntegrityException;
import br.com.sisblog.exceptions.ObjectNotFoundException;
import br.com.sisblog.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public Page<User> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public User find(Integer id) {

        Optional<User> optUser = repo.findById(id);
        return optUser.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found! Id: " + id + ", Type: " + User.class.getName()));
    }

    public List<User> findAll() {
        return repo.findAll();
    }

    @Transactional
    public User insert(User usuario) {
        usuario.setId(null);
        return repo.save(usuario);
    }

    public User update(User oldUser) {
        User newUser = find(oldUser.getId());
        newUser.setName(oldUser.getName() == null ? newUser.getName() : oldUser.getName());
        newUser.setEmail(oldUser.getEmail() == null ? newUser.getEmail() : oldUser.getEmail());
        return repo.save(newUser);
    }

    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException err) {
            throw new DataIntegrityException(
                    "You cannot delete a customer that has an address and linked orders.");
        }
    }

}