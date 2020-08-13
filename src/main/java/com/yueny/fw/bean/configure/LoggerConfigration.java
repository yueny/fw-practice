//package com.yueny.fw.bean.configure;
//
//
//import com.ctrip.framework.apollo.Config;
//import com.ctrip.framework.apollo.model.ConfigChangeEvent;
//import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
//import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.logging.LogLevel;
//import org.springframework.boot.logging.LoggingSystem;
//import org.springframework.context.annotation.Configuration;
//
//import javax.annotation.PostConstruct;
//import java.util.Set;
//
///**
// * 日志配置变化，动态生效
// *
// * 使用@ApolloConfig自动注入Config对象
// * 使用@ApolloConfigChangeListener自动注入ConfigChangeListener对象.
// * 当监听到属性值发生变化后使用Config API修改属性值
// *
// * @Author yueny09 <deep_blue_yang@126.com>
// * @Date 2019-12-11 17:15
// */
//@Configuration
//public class LoggerConfigration implements InitializingBean {
//    private static final Logger logger = LoggerFactory.getLogger(LoggerConfigration.class);
//
//    /**
//     * 日志配置所在的空间名称
//     */
//    private static final String ns = "log";
//
//    /**
//     * 日志的路径的级别配置
//     */
//    private static final String LOGGER_TAG = "logging.level.";
//
//    @Autowired
//    private LoggingSystem loggingSystem;
//
//    /**
//     * inject config.log for namespace application
//     */
//    @ApolloConfig(value=ns)
//    private Config config;
//
//    /**
//     * LoggerConfig， 已配置，配置生效
//     *
//     * config.log change listener for namespace application
//     */
//    @ApolloConfigChangeListener(value=ns)
//    private void configChangeListener(ConfigChangeEvent changeEvent) {
//        refreshLoggingLevels();
//    }
//
//    @PostConstruct
//    private void refreshLoggingLevels() {
//        Set<String> keyNames = config.getPropertyNames();
//        for (String key : keyNames) {
//            if (StringUtils.containsIgnoreCase(key, LOGGER_TAG)) {
//                String strLevel = config.getProperty(key, "info");
//                LogLevel level = LogLevel.valueOf(strLevel.toUpperCase());
//
//                loggingSystem.setLogLevel(key.replace(LOGGER_TAG, ""), level);
//
//                logger.info("{}:{}", key, strLevel);
//            }
//        }
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        logger.info("LoggerConfig afterPropertiesSet!");
//    }
//}
//
