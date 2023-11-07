package com.github.hbh.hotspeed.watch;

import java.net.URI;

public interface WatchFileEvent {
  FileEvent getEventType();

  URI getURI();

  boolean isFile();

  boolean isDirectory();
}
