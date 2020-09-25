package com.zhongjis.versioncheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class VersionCheckApplication extends SpringBootServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(VersionCheckApplication.class, args);
  }

}
