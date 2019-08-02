package dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pojo.Users;

import java.sql.SQLException;
import java.util.List;

public class UserDao {
    ComboPooledDataSource co = new ComboPooledDataSource();
    QueryRunner qr = new QueryRunner(co);
    public List<Users> selectAll(String pageSize, String pageNum) {
        String sql = "select * from users";
        List<Users> list = null;
        try {
            list = qr.query(sql, new BeanListHandler<Users>(Users.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Users selectOne(String username, String password) {
        String sql = "select * from users where uname=? and psd=?";
        Users u = null;
        try {
            u = qr.query(sql, new BeanHandler<Users>(Users.class),username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
    public Users selectOne(int uid) {
        String sql = "select * from users where uid=?";
        Users u = null;
        try {
            u = qr.query(sql, new BeanHandler<Users>(Users.class),uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
    public int UpdateOne(int uid){
        String sql = "update users set states=1 where uid=?";
        int u = 0;
        try {
            u = qr.update(sql,uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
}
