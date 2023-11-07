package com.github.hbh.hotspeed.watch;

import java.net.URI;

public interface Watcher {
  void addEventListener(URI pathPrefix, WatchEventListener listener);

  void run();

  void stop();
}
