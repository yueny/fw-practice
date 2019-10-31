package com.yueny.fw.dao.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author yueny09 <deep_blue_yang@163.com>
 *
 * @DATE 2019/6/20 下午12:09
 *
 */
@Configuration
@MapperScan(basePackages = {"com.yueny.fw.dao.mapper*"})
public class MybatisPlusConfig {
//    private Long mybatisPlusSqlMaxTime = 200L;
//
//    @Autowired
//    @Qualifier("dataSource")
//    private DataSource dataSource;
//
//    @Bean(name="mybatisSqlSessionFactory")
//    @Primary
//    public SqlSessionFactory mybatisSqlSessionFactory(GlobalConfig globalConfig,
//                                                      PaginationInterceptor paginationInterceptor)
//            throws Exception {
//        return getAssemblySqlSessionFactory(dataSource, globalConfig, paginationInterceptor);
//    }
//
//    @Bean
//    public GlobalConfig globalConfig() {
//        GlobalConfig conf = new GlobalConfig();
//        // 默认值：false 是否缓存 Sql 解析，默认不缓存
//        conf.setSqlParserCache(true);
//
//        // 数据库相关配置
//        GlobalConfig.DbConfig dbConfig = new GlobalConfig.DbConfig();
//        // 全局唯一ID (idWorker)
//        dbConfig.setIdType(IdType.ID_WORKER);
////        // 逻辑删除值
////        dbConfig.setLogicDeleteValue(String.valueOf(DelEnum.DEL.getVal()));
////        // 逻辑未删除值
////        dbConfig.setLogicNotDeleteValue(String.valueOf(DelEnum.NORMAL.getVal()));
//        conf.setDbConfig(dbConfig);
//
//        return conf;
//    }
//
//    private SqlSessionFactory getAssemblySqlSessionFactory(DataSource dataSource,
//                                                                     GlobalConfig globalConfig,
//                                                                     Interceptor... interceptors)
//            throws Exception {
//
//        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
//        /* 数据源 */
//        sqlSessionFactory.setDataSource(dataSource);
//        /* 枚举扫描路径定义 */
//        sqlSessionFactory.setTypeEnumsPackage("com.yueny.fw.enums");
//
//        /* entity扫描,mybatis的Alias功能 */
//        MybatisConfiguration configuration = new MybatisConfiguration();
//        configuration.setLogImpl(org.apache.ibatis.logging.stdout.StdOutImpl.class);
//        configuration.setJdbcTypeForNull(JdbcType.NULL);
//        /* 驼峰转下划线 */
//        configuration.setMapUnderscoreToCamelCase(true);
//
//        /* 默认添加 乐观锁插件 */
//        configuration.addInterceptor(new OptimisticLockerInterceptor());
//
//        if(interceptors != null){
//            for (Interceptor interceptor: interceptors) {
//                configuration.addInterceptor(interceptor);
//            }
//        }
//
//        sqlSessionFactory.setConfiguration(configuration);
//
//        /* 自动填充插件 */
////        globalConfig.setMetaObjectHandler(new MysqlMetaObjectHandler());
//        sqlSessionFactory.setGlobalConfig(globalConfig);
//
//        /* SQL 逻辑删除注入器 */
//        //globalConfig.setSqlInjector(new LogicSqlInjector());
//
//        return sqlSessionFactory.getObject();
//    }

    /**
     * 分页插件注册
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
