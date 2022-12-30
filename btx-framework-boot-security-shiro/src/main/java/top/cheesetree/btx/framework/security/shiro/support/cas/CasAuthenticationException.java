package top.cheesetree.btx.framework.security.shiro.support.cas;

import org.apache.shiro.authc.AuthenticationException;

/**
 * @author van
 */
public class CasAuthenticationException extends AuthenticationException {
    public CasAuthenticationException() {
    }

    public CasAuthenticationException(String message) {
        super(message);
    }

    public CasAuthenticationException(Throwable cause) {
        super(cause);
    }

    public CasAuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
