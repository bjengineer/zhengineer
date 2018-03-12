/**     
 * mina�ͻ���     
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
               
        //�����������ݵĹ�����       
        DefaultIoFilterChainBuilder chain = connector.getFilterChain();       
               
        //�趨�����������һ��һ��(/r/n)�Ķ�ȡ����       
        chain.addLast("myChin", new ProtocolCodecFilter(new TextLineCodecFactory()));       
               
        //�ͻ��˵���Ϣ��������һ��SamplMinaServerHander����       
        connector.setHandler(new MinaClientHandler());       
               
        //set connect timeout       
        connector.setConnectTimeout(5000);       
               
        //���ӵ���������       
        ConnectFuture cf = connector.connect(new InetSocketAddress("localhost",8091));       
               
//        Wait for the connection attempt to be finished.       
        cf.awaitUninterruptibly();       
               
        cf.getSession().getCloseFuture().awaitUninterruptibly();       
               
        connector.dispose();       
    }      
}