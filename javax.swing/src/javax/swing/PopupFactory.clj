(ns javax.swing.PopupFactory
  "PopupFactory, as the name implies, is used to obtain
  instances of Popups. Popups are used to
  display a Component above all other Components
  in a particular containment hierarchy. The general contract is that
  once you have obtained a Popup from a
  PopupFactory, you must invoke hide on the
  Popup. The typical usage is:


    PopupFactory factory = PopupFactory.getSharedInstance();
    Popup popup = factory.getPopup(owner, contents, x, y);
    popup.show();
    ...
    popup.hide();"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing PopupFactory]))

(defn ->popup-factory
  "Constructor."
  ([]
    (new PopupFactory )))

(defn *set-shared-instance
  "Sets the PopupFactory that will be used to obtain
   Popups.
   This will throw an IllegalArgumentException if
   factory is null.

  factory - Shared PopupFactory - `javax.swing.PopupFactory`

  throws: java.lang.IllegalArgumentException - if factory is null"
  ([factory]
    (PopupFactory/setSharedInstance factory)))

(defn *get-shared-instance
  "Returns the shared PopupFactory which can be used
   to obtain Popups.

  returns: Shared PopupFactory - `javax.swing.PopupFactory`"
  ([]
    (PopupFactory/getSharedInstance )))

(defn get-popup
  "Creates a Popup for the Component owner
   containing the Component contents. owner
   is used to determine which Window the new
   Popup will parent the Component the
   Popup creates to. A null owner implies there
   is no valid parent. x and
   y specify the preferred initial location to place
   the Popup at. Based on screen size, or other paramaters,
   the Popup may not display at x and
   y.

  owner - Component mouse coordinates are relative to, may be null - `java.awt.Component`
  contents - Contents of the Popup - `java.awt.Component`
  x - Initial x screen coordinate - `int`
  y - Initial y screen coordinate - `int`

  returns: Popup containing Contents - `javax.swing.Popup`

  throws: java.lang.IllegalArgumentException - if contents is null"
  ([this owner contents x y]
    (-> this (.getPopup owner contents x y))))

