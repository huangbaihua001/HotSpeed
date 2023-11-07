package com.github.hbh.hotspeed.watch;

import static org.junit.Assert.assertNotNull;

import com.intellij.openapi.diagnostic.Logger;
import org.junit.Test;

public class WatchFactoryTest {

  Logger logger = Logger.getInstance(this.getClass());

  @Test
  public void whenGetWatcher_thenSuccess() throws Exception {
    logger.debug("---------------testGetWatcher---------------");
    assertNotNull(new WatcherFactory().getWatcher());
  }
}
