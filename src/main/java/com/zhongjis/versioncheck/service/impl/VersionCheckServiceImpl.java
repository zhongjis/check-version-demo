package com.zhongjis.versioncheck.service.impl;

import com.zhongjis.versioncheck.controller.exception.IlegalVersionIdException;
import com.zhongjis.versioncheck.service.VersionCheckService;
import org.springframework.stereotype.Service;

@Service
public class VersionCheckServiceImpl implements VersionCheckService {

  public String checkVersion(String versionOne, String versionTwo) throws IlegalVersionIdException {
    // generate splited arrs
    String[] splitedOne = versionOne.split("\\.");
    String[] splitedTwo = versionTwo.split("\\.");

    // check if the versions are valid
    checkVersionIdIsValid(splitedOne);
    checkVersionIdIsValid(splitedTwo);

    // compare
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

  private boolean checkVersionIdIsValid(String[] versionIdArr) throws IlegalVersionIdException{
    try {
      for (String str : versionIdArr) {
        Integer.parseInt(str);
      }
    } catch (NumberFormatException e) {
      throw new IlegalVersionIdException("Ilegal Version Id detected, please try again");
    }

    return true;
  }
}
