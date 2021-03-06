package concurrency.controller;

import concurrency.filter.ThreadInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 调用线程的信息
 *
 * @author Jion
 */
@Controller
@RequestMapping(path = "/threadLocal")
public class ThreadLocalController {

    /**
     * 使用线程信息获得每个线程独有的参数
     */
    @RequestMapping(path = "/getInfo")
    @ResponseBody
    public String getInfo() {
        return ThreadInfo.getInfo();
    }
}
