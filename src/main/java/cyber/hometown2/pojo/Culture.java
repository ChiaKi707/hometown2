package cyber.hometown2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Culture {
    private Integer id;
    private String name;
    private String description;
    private String image;
    private LocalDateTime creationTime;
    private LocalDateTime updateTime;
}
