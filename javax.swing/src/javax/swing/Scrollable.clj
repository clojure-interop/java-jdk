(ns javax.swing.Scrollable
  "An interface that provides information to a scrolling container
  like JScrollPane.  A complex component that's likely to be used
  as a viewing a JScrollPane viewport (or other scrolling container)
  should implement this interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing Scrollable]))

(defn get-preferred-scrollable-viewport-size
  "Returns the preferred size of the viewport for a view component.
   For example, the preferred size of a JList component
   is the size required to accommodate all of the cells in its list.
   However, the value of preferredScrollableViewportSize
   is the size required for JList.getVisibleRowCount rows.
   A component without any properties that would affect the viewport
   size should just return getPreferredSize here.

  returns: the preferredSize of a JViewport whose view
      is this Scrollable - `java.awt.Dimension`"
  ([this]
    (-> this (.getPreferredScrollableViewportSize))))

(defn get-scrollable-unit-increment
  "Components that display logical rows or columns should compute
   the scroll increment that will completely expose one new row
   or column, depending on the value of orientation.  Ideally,
   components should handle a partially exposed row or column by
   returning the distance required to completely expose the item.

   Scrolling containers, like JScrollPane, will use this method
   each time the user requests a unit scroll.

  visible-rect - The view area visible within the viewport - `java.awt.Rectangle`
  orientation - Either SwingConstants.VERTICAL or SwingConstants.HORIZONTAL. - `int`
  direction - Less than zero to scroll up/left, greater than zero for down/right. - `int`

  returns: The `unit` increment for scrolling in the specified direction.
           This value should always be positive. - `int`"
  ([this visible-rect orientation direction]
    (-> this (.getScrollableUnitIncrement visible-rect orientation direction))))

(defn get-scrollable-block-increment
  "Components that display logical rows or columns should compute
   the scroll increment that will completely expose one block
   of rows or columns, depending on the value of orientation.

   Scrolling containers, like JScrollPane, will use this method
   each time the user requests a block scroll.

  visible-rect - The view area visible within the viewport - `java.awt.Rectangle`
  orientation - Either SwingConstants.VERTICAL or SwingConstants.HORIZONTAL. - `int`
  direction - Less than zero to scroll up/left, greater than zero for down/right. - `int`

  returns: The `block` increment for scrolling in the specified direction.
           This value should always be positive. - `int`"
  ([this visible-rect orientation direction]
    (-> this (.getScrollableBlockIncrement visible-rect orientation direction))))

(defn get-scrollable-tracks-viewport-width?
  "Return true if a viewport should always force the width of this
   Scrollable to match the width of the viewport.
   For example a normal
   text view that supported line wrapping would return true here, since it
   would be undesirable for wrapped lines to disappear beyond the right
   edge of the viewport.  Note that returning true for a Scrollable
   whose ancestor is a JScrollPane effectively disables horizontal
   scrolling.

   Scrolling containers, like JViewport, will use this method each
   time they are validated.

  returns: True if a viewport should force the Scrollables width to match its own. - `boolean`"
  ([this]
    (-> this (.getScrollableTracksViewportWidth))))

(defn get-scrollable-tracks-viewport-height?
  "Return true if a viewport should always force the height of this
   Scrollable to match the height of the viewport.  For example a
   columnar text view that flowed text in left to right columns
   could effectively disable vertical scrolling by returning
   true here.

   Scrolling containers, like JViewport, will use this method each
   time they are validated.

  returns: True if a viewport should force the Scrollables height to match its own. - `boolean`"
  ([this]
    (-> this (.getScrollableTracksViewportHeight))))

