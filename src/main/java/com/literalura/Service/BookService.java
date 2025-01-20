package com.literalura.Service;

import com.literalura.Model.Book;
import com.literalura.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void exibirQuantidadeLivrosPorIdioma(String idioma) {
        List<Book> livros = bookRepository.findByLanguage(idioma);

        System.out.println("Quantidade de livros no idioma \"" + idioma + "\": " + livros.size());
    }
}
