package controller;


import common.ResponseCode;
import pojo.Users;
import service.UserService;
import utils.PathUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
        String path = PathUtil.getPath(pathInfo);
        ResponseCode rs = null;
        //判断一下是什么样的请求
        switch (path){
            case "list":
                rs=listDo(req,resp);

                break;
            case "login":
                loginDo(req,resp);
                break;
            case "disableuser":
                rs= disaableDo(req);
                break;
        }

        //返回响应数据


//        resp.getWriter().write(rs.toString());
    }
    //用户登录请求
    public void loginDo(HttpServletRequest req,HttpServletResponse resp){

        //获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        ResponseCode rs = uc.selectOne(username, password);
        HttpSession se = req.getSession();

        se.setAttribute("user", rs.getData());

        Users user=(Users) rs.getData();
        if (user==null){
            rs.setStatus(3);
            rs.setMag("请登录后操作！");
            try {
                resp.getWriter().write(rs.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        try{
            req.getRequestDispatcher("/WEB-INF/home.jsp").forward(req, resp);
        }catch (Exception e){
            e.printStackTrace();
        }
//        return rs;
    }
    //查询用户列表
    private ResponseCode listDo(HttpServletRequest req,HttpServletResponse resp){
        ResponseCode rs = new ResponseCode();
        //获取参数
        String pageSize = req.getParameter("pageSize");
        String pageNum = req.getParameter("pageNum");

        //调用业务层处理业务
        rs = uc.selectAll(pageSize, pageNum);
       req.setAttribute("uli",rs );
        try {
            req.getRequestDispatcher("/WEB-INF/userlist.jsp").forward(req,resp );
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //用户禁用请求
    private ResponseCode disaableDo(HttpServletRequest req) {
        ResponseCode rs = new ResponseCode();
        String uid = req.getParameter("uid");
        rs = uc.selectUid( uid );
        return rs;
    }


}
