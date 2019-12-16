package com.yueny.fw.manager.impl;


import com.yueny.fw.manager.ITemplateEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import org.thymeleaf.TemplateEngine;
//import org.thymeleaf.context.Context;

import java.util.Map;

/**
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-12-13 16:21
 */
@Component
public class TemplateThymeleafEngine implements ITemplateEngine {
//  //  template模板引擎
//    @Autowired
//    private TemplateEngine templateEngine;

    /**
     * 发送模板邮件 使用thymeleaf模板
     *
     * 若使用freemarker模板
     *     Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
     *     configuration.setClassForTemplateLoading(this.getClass(), "/templates");
     *     String emailContent = FreeMarkerTemplateUtils.processTemplateIntoString(configuration.getTemplate("mail.ftl"), params);
     *
     * @param template  模板路径
     * @param attachment  动态模板数据
     */
    @Override
    public String getContext(String template, Map<String, Object> attachment) {
//        //使用模板thymeleaf
//        //Context是导这个包import org.thymeleaf.context.Context;
//        Context context = new Context();
//        //定义模板数据
//        context.setVariables(attachment);
//
//        //获取thymeleaf的html模板
//        // 执行模板引擎，执行模板引擎需要传入模板名、上下文对象
//        // Thymeleaf的默认配置期望所有HTML文件都放在 **resources/templates ** 目录下，以.html扩展名结尾。
//        String emailContent = templateEngine.process(template, context); //指定模板路径
//
//        return emailContent;
        return "";
    }
}
