package com.springboot.websocket.websocket;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 @author MinXin Huang
 @see
 @since version 1.0
 @create 2019/8/5
*/

@ServerEndpoint("/server-chatRoom/{userName}")
public class ChatroomServerPoint {

    private static Map<String,Session> map = new ConcurrentHashMap<>();
    @OnOpen
    public void onSession(@PathParam("userName")String username, Session session) {
        sendTextAll("欢迎用户["+username+"]来到聊天室");
        String sessionId = session.getId();
        map.put(sessionId,session);

    }

    @OnMessage
    public void onMessage(@PathParam("userName")String username, Session session,String message) {
        sendTextAll("用户[" + username + "]:"+message);
    }

    private void sendTextAll(String message) {
        map.forEach((sessionId, session) -> {
            sendMessage(session,message);
        } );
    }

    @OnClose
    public void onClose(@PathParam("userName")String username, Session session) {
        map.remove(session.getId());
        sendTextAll("用户["+username+"]离开聊天室");
    }
    private void sendMessage(Session session,String message) {
        RemoteEndpoint.Basic basic = session.getBasicRemote();
        try {
            basic.sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
