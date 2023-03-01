package top.cheesetree.btx.framework.security;

import top.cheesetree.btx.framework.core.json.CommJSON;
import top.cheesetree.btx.framework.core.model.ValueObject;
import top.cheesetree.btx.framework.security.model.SecurityAuthUserDTO;
import top.cheesetree.btx.framework.security.model.SecurityUserDTO;

/**
 * @author: van
 */
public interface IBtxSecurityOperation {

    CommJSON<? extends SecurityAuthUserDTO> login(String... args);

    CommJSON logout();

    String getUserId();

    <T extends SecurityUserDTO> T getUserInfo();

    <T extends ValueObject> T getAuthInfo();

    <T extends SecurityUserDTO> CommJSON runas(T user);
}
