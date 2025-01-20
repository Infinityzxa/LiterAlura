package com.literalura.api;

import com.literalura.Model.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class GutendexService {

    private final String API_URL = "https://gutendex.com/books/";  // URL base da API

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public GutendexService() {
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
    }

    // Método para buscar livros reais da API e limitar os idiomas para Inglês (en) e Espanhol (es)
    public List<Book> fetchBooks(String keyword) {
        String url = API_URL + "?search=" + keyword;  // URL para fazer a consulta

        try {
            // Realiza a requisição para a API
            String response = restTemplate.getForObject(url, String.class);

            // Mapeia a resposta JSON para uma lista de livros
            List<Book> books = objectMapper.readValue(response, objectMapper.getTypeFactory().constructCollectionType(List.class, Book.class));

            // Filtra os livros para manter apenas os de idiomas Inglês (en) e Espanhol (es)
            return books.stream()
                    .filter(book -> book.getLanguages() != null &&
                            (book.getLanguages().contains("en") || book.getLanguages().contains("es"))) // Limita para os idiomas fixos
                    .collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();  // Retorna uma lista vazia em caso de erro
        }
    }
}
