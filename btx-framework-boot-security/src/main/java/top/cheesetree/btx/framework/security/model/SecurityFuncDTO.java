package top.cheesetree.btx.framework.security.model;

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
public abstract class SecurityFuncDTO implements ValueObject {
    private String funcCode;
    private String funcName;
    private String funcDesc;
    private String note;
    private String actionLink;
}
