package com.github.shymega.apps.chat.mjolnir.observer.api;

import org.glassfish.grizzly.compression.lzma.impl.Base;
import org.springframework.stereotype.Component;
import org.springframework.context.ApplicationListener;
import lombok.extern.slf4j.Slf4j;
import com.github.shymega.apps.chat.mjolnir.observer.events.BaseEvent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
@Slf4j
public class ObserverDispatch implements ApplicationListener<BaseEvent> {
  
  private final ExecutorService executorService = Executors.newFixedThreadPool(10);
  
  @Override
  public void onApplicationEvent(final BaseEvent evt) {
    if (evt == null) throw new IllegalArgumentException("Event cannot be null");
    executorService.submit(() -> {
      log.trace("Received event: {}", evt.toString());
    });
  }

  private synchronized void handleAdapterMessageEvent(final BaseEvent evt) {
    //
  }
}
