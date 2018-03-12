/**   
 * 客户端业务处理逻辑   
 *    
 * @author aniyo blog: http://aniyo.iteye.com   
 */  
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.apache.mina.*;

public class MinaClientHandler extends IoHandlerAdapter {    
    // 当客户端连接进入时    
    @Override    
    public void sessionOpened(IoSession session) throws Exception {    
        System.out.println("incomming 客户端: " + session.getRemoteAddress());    
        session.write("i am coming");    
    }    
    
    @Override    
    public void exceptionCaught(IoSession session, Throwable cause)    
            throws Exception {    
        System.out.println("客户端发送信息异常....");    
    }    
    
    // 当客户端发送消息到达时    
    @Override    
    public void messageReceived(IoSession session, Object message)    
            throws Exception {    
    
        System.out.println("服务器返回的数据：" + message.toString());    
    }    
    
    @Override    
    public void sessionClosed(IoSession session) throws Exception {    
        System.out.println("客户端与服务端断开连接.....");    
    }    
    
    @Override    
    public void sessionCreated(IoSession session) throws Exception {    
        // TODO Auto-generated method stub    
        System.out    
                .println("one Client Connection" + session.getRemoteAddress());    
        session.write("我来了······");    
    }    
    
}