package stepik.properties;

import lombok.*;
import lombok.experimental.Accessors;


import java.time.OffsetDateTime;

@Setter
@Getter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse extends Book {

    private Integer id;
    private OffsetDateTime lastUpdated;

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