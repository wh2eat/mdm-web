package com.idata.mdm.web.controller.dto;

import com.idata.mdm.web.service.vo.UserVo;

public class UserDTO {

    private String loginName;

    private String password;

    private Boolean keepSession;

    public UserDTO() {
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getKeepSession() {
        return keepSession;
    }

    public void setKeepSession(Boolean keepSession) {
        this.keepSession = keepSession;
    }

    public UserVo convertToUser() {
        UserVo userVo = new UserVo();
        userVo.setLoginName(loginName);
        userVo.setPassword(password);
        return userVo;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("loginName:").append(loginName).append(";password:").append(password).append(";keepSession:")
                .append(keepSession);
        return builder.toString();
    }

}
