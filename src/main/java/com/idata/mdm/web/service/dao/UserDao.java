package com.idata.mdm.web.service.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.idata.mdm.web.service.vo.UserVo;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private UserRowMapper rowMapper = new UserRowMapper();

    public UserVo get(String loginName) {
        String sql = "select * from user where login_name=?";
        List<UserVo> userVos = jdbcTemplate.query(sql, new Object[] { loginName }, rowMapper);
        if (CollectionUtils.isNotEmpty(userVos)) {
            return userVos.get(0);
        }
        return null;
    }

    public void updateLoginTime(Integer userId) {
        String sql = "update user set last_login_time=?,update_time=? where id=?";

        Date now = new Date(System.currentTimeMillis());

        jdbcTemplate.update(sql, now, now, userId);

    }

    private class UserRowMapper implements RowMapper<UserVo> {

        @Override
        public UserVo mapRow(ResultSet rs, int idx) throws SQLException {
            UserVo userVo = new UserVo();
            int clounCount = rs.getMetaData().getColumnCount();
            for (int i = 1; i <= clounCount; i++) {
                String columnName = rs.getMetaData().getColumnName(i);
                String fieldName = convertToObjectFieldName(columnName);
                Object fieldValue = rs.getObject(i);
                if (null == fieldValue) {
                    continue;
                }
                try {
                    BeanUtils.setProperty(userVo, fieldName, fieldValue);
                }
                catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            return userVo;
        }

        private String convertToObjectFieldName(String columnName) {
            if (columnName.indexOf("_") == -1) {
                return columnName;
            }
            String[] splitNames = columnName.split("_");
            StringBuilder fileName = new StringBuilder();
            int length = splitNames.length;
            for (int i = 0; i < length; i++) {
                String split = splitNames[i];
                if (i == 0) {
                    fileName.append(split);
                }
                else {
                    fileName.append((split.substring(0, 1)).toUpperCase());
                    if (split.length() > 1) {
                        fileName.append(split.substring(1, split.length()));
                    }
                }
            }
            return fileName.toString();
        }

    }

}
