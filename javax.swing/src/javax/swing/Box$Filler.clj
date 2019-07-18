(ns javax.swing.Box$Filler
  "An implementation of a lightweight component that participates in
  layout but has no view.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing Box$Filler]))

(defn ->filler
  "Constructor.

  Constructor to create shape with the given size ranges.

  min - Minimum size - `java.awt.Dimension`
  pref - Preferred size - `java.awt.Dimension`
  max - Maximum size - `java.awt.Dimension`"
  (^Box$Filler [^java.awt.Dimension min ^java.awt.Dimension pref ^java.awt.Dimension max]
    (new Box$Filler min pref max)))

(defn change-shape
  "Change the size requests for this shape.  An invalidate() is
   propagated upward as a result so that layout will eventually
   happen with using the new sizes.

  min - Value to return for getMinimumSize - `java.awt.Dimension`
  pref - Value to return for getPreferredSize - `java.awt.Dimension`
  max - Value to return for getMaximumSize - `java.awt.Dimension`"
  ([^Box$Filler this ^java.awt.Dimension min ^java.awt.Dimension pref ^java.awt.Dimension max]
    (-> this (.changeShape min pref max))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this Box.Filler.
   For box fillers, the AccessibleContext takes the form of an
   AccessibleBoxFiller.
   A new AccessibleAWTBoxFiller instance is created if necessary.

  returns: an AccessibleBoxFiller that serves as the
           AccessibleContext of this Box.Filler. - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^Box$Filler this]
    (-> this (.getAccessibleContext))))

