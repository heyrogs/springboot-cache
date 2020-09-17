package com.jiang.service;

import com.jiang.entity.dto.UserDTO;
import com.jiang.entity.vo.UserVO;
import com.jiang.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


/**
 *
 *  @author shijiang.luo
 *  * @description
 *  * @date 2020-09-16 22:54
 *
 */
@Slf4j
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     *
     *  将方法的运行结果进行缓存；以后再要相同的数据，直接从缓存中获取， 不用调用方法
     *
     *  @Cacheable 几个属性：
     *
     *  cacheNames/value: 指定缓存的名字;
     *
     *  key: 缓存数据使用的key， 可以用他来指定。默认使用方法的参数值 1-方法的返回值，
     *       编写 SpEL；#id; 参数id的值  #a0 #p0 #root.args[0]
     *
     *  keyGenerator: key的生成器； 可以自己指定key的生成器组件id key/keyGenerator;
     *                二选一使用。
     *
     *  cacheManager： 指定缓存管理器； 或者 cacheResolver执行获取解析器。
     *
     *  condition： 指定符合条件的情况下才缓存；
     *
     *  unless: 否定缓存， 当unless指定的条件为 true， 方法的返回值就不会缓存。
     *
     *  sync：缓存是否使用异步模式
     *
     * @param id
     * @return
     */
    @Cacheable(cacheNames = {"user"})
    public UserVO getUser(Integer id) {
        log.info("员工: {}", id);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userMapper.getUserById(id), userVO);
        return userVO;
    }

    /**
     *
     * 使用 key 的生成策略
     *
     * @param id
     * @return
     */
    @Cacheable(cacheNames = {"user"}, key = "keyGenerator")
    public UserVO getUser2(Integer id) {
        log.info("员工: {}", id);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userMapper.getUserById(id), userVO);
        return userVO;
    }

    /**
     *
     * 即调用方法， 又更新缓存数据；
     *
     * 修改了数据库的某个数据，同时更新缓存；
     *
     * 运行时机:
     * 1、先调用目标方法；
     * 2、将目标方法结果缓存起来
     *
     * 测试步骤：
     * 1、查询一号员工，查到结果放到缓存中
     * 2、更新一号员工，
     *
     * @param userVO
     * @return
     */
    @CachePut(cacheNames = {"user"}, key = "#result.id")
    public UserVO updateUser(UserVO userVO){
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userVO, userDTO);
        userMapper.updateUser(userDTO);
        return userVO;
    }

}