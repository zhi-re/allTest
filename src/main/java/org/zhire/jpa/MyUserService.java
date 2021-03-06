package org.zhire.jpa;

import java.util.List;

public interface MyUserService {
    void insert();

    ZpUserBusiness testTran(User user);

    User findByUserName(String userName);

    User findByUserNameOrEmail(String userName, String email);

    List<User> findAll(int page, int pageSize);

    List<UserAndInfo> findAllInfo(int page, int pageSize);

    ZpUserBusiness findFirst(ZpUserBusiness.FROMTYPE fromType);

    void findAllList();

    void updateById(String id);

    User insert(User user);

    void findIn();
}
