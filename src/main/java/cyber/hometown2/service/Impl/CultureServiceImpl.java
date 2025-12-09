package cyber.hometown2.service.Impl;

import cyber.hometown2.mapper.CultureMapper;
import cyber.hometown2.pojo.Culture;
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

    //添加
    @Override
    public void addCulture(Culture c) {
        c.setCreationDate(LocalDateTime.now());
        c.setUpdateDate(LocalDateTime.now());
        cultureMapper.insertCulture(c);
    }

    //修改
    @Override
    public void updateCulture(Culture c) {
        c.setUpdateDate(LocalDateTime.now());
        cultureMapper.updateCulture(c);
    }

    //删除
    @Override
    public void deleteCulture(Integer id) {
        cultureMapper.deleteCulture(id);
    }
}
