package com.my.project.feign;

import com.my.project.feign.fallback.ResourceFeignClientFallback;
import com.my.project.common.user.ResourceBO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Resource
 *
 * @author
 */
@FeignClient(name = "core-server", fallback = ResourceFeignClientFallback.class)
public interface ResourceFeignClient {
    /**
     * get all Resource list
     */
    @GetMapping("sys/sysresource/list")
    List<ResourceBO> list();
}
