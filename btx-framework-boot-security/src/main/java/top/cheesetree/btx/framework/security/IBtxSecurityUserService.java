package top.cheesetree.btx.framework.security;

import top.cheesetree.btx.framework.core.json.CommJSON;
import top.cheesetree.btx.framework.security.model.SecurityUserDTO;

/**
 * @author: van
 */
public interface IBtxSecurityUserService<T extends SecurityUserDTO> {
    CommJSON<T> login(String loginid,
                      String loginpwd);

    CommJSON logout();

    CommJSON<String> gethdImgurl(String url, String userid);

    CommJSON changePwd(String userid, String loginpwd,
                       String newpwd);

    CommJSON<T> getUserInfo(String uid);
}
