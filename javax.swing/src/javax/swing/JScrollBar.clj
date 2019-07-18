(ns javax.swing.JScrollBar
  "An implementation of a scrollbar. The user positions the knob in the
  scrollbar to determine the contents of the viewing area. The
  program typically adjusts the display so that the end of the
  scrollbar represents the end of the displayable contents, or 100%
  of the contents. The start of the scrollbar is the beginning of the
  displayable contents, or 0%. The position of the knob within
  those bounds then translates to the corresponding percentage of
  the displayable contents.

  Typically, as the position of the knob in the scrollbar changes
  a corresponding change is made to the position of the JViewport on
  the underlying view, changing the contents of the JViewport.

  Warning: Swing is not thread safe. For more
  information see Swing's Threading
  Policy.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing JScrollBar]))

(defn ->j-scroll-bar
  "Constructor.

  Creates a scrollbar with the specified orientation,
   value, extent, minimum, and maximum.
   The `extent` is the size of the viewable area. It is also known
   as the `visible amount`.

   Note: Use setBlockIncrement to set the block
   increment to a size slightly smaller than the view's extent.
   That way, when the user jumps the knob to an adjacent position,
   one or two lines of the original contents remain in view.

  orientation - `int`
  value - `int`
  extent - `int`
  min - `int`
  max - `int`

  throws: java.lang.IllegalArgumentException - if orientation is not one of VERTICAL, HORIZONTAL"
  (^JScrollBar [^Integer orientation ^Integer value ^Integer extent ^Integer min ^Integer max]
    (new JScrollBar orientation value extent min max))
  (^JScrollBar [^Integer orientation]
    (new JScrollBar orientation))
  (^JScrollBar []
    (new JScrollBar )))

(defn get-adjustment-listeners
  "Returns an array of all the AdjustmentListeners added
   to this JScrollBar with addAdjustmentListener().

  returns: all of the AdjustmentListeners added or an empty
           array if no listeners have been added - `java.awt.event.AdjustmentListener[]`"
  ([^JScrollBar this]
    (-> this (.getAdjustmentListeners))))

(defn get-visible-amount
  "Returns the scrollbar's extent, aka its `visibleAmount`.  In many
   scrollbar look and feel implementations the size of the
   scrollbar `knob` or `thumb` is proportional to the extent.

  returns: the value of the model's extent property - `int`"
  (^Integer [^JScrollBar this]
    (-> this (.getVisibleAmount))))

(defn set-block-increment
  "Sets the blockIncrement property.

   Note, that if the argument is equal to the value of Integer.MIN_VALUE,
   the most look and feels will not provide the scrolling to the right/down.

   Some look and feels implement custom scrolling behavior
   and ignore this property.

  block-increment - the block increment - `int`"
  ([^JScrollBar this ^Integer block-increment]
    (-> this (.setBlockIncrement block-increment))))

(defn get-minimum-size
  "The scrollbar is flexible along it's scrolling axis and
   rigid along the other axis.

  returns: the value of the minimumSize property - `java.awt.Dimension`"
  (^java.awt.Dimension [^JScrollBar this]
    (-> this (.getMinimumSize))))

(defn get-value-is-adjusting?
  "True if the scrollbar knob is being dragged.

  returns: the value of the model's valueIsAdjusting property - `boolean`"
  (^Boolean [^JScrollBar this]
    (-> this (.getValueIsAdjusting))))

(defn get-orientation
  "Returns the component's orientation (horizontal or vertical).

  returns: VERTICAL or HORIZONTAL - `int`"
  (^Integer [^JScrollBar this]
    (-> this (.getOrientation))))

(defn get-maximum-size
  "The scrollbar is flexible along it's scrolling axis and
   rigid along the other axis.

  returns: the value of the maximumSize property - `java.awt.Dimension`"
  (^java.awt.Dimension [^JScrollBar this]
    (-> this (.getMaximumSize))))

(defn get-minimum
  "Returns the minimum value supported by the scrollbar
   (usually zero).

  returns: the value of the model's minimum property - `int`"
  (^Integer [^JScrollBar this]
    (-> this (.getMinimum))))

(defn get-unit-increment
  "Returns the amount to change the scrollbar's value by,
   given a unit up/down request.  A ScrollBarUI implementation
   typically calls this method when the user clicks on a scrollbar
   up/down arrow and uses the result to update the scrollbar's
   value.   Subclasses my override this method to compute
   a value, e.g. the change required to scroll up or down one
   (variable height) line text or one row in a table.

   The JScrollPane component creates scrollbars (by default)
   that override this method and delegate to the viewports
   Scrollable view, if it has one.  The Scrollable interface
   provides a more specialized version of this method.

   Some look and feels implement custom scrolling behavior
   and ignore this property.

  direction - is -1 or 1 for up/down respectively - `int`

  returns: the value of the unitIncrement property - `int`"
  (^Integer [^JScrollBar this ^Integer direction]
    (-> this (.getUnitIncrement direction)))
  (^Integer [^JScrollBar this]
    (-> this (.getUnitIncrement))))

(defn get-block-increment
  "Returns the amount to change the scrollbar's value by,
   given a block (usually `page`) up/down request.  A ScrollBarUI
   implementation typically calls this method when the user clicks
   above or below the scrollbar `knob` to change the value
   up or down by large amount.  Subclasses my override this
   method to compute a value, e.g. the change required to scroll
   up or down one paragraph in a text document.

   The JScrollPane component creates scrollbars (by default)
   that override this method and delegate to the viewports
   Scrollable view, if it has one.  The Scrollable interface
   provides a more specialized version of this method.

   Some look and feels implement custom scrolling behavior
   and ignore this property.

  direction - is -1 or 1 for up/down respectively - `int`

  returns: the value of the blockIncrement property - `int`"
  (^Integer [^JScrollBar this ^Integer direction]
    (-> this (.getBlockIncrement direction)))
  (^Integer [^JScrollBar this]
    (-> this (.getBlockIncrement))))

(defn add-adjustment-listener
  "Adds an AdjustmentListener.  Adjustment listeners are notified
   each time the scrollbar's model changes.  Adjustment events are
   provided for backwards compatibility with java.awt.Scrollbar.

   Note that the AdjustmentEvents type property will always have a
   placeholder value of AdjustmentEvent.TRACK because all changes
   to a BoundedRangeModels value are considered equivalent.  To change
   the value of a BoundedRangeModel one just sets its value property,
   i.e. model.setValue(123).  No information about the origin of the
   change, e.g. it's a block decrement, is provided.  We don't try
   fabricate the origin of the change here.

  l - the AdjustmentLister to add - `java.awt.event.AdjustmentListener`"
  ([^JScrollBar this ^java.awt.event.AdjustmentListener l]
    (-> this (.addAdjustmentListener l))))

(defn get-ui-class-id
  "Returns the name of the LookAndFeel class for this component.

  returns: `ScrollBarUI` - `java.lang.String`"
  (^java.lang.String [^JScrollBar this]
    (-> this (.getUIClassID))))

(defn get-value
  "Returns the scrollbar's value.

  returns: the model's value property - `int`"
  (^Integer [^JScrollBar this]
    (-> this (.getValue))))

(defn remove-adjustment-listener
  "Removes an AdjustmentEvent listener.

  l - the AdjustmentLister to remove - `java.awt.event.AdjustmentListener`"
  ([^JScrollBar this ^java.awt.event.AdjustmentListener l]
    (-> this (.removeAdjustmentListener l))))

(defn set-ui
  "Sets the L&F object that renders this component.

  ui - the ScrollBarUI L&F object - `javax.swing.plaf.ScrollBarUI`"
  ([^JScrollBar this ^javax.swing.plaf.ScrollBarUI ui]
    (-> this (.setUI ui))))

(defn set-maximum
  "Sets the model's maximum property.  Note that the scrollbar's value
   can only be set to maximum - extent.

  maximum - the maximum value - `int`"
  ([^JScrollBar this ^Integer maximum]
    (-> this (.setMaximum maximum))))

(defn get-ui
  "Returns the delegate that implements the look and feel for
   this component.

  returns: `javax.swing.plaf.ScrollBarUI`"
  (^javax.swing.plaf.ScrollBarUI [^JScrollBar this]
    (-> this (.getUI))))

(defn set-value-is-adjusting
  "Sets the model's valueIsAdjusting property.  Scrollbar look and
   feel implementations should set this property to true when
   a knob drag begins, and to false when the drag ends.  The
   scrollbar model will not generate ChangeEvents while
   valueIsAdjusting is true.

  b - `boolean`"
  ([^JScrollBar this ^Boolean b]
    (-> this (.setValueIsAdjusting b))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this JScrollBar.
   For JScrollBar, the AccessibleContext takes the form of an
   AccessibleJScrollBar.
   A new AccessibleJScrollBar instance is created if necessary.

  returns: an AccessibleJScrollBar that serves as the
           AccessibleContext of this JScrollBar - `javax.accessibility.AccessibleContext`"
  (^javax.accessibility.AccessibleContext [^JScrollBar this]
    (-> this (.getAccessibleContext))))

(defn set-values
  "Sets the four BoundedRangeModel properties after forcing
   the arguments to obey the usual constraints:


   minimum ≤ value ≤ value+extent ≤ maximum

  new-value - `int`
  new-extent - `int`
  new-min - `int`
  new-max - `int`"
  ([^JScrollBar this ^Integer new-value ^Integer new-extent ^Integer new-min ^Integer new-max]
    (-> this (.setValues new-value new-extent new-min new-max))))

(defn set-unit-increment
  "Sets the unitIncrement property.

   Note, that if the argument is equal to the value of Integer.MIN_VALUE,
   the most look and feels will not provide the scrolling to the right/down.

   Some look and feels implement custom scrolling behavior
   and ignore this property.

  unit-increment - the unit increment - `int`"
  ([^JScrollBar this ^Integer unit-increment]
    (-> this (.setUnitIncrement unit-increment))))

(defn set-value
  "Sets the scrollbar's value.  This method just forwards the value
   to the model.

  value - the current value, between minimum and maximum - visibleAmount - `int`"
  ([^JScrollBar this ^Integer value]
    (-> this (.setValue value))))

(defn set-enabled
  "Enables the component so that the knob position can be changed.
   When the disabled, the knob position cannot be changed.

  x - a boolean value, where true enables the component and false disables it - `boolean`"
  ([^JScrollBar this ^Boolean x]
    (-> this (.setEnabled x))))

(defn set-orientation
  "Set the scrollbar's orientation to either VERTICAL or
   HORIZONTAL.

  orientation - `int`

  throws: java.lang.IllegalArgumentException - if orientation is not one of VERTICAL, HORIZONTAL"
  ([^JScrollBar this ^Integer orientation]
    (-> this (.setOrientation orientation))))

(defn set-visible-amount
  "Set the model's extent property.

  extent - the length of the indicator - `int`"
  ([^JScrollBar this ^Integer extent]
    (-> this (.setVisibleAmount extent))))

(defn get-model
  "Returns data model that handles the scrollbar's four
   fundamental properties: minimum, maximum, value, extent.

  returns: `javax.swing.BoundedRangeModel`"
  (^javax.swing.BoundedRangeModel [^JScrollBar this]
    (-> this (.getModel))))

(defn set-minimum
  "Sets the model's minimum property.

  minimum - the minimum value - `int`"
  ([^JScrollBar this ^Integer minimum]
    (-> this (.setMinimum minimum))))

(defn get-maximum
  "The maximum value of the scrollbar is maximum - extent.

  returns: the value of the model's maximum property - `int`"
  (^Integer [^JScrollBar this]
    (-> this (.getMaximum))))

(defn set-model
  "Sets the model that handles the scrollbar's four
   fundamental properties: minimum, maximum, value, extent.

  new-model - `javax.swing.BoundedRangeModel`"
  ([^JScrollBar this ^javax.swing.BoundedRangeModel new-model]
    (-> this (.setModel new-model))))

(defn update-ui
  "Overrides JComponent.updateUI."
  ([^JScrollBar this]
    (-> this (.updateUI))))

