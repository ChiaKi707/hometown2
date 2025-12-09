package cyber.hometown2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    private Integer id;//id
    private String name;//美食名称
    private String description;//简介
    private String image;//图片
    private LocalDateTime creationDate;//创建时间
    private LocalDateTime updateDate;//修改时间
}
