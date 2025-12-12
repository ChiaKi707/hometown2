package cyber.hometown2.service.Impl;

import cyber.hometown2.mapper.CultureMapper;
import cyber.hometown2.pojo.Culture;
import cyber.hometown2.pojo.Scenery;
import cyber.hometown2.service.CultureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CultureServiceImpl implements CultureService {

    @Autowired
    private CultureMapper cultureMapper;

    //单个查询
    @Override
    public Culture findById(Integer id) {
        return cultureMapper.getById(id);
    }

    //查询所有
    @Override
    public List<Culture> findAll() {
        List<Culture> list = cultureMapper.findAllCulture();
        return list;
    }

    @Override
    public List<Culture> serach(String name) {
        Culture c = new Culture();
        c.setName(name);

        return cultureMapper.search(c);
    }

    //添加
    @Override
    public boolean addCulture(Culture c) {
        c.setCreationDate(LocalDateTime.now());
        c.setUpdateDate(LocalDateTime.now());
        return cultureMapper.insertCulture(c) > 0;
    }

    //修改
    @Override
    public boolean updateCulture(Culture c) {
        c.setUpdateDate(LocalDateTime.now());
        return cultureMapper.updateCulture(c) > 0;
    }

    //删除
    @Override
    public boolean deleteCulture(Integer id) {
        return cultureMapper.deleteCulture(id) > 0;
    }
}
