package service;

import common.Const;
import common.ResponseCode;
import dao.UserDao;
import pojo.Users;
import java.util.List;

public class UserService {
    private UserDao ud = new UserDao();
    //查询用户列表业务
    public ResponseCode selectAll(String pageSize, String pageNum) {
        ResponseCode rs = new ResponseCode();
        if (pageSize==null || pageSize.equals("")){
            pageSize="10";
        }
        if (pageNum==null || pageNum.equals("")){
            pageNum="1";
        }

        List<Users> li = ud.selectAll(pageSize,pageNum);
        //如果集合元素是空

        rs.setStatus(0);
        rs.setData(li);
        return rs;
    }
    //用户登录业务
    public ResponseCode selectOne(String username, String password) {
        ResponseCode rs = new ResponseCode();
        if (username==null || username.equals("") || password==null || password.equals("")){
            rs.setStatus(1);
            rs.setMag("账号或密码错误！");
            return rs;
        }
        //查找是否有这样的用户
        Users users =ud.selectOne(username,password);

        //如果用户不存在
        if (users==null){
            rs.setStatus(1);
            rs.setMag("用户不存在！");
            return rs;
        }
        //用户权限
        if (users.getType()!=1){
            rs.setStatus(2);
            rs.setMag("没有操作权限！");
            return rs;
        }
        rs.setStatus(0);
        rs.setData(users);
      return rs;
    }
    //用户禁用业务
    public ResponseCode selectUid(String uids) {
        ResponseCode rs = new ResponseCode();
        if (uids == null || uids.equals("")){
            rs.setStatus(Const.USER_PARAMETER_CODE);
            rs.setMag(Const.USER_PARAMETER_MSG);
            return rs;
        }
        Integer uid = null;
        try {
            uid =Integer.parseInt(uids);
        }catch (Exception e){
            rs.setStatus(Const.USER_INVALID_CODE);
            rs.setMag(Const.USER_INVALID_MSG);
            return rs;
        }

        //查找用户是否存在
        Users users = ud.selectOne(uid);
        //如果用户不存在
        if (users == null){
            rs.setStatus(Const.USER_NO_CODE);
            rs.setMag(Const.USER_NO_MSG);
            return rs;
        }
        //用户是否已经被禁用
        if (users.getStates() == 1){
            rs.setStatus(Const.USER_DISABLE_CODE);
            rs.setMag(Const.USER_DISABLE_MSG);
            return rs;
        }

        int row = ud.UpdateOne(uid);
        if (row<=0){
            rs.setStatus(Const.USER_UPDATE_FAILED_CODE);
            rs.setMag(Const.USER_UPDATE_FAILED_MSG);
        }
        rs.setStatus(0);
        rs.setData(row);
        return rs;
    }


}
