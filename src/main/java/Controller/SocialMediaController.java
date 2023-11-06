package Controller;

import Model.User;
import Service.MessageServices;
import Service.UserServices;
import io.javalin.Javalin;

import javax.naming.Context;
import java.util.List;

public class SocialMediaController {

    UserServices userServices;
    MessageServices messageServices;

    public SocialMediaController(){
        this.userServices = new UserServices();
        this.messageServices = new MessageServices();
    }

    public void startAPI(){
        Javalin app = Javalin.create();

    }

    public void getAllUsers(Context ctx){
        List<User> users = userServices.getAllUser();

    }

}
