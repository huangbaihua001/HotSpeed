package com.github.hbh.hotspeed.watch;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WatcherNIO2Test {

  Watcher watcher;
  Path temp;

  @Before
  public void setup() throws IOException {
    watcher = new WatcherFactory().getWatcher();
    temp = Files.createTempDirectory("watcherNIO2Test");
    watcher.run();
  }

  @After
  public void tearDown() {
    watcher.run();
  }

  @Test
  public void testCreateFileAndEventListenerCalled() throws Exception {
    final ResultHolder resultHolder = new ResultHolder();
    assertNotNull(watcher);
    assertNotNull(temp);
    System.out.println("watcher -> " + watcher);
    System.out.println("temp -> " + temp);

    watcher.addEventListener(
      null,
      temp.toUri(),
      new WatchEventListener() {
        @Override
        public void onEvent(WatchFileEvent event) {
          System.out.println("fileEvent -> " + event);
          assertEquals("New file event type", FileEvent.CREATE, event.getEventType());
          assertTrue("File name", event.getURI().toString().endsWith("test.class"));
          resultHolder.result = true;
        }
      }
    );

    File testFile = new File(temp.toFile(), "test.class");
    boolean newFile = testFile.createNewFile();
    System.out.println("testFile -> " + testFile + ", " + newFile);

    assertTrue("Event listener called", waitForResult(resultHolder));
  }

  private boolean waitForResult(ResultHolder resultHolder) {
    for (int i = 0; i < 1000; i++) {
      if (resultHolder.result) {
        return true;
      }

      // waitForResult for NIO thread
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {}
    }
    return false;
  }

  private static class ResultHolder {

    boolean result = false;
  }
}
