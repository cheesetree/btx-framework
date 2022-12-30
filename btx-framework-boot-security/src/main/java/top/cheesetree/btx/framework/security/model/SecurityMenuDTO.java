package top.cheesetree.btx.framework.security.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import top.cheesetree.btx.framework.core.model.ValueObject;

/**
 * @author: van
 */
@Getter
@Setter
@NoArgsConstructor
public abstract class SecurityMenuDTO implements ValueObject {
    private String menuId;
    private String menuName;
    private String menuUrl;
    private String menuDesc;
    private String menuLevel;
    private String authLevel;
    private String target;
    private String note;
    private String menuIcon;
    private String pMenuId;
    private String param1;
    private String param2;
}
