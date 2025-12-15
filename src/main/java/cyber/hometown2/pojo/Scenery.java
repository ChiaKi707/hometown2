package cyber.hometown2.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Scenery {
    private Integer id;//id
    private String name;//景点名称
    private String description;//简介
    private String image;//图片
    private String location;//地址
    private String price;//门票价格
    private LocalDateTime creationTime;//创建时间
    private LocalDateTime updateTime;//修改时间
}
