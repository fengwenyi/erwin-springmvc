package com.fengwenyi.erwin_framework.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * servlet 核心类
 * @author Erwin Feng
 * @since 2019-07-03 02:48
 */
@WebServlet(name = "dispatcherServlet", urlPatterns = "/*", loadOnStartup = 1,
initParams = {@WebInitParam(name = "base-package", value = "com.fengwenyi.erwin_springmvc_simple")})
public class DispatcherServlet extends HttpServlet {


    // 扫描基础包
    private String basePackage = "";
    // 基础包下面所有带包路径的类名
    private List<String> packageNames = new ArrayList<>();
    // 注解实例化， 名称 : 对象
    private Map<String, Object> instanceMap = new HashMap<>();
    // 包路径名称 : 注解名称
    private Map<String, String> nameMap = new HashMap<>();
    // url 方法
    private Map<String, Method> urlMethodMap = new HashMap<>();
    // url 权限定类名关系
    private Map<Method, String> methodPackageMap = new HashMap<>();


    @Override
    public void init(ServletConfig config) throws ServletException {
        basePackage = config.getInitParameter("base-package");

    }

    private void scanBasePackage(String basePackage) {
        // 注意为了得到基础包下面的URL路径需要对basePackage做转换，将.替换为/

        URL url = this.getClass().getClassLoader().getResource(basePackage.replaceAll("\\.", "/"));
        File basePackageFile = new File(url.getPath());
        File[] childFiles = basePackageFile.listFiles();
        for (File file : childFiles) {
            if (file.isDirectory()) {
                // 目录继续扫描
                scanBasePackage(basePackage + "." + file.getName());
            } else if (file.isFile()) {
                packageNames.add(basePackage + "." + file.getName().split("\\.")[0]);
            }
        }
    }
}
