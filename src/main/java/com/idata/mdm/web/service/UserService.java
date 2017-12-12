package com.idata.mdm.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idata.mdm.web.service.dao.UserDao;
import com.idata.mdm.web.service.vo.UserVo;

@Service
public class UserService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    public UserService() {

    }

    @Autowired
    private UserDao userDao;

    public boolean login(UserVo userVo) throws ServiceException {
        String loginName = userVo.getLoginName();
        UserVo dbUserVo = userDao.get(loginName);
        if (null == dbUserVo) {
            throw new ServiceException(ServiceCodeConstatnts.USER_NOT_FOUND, "not find user by loginName:" + loginName);
        }
        String password = userVo.getPassword();
        if (!password.equals(dbUserVo.getPassword())) {
            throw new ServiceException(ServiceCodeConstatnts.USER_PASSWORD_ERROR,
                    "user password error,loginName:" + loginName);
        }
        userDao.updateLoginTime(dbUserVo.getId());
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(
                    "[][][user login success,id:" + userVo.getId() + ";loginName:" + dbUserVo.getLoginName() + "]");
        }
        return true;
    }

    public UserVo getLoginUser(UserVo userVo) {
        String loginName = userVo.getLoginName();
        return userDao.get(loginName);
    }

}
