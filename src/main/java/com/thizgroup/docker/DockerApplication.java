package com.thizgroup.docker;

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
    return "";
  }

}
