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
      while (index < lenOne) {
        int num = Integer.parseInt(splitedOne[index]);
        if (num > 0) {
          return "after";
        }
        index++;
      }
    } else if (lenOne < lenTwo) {
      while (index < lenTwo) {
        int num = Integer.parseInt(splitedTwo[index]);
        if (num > 0) {
          return "before";
        }
        index++;
      }
    }
    return "equal";
  }

  // NOTE: this function will consider ... is also valid
  private boolean checkVersionIdIsValid(String[] versionIdArr) throws IlegalVersionIdException{
    try {
      for (String str : versionIdArr) {
        int temp = Integer.parseInt(str);
        if (temp < 0) {
          throw new NumberFormatException();
        }
      }
    } catch (NumberFormatException e) {
      throw new IlegalVersionIdException("Ilegal Version Id detected, please try again");
    }

    return true;
  }
}
