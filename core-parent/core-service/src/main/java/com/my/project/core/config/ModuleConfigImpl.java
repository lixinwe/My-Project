package com.my.project.core.config;

import com.my.project.common.config.ModuleConfig;
import org.springframework.stereotype.Service;



@Service
public class ModuleConfigImpl implements ModuleConfig {

    @Override
    public String getName() {
        return "sys";
    }
}
