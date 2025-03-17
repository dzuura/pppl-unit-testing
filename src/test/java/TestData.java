import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class TestData {
    // static penting, kalau tanpa static nanti error
    static Stream<Arguments> provideAddData(){
        return Stream.of(
                Arguments.of(1,10,11),
                Arguments.of(2,3,5),
                Arguments.of(10,20,30)
        );
    }
}
