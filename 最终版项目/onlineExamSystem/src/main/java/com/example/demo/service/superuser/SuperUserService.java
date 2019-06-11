package com.example.demo.service.superuser;

/**
 * @author : kongyy
 * @time : 2019/5/25 16:21
 */
public interface SuperUserService {

    public boolean updateUser(int uid) throws Exception;

    public boolean delUser(int uid) throws Exception;
}
