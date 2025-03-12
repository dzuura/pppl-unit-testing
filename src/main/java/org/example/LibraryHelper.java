package org.example;

import java.util.List;

public class LibraryHelper {
    private LibraryService service;

    public LibraryHelper(LibraryService service) {
        this.service = service;
    }

    public int countBooks() {
        List<Book> retrieveBooks = this.service.getAllBooks();
        return retrieveBooks.size();
    }

    public void saveBooks(List<Book> books) {
        if (books.size() > 0) {
            this.service.storeData(books);
        }
    }
}
