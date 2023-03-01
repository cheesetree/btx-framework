package top.cheesetree.btx.framework.database.config;


import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import top.cheesetree.btx.framework.database.handler.IBtxMybatisPlusAutoFill;
import top.cheesetree.btx.framework.database.handler.IBtxMybatisPlusMetaHandler;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author van
 */
@Configuration
@MapperScan("${mybatis-plus.mapper-scan:top.cheesetree.**.mapper}")
@EnableTransactionManagement
@EnableConfigurationProperties({BtxMybatisPlusProperties.class})
public class MybatisPlusConfigure {
    @Autowired
    BtxMybatisPlusProperties btxMybatisPlusProperties;

    @Autowired(required = false)
    IBtxMybatisPlusAutoFill btxMybatisPlusAutoFill;

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(PaginationInnerInterceptor paginationInnerInterceptor) {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(paginationInnerInterceptor);
        return interceptor;
    }

    @Bean
    @ConditionalOnMissingBean(IBtxMybatisPlusMetaHandler.class)
    public MetaObjectHandler metaObjectHandler() {
        return new MetaObjectHandler() {
            final String[] DEFAULT_INSERTFILL_COLUMNS = {"createTime", "createDate"};
            final String[] DEFAULT_UPDATEFILL_COLUMNS = {"updateTime", "updateDate"};

            final String[] DEFAULT_USERFILL_COLUMNS = {"createUser"};

            @Override
            public void insertFill(MetaObject metaObject) {
                if (btxMybatisPlusProperties.getInsertDateTimeFillColumns() != null) {
                    btxMybatisPlusProperties.getInsertDateTimeFillColumns().forEach((String fc) -> {
                        this.strictInsertFill(metaObject, fc, () -> LocalDateTime.now(), LocalDateTime.class);
                    });
                }

                if (btxMybatisPlusProperties.getDefaultFillColumns()) {
                    Arrays.stream(DEFAULT_INSERTFILL_COLUMNS).forEach((String fc) -> {
                        this.strictInsertFill(metaObject, fc, () -> LocalDateTime.now(), LocalDateTime.class);
                    });
                }

                if (btxMybatisPlusAutoFill != null) {
                    if (btxMybatisPlusProperties.getInsertUserIdFillColumns() != null) {
                        btxMybatisPlusProperties.getInsertUserIdFillColumns().forEach((String fc) -> {
                            this.strictInsertFill(metaObject, fc, () -> btxMybatisPlusAutoFill.getCurrUserId(),
                                    String.class);
                        });
                    }

                    if (btxMybatisPlusProperties.getDefaultFillColumns()) {
                        Arrays.stream(DEFAULT_USERFILL_COLUMNS).forEach((String fc) -> {
                            this.strictInsertFill(metaObject, fc, () -> btxMybatisPlusAutoFill.getCurrUserId(),
                                    String.class);
                        });
                    }
                }
            }

            @Override
            public void updateFill(MetaObject metaObject) {
                if (btxMybatisPlusProperties.getUpdateDateTimeFillColumns() != null) {
                    btxMybatisPlusProperties.getUpdateDateTimeFillColumns().forEach((String fc) -> {
                        this.strictUpdateFill(metaObject, fc, () -> LocalDateTime.now(), LocalDateTime.class);
                    });
                }

                if (btxMybatisPlusProperties.getDefaultFillColumns()) {
                    Arrays.stream(DEFAULT_UPDATEFILL_COLUMNS).forEach((String fc) -> {
                        this.strictUpdateFill(metaObject, fc, () -> LocalDateTime.now(), LocalDateTime.class);
                    });
                }
            }
        };
    }

    @Bean
    @Primary
    public PaginationInnerInterceptor btxPaginationInnerInterceptor() {
        PaginationInnerInterceptor pi = new PaginationInnerInterceptor(btxMybatisPlusProperties.getDbType());
        return pi;
    }

}
