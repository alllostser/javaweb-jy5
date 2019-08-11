package dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pojo.Users;

import java.sql.SQLException;
import java.util.List;

/**
 * 连接层
 */
public class UserDao {
    //建立连接
    ComboPooledDataSource co = new ComboPooledDataSource();
    QueryRunner qr = new QueryRunner(co);

    /**
     *查询用户列表
     * @param pageSize
     * @param pageNum
     * @return
     */
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

    /**
     *用户登录
     * @param username
     * @param password
     * @return
     */
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

    /**
     *查询被禁用用户是否存在
     * @param uid
     * @return
     */
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

    /**
     *禁用用户
     * @param uid
     * @return
     */
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
