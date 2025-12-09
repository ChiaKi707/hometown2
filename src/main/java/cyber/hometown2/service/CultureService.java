package cyber.hometown2.service;

import cyber.hometown2.pojo.Culture;

import java.util.List;

public interface CultureService {

    /**
     * id查询
     * @param id
     * @return
     */
    Culture findById(Integer id);

    /**
     * 查询所有
     * @return
     */
    List<Culture> findAll();

    /**
     * 添加
     * @param c
     */
    void addCulture(Culture c);

    /**
     * 修改
     * @param c
     */
    void updateCulture(Culture c);

    /**
     * 删除
     * @param id
     */
    void deleteCulture(Integer id);
}
