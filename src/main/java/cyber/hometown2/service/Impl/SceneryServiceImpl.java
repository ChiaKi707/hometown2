package cyber.hometown2.service.Impl;


import cyber.hometown2.mapper.SceneryMapper;
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
}
