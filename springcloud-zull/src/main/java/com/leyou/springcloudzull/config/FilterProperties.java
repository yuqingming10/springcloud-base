package com.leyou.springcloudzull.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * Created by Administrator on 2019\8\23 0023.
 */
@ConfigurationProperties(prefix = "leyou.filter")
public class FilterProperties {
    //配置白名单，获取配置文件中集合
    private List<String> allowPaths;

    public List<String> getAllowPaths() {
        return allowPaths;
    }

    public void setAllowPaths(List<String> allowPaths) {
        this.allowPaths = allowPaths;
    }
}
