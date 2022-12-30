package top.cheesetree.btx.framework.security.controller;

import top.cheesetree.btx.framework.core.model.ValueObject;
import top.cheesetree.btx.framework.security.model.SecurityUserDTO;

/**
 * @author: van
 */
public interface SecurityController {
    String getUserId();

    <T extends SecurityUserDTO> T getUser();

    <T extends ValueObject> T getAuthInfo();
}
