package top.cheesetree.btx.framework.cache.redis;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @author van
 */
@Getter
@Setter
public class BtxRedisSerializer {
    private RedisSerializer<?> keySerializer;

    private RedisSerializer<?> valueSerializer;

    private RedisSerializer<?> hashKeySerializer;

    private RedisSerializer<?> hashValueSerializer = valueSerializer;

    private RedisSerializer<String> stringSerializer = RedisSerializer.string();
}
