package com.literalura;

import com.literalura.api.GutendexService;
import com.literalura.Model.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Main implements CommandLineRunner {

    private final GutendexService service = new GutendexService();

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Exibir o menu
            System.out.println("=== Bem-vindo ao LiterAlura ===");
            System.out.println("1. Buscar livros por palavra-chave");
            System.out.println("2. Listar autores de um livro");
            System.out.println("3. Listar idiomas disponíveis");
            System.out.println("4. Mostrar os livros mais baixados");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    buscarLivros(scanner);
                    break;
                case "2":
                    listarAutores(scanner);
                    break;
                case "3":
                    listarIdiomas(scanner);
                    break;
                case "4":
                    mostrarLivrosMaisBaixados();
                    break;
                case "5":
                    System.out.println("Saindo... Obrigado por usar o LiterAlura!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println();
        }
    }

    private void buscarLivros(Scanner scanner) {
        System.out.print("Digite uma palavra-chave para buscar livros: ");
        String keyword = scanner.nextLine();

        List<Book> books = service.fetchBooks(keyword);

        if (books.isEmpty()) {
            System.out.println("Nenhum livro encontrado para a palavra-chave: " + keyword);
        } else {
            System.out.println("Livros encontrados:");
            books.forEach(book -> {
                System.out.println("Título: " + book.getTitle());
                // Usando getLanguages() para acessar os idiomas
                System.out.println("Idiomas: " + String.join(", ", book.getLanguages()));
                System.out.println("---");
            });
        }
    }

    private void listarAutores(Scanner scanner) {
        System.out.print("Digite o título do livro para listar os autores: ");
        String keyword = scanner.nextLine();

        List<Book> books = service.fetchBooks(keyword);

        if (books.isEmpty()) {
            System.out.println("Nenhum livro encontrado com o título: " + keyword);
        } else {
            books.forEach(book -> {
                System.out.println("Título: " + book.getTitle());
                // Aqui você pode adicionar a lógica de autores, se necessário.
                System.out.println("---");
            });
        }
    }

    private void listarIdiomas(Scanner scanner) {
        System.out.print("Digite o título do livro para listar os idiomas disponíveis: ");
        String keyword = scanner.nextLine();

        List<Book> books = service.fetchBooks(keyword);

        if (books.isEmpty()) {
            System.out.println("Nenhum livro encontrado com o título: " + keyword);
        } else {
            books.forEach(book -> {
                System.out.println("Título: " + book.getTitle());
                // Usando getLanguages() para acessar os idiomas
                System.out.println("Idiomas: " + String.join(", ", book.getLanguages()));
                System.out.println("---");
            });
        }
    }

    private void mostrarLivrosMaisBaixados() {
        // Este método pode ser ajustado para mostrar os livros mais baixados, se necessário.
        List<Book> books = service.fetchBooks("");

        books.forEach(book -> {
            System.out.println("Título: " + book.getTitle());
            // Usando getLanguages() para acessar os idiomas
            System.out.println("Idiomas: " + String.join(", ", book.getLanguages()));
            System.out.println("---");
        });
    }
}
