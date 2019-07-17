(ns javax.swing.text.html.HTMLFrameHyperlinkEvent
  "HTMLFrameHyperlinkEvent is used to notify interested
  parties that link was activated in a frame."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html HTMLFrameHyperlinkEvent]))

(defn ->html-frame-hyperlink-event
  "Constructor.

  Creates a new object representing a hypertext link event.

  source - the object responsible for the event - `java.lang.Object`
  type - the event type - `javax.swing.event.HyperlinkEvent.EventType`
  target-url - the affected URL - `java.net.URL`
  desc - a description - `java.lang.String`
  source-element - the element that corresponds to the source of the event - `javax.swing.text.Element`
  input-event - InputEvent that triggered the hyperlink event - `java.awt.event.InputEvent`
  target-frame - the Frame to display the document in - `java.lang.String`"
  ([^java.lang.Object source ^javax.swing.event.HyperlinkEvent.EventType type ^java.net.URL target-url ^java.lang.String desc ^javax.swing.text.Element source-element ^java.awt.event.InputEvent input-event ^java.lang.String target-frame]
    (new HTMLFrameHyperlinkEvent source type target-url desc source-element input-event target-frame))
  ([^java.lang.Object source ^javax.swing.event.HyperlinkEvent.EventType type ^java.net.URL target-url ^java.lang.String desc ^javax.swing.text.Element source-element ^java.lang.String target-frame]
    (new HTMLFrameHyperlinkEvent source type target-url desc source-element target-frame))
  ([^java.lang.Object source ^javax.swing.event.HyperlinkEvent.EventType type ^java.net.URL target-url ^java.lang.String desc ^java.lang.String target-frame]
    (new HTMLFrameHyperlinkEvent source type target-url desc target-frame))
  ([^java.lang.Object source ^javax.swing.event.HyperlinkEvent.EventType type ^java.net.URL target-url ^java.lang.String target-frame]
    (new HTMLFrameHyperlinkEvent source type target-url target-frame)))

(defn get-target
  "returns the target for the link.

  returns: `java.lang.String`"
  (^java.lang.String [^javax.swing.text.html.HTMLFrameHyperlinkEvent this]
    (-> this (.getTarget))))

