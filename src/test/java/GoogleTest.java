import org.example.searchPage;
import org.example.searchResultPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class GoogleTest {

    @Test
    public void testBingPositiveCase() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.bing.com/");
        searchPage lamanPencarian = new searchPage(driver);
        String querry = "ooo";
        lamanPencarian.setSearchBar(querry);
        lamanPencarian.submitForm();
        searchResultPage resultPage = new searchResultPage(driver);

        Assertions.assertTrue(resultPage.getLink(querry).contains(querry));
    }

}
