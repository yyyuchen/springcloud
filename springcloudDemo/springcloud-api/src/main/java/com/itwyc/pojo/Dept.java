package com.itwyc.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)    //链式写法
public class Dept implements Serializable {

    private Long deptno;      //主键
    private String dname;
    private String db_source;    //此字段是记录来自哪个数据库 ~微服务，一个服务器对应一个数据库

    public Dept(String dname) {
        this.dname = dname;
    }

    /**
     * 传统写法：
     * Dept dept = new Dept();
     * dept.setDeptNo(11);
     * dept.setDname("张三");
     *
     * 链式写法：
     * dept.setDeptNo(11).setDname("张三");
     *
     */
}
