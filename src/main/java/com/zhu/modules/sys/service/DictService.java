package com.zhu.modules.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhu.modules.sys.dao.DictDao;
import com.zhu.modules.sys.entity.Dict;

@Service
public class DictService {

    @Autowired
    private DictDao dictDao;

    public Dict get(String id) {
        return dictDao.get(id);
    }

    public List<Dict> findAllDict(Dict entity) {
        return dictDao.findAllList(entity);
    }

    public void save(Dict entity) {
        Dict d = get(entity.getId());
        if (d == null) {
            dictDao.insert(entity);
        } else {
            dictDao.update(entity);
        }
    }

}
