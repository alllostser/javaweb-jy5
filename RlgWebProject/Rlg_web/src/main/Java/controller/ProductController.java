package controller;

import common.ResponseCode;
import service.ProductService;
import utils.PathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductController",value = "/manage/product/*")
public class ProductController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        //怎么获取请求路径信息
        String pathInfo = req.getPathInfo();
        String path = PathUtil.getPath(pathInfo);
        ResponseCode rs = null;
        //判断一下是什么样的请求
        switch (path){
            case "list":
                rs=getAll(req);
                break;
        }
        res.getWriter().write(rs.toString());
    }
    private ProductService ps = new ProductService();


    /**
     * 查询所以商品列表list
     * @param req
     * @return
     */
    private ResponseCode getAll(HttpServletRequest req){
        //获取参数
        String pageSize = req.getParameter("pageSize");
        String pageNum = req.getParameter("pageNum");
        //调用业务层
        ResponseCode rs = ps.getAll(pageSize,pageNum);
        return rs;
    }

}
