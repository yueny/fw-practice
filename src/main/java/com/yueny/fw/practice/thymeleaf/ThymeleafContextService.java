package com.yueny.fw.practice.thymeleaf;

import com.yueny.fw.manager.ITemplateEngine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-12-13 17:05
 */
@Component
public class ThymeleafContextService {
    @Autowired
    private ITemplateEngine templateEngine;

    private void sendMSg(List<ErrorMsg> errorMsgList){
//        String errorMsg = "文件 " + taskInfoBo.getFileRemoteName() + " 数据补偿失败， 原因" + e.getMessage();
//        send("【文件补偿】文件数据补偿失败", errorMsg);

        List<Map<String, Object>> list = new ArrayList<>();
        for (ErrorMsg errorMsg : errorMsgList){
            Map<String, Object> att = new HashMap<>();
            att.put("fileName", errorMsg.getTaskInfoBo());
            att.put("cause", errorMsg.getCause().getMessage());

            list.add(att);
        }

        // 附件体
        Map<String, Object> attachment = new HashMap<>();
        attachment.put("list", list);

        String co = templateEngine.getContext("thymeleaf/storage_fail", attachment);
        System.out.println(co);
    }


    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    private static class ErrorMsg{
        private String taskInfoBo;

        private Exception cause;
    }
}
