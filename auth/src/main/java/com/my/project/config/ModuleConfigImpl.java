package com.my.project.config;

import com.my.project.common.config.ModuleConfig;
import org.springframework.stereotype.Service;

/**
 * Module configuration information
 *
 * @author
 */
@Service
public class ModuleConfigImpl implements ModuleConfig {
    @Override
    public String getName() {
        return "auth";
    }
}
