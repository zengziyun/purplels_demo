package com.example.one.util;

import org.hamcrest.Matchers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * 模拟请求对象帮助类
 * */
public class MockMvcUtil {

    private static Logger log = LoggerFactory.getLogger(MockMvcUtil.class);
    /**
     * 初始化mockMvc对象
     * 用模拟浏览器的post和get的请求来获取数据
     * @param e 需要请求的controller的新对象 例 new object()
     * */
    public static MockMvc getMockMvc(Object e) {
        //初始化MockMac
       return MockMvcBuilders.standaloneSetup(e).build();
    }

    /**
     * 输出MockMvc请求的详细信息  Post请求
     * @param mockMvc MockMvc对象
     * @param path 请求的具体路径
     * */
    public static void printMockMvcInfoByPost(MockMvc mockMvc,String path) throws Exception {
        if(ObjectUtil.isEmpty(mockMvc)) {
            log.debug("mockMvc对象没有初始化", new Throwable());
            return;
        }
        /**
         * @Before 注解的方法表示在测试启动的时候优先执行，一般用作资源初始化。
         * .accept(MediaType.APPLICATION_JSON_UTF8)) 这句是设置 JSON 返回编码，避免出现中文乱码的问题。
         * print() 等方法都是 MockMvcResultHandlers 类的静态方法
         * */
        mockMvc.perform(MockMvcRequestBuilders.post(path).accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }

    /**
     * 输出MockMvc请求的详细信息 post请求  并根据传入的param的值进行筛选 查看返回的值有没有对应的值
     * 如果有返回值就打印对应信息
     * 没有则抛出异常
     *@param mockMvc MockMvc对象
     *@param path 请求的具体路径
     *@param param 比对的信息
     * */
    public static void printMockMvcInfoByPost(MockMvc mockMvc,String path,String param) throws Exception {
        if(ObjectUtil.isEmpty(mockMvc)) {
            log.debug("mockMvc对象没有初始化", new Throwable());
            return;
        }
        /**
         * @Before 注解的方法表示在测试启动的时候优先执行，一般用作资源初始化。
         * .accept(MediaType.APPLICATION_JSON_UTF8)) 这句是设置 JSON 返回编码，避免出现中文乱码的问题。
         * print() 等方法都是 MockMvcResultHandlers 类的静态方法
         * */
        mockMvc.perform(MockMvcRequestBuilders.post(path).accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString(param)));
    }

    /**
     * 输出MockMvc请求的详细信息 get请求
     * @param mockMvc MockMvc对象
     * @param path 请求的具体路径
     * */
    public static void printMockMvcInfoByGet(MockMvc mockMvc,String path) throws Exception {
        if(ObjectUtil.isEmpty(mockMvc)) {
            log.debug("mockMvc对象没有初始化", new Throwable());
            return;
        }
        /**
         * @Before 注解的方法表示在测试启动的时候优先执行，一般用作资源初始化。
         * .accept(MediaType.APPLICATION_JSON_UTF8)) 这句是设置 JSON 返回编码，避免出现中文乱码的问题。
         * print() 等方法都是 MockMvcResultHandlers 类的静态方法
         * */
        mockMvc.perform(MockMvcRequestBuilders.get(path).accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }

    /**
     * 输出MockMvc请求的详细信息 get请求  并根据传入的param的值进行筛选 查看返回的值有没有对应的值
     * 如果有返回值就打印对应信息
     * 没有则抛出异常
     *@param mockMvc MockMvc对象
     *@param path 请求的具体路径
     *@param param 比对的信息
     * */
    public static void printMockMvcInfoByGet(MockMvc mockMvc,String path,String param) throws Exception {
        if(ObjectUtil.isEmpty(mockMvc)) {
            log.debug("mockMvc对象没有初始化", new Throwable());
            return;
         }
        /**
         * @Before 注解的方法表示在测试启动的时候优先执行，一般用作资源初始化。
         * .accept(MediaType.APPLICATION_JSON_UTF8)) 这句是设置 JSON 返回编码，避免出现中文乱码的问题。
         * print() 等方法都是 MockMvcResultHandlers 类的静态方法
         * */
        mockMvc.perform(MockMvcRequestBuilders.get(path).accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString(param)));
    }

    /**
     * post请求  输出json数据 并返回获取的json数据
     * 如果返回为空则返回 null
     * */
    public static String printMockMvcListByPost(MockMvc mockMvc,String path) throws Exception {
        if(ObjectUtil.isEmpty(mockMvc)) {
            log.debug("mockMvc对象没有初始化", new Throwable());
            return null;
        }

        String info =  mockMvc.perform(MockMvcRequestBuilders.post(path))
                .andReturn().getResponse().getContentAsString();
        System.out.printf("result：%s",info);
        return ObjectUtil.isNotEmpty(info) == true ? info : null;
    }

    /**
     * get请求  输出json数据 并返回获取的json数据
     * 如果返回为空则返回 null
     * */
    public static String printMockMvcListByGet(MockMvc mockMvc,String path) throws Exception {
        if(ObjectUtil.isEmpty(mockMvc)) {
            log.debug("mockMvc对象没有初始化", new Throwable());
            return null;
        }

        String info =  mockMvc.perform(MockMvcRequestBuilders.get(path))
                .andReturn().getResponse().getContentAsString();
        System.out.printf("result：%s",info);
        return ObjectUtil.isNotEmpty(info) == true ? info : null;
    }

}
