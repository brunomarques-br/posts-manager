package br.com.sisblog.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.sisblog.domain.Post;
import br.com.sisblog.domain.User;
import br.com.sisblog.exceptions.DataIntegrityException;
import br.com.sisblog.exceptions.ObjectNotFoundException;
import br.com.sisblog.repositories.PostRepository;

@Service
public class PostService {
    
    @Autowired
    private PostRepository repo;

    @Autowired
    private UserService userService;

    public Page<Post> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public Post find(Integer id) {

        Optional<Post> optPost = repo.findById(id);
        return optPost.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Post.class.getName()));
    }

    public List<Post> findAll() {
        return repo.findAll();
    }

    @Transactional
    public Post insert(Post post) {
        User author = userService.find(post.getAuthor().getId());
        post.setId(null);
        post.setAuthor(author);
        return repo.save(post);
    }

/**
 * Pode alterar somenmte o Título e conteúdo da postagem.
 * @param oldPost
 * @return
 */
    public Post update(Post oldPost) {
        Post newPost = find(oldPost.getId());
        newPost.setTitle(oldPost.getTitle() == null ? newPost.getTitle() : oldPost.getTitle());
        newPost.setBody(oldPost.getBody() == null ? newPost.getBody() : oldPost.getBody());
        return repo.save(newPost);
    }

    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException err) {
            throw new DataIntegrityException(
                    "Não é possível excluir um cliente que possua endereço e pedidos vinculados.");
        }
    }

}