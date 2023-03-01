package top.cheesetree.btx.framework.security.shiro.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import top.cheesetree.btx.framework.core.model.ValueObject;

/**
 * @author van
 */
@Getter
@Setter
@NoArgsConstructor
public class AuthTokenInfo implements ValueObject {
    private String accessToken;
    private String refreshToken;
}
