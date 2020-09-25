package com.zhongjis.versioncheck.service;

import org.springframework.stereotype.Service;

@Service
public class VersionCheckService {

  public String checkVersion(String versionOne, String versionTwo) {
    // check if both Strings are legal

    // compare
    String[] splitedOne = versionOne.split("\\.");
    String[] splitedTwo = versionTwo.split("\\.");

    return compareTwoVersionArr(splitedOne, splitedTwo);
  }

  private String compareTwoVersionArr(String[] splitedOne, String[] splitedTwo) {
    int lenOne = splitedOne.length;
    int lenTwo = splitedTwo.length;

    int index = 0;

    while (index < lenOne && index < lenTwo) {
      int numOne = Integer.parseInt(splitedOne[index]);
      int numTwo = Integer.parseInt(splitedTwo[index]);

      if (numOne > numTwo) return ">";
      else if (numOne < numTwo) return "<";
      index++;
    }

    if (lenOne > lenTwo) {
      return ">";
    } else if (lenOne < lenTwo) {
      return "<";
    } else {
      return "=";
    }
  }
}
