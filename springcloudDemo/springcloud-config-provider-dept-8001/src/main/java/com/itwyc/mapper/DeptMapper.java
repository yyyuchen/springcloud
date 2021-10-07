package com.itwyc.mapper;

import com.itwyc.pojo.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptMapper {
    @Insert("insert into dept (dname, db_source) values (#{dname}, DATABASE())")
    boolean addDept(Dept dept);

    @Select("select * from dept where deptno = #{deptno}")
    Dept queryById(Long id);

    @Select("select * from dept")
    List<Dept> queryAll();

}
