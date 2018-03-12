
import java.util.Date;

import org.apache.mina.core.service.IoHandlerAdapter;

import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;




public class TimeServerHandler extends IoHandlerAdapter {   
	@Override  
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {  
        System.out.println("MinaServerHandler---exceptionCaught");  
    }  
  
  @Override  
    public void messageReceived(IoSession session, Object message) throws Exception {  
        System.out.println("MinaServerHandler---messageReceived"+message.toString());  
          
        // 向客户端回复消息  
        session.write("server replay--"+message);  
    }
  
    @Override  
    public void messageSent(IoSession session, Object message) throws Exception {  
        System.out.println("MinaServerHandler---messageSent:"+message.toString());  
    }  
  
    @Override  
    public void sessionClosed(IoSession session) throws Exception {  
        System.out.println("MinaServerHandler---sessionClosed");  
    }  
  
    @Override  
    public void sessionCreated(IoSession session) throws Exception {  
        System.out.println("MinaServerHandler---sessionCreated");  
    }  
  
    @Override  
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {  
        System.out.println("MinaServerHandler---sessionIdle");  
    }  
  
    @Override  
    public void sessionOpened(IoSession session) throws Exception {  
        System.out.println("MinaServerHandler---sessionOpened");  
    }
        
//    @Override    
//    public void exceptionCaught(IoSession session, Throwable cause)    
//            throws Exception {    
//        cause.printStackTrace();    
//    }    
//    
//    /*   
//     * 这个方法是目前这个类里最主要的，   
//     * 当接收到消息，只要不是quit，就把服务器当前的时间返回给客户端   
//     * 如果是quit，则关闭客户端连接*/    
//    @Override    
//    public void messageReceived(IoSession session, Object message)    
//            throws Exception {    
//        String str = message.toString();    
//        if (str.trim().equalsIgnoreCase("quit")) {    
//            session.close();    
//            return;    
//        }    
//        Date date = new Date();    
//        System.out.println("hello"+str+session.getRemoteAddress()+date.toString());    
//            
//            session.write("iamrecived");    
//      
//        System.out.println("Message written...");    
//    
//    }    
//        
//    @Override    
//    public void sessionClosed(IoSession session) throws Exception {    
//        // TODO Auto-generated method stub    
//        super.sessionClosed(session);    
//        System.out.println("客户端与服务端断开连接.....");    
//    }  
//    
//    
//  
////    @Override  
////    public void messageReceived(IoSession session, Object message)  
////            throws Exception {  
////        String receiverContent = (String)message;  
////        System.out.println("server messageReceived: "+receiverContent);  
////        session.write("Server has received message");  
////    }  
////  
//    @Override  
//    public void messageSent(IoSession session, Object message) throws Exception {  
//        System.out.println("messageSent");  
//    }  
//  
//
//  
//    @Override  
//    public void sessionCreated(IoSession session) throws Exception {  
//        System.out.println("sessionCreated");  
//    }  
//  
////    @Override  
////    public void sessionIdle(IoSession session, IdleStatus status)  
////            throws Exception {  
////        System.out.println("sessionIdle");  
////    }  
//  
//    @Override  
//    public void sessionOpened(IoSession session) throws Exception {  
//        System.out.println("sessionOpened");  
//    }
//    
}