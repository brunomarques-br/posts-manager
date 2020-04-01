package br.com.sisblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sisblog.domain.Post;
import br.com.sisblog.domain.User;
import br.com.sisblog.repositories.PostRepository;
import br.com.sisblog.repositories.UserRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Service
public class DbService {

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private PostRepository postRepository;

        public void instantiateTestDatabase() throws ParseException {

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

                User user1 = new User(null, "Bruno Marque", "brunomarques@gmail.com");
                User user2 = new User(null, "Henrique Xavier", "henirquevavier@gmail.com");

                Post post1 = new Post(null, sdf.parse("31/03/2020 10:32"), "Primeiro post do blog",
                                "Descrição do primeiro post do blog", user1);

                Post post2 = new Post(null, sdf.parse("31/03/2020 11:32"), "Segundo post do blog",
                                "Descrição do segundo post do blog", user1);

                Post post3 = new Post(null, sdf.parse("31/03/2020 12:32"), "Terceiro post do blog",
                                "Descrição do terceiro post do blog", user2);

                Post post4 = new Post(null, sdf.parse("31/03/2020 13:32"), "Quarto post do blog",
                                "Descrição do quarto post do blog", user1);

                Post post5 = new Post(null, sdf.parse("31/03/2020 14:32"), "Quinto post do blog",
                                "Descrição do quinto post do blog", user2);

                Post post6 = new Post(null, sdf.parse("31/03/2020 14:32"), "Quinto post do blog",
                                "Descrição do quinto post do blog", user1);

                userRepository.saveAll(Arrays.asList(user1, user2));

                postRepository.saveAll(Arrays.asList(post1, post2, post3, post4, post5, post6));

        }
}
