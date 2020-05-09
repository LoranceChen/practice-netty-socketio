package myuke.mysocketio.config;

import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.io.IOException;

@Configuration
@Slf4j
public class SocketIOConfig {

    @Resource
    private NettySocketioProps nettySocketioProps;

    @Resource
    private ApplicationContext applicationContext;

    @Bean
    public NettySocketIOConfiguration nettySocketIOConfiguration() {
        NettySocketIOConfiguration configuration = new NettySocketIOConfiguration();
        configuration.setHostname(nettySocketioProps.getHostname());
        configuration.setPort(nettySocketioProps.getPort());
        configuration.getSocketConfig().setReuseAddress(nettySocketioProps.getReuseAddress());

        //configuration.setBossThreads(nettySocketioProps.getBossThreads());
        //configuration.setWorkerThreads(nettySocketioProps.getWorkerThreads());
        //configuration.setUseLinuxNativeEpoll(!PlatformDependent.isWindows());
        return configuration;
    }

    @Bean
    public SocketIOServer socketIOServer(NettySocketIOConfiguration nettySocketIOConfiguration) {
        SocketIOServer server = new SocketIOServer(nettySocketIOConfiguration);
        this.addNamespace(server);
        return server;
    }

    @Bean(initMethod = SocketIOServerManager.INIT_METHOD, destroyMethod = SocketIOServerManager.DESTROY_METHOD)
    public SocketIOServerManager socketIOServerManager(SocketIOServer socketIOServer) {
        SocketIOServerManager socketIOServerManager = new SocketIOServerManager(socketIOServer);
        return socketIOServerManager;
    }

    @Bean
    public SpringAnnotationScanner springAnnotationScanner(SocketIOServer socketServer) {
        return new SpringAnnotationScanner(socketServer);
    }

    private void setSocketKeySore(NettySocketIOConfiguration configuration) {
        org.springframework.core.io.Resource keyStoreResource = applicationContext.getResource(nettySocketioProps.getKeyStorePath());
        try {
            configuration.setKeyStore(keyStoreResource.getInputStream());
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        configuration.setKeyStorePassword(nettySocketioProps.getKeyStorePassword());
    }

    private void addNamespace(SocketIOServer server) {
        server.addNamespace(CommonConsts.BACKGROUND_NAMESPACE);
        server.getNamespace(CommonConsts.BACKGROUND_NAMESPACE).addConnectListener(client -> {
            log.info("Socket client connect. nsp: {}; sessionId: {}", client.getNamespace().getName(), client.getSessionId());
        });
        server.getNamespace(CommonConsts.BACKGROUND_NAMESPACE).addDisconnectListener(client -> {
            log.info("Socket client disconnect. nsp: {}; sessionId: {}", client.getNamespace().getName(), client.getSessionId());
        });
    }

    @Slf4j
    public static class SocketIOServerManager {

        public static final String INIT_METHOD = "startup";

        public static final String DESTROY_METHOD = "shutdown";

        private static final String HOST_LOCALHOST = "localhost";

        private SocketIOServer socketIOServer;

        public SocketIOServerManager(SocketIOServer socketIOServer) {
            this.socketIOServer = socketIOServer;
        }

        public void startup() {
            String host = getHost();

            log.info("Netty 'socket.io' Server start ... ");

            socketIOServer.start();

            log.info("Netty 'socket.io' Server running in {}", host);
        }

        public void shutdown() {
            String host = getHost();

            log.info("Netty 'socket.io' Server ({}) stop ... ", host);

            socketIOServer.stop();

            log.info("Netty 'socket.io' Server ({}) was shutdown ", host);
        }

        public String getHost() {
            String hostname = socketIOServer.getConfiguration().getHostname();
            hostname = StringUtils.isEmpty(hostname) ? HOST_LOCALHOST : hostname;
            int port = socketIOServer.getConfiguration().getPort();
            return String.format("%s:%s", hostname, port);
        }
    }
}
