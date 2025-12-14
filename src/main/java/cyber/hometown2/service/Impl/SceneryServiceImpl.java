package cyber.hometown2.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cyber.hometown2.mapper.SceneryMapper;
import cyber.hometown2.pojo.PageResult;
import cyber.hometown2.pojo.Scenery;
import cyber.hometown2.service.SceneryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SceneryServiceImpl implements SceneryService {

    @Autowired
    private SceneryMapper sceneryMapper;

    //单个查询
    @Override
    public Scenery findById(Integer id) {
        return sceneryMapper.getById(id);
    }

    //查询所有
    @Override
    public List<Scenery> findAll() {
        List<Scenery> list = sceneryMapper.findAllScenery();
        return list;
    }

    @Override
    public List<Scenery> serach(String name, String location) {
        Scenery s = new Scenery();
        s.setName(name);
        s.setLocation(location);

        return sceneryMapper.search(s);
    }

    //添加
    @Override
    public boolean addScenery(Scenery s) {
        s.setCreationtime(LocalDateTime.now());
        s.setUpdatetime(LocalDateTime.now());
        return sceneryMapper.insertScenery(s) > 0;
    }

    //修改
    @Override
    public boolean updateScenery(Scenery s) {
        s.setUpdatetime(LocalDateTime.now());
        return sceneryMapper.updateScenery(s) > 0;
    }

    //删除
    @Override
    public boolean deleteScenery(Integer id) {
        return sceneryMapper.deleteScenery(id) > 0;
    }

    @Override
    public PageResult<Scenery> list(String name,String location, Integer pageNum, Integer pageSize) {
        // 1. 设置分页
        PageHelper.startPage(pageNum, pageSize);

        // 2. 执行查询
        Scenery queryCondition = new Scenery();
        queryCondition.setName(name);
        queryCondition.setLocation(location);
        List<Scenery> L = sceneryMapper.search(queryCondition);

        // 3. 封装结果
        Page<Scenery> p = (Page<Scenery>) L;
        return new PageResult<>(p.getTotal(), p.getResult());
    }
}
