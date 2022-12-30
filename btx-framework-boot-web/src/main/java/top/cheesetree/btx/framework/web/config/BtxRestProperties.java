package top.cheesetree.btx.framework.web.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author van
 */
@ConfigurationProperties("btx.web.rest")
@Data
public class BtxRestProperties {
    private int connectTimeOut = 2;

    private int readTimeOut = 10;

    private int writeTimeOut = readTimeOut;

    private int maxPoolIdle = 5;

    private int maxPoolLiveTime = 5;
}
