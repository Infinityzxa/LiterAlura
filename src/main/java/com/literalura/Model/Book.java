package com.literalura.Model;

import java.util.List;

public class Book {
    private String title;
    private String authors;
    private List<String> languages; // Lista de idiomas
    private Integer downloadCount;

    // Construtores, getters e setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public List<String> getLanguages() {
        return languages; // Este método retorna a lista de idiomas
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    // Você pode adicionar outros métodos conforme necessário
}
