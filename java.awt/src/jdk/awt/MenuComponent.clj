(ns jdk.awt.MenuComponent
  "The abstract class MenuComponent is the superclass
  of all menu-related components. In this respect, the class
  MenuComponent is analogous to the abstract superclass
  Component for AWT components.

  Menu components receive and process AWT events, just as components do,
  through the method processEvent."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt MenuComponent]))

(defn ->menu-component
  "Constructor.

  Creates a MenuComponent.

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless returns true"
  ([]
    (new MenuComponent )))

(defn post-event
  "Deprecated. As of JDK version 1.1, replaced by dispatchEvent.

  evt - the event which is to take place - `java.awt.Event`

  returns: `java.lang.  boolean`"
  ([^java.awt.MenuComponent this ^java.awt.Event evt]
    (-> this (.postEvent evt))))

(defn set-name
  "Sets the name of the component to the specified string.

  name - the name of the menu component - `java.lang.String`"
  ([^java.awt.MenuComponent this ^java.lang.String name]
    (-> this (.setName name))))

(defn to-string
  "Returns a representation of this menu component as a string.

  returns: a string representation of this menu component - `java.lang.String`"
  ([^java.awt.MenuComponent this]
    (-> this (.toString))))

(defn get-name
  "Gets the name of the menu component.

  returns: the name of the menu component - `java.lang.String`"
  ([^java.awt.MenuComponent this]
    (-> this (.getName))))

(defn remove-notify
  "Removes the menu component's peer.  The peer allows us to modify the
   appearance of the menu component without changing the functionality of
   the menu component."
  ([^java.awt.MenuComponent this]
    (-> this (.removeNotify))))

(defn get-parent
  "Returns the parent container for this menu component.

  returns: the menu component containing this menu component,
                   or null if this menu component
                   is the outermost component, the menu bar itself - `java.awt.MenuContainer`"
  ([^java.awt.MenuComponent this]
    (-> this (.getParent))))

(defn set-font
  "Sets the font to be used for this menu component to the specified
   font. This font is also used by all subcomponents of this menu
   component, unless those subcomponents specify a different font.

   Some platforms may not support setting of all font attributes
   of a menu component; in such cases, calling setFont
   will have no effect on the unsupported font attributes of this
   menu component.  Unless subcomponents of this menu component
   specify a different font, this font will be used by those
   subcomponents if supported by the underlying platform.

  f - the font to be set - `java.awt.Font`"
  ([^java.awt.MenuComponent this ^java.awt.Font f]
    (-> this (.setFont f))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with
   this MenuComponent.

   The method implemented by this base class returns null.
   Classes that extend MenuComponent
   should implement this method to return the
   AccessibleContext associated with the subclass.

  returns: the AccessibleContext of this
       MenuComponent - `javax.accessibility.AccessibleContext`"
  ([^java.awt.MenuComponent this]
    (-> this (.getAccessibleContext))))

(defn dispatch-event
  "Delivers an event to this component or one of its sub components.

  e - the event - `java.awt.AWTEvent`"
  ([^java.awt.MenuComponent this ^java.awt.AWTEvent e]
    (-> this (.dispatchEvent e))))

(defn get-font
  "Gets the font used for this menu component.

  returns: the font used in this menu component, if there is one;
                    null otherwise - `java.awt.Font`"
  ([^java.awt.MenuComponent this]
    (-> this (.getFont))))

(defn get-peer
  "Deprecated. As of JDK version 1.1,
   programs should not directly manipulate peers.

  returns: `java.lang.  java.awt.peer.MenuComponentPeer`"
  ([^java.awt.MenuComponent this]
    (-> this (.getPeer))))

