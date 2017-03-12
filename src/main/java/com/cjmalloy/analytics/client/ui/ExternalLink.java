package com.cjmalloy.analytics.client.ui;

import com.cjmalloy.analytics.client.GoogleAnalytics;
import com.cjmalloy.analytics.client.GoogleAnalytics.HitCallback;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.ui.Anchor;

public class ExternalLink extends Anchor {

  private HandlerRegistration clickReg = null;

  public ExternalLink() {}

  public ExternalLink(String url) {
    setHref(url);
  }

  @Override
  public void setHref(final String url) {
    super.setHref(url);
    if (clickReg != null) {
      clickReg.removeHandler();
    }
    clickReg = this.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        event.stopPropagation();
        event.preventDefault();
        GoogleAnalytics.trackOutboundLink(url, new HitCallback() {
          @Override
          public void call() {
            Location.assign(url);
          }
        });
      }
    });
  }
}
