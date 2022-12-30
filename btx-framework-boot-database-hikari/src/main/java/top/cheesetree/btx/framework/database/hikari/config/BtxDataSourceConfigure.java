package top.cheesetree.btx.framework.database.hikari.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author van
 */
@ConfigurationProperties(prefix = "btx.database")
@Getter
@Setter
public class BtxDataSourceConfigure {
    private String appId;
    private String secretKey;
}
