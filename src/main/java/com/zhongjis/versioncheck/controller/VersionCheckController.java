package com.zhongjis.versioncheck.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhongjis.versioncheck.service.VersionCheckService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/version")
public class VersionCheckController {

  private final VersionCheckService versionCheckService;

  @Autowired
  public VersionCheckController(VersionCheckService versionCheckService) {
    this.versionCheckService = versionCheckService;
  }

  @RequestMapping(value = "/helloworld", method = RequestMethod.GET)
  public ResponseEntity<String> greeting() {
    return new ResponseEntity<>("Hello World from Zhongjie Shen", HttpStatus.OK);
  }

  @RequestMapping(value = "/check", method = RequestMethod.POST)
  public ResponseEntity<String> checkVersion(@RequestBody String versionsList)
      throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    JsonNode jsonNode = objectMapper.readTree(versionsList);

    String firstVersionId = jsonNode.get("firstVersionId").asText();
    String secondVersionId = jsonNode.get("secondVersionId").asText();

    String result = versionCheckService.checkVersion(firstVersionId, secondVersionId);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }

}
