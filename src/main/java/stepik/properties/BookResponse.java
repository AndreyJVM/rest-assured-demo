package stepik.properties;

import lombok.*;
import lombok.experimental.Accessors;

import java.time.OffsetDateTime;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@Data
public class BookResponse extends Book {

    private Integer id;
    private OffsetDateTime lastUpdated;

    @EqualsAndHashCode.Exclude
    private OffsetDateTime timestamp;
    private Integer status;
    private String error;
    private String path;

    public static BookResponse createError400() {
        return new BookResponse().setStatus(400).
                setError("Bad Request").
                setPath("/rest-api/books");
    }
}