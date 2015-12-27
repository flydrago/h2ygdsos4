package com.h2y.os.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import java.util.Enumeration;
import java.util.List;

/**
 * Spring拦截器

 * 作者：段晓刚

 * 时间：2014-3-8 下午1:24:34

 * 电子邮件：@qq.com

 * QQ：

 * Gmail :
 */
public class CommonInterceptor implements HandlerInterceptor {

	private final static Logger logger = Logger.getLogger(CommonInterceptor.class);


    private String loginUrl;

    private String errorUrl;

    private List<String> noFilterUrls;

	public CommonInterceptor() {
		// TODO Auto-generated constructor stub
	}

	public void setMappingURL(String mappingURL) {
	}

    /**
     * 在业务处理器处理请求之前被调用
     * 如果返回false
     *     从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
     *
     * 如果返回true
     *    执行下一个拦截器,直到所有的拦截器都执行完毕
     *    再执行被拦截的Controller
     *    然后进入拦截器链,
     *    从最后一个拦截器往回执行所有的postHandle()
     *    接着再从最后一个拦截器往回执行所有的afterCompletion()
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

        String requestUrl = request.getRequestURI();

        //去掉上下文路径
        String contextPath = request.getContextPath();
        if(null!=contextPath){
            requestUrl = requestUrl.substring(contextPath.length()+1);
        }

        logger.debug("url拦截信息：\n loginUrl:"+loginUrl+" \n errorUrl:"+errorUrl+" \n noFilterUrls:"+noFilterUrls+" \n requestUrl:"+requestUrl);

        debugRequestParameters(request);

        if (requestUrl.equals("/")) {
            return true;
        }else if (requestUrl.equals(loginUrl)) {
            return true;
        }else if (requestUrl.equals(errorUrl)) {
            return true;
        }

        //不过滤url
        if (noFilterUrls.contains(requestUrl)) {
            return true;
        }

        //是否已登录
        if (isHasLogin()) {
            return true;
        }

        response.sendRedirect(loginUrl);
        return false;
    }


    /**
     * 	在业务处理器处理请求执行完成后,生成视图之前执行的动作
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("postHandle");
    }

    /**
     * 在DispatcherServlet完全处理完请求后被调用
     *
     *   当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
     */
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception exception)
            throws Exception {
        logger.info("afterCompletion");
    }


    private boolean isHasLogin(){

        return true;
    }


    private void debugRequestParameters(HttpServletRequest request){

        try{
            Enumeration<String> names=(Enumeration<String>)request.getParameterNames();
            StringBuffer parameters= new StringBuffer();
            while(names.hasMoreElements()){
                String name=names.nextElement();
                String[] values=request.getParameterValues(name);
                String value="";
                if(values!=null){
                    for (String string : values) {
                        if (value.equals("")) value = string;
                        else value+= string;
                    }
                }
                parameters.append(name+":"+value+"\t");
            }
            logger.debug("-method:"+request.getMethod()+",parameters:{"+parameters+"}");
        }catch(Exception e){
            logger.warn(e);
        }
    }

    public String getLoginUrl() {
        return loginUrl;
    }


    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }


    public String getErrorUrl() {
        return errorUrl;
    }


    public void setErrorUrl(String errorUrl) {
        this.errorUrl = errorUrl;
    }


    public List<String> getNoFilterUrls() {
        return noFilterUrls;
    }


    public void setNoFilterUrls(List<String> noFilterUrls) {
        this.noFilterUrls = noFilterUrls;
    }

}
