package com.yueny.fw.manager;

import java.util.Map;

/**
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-12-13 16:27
 */
public interface ITemplateEngine {
    String getContext(String template, Map<String, Object> attachment);
}
