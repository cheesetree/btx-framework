package top.cheesetree.btx.framework.security.shiro.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import top.cheesetree.btx.framework.security.shiro.constants.BtxSecurityShiroEnum;

/**
 * @author: van
 */
@ConfigurationProperties("btx.security.shiro.cache")
@Getter
@Setter
public class BtxShiroCacheProperties {
    private boolean enabled = false;
    private BtxSecurityShiroEnum.CACHE_TYPE cacheType = BtxSecurityShiroEnum.CACHE_TYPE.INNER;
    private Integer cacheExpire;
    private String authenticationCacheName = "authenticationCache";
    private String authorizationCacheName = "authorizationCache";
}
