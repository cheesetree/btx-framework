package top.cheesetree.btx.framework.security.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author: van
 */
@EnableConfigurationProperties({BtxSecurityProperties.class})
@Configuration
public class BtxSecurityConfigure {
}
