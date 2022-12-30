package top.cheesetree.btx.framework.security;

import top.cheesetree.btx.framework.security.model.SecurityFuncDTO;
import top.cheesetree.btx.framework.security.model.SecurityMenuDTO;
import top.cheesetree.btx.framework.security.model.SecurityRoleDTO;

import java.util.List;

/**
 * @author: van
 */
public interface IBtxSecurityPermissionService<T extends SecurityMenuDTO, F extends SecurityFuncDTO,
        R extends SecurityRoleDTO> {
    List<T> getMenu(String userid, String authlevel);

    List<F> getFunc(String userid);

    List<F> getAllFunc();

    List<R> getRole(String userid);
}
