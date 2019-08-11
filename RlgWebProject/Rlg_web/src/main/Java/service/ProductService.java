package service;

import common.ResponseCode;
import dao.productDao;
import pojo.Product;

import java.util.List;

public class ProductService {
    private productDao pd = new productDao();

    public ResponseCode getAll(String pageSize ,String pageNum) {
        if (pageSize==null || pageSize.equals("")){
            pageSize="10";
        }
        if (pageNum==null || pageNum.equals("")){
            pageNum="1";
        }
        ResponseCode rs = null;
        List<Product> li = pd.selectAll(pageSize,pageNum);
        rs = ResponseCode.successRs(li);
        return rs;
    }
}
