package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

//    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
//        this.authorRepository = authorRepository;
//        this.bookRepository = bookRepository;
//    }

    @Override
    public void run(String... args) throws Exception {

        Author author = new Author("Shiva","Ganesha");
        Book book = new Book("Life Book","1111");
        author.getBooks().add(book);
        book.getAuthors().add(author);

        authorRepository.save(author);
        bookRepository.save(book);

        System.out.println("Bootstrap started ....");
        System.out.println("Number of Books = "+author.getBooks().size());
    }




}
