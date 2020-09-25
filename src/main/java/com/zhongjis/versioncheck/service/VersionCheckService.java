package com.zhongjis.versioncheck.service;

import org.springframework.stereotype.Service;

@Service
public class VersionCheckService {

  public String checkVersion(String versionOne, String versionTwo) {
    // check if both Strings are legal

    // compare
    String[] splitedOne = versionOne.split("\\.");
    String[] splitedTwo = versionTwo.split("\\.");

    String symbol = compareTwoVersionArr(splitedOne, splitedTwo);
    return versionOne + " is \"" + symbol + "\" " + versionTwo;
  }

  private String compareTwoVersionArr(String[] splitedOne, String[] splitedTwo) {
    int lenOne = splitedOne.length;
    int lenTwo = splitedTwo.length;

    int index = 0;

    while (index < lenOne && index < lenTwo) {
      int numOne = Integer.parseInt(splitedOne[index]);
      int numTwo = Integer.parseInt(splitedTwo[index]);

      if (numOne > numTwo) return "after";
      else if (numOne < numTwo) return "before";
      index++;
    }

    if (lenOne > lenTwo) {
      return "after";
    } else if (lenOne < lenTwo) {
      return "before";
    } else {
      return "same as";
    }
  }
}
