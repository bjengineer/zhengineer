/**     
 * mina客户端     
 * @author aniyo      
 * blog:http://aniyo.iteye.com   
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
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.apache.mina.*;

public class MinaClient {       
      
    public static void main(String []args)throws Exception{       
               
        //Create TCP/IP connection       
        NioSocketConnector connector = new NioSocketConnector();       
               
        //创建接受数据的过滤器       
        DefaultIoFilterChainBuilder chain = connector.getFilterChain();       
               
        //设定这个过滤器将一行一行(/r/n)的读取数据       
        chain.addLast("myChin", new ProtocolCodecFilter(new TextLineCodecFactory()));       
               
        //客户端的消息处理器：一个SamplMinaServerHander对象       
        connector.setHandler(new MinaClientHandler());       
               
        //set connect timeout       
        connector.setConnectTimeout(5000);       
               
        //连接到服务器：       
        ConnectFuture cf = connector.connect(new InetSocketAddress("localhost",8091));       
               
//        Wait for the connection attempt to be finished.       
        cf.awaitUninterruptibly();       
               
        cf.getSession().getCloseFuture().awaitUninterruptibly();       
               
        connector.dispose();       
    }      
}