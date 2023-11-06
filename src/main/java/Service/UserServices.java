package Service;

import DAO.UserDAO;
import Model.User;

import java.util.List;

public class UserServices {

    UserDAO userDAO;

    public UserServices(){
        userDAO = new UserDAO();
    }

    public UserServices(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public List<User> getAllUser(){
        return userDAO.userList();
    }

    public User addNewUser(User user){
        return userDAO.insertUser(user);
    }

   public User UpdateUser(int id, User user){
        if(userDAO.getUserById(id)==null){
            return null;
        }

        userDAO.UpdateUser(id, user);
        return null;
   }




}
