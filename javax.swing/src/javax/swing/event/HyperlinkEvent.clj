(ns javax.swing.event.HyperlinkEvent
  "HyperlinkEvent is used to notify interested parties that
  something has happened with respect to a hypertext link.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event HyperlinkEvent]))

(defn ->hyperlink-event
  "Constructor.

  Creates a new object representing a hypertext link event.

  source - the object responsible for the event - `java.lang.Object`
  type - the event type - `javax.swing.event.HyperlinkEvent.EventType`
  u - the affected URL. This may be null if a valid URL could not be created. - `java.net.URL`
  desc - the description of the link. This may be useful when attempting to form a URL resulted in a MalformedURLException. The description provides the text used when attempting to form the URL. - `java.lang.String`
  source-element - Element in the Document representing the anchor - `javax.swing.text.Element`
  input-event - InputEvent that triggered the hyperlink event - `java.awt.event.InputEvent`"
  ([source type u desc source-element input-event]
    (new HyperlinkEvent source type u desc source-element input-event))
  ([source type u desc source-element]
    (new HyperlinkEvent source type u desc source-element))
  ([source type u desc]
    (new HyperlinkEvent source type u desc))
  ([source type u]
    (new HyperlinkEvent source type u)))

(defn get-event-type
  "Gets the type of event.

  returns: the type - `javax.swing.event.HyperlinkEvent.EventType`"
  ([this]
    (-> this (.getEventType))))

(defn get-description
  "Get the description of the link as a string.
   This may be useful if a URL can't be formed
   from the description, in which case the associated
   URL would be null.

  returns: `java.lang.String`"
  ([this]
    (-> this (.getDescription))))

(defn get-url
  "Gets the URL that the link refers to.

  returns: the URL - `java.net.URL`"
  ([this]
    (-> this (.getURL))))

(defn get-source-element
  "Returns the Element that corresponds to the source of the
   event. This will typically be an Element representing
   an anchor. If a constructor that is used that does not specify a source
   Element, or null was specified as the source
   Element, this will return null.

  returns: Element indicating source of event, or null - `javax.swing.text.Element`"
  ([this]
    (-> this (.getSourceElement))))

(defn get-input-event
  "Returns the InputEvent that triggered the hyperlink event.
   This will typically be a MouseEvent.  If a constructor is used
   that does not specify an InputEvent, or @{code null}
   was specified as the InputEvent, this returns null.

  returns: InputEvent that triggered the hyperlink event, or null - `java.awt.event.InputEvent`"
  ([this]
    (-> this (.getInputEvent))))

