package com.github.shymega.apps.chat.mjolnir.observer.api;

import com.github.shymega.apps.chat.mjolnir.observer.events.BaseEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public final class EventSender {

  @Autowired
  private ApplicationEventPublisher eventPublisher;

  @Autowired
  private EventSender(final ApplicationEventPublisher eventPublisher) {
    this.eventPublisher = eventPublisher;
  }

  public <T extends BaseEvent> void sendEvent(final T evt) throws IllegalArgumentException {
    if (evt == null) throw new IllegalArgumentException("Event cannot be null");

    log.trace("EventSender.sendEvent called with event: {}", evt.toString());
    eventPublisher.publishEvent(evt);
  }
}
