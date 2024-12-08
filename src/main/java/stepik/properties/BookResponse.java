package stepik.properties;

import lombok.*;

import java.time.OffsetDateTime;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse extends Book {

    private Integer id;
    private OffsetDateTime lastUpdated;
}