package top.cciradih.spring.data.redis;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.hash.HashMapper;
import org.springframework.data.redis.hash.ObjectHashMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

@Component
public class HashMapping {
    @Resource(name = "redisTemplate")
    private HashOperations<String, byte[], byte[]> operations;

    private HashMapper<Object, byte[], byte[]> mapper = new ObjectHashMapper();

    public void writeHash(String key, User user) {
        Map<byte[], byte[]> mappedHash = mapper.toHash(user);
        operations.putAll(key, mappedHash);
    }

    public User loadHash(String key) {
        Map<byte[], byte[]> loadedHash = operations.entries(key);
        return (User) mapper.fromHash(loadedHash);
    }
}
