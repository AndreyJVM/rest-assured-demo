package stepik.properties;

import lombok.*;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String title;
    private String description;
    private String author;
    private Integer price;
    private Integer count;
    private Category category;

    public Book(Book book) {
        this.title = book.title;
        this.description = book.description;
        this.author = book.author;
        this.price = book.price;
        this.count = book.count;
        this.category = book.category;
    }
}