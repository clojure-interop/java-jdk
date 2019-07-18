(ns javax.accessibility.AccessibleComponent
  "The AccessibleComponent interface should be supported by any object
  that is rendered on the screen.  This interface provides the standard
  mechanism for an assistive technology to determine and set the
  graphical representation of an object.  Applications can determine
  if an object supports the AccessibleComponent interface by first
  obtaining its AccessibleContext
  and then calling the
  AccessibleContext.getAccessibleComponent() method.
  If the return value is not null, the object supports this interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.accessibility AccessibleComponent]))

(defn get-location
  "Gets the location of the object relative to the parent in the form
   of a point specifying the object's top-left corner in the screen's
   coordinate space.

  returns: An instance of Point representing the top-left corner of the
   object's bounds in the coordinate space of the screen; null if
   this object or its parent are not on the screen - `java.awt.Point`"
  (^java.awt.Point [^AccessibleComponent this]
    (-> this (.getLocation))))

(defn set-location
  "Sets the location of the object relative to the parent.

  p - the new position for the top-left corner - `java.awt.Point`"
  ([^AccessibleComponent this ^java.awt.Point p]
    (-> this (.setLocation p))))

(defn set-foreground
  "Sets the foreground color of this object.

  c - the new Color for the foreground - `java.awt.Color`"
  ([^AccessibleComponent this ^java.awt.Color c]
    (-> this (.setForeground c))))

(defn get-foreground
  "Gets the foreground color of this object.

  returns: the foreground color, if supported, of the object;
   otherwise, null - `java.awt.Color`"
  (^java.awt.Color [^AccessibleComponent this]
    (-> this (.getForeground))))

(defn get-cursor
  "Gets the Cursor of this object.

  returns: the Cursor, if supported, of the object; otherwise, null - `java.awt.Cursor`"
  (^java.awt.Cursor [^AccessibleComponent this]
    (-> this (.getCursor))))

(defn contains
  "Checks whether the specified point is within this object's bounds,
   where the point's x and y coordinates are defined to be relative to the
   coordinate system of the object.

  p - the Point relative to the coordinate system of the object - `java.awt.Point`

  returns: true if object contains Point; otherwise false - `boolean`"
  (^Boolean [^AccessibleComponent this ^java.awt.Point p]
    (-> this (.contains p))))

(defn get-location-on-screen
  "Returns the location of the object on the screen.

  returns: the location of the object on screen; null if this object
   is not on the screen - `java.awt.Point`"
  (^java.awt.Point [^AccessibleComponent this]
    (-> this (.getLocationOnScreen))))

(defn set-background
  "Sets the background color of this object.

  c - the new Color for the background - `java.awt.Color`"
  ([^AccessibleComponent this ^java.awt.Color c]
    (-> this (.setBackground c))))

(defn focus-traversable?
  "Returns whether this object can accept focus or not.   Objects that
   can accept focus will also have the AccessibleState.FOCUSABLE state
   set in their AccessibleStateSets.

  returns: true if object can accept focus; otherwise false - `boolean`"
  (^Boolean [^AccessibleComponent this]
    (-> this (.isFocusTraversable))))

(defn get-font-metrics
  "Gets the FontMetrics of this object.

  f - the Font - `java.awt.Font`

  returns: the FontMetrics, if supported, the object; otherwise, null - `java.awt.FontMetrics`"
  (^java.awt.FontMetrics [^AccessibleComponent this ^java.awt.Font f]
    (-> this (.getFontMetrics f))))

(defn add-focus-listener
  "Adds the specified focus listener to receive focus events from this
   component.

  l - the focus listener - `java.awt.event.FocusListener`"
  ([^AccessibleComponent this ^java.awt.event.FocusListener l]
    (-> this (.addFocusListener l))))

(defn set-font
  "Sets the Font of this object.

  f - the new Font for the object - `java.awt.Font`"
  ([^AccessibleComponent this ^java.awt.Font f]
    (-> this (.setFont f))))

(defn set-visible
  "Sets the visible state of the object.

  b - if true, shows this object; otherwise, hides it - `boolean`"
  ([^AccessibleComponent this ^Boolean b]
    (-> this (.setVisible b))))

(defn set-enabled
  "Sets the enabled state of the object.

  b - if true, enables this object; otherwise, disables it - `boolean`"
  ([^AccessibleComponent this ^Boolean b]
    (-> this (.setEnabled b))))

(defn visible?
  "Determines if the object is visible.  Note: this means that the
   object intends to be visible; however, it may not be
   showing on the screen because one of the objects that this object
   is contained by is currently not visible.  To determine if an object is
   showing on the screen, use isShowing().
   Objects that are visible will also have the
   AccessibleState.VISIBLE state set in their AccessibleStateSets.

  returns: true if object is visible; otherwise, false - `boolean`"
  (^Boolean [^AccessibleComponent this]
    (-> this (.isVisible))))

(defn set-size
  "Resizes this object so that it has width and height.

  d - The dimension specifying the new size of the object. - `java.awt.Dimension`"
  ([^AccessibleComponent this ^java.awt.Dimension d]
    (-> this (.setSize d))))

(defn request-focus
  "Requests focus for this object.  If this object cannot accept focus,
   nothing will happen.  Otherwise, the object will attempt to take
   focus."
  ([^AccessibleComponent this]
    (-> this (.requestFocus))))

(defn get-bounds
  "Gets the bounds of this object in the form of a Rectangle object.
   The bounds specify this object's width, height, and location
   relative to its parent.

  returns: A rectangle indicating this component's bounds; null if
   this object is not on the screen. - `java.awt.Rectangle`"
  (^java.awt.Rectangle [^AccessibleComponent this]
    (-> this (.getBounds))))

(defn set-bounds
  "Sets the bounds of this object in the form of a Rectangle object.
   The bounds specify this object's width, height, and location
   relative to its parent.

  r - rectangle indicating this component's bounds - `java.awt.Rectangle`"
  ([^AccessibleComponent this ^java.awt.Rectangle r]
    (-> this (.setBounds r))))

(defn get-font
  "Gets the Font of this object.

  returns: the Font,if supported, for the object; otherwise, null - `java.awt.Font`"
  (^java.awt.Font [^AccessibleComponent this]
    (-> this (.getFont))))

(defn set-cursor
  "Sets the Cursor of this object.

  cursor - the new Cursor for the object - `java.awt.Cursor`"
  ([^AccessibleComponent this ^java.awt.Cursor cursor]
    (-> this (.setCursor cursor))))

(defn get-background
  "Gets the background color of this object.

  returns: the background color, if supported, of the object;
   otherwise, null - `java.awt.Color`"
  (^java.awt.Color [^AccessibleComponent this]
    (-> this (.getBackground))))

(defn get-accessible-at
  "Returns the Accessible child, if one exists, contained at the local
   coordinate Point.

  p - The point relative to the coordinate system of this object. - `java.awt.Point`

  returns: the Accessible, if it exists, at the specified location;
   otherwise null - `javax.accessibility.Accessible`"
  (^javax.accessibility.Accessible [^AccessibleComponent this ^java.awt.Point p]
    (-> this (.getAccessibleAt p))))

(defn showing?
  "Determines if the object is showing.  This is determined by checking
   the visibility of the object and its ancestors.
   Note: this
   will return true even if the object is obscured by another (for example,
   it is underneath a menu that was pulled down).

  returns: true if object is showing; otherwise, false - `boolean`"
  (^Boolean [^AccessibleComponent this]
    (-> this (.isShowing))))

(defn get-size
  "Returns the size of this object in the form of a Dimension object.
   The height field of the Dimension object contains this object's
   height, and the width field of the Dimension object contains this
   object's width.

  returns: A Dimension object that indicates the size of this component;
   null if this object is not on the screen - `java.awt.Dimension`"
  (^java.awt.Dimension [^AccessibleComponent this]
    (-> this (.getSize))))

(defn remove-focus-listener
  "Removes the specified focus listener so it no longer receives focus
   events from this component.

  l - the focus listener - `java.awt.event.FocusListener`"
  ([^AccessibleComponent this ^java.awt.event.FocusListener l]
    (-> this (.removeFocusListener l))))

(defn enabled?
  "Determines if the object is enabled.  Objects that are enabled
   will also have the AccessibleState.ENABLED state set in their
   AccessibleStateSets.

  returns: true if object is enabled; otherwise, false - `boolean`"
  (^Boolean [^AccessibleComponent this]
    (-> this (.isEnabled))))

