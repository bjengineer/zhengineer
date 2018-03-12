
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
          
        // ��ͻ��˻ظ���Ϣ  
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
//     * ���������Ŀǰ�����������Ҫ�ģ�   
//     * �����յ���Ϣ��ֻҪ����quit���Ͱѷ�������ǰ��ʱ�䷵�ظ��ͻ���   
//     * �����quit����رտͻ�������*/    
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
//        System.out.println("�ͻ��������˶Ͽ�����.....");    
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