package controller;


import common.ResponseCode;
import pojo.Users;
import service.UserService;
import sun.security.krb5.internal.LoginOptions;
import sun.security.util.Password;
import utils.PathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/manage/user/*")
public class UsersController extends HttpServlet {
  private   UserService uc = new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //怎么获取请求路径信息
        String pathInfo = req.getPathInfo();
//        System.out.println(pathInfo);
        String path = PathUtil.getPath(pathInfo);
//        System.out.println(path);
        ResponseCode rs = null;
        //判断一下是什么样的请求
        switch (path){
            case "list":
                rs = listDo(req);
                break;
            case "login":
                rs = loginDo(req);
                break;
            case "disableuser":
                rs= disaableDo(req);
                break;
        }

        //创建统一返回对象


        //调用业务层方法处理业务
//        UserService uc = new UserService();
//         rs = uc.selectAll(pageSize, pageNum);

        //返回响应数据
        resp.getWriter().write(rs.toString());



       /* UserService us = new UserService();
        List<Users> li = us.selectAll(pageSize,pageNum);
        for (int i = 0; i<li.size();i++){
            Users users = li.get(i);
            resp.getWriter().write(users.toString()+"</br>");
        }*/

    }


    private ResponseCode listDo(HttpServletRequest req){
        ResponseCode rs = new ResponseCode();
        //获取参数
        String pageSize = req.getParameter("pageSize");
        String pageNum = req.getParameter("pageNum");

//        HttpSession s = req.getSession();
//
//        Users user = (Users) s.getAttribute("user");
//        if (user == null){
//            rs.setStatus(3);
//            rs.setMag("请登录后操作！");
//            return rs;
//        }
        rs = uc.selectAll(pageSize, pageNum);
        //调用业务层处理业务
        return rs;
    }
    //用户登录请求
    private ResponseCode loginDo(HttpServletRequest req){
        //获取参数
        String username = req.getParameter("username");
//        System.out.println(username);
        String password = req.getParameter("password");
//        System.out.println(password);
        ResponseCode rs = uc.selectOne(username, password);
        HttpSession se = req.getSession();

        se.setAttribute("user", rs.getData());
        //调用业务层处理业务
        return rs;
    }
    //用户禁用请求
    private ResponseCode disaableDo(HttpServletRequest req) {
        ResponseCode rs = new ResponseCode();
        String uid = req.getParameter("uid");
//        HttpSession s = req.getSession();
//
//        Users user = (Users) s.getAttribute("user");
//        if (user == null){
//            rs.setStatus(3);
//            rs.setMag("请登录后操作！");
//            return rs;
//        }
        rs = uc.selectUid( uid );
        return rs;
    }

}
