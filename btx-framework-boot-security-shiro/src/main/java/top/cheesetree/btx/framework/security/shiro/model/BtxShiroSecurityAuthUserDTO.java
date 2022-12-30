package top.cheesetree.btx.framework.security.shiro.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import top.cheesetree.btx.framework.security.model.SecurityAuthUserDTO;

/**
 * @author van
 */
@NoArgsConstructor
@Getter
@Setter
public class BtxShiroSecurityAuthUserDTO<U extends BtxShiroSecurityUserDTO, T extends AuthTokenInfo> extends SecurityAuthUserDTO<U, T> {
}
