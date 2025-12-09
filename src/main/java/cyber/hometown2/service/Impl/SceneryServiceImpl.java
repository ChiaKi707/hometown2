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

    //添加
    @Override
    public void addScenery(Scenery s) {
        s.setCreationtime(LocalDateTime.now());
        s.setUpdatetime(LocalDateTime.now());
        sceneryMapper.insertScenery(s);
    }

    //修改
    @Override
    public void updateScenery(Scenery s) {
        s.setUpdatetime(LocalDateTime.now());
        sceneryMapper.updateScenery(s);
    }

    //删除
    @Override
    public void deleteScenery(Integer id) {
        sceneryMapper.deleteScenery(id);
    }
}
