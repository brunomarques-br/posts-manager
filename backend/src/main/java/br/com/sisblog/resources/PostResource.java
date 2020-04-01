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

import br.com.sisblog.domain.Post;
import br.com.sisblog.service.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    /**
     * @TODO
     * Implementar a conversão do DTO na requisição e resposta
     * Implementar o endpoint paginado.
     *  */ 

    @Autowired
    private PostService service;

    @GetMapping(value = "/")
    public ResponseEntity<List<Post>> findAll() {
        List<Post> Posts = service.findAll();
        List<Post> PostsDTO = Posts.stream().map(obj -> new Post(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(PostsDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> find(@PathVariable Integer id) {
        Post Post = service.find(id);
        return ResponseEntity.ok().body(Post);
    }

    @PostMapping
    public ResponseEntity<Post> insert(@Valid @RequestBody Post Post) {
        Post newPost = service.insert(Post);
        return ResponseEntity.status(200).body(newPost);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Post> update(@Valid @RequestBody Post oldPost, @PathVariable Integer id) {
        oldPost.setId(id);
        Post newPost = service.update(oldPost);
        return ResponseEntity.status(200).body(newPost);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}