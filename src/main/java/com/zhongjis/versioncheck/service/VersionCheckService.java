package com.zhongjis.versioncheck.service;

import com.zhongjis.versioncheck.controller.exception.IlegalVersionIdException;

public interface VersionCheckService {
  String checkVersion(String versionOne, String versionTwo) throws IlegalVersionIdException;
}
