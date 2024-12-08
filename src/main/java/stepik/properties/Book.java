package stepik.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Book {
    private final String title;
    private final String description;
    private final String author;
    private final Integer price;
    private final Integer count;
    private final Category category;
}