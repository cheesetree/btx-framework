package top.cheesetree.btx.framework.cache.redis;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.lang.Nullable;
import top.cheesetree.btx.framework.core.constants.BtxConsts;

/**
 * @author van
 */
public class BtxKeyStringRedisSerializer implements RedisSerializer<String> {
    private String keyprefix;

    public BtxKeyStringRedisSerializer(String keyprefix) {
        this.keyprefix = keyprefix;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.redis.serializer.RedisSerializer#deserialize(byte[])
     */
    @Override
    public String deserialize(@Nullable byte[] bytes) {
        return (bytes == null ? null :
                new String(bytes, BtxConsts.DEF_ENCODE).replaceFirst(keyprefix
                        , ""));
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.redis.serializer.RedisSerializer#serialize(java.lang.Object)
     */
    @Override
    public byte[] serialize(@Nullable String string) {
        return (string == null ? null :
                (keyprefix + string).getBytes(BtxConsts.DEF_ENCODE));
    }
}
