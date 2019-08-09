package com.thizgroup.docker;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gangquan.hu
 * @Package: com.thizgroup.docker.DockerApplication
 * @Description: docker自动化部署测试
 * @date 2019/8/5 18:37
 */
@SpringBootApplication
@RestController
public class DockerApplication {

  public static void main(String[] args) {
    SpringApplication.run(DockerApplication.class,args);
  }

  @RequestMapping("/")
  public String home() {
    return "Hello Docker World";
  }

  @RequestMapping("/testGithubWebhooks")
  public String testGithubWebhooks(HttpServletRequest request, HttpServletResponse response){
    System.out.println("testGithubWebhooks be called");
    System.out.println("request param:");



    Map<String, String[]> parameterMap = request.getParameterMap();
    Set<Entry<String, String[]>> entries = parameterMap.entrySet();
    Iterator<Entry<String, String[]>> iterator = entries.iterator();
    while (iterator.hasNext()){
      Entry<String, String[]> next = iterator.next();
      System.out.println(next.getKey()+"="+ Arrays.toString(next.getValue()));
    }
    System.out.println("request header:"+request.getHeaderNames());
    Enumeration<String> headerNames = request.getHeaderNames();
    while (headerNames.hasMoreElements()){
      String element = headerNames.nextElement();
      System.out.println("name:"+element+",value="+request.getHeader(element));
    }
    return "";
  }

}
