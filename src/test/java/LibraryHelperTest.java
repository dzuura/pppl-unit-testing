import org.example.Book;
import org.example.LibraryHelper;
import org.example.LibraryService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LibraryHelperTest {

    @Mock
    public LibraryService service;

    @InjectMocks
    public LibraryHelper helper;

    @Test
    public void testCountBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("a", "123", "none"));
        books.add(new Book("b", "123", "none"));

        when(service.getAllBooks()).thenReturn(books);
        Assertions.assertEquals(2, helper.countBooks());
    }

    @Test
    public void testSaveEmptyBooks() {
        List<Book> books = new ArrayList<>();

        helper.saveBooks(books);
        verify(service, never()).storeData(any());
    }

    @Test
    public void testSaveNotEmptyBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("some title", "some isbn", "some author"));

        helper.saveBooks(books);

        verify(service).storeData(books);
    }

//    @Test
//    public void testSaveBooks_WithSpecificBooks() {
//        List<Book> books = new ArrayList<>();
//        books.add(new Book("a", "123", "none"));
//        books.add(new Book("b", "456", "none"));
//
//        helper.saveBooks(books);
//
//        ArgumentCaptor<List<Book>> captor = ArgumentCaptor.forClass(List.class);
//        verify(service).storeData(captor.capture());
//
//        List<Book> capturedBooks = captor.getValue();
//        Assertions.assertEquals(books, capturedBooks);
//    }
//
//    @Test
//    public void testCountBooks_WithSpy() {
//        LibraryService realService = new LibraryService();
//        LibraryService spyService = spy(realService);
//
//        List<Book> books = new ArrayList<>();
//        books.add(new Book("a", "123", "none"));
//        books.add(new Book("b", "456", "none"));
//
//        doReturn(books).when(spyService).getAllBooks();
//
//        LibraryHelper helper = new LibraryHelper(spyService);
//
//        int count = helper.countBooks();
//
//        Assertions.assertEquals(2, count);
//
//        verify(spyService).getAllBooks();
//    }

    @Test
    public void testCountBooks_ThrowsExceptionWhenServiceFails() {
        doThrow(new RuntimeException("Database error")).when(service).getAllBooks();

        Assertions.assertThrows(RuntimeException.class, () -> {
            helper.countBooks();
        });
    }

    @Test
    public void testSaveBooks_TimeoutVerification() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Test Title", "Test ISBN", "Test Author"));

        helper.saveBooks(books);

        verify(service, timeout(100)).storeData(books);
    }

    @Test
    public void testCountBooks_UsingAnswer() {
        when(service.getAllBooks()).thenAnswer(invocation -> {
            List<Book> books = new ArrayList<>();
            books.add(new Book("Dynamic Book", "999", "Dynamic Author"));
            return books;
        });

        int count = helper.countBooks();

        Assertions.assertEquals(1, count);
    }

    @Test
    public void testSaveBooks_UsingDoNothing() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Title A", "ISBN A", "Author A"));

        doNothing().when(service).storeData(books);

        helper.saveBooks(books);

        verify(service, times(1)).storeData(books);
    }
}
