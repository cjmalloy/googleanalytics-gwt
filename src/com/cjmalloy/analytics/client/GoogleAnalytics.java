package com.cjmalloy.analytics.client;

public class GoogleAnalytics
{

    public static native void sendEvent(String category, String action) /*-{

        $wnd.ga('send', 'event', category, action);
     }-*/;

    public static native void sendEvent(String category, String action, HitCallback callback) /*-{

        $wnd.ga('send', 'event', category, action,
            {'hitCallback': $entry(callback.@com.cjmalloy.analytics.client.GoogleAnalytics.HitCallback::call())});
     }-*/;

    public static native void sendEvent(String category, String action, String label) /*-{

        $wnd.ga('send', 'event', category, action, label);
     }-*/;

    public static native void sendEvent(String category, String action, String label, HitCallback callback) /*-{

        $wnd.ga('send', 'event', category, action, label,
            {'hitCallback': $entry(callback.@com.cjmalloy.analytics.client.GoogleAnalytics.HitCallback::call())});
     }-*/;

    public static native void sendEvent(String category, String action, String label, int value) /*-{

        $wnd.ga('send', 'event', category, action, label, value);
     }-*/;

    public static native void sendEvent(String category, String action, String label, int value, HitCallback callback) /*-{

        $wnd.ga('send', 'event', category, action, label, value,
            {'hitCallback': $entry(callback.@com.cjmalloy.analytics.client.GoogleAnalytics.HitCallback::call())});
     }-*/;

    public static void trackHistoryEvent(String historyToken)
    {
        sendEvent("gwt-history", "click", historyToken);
    }

    public static void trackOutboundLink(String url)
    {
        sendEvent("outbound", "click", url);
    }

    public static void trackOutboundLink(String url, HitCallback callback)
    {
        sendEvent("outbound", "click", url, callback);
    }

    public static interface HitCallback
    {
        void call();
    }
}
