package org.example.dippy.services;

import javassist.NotFoundException;
import org.example.dippy.dao.Repository;
import org.example.dippy.exception.DataNotFoundException;
import org.example.dippy.models.Comment;
import org.example.dippy.models.Message;

import java.util.*;

public class MessageService {

    Map<Long,Message> messages = new Repository().getMessages();
    public MessageService(){

        messages.put(1L,new Message(1L,"Dipali","Dipali"));
        messages.put(2L,new Message(2L,"Nirav","Nirav"));
        Map<Long,Comment> comments = new HashMap<>();
        comments.put(1L,new Comment(1L,"Lookign Beautiful"));
        messages.get(1L).setComments(comments);
    }

    public List<Message> getAllMessages(){
        return new ArrayList<Message>(messages.values());
    }

    public List<Message> getMessageOfYear(int year){
        Calendar cal = Calendar.getInstance();
        List<Message> messagesOfYear = new ArrayList<>();
        for(Message message:messages.values()){
            cal.setTime(message.getCreatedDate());
            if(cal.get(Calendar.YEAR)==year){
                messagesOfYear.add(message);
            }
        }
        return messagesOfYear;
    }

    public List<Message> getMessageOfPagination(int start,int size){
        List<Message> messagesOfPagination = new ArrayList<>(messages.values());
        return messagesOfPagination.subList(start,start+size);
    }

    public Message getMessage(Long id) throws Throwable {

        Message message =  messages.get(id);
        if(message==null){
            throw new DataNotFoundException("message with id: "+id+"  not found");
            //throw new Exception("message");
            //throw new Throwable("");
        }
        return message;
    }

    public Message addMessage(Message message){
        message.setMessageId((long) (messages.size()+1));
        messages.put(message.getMessageId(),message);
        return messages.get(message.getMessageId());
    }

    public Message updateMessage(Long id,Message message){
        if(message.getMessageId()<=0){
            return null;
        }
        messages.put(id,message);
        return message;
    }
    public void removeMessage(Long id){
        messages.remove(id);
    }
}

/*Message m1 = new Message(1,"Dipali");
    Message m2 = new Message(2,"Nirr");
    Message m3 = new Message(3,"Raja");

    List<Message> list = new ArrayList<>();

    public List<Message> getList() {
        list.add(m1);
        list.add(m2);
        list.add(m3);

        return  list;
    }*/

