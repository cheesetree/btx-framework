package top.cheesetree.btx.framework.database.config;

import com.baomidou.mybatisplus.annotation.DbType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author van
 */
@ConfigurationProperties("btx.mybatis-plus")
@Getter
@Setter
public class BtxMybatisPlusProperties {
    private DbType dbType = DbType.POSTGRE_SQL;
    private Boolean defaultFillColumns = false;
    private List<String> insertDateTimeFillColumns;
    private List<String> updateDateTimeFillColumns;
    private List<String> insertUserIdFillColumns;
}
