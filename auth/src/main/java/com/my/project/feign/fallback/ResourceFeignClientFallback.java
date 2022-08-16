package com.my.project.feign.fallback;

import com.my.project.feign.ResourceFeignClient;
import com.my.project.common.user.ResourceBO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Resource Fallback
 *
 * @author
 */
@Component
public class ResourceFeignClientFallback implements ResourceFeignClient {

    @Override
    public List<ResourceBO> list() {
        return new ArrayList<>();
    }
}
