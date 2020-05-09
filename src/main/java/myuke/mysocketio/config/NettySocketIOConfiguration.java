package myuke.mysocketio.config;

import com.corundumstudio.socketio.Configuration;
import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.IOException;

public class NettySocketIOConfiguration extends Configuration {

    public void setKeyStoreResource(String resource) {
        if (StringUtils.isEmpty(resource)) {
            return;
        }

        try {
            this.setKeyStore(new FileInputStream(resource));
        } catch (IOException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("Netty JKS Initialization Error");
        }
    }
}
