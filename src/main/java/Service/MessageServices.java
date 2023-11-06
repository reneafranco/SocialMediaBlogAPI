package Service;

import DAO.MessageDAO;
import Model.Message;

import java.util.List;

public class MessageServices {

    MessageDAO messageDAO;


    public MessageServices(){
        this.messageDAO = new MessageDAO();
    }

    public MessageServices(MessageDAO messageDAO){
        this.messageDAO = messageDAO;
    }


    public List<Message> getAllMessages(){
        return messageDAO.MessageList();
    }

    public Message getMessageById(int id){
        return messageDAO.getMessageBiId(id);
    }

    public Message addNewMessage(Message message){
        return messageDAO.insertMessage(message);
    }


}
