import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class TestMenu {
    static Stream<Arguments> provideMenuData() {
        return Stream.of(
                Arguments.of("Nasi Goreng", 2, 30000),
                Arguments.of("Mie Ayam", 3, 36000),
                Arguments.of("Sate Ayam", 1, 20000)
        );
    }
}
