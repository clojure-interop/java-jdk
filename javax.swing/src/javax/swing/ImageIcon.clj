(ns javax.swing.ImageIcon
  "An implementation of the Icon interface that paints Icons
  from Images. Images that are created from a URL, filename or byte array
  are preloaded using MediaTracker to monitor the loaded state
  of the image.


  For further information and examples of using image icons, see
  How to Use Icons
  in The Java Tutorial.


  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing ImageIcon]))

(defn ->image-icon
  "Constructor.

  Creates an ImageIcon from the specified file. The image will
   be preloaded by using MediaTracker to monitor the loading state
   of the image.

  filename - the name of the file containing the image - `java.lang.String`
  description - a brief textual description of the image - `java.lang.String`"
  ([^java.lang.String filename ^java.lang.String description]
    (new ImageIcon filename description))
  ([^java.lang.String filename]
    (new ImageIcon filename))
  ([]
    (new ImageIcon )))

(defn get-image
  "Returns this icon's Image.

  returns: the Image object for this ImageIcon - `java.awt.Image`"
  ([^javax.swing.ImageIcon this]
    (-> this (.getImage))))

(defn get-icon-height
  "Gets the height of the icon.

  returns: the height in pixels of this icon - `int`"
  ([^javax.swing.ImageIcon this]
    (-> this (.getIconHeight))))

(defn set-description
  "Sets the description of the image.  This is meant to be a brief
   textual description of the object.  For example, it might be
   presented to a blind user to give an indication of the purpose
   of the image.

  description - a brief textual description of the image - `java.lang.String`"
  ([^javax.swing.ImageIcon this ^java.lang.String description]
    (-> this (.setDescription description))))

(defn set-image-observer
  "Sets the image observer for the image.  Set this
   property if the ImageIcon contains an animated GIF, so
   the observer is notified to update its display.
   For example:


       icon = new ImageIcon(...)
       button.setIcon(icon);
       icon.setImageObserver(button);

  observer - the image observer - `java.awt.image.ImageObserver`"
  ([^javax.swing.ImageIcon this ^java.awt.image.ImageObserver observer]
    (-> this (.setImageObserver observer))))

(defn set-image
  "Sets the image displayed by this icon.

  image - the image - `java.awt.Image`"
  ([^javax.swing.ImageIcon this ^java.awt.Image image]
    (-> this (.setImage image))))

(defn to-string
  "Returns a string representation of this image.

  returns: a string representing this image - `java.lang.String`"
  ([^javax.swing.ImageIcon this]
    (-> this (.toString))))

(defn get-description
  "Gets the description of the image.  This is meant to be a brief
   textual description of the object.  For example, it might be
   presented to a blind user to give an indication of the purpose
   of the image.
   The description may be null.

  returns: a brief textual description of the image - `java.lang.String`"
  ([^javax.swing.ImageIcon this]
    (-> this (.getDescription))))

(defn get-icon-width
  "Gets the width of the icon.

  returns: the width in pixels of this icon - `int`"
  ([^javax.swing.ImageIcon this]
    (-> this (.getIconWidth))))

(defn paint-icon
  "Paints the icon.
   The top-left corner of the icon is drawn at
   the point (x, y)
   in the coordinate space of the graphics context g.
   If this icon has no image observer,
   this method uses the c component
   as the observer.

  c - the component to be used as the observer if this icon has no image observer - `java.awt.Component`
  g - the graphics context - `java.awt.Graphics`
  x - the X coordinate of the icon's top-left corner - `int`
  y - the Y coordinate of the icon's top-left corner - `int`"
  ([^javax.swing.ImageIcon this ^java.awt.Component c ^java.awt.Graphics g ^Integer x ^Integer y]
    (-> this (.paintIcon c g x y))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this ImageIcon.
   For image icons, the AccessibleContext takes the form of an
   AccessibleImageIcon.
   A new AccessibleImageIcon instance is created if necessary.

  returns: an AccessibleImageIcon that serves as the
           AccessibleContext of this ImageIcon - `javax.accessibility.AccessibleContext`"
  ([^javax.swing.ImageIcon this]
    (-> this (.getAccessibleContext))))

(defn get-image-load-status
  "Returns the status of the image loading operation.

  returns: the loading status as defined by java.awt.MediaTracker - `int`"
  ([^javax.swing.ImageIcon this]
    (-> this (.getImageLoadStatus))))

(defn get-image-observer
  "Returns the image observer for the image.

  returns: the image observer, which may be null - `java.awt.image.ImageObserver`"
  ([^javax.swing.ImageIcon this]
    (-> this (.getImageObserver))))

