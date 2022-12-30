package top.cheesetree.btx.framework.cache.redis;

import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheWriter;

/**
 * @author van
 */
public class BtxRedisCache extends RedisCache {

    protected BtxRedisCache(String name, RedisCacheWriter cacheWriter, RedisCacheConfiguration cacheConfig) {
        super(name, cacheWriter, cacheConfig);
    }
}
