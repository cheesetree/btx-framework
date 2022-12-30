package top.cheesetree.btx.framework.web.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author van
 */
@ConfigurationProperties("btx.web")
@Data
public class BtxWebProperties {
    private String dateformat = "yyyy-MM-dd HH:mm:ss";
    private boolean writedateusedateformat = true;
}
