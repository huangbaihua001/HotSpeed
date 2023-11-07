package com.github.hbh.hotspeed.watch;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.WatchEvent;

public class HotSpeedWatchFileEvent implements WatchFileEvent {

  private final WatchEvent<?> event;
  private final Path path;

  public HotSpeedWatchFileEvent(WatchEvent<?> event, Path path) {
    this.event = event;
    this.path = path;
  }

  @Override
  public FileEvent getEventType() {
    return toFileEvent(event.kind());
  }

  @Override
  public URI getURI() {
    return path.toUri();
  }

  @Override
  public boolean isFile() {
    return !isDirectory();
  }

  @Override
  public boolean isDirectory() {
    return Files.isDirectory(path);
  }

  static FileEvent toFileEvent(WatchEvent.Kind<?> kind) {
    if (kind == ENTRY_CREATE) {
      return FileEvent.CREATE;
    } else if (kind == ENTRY_MODIFY) {
      return FileEvent.MODIFY;
    } else if (kind == ENTRY_DELETE) {
      return FileEvent.DELETE;
    } else {
      throw new IllegalArgumentException("Unknown event type " + kind.name());
    }
  }
}
