package com.ypj.main;

/**
 * Created by ypj on 2019/1/5.
 */

import com.ypj.mapper.RoleMapper;
import com.ypj.po.Role;
import com.ypj.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import org.apache.log4j.Logger;

public class Chapter3Main {
    public static void main(String[] args) {
        Logger log = Logger.getLogger(Chapter3Main.class);
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRole(1L);
            log.info(role.getRoleName());
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}