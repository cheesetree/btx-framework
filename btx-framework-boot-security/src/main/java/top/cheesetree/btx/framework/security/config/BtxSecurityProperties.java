package top.cheesetree.btx.framework.security.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: van
 */
@ConfigurationProperties(prefix = "btx.security")
@Getter
@Setter
public class BtxSecurityProperties {
    private String[] contextInterceptorExcludePathPatterns = new String[1];
    private String errorPath = "";
    private String loginPath = "";
    private String noAuthPath = "";
    private String expirePath = noAuthPath;
}
