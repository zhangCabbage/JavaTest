package zhang.algorithm.JavaTest.IO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/4/7
 * Time: 下午2:57
 * To change this template use File | Settings | File Templates.
 */
public class TCPServer {

    static class HandleProtocol {
        private int size;

        public HandleProtocol(int size) {
            this.size = size;
        }

        public void handleAccept(SelectionKey key) throws IOException, InterruptedException {
            SocketChannel channel = ((ServerSocketChannel) key.channel()).accept();
            channel.configureBlocking(false);
            Thread.sleep(2000);
            channel.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocateDirect(size));
        }

        /**
         * 对buffer的控制操作
         *
         * @param key
         * @throws IOException
         */
        public void handleRead(SelectionKey key) throws IOException {
            SocketChannel channel = (SocketChannel) key.channel();
            ByteBuffer buf = (ByteBuffer) key.attachment();
            long bytesRead = channel.read(buf);
            System.out.println("receive data --> " + buf);
            System.out.println("bytesRead --> " + bytesRead);

            if (bytesRead == -1) {
                channel.close();
            } else if (bytesRead > 0) {
                key.interestOps(SelectionKey.OP_READ);
            }
        }
    }

    public static void main(String[] args) {
        try {
            int port = 8888;
            int timeout = 1000;

            Selector selector = Selector.open();

            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(port));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            HandleProtocol protocol = new HandleProtocol(256);
            while (true) {
                if (selector.select(timeout) == 0) {
                    System.out.println(System.currentTimeMillis() + " empty run!");
                    continue;
                }
                System.out.println("==============");
                Iterator<SelectionKey> keyIter = selector.selectedKeys().iterator();
                int i = 1;
                while (keyIter.hasNext()) {
                    SelectionKey key = keyIter.next();
                    if (key.isAcceptable()) {
                        System.out.println(System.currentTimeMillis() + " [" + i + "] Accept!");
                        protocol.handleAccept(key);
                    }
                    if (key.isReadable()) {
                        System.out.println(System.currentTimeMillis() + " [" + i + "] Read!");
                        protocol.handleRead(key);
                    }
                    i++;
                    keyIter.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
