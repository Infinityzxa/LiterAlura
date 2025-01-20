package com.literalura.Service;

import com.literalura.Model.Author;
import com.literalura.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public void listarAutoresVivosEmAno(int ano) {
        List<Author> autores = authorRepository.findAuthorsAliveInYear(ano);

        if (autores.isEmpty()) {
            System.out.println("Nenhum autor encontrado que estava vivo no ano " + ano + ".");
        } else {
            System.out.println("Autores vivos no ano " + ano + ":");
            autores.forEach(autor -> {
                System.out.println("- " + autor.getName() +
                        " (Nascimento: " + autor.getBirthYear() +
                        ", Falecimento: " + (autor.getDeathYear() != null ? autor.getDeathYear() : "Ainda vivo") + ")");
            });
        }
    }
}
