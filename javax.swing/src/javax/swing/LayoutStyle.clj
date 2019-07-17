(ns javax.swing.LayoutStyle
  "LayoutStyle provides information about how to position
  components.  This class is primarily useful for visual tools and
  layout managers.  Most developers will not need to use this class.

  You typically don't set or create a
  LayoutStyle.  Instead use the static method
  getInstance to obtain the current instance."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing LayoutStyle]))

(defn ->layout-style
  "Constructor.

  Creates a new LayoutStyle.  You generally don't
   create a LayoutStyle.  Instead use the method
   getInstance to obtain the current
   LayoutStyle."
  ([]
    (new LayoutStyle )))

(defn *set-instance
  "Sets the shared instance of LayoutStyle.  Specifying
   null results in using the LayoutStyle from
   the current LookAndFeel.

  style - the LayoutStyle, or null - `javax.swing.LayoutStyle`"
  ([style]
    (LayoutStyle/setInstance style)))

(defn *get-instance
  "Returns the shared instance of LayoutStyle.  If an instance
   has not been specified in setInstance, this will return
   the LayoutStyle from the current LookAndFeel.

  returns: the shared instance of LayoutStyle - `javax.swing.LayoutStyle`"
  ([]
    (LayoutStyle/getInstance )))

(defn get-preferred-gap
  "Returns the amount of space to use between two components.
   The return value indicates the distance to place
   component2 relative to component1.
   For example, the following returns the amount of space to place
   between component2 and component1
   when component2 is placed vertically above
   component1:


     int gap = getPreferredGap(component1, component2,
                               ComponentPlacement.RELATED,
                               SwingConstants.NORTH, parent);
   The type parameter indicates the relation between
   the two components.  If the two components will be contained in
   the same parent and are showing similar logically related
   items, use RELATED.  If the two components will be
   contained in the same parent but show logically unrelated items
   use UNRELATED.  Some look and feels may not
   distinguish between the RELATED and
   UNRELATED types.

   The return value is not intended to take into account the
   current size and position of component2 or
   component1.  The return value may take into
   consideration various properties of the components.  For
   example, the space may vary based on font size, or the preferred
   size of the component.

  component-1 - the JComponent component2 is being placed relative to - `javax.swing.JComponent`
  component-2 - the JComponent being placed - `javax.swing.JComponent`
  type - how the two components are being placed - `javax.swing.LayoutStyle.ComponentPlacement`
  position - the position component2 is being placed relative to component1; one of SwingConstants.NORTH, SwingConstants.SOUTH, SwingConstants.EAST or SwingConstants.WEST - `int`
  parent - the parent of component2; this may differ from the actual parent and it may be null - `java.awt.Container`

  returns: the amount of space to place between the two components - `int`

  throws: java.lang.NullPointerException - if component1, component2 or type is null"
  ([this component-1 component-2 type position parent]
    (-> this (.getPreferredGap component-1 component-2 type position parent))))

(defn get-container-gap
  "Returns the amount of space to place between the component and specified
   edge of its parent.

  component - the JComponent being positioned - `javax.swing.JComponent`
  position - the position component is being placed relative to its parent; one of SwingConstants.NORTH, SwingConstants.SOUTH, SwingConstants.EAST or SwingConstants.WEST - `int`
  parent - the parent of component; this may differ from the actual parent and may be null - `java.awt.Container`

  returns: the amount of space to place between the component and specified
           edge - `int`

  throws: java.lang.IllegalArgumentException - if position is not one of SwingConstants.NORTH, SwingConstants.SOUTH, SwingConstants.EAST or SwingConstants.WEST"
  ([this component position parent]
    (-> this (.getContainerGap component position parent))))

