package br.com.sisblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sisblog.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}