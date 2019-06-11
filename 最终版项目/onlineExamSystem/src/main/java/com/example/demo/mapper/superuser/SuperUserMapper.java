package com.example.demo.mapper.superuser;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author : kongyy
 * @time : 2019/5/25 20:11
 */
@Repository
@Mapper
public interface SuperUserMapper {

    /**
     * 修改用户权限
     * @param uid
     * @return
     * @throws Exception
     */
    public boolean updateUser(@Param("uid") int uid) throws Exception;

    /**
     * 删除用户
     * @param uid
     * @return
     * @throws Exception
     */
    public boolean delUser(@Param("uid") int uid) throws Exception;
}
