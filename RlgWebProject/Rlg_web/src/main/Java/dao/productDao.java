package dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pojo.Product;
import pojo.Users;

import java.sql.SQLException;
import java.util.List;

public class productDao {
    //建立连接
    ComboPooledDataSource co = new ComboPooledDataSource();
    QueryRunner qr = new QueryRunner(co);
    public List<Product> selectAll(String pageSize ,String pageNum) {
        String sql = "select * from products";
        List<Product> list = null;
        try {
            list = qr.query(sql, new BeanListHandler<Product>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }
}
