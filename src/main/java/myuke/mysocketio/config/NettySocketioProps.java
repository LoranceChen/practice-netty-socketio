package myuke.mysocketio.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = NettySocketioProps.PREFIX)
@Data
public class NettySocketioProps {
    public static final String PREFIX = "netty.socketio";

    private String hostname;
    private Integer port;
    private Integer bossThreads = 1;
    private Integer workerThreads = Runtime.getRuntime().availableProcessors() * 2;
    private Boolean reuseAddress = true;
    private String keyStorePath;
    private String keyStorePassword;
}
