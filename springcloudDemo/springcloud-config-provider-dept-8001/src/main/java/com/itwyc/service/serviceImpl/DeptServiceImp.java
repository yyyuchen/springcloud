package com.itwyc.service.serviceImpl;

import com.itwyc.mapper.DeptMapper;
import com.itwyc.service.DeptService;
import com.itwyc.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImp implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    public boolean addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    public Dept queryById(Long id) {
        return deptMapper.queryById(id);
    }

    public List<Dept> queryAll() {
        return deptMapper.queryAll();
    }
}
