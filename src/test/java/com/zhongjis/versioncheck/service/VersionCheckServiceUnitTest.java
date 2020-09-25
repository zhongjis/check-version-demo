package com.zhongjis.versioncheck.service;

import static org.junit.Assert.assertEquals;

import com.zhongjis.versioncheck.controller.exception.IlegalVersionIdException;
import com.zhongjis.versioncheck.service.impl.VersionCheckServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class VersionCheckServiceUnitTest {

  @InjectMocks
  VersionCheckServiceImpl versionCheckService;

  @Test
  public void testCheckVersionWithLegalVersionId() throws IlegalVersionIdException{
    assertEquals("1.0.0 is \"before\" 2.0.0", versionCheckService.checkVersion(
        "1.0.0", "2.0.0"), "1.0.0 is \"before\" 2.0.0");
    assertEquals("1.0 is \"before\" 2.0.0", versionCheckService.checkVersion(
        "1.0", "2.0.0"), "1.0 is \"before\" 2.0.0");
    assertEquals("2.0.0 is \"after\" 1.0.0", versionCheckService.checkVersion(
        "2.0.0", "1.0.0"), "2.0.0 is \"after\" 1.0.0");
    assertEquals("2.0 is \"before\" 3.0.0", versionCheckService.checkVersion(
        "2.0", "3.0.0"), "2.0 is \"before\" 3.0.0");
    assertEquals("2.0 is \"equal\" 2.0.0", versionCheckService.checkVersion(
        "2.0", "2.0.0"), "2.0 is \"equal\" 2.0.0");
  }

  @Test(expected = IlegalVersionIdException.class)
  public void testCheckVersionWithIlegalVersionId() throws IlegalVersionIdException{
    versionCheckService.checkVersion("a.0.0", "1.1.1");
    versionCheckService.checkVersion("1.0.0", "c.1.1");
    versionCheckService.checkVersion("1.-11.0", "c.1.1");
  }
}
