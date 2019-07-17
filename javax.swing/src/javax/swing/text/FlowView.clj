(ns javax.swing.text.FlowView
  "A View that tries to flow it's children into some
  partially constrained space.  This can be used to
  build things like paragraphs, pages, etc.  The
  flow is made up of the following pieces of functionality.

  A logical set of child views, which as used as a
  layout pool from which a physical view is formed.
  A strategy for translating the logical view to
  a physical (flowed) view.
  Constraints for the strategy to work against.
  A physical structure, that represents the flow.
  The children of this view are where the pieces of
  of the logical views are placed to create the flow."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text FlowView]))

(defn ->flow-view
  "Constructor.

  Constructs a FlowView for the given element.

  elem - the element that this view is responsible for - `javax.swing.text.Element`
  axis - may be either View.X_AXIS or View.Y_AXIS - `int`"
  ([^javax.swing.text.Element elem ^Integer axis]
    (new FlowView elem axis)))

(defn get-flow-axis
  "Fetches the axis along which views should be
   flowed.  By default, this will be the axis
   orthogonal to the axis along which the flow
   rows are tiled (the axis of the default flow
   rows themselves).  This is typically used
   by the FlowStrategy.

  returns: `int`"
  (^Integer [^javax.swing.text.FlowView this]
    (-> this (.getFlowAxis))))

(defn get-flow-span
  "Fetch the constraining span to flow against for
   the given child index.  This is called by the
   FlowStrategy while it is updating the flow.
   A flow can be shaped by providing different values
   for the row constraints.  By default, the entire
   span inside of the insets along the flow axis
   is returned.

  index - the index of the row being updated. This should be a value >= 0 and < getViewCount(). - `int`

  returns: `int`"
  (^Integer [^javax.swing.text.FlowView this ^Integer index]
    (-> this (.getFlowSpan index))))

(defn get-flow-start
  "Fetch the location along the flow axis that the
   flow span will start at.  This is called by the
   FlowStrategy while it is updating the flow.
   A flow can be shaped by providing different values
   for the row constraints.

  index - the index of the row being updated. This should be a value >= 0 and < getViewCount(). - `int`

  returns: `int`"
  (^Integer [^javax.swing.text.FlowView this ^Integer index]
    (-> this (.getFlowStart index))))

(defn insert-update
  "Gives notification that something was inserted into the document
   in a location that this view is responsible for.

  changes - the change information from the associated document - `javax.swing.event.DocumentEvent`
  a - the current allocation of the view - `java.awt.Shape`
  f - the factory to use to rebuild if the view has children - `javax.swing.text.ViewFactory`"
  ([^javax.swing.text.FlowView this ^javax.swing.event.DocumentEvent changes ^java.awt.Shape a ^javax.swing.text.ViewFactory f]
    (-> this (.insertUpdate changes a f))))

(defn remove-update
  "Gives notification that something was removed from the document
   in a location that this view is responsible for.

  changes - the change information from the associated document - `javax.swing.event.DocumentEvent`
  a - the current allocation of the view - `java.awt.Shape`
  f - the factory to use to rebuild if the view has children - `javax.swing.text.ViewFactory`"
  ([^javax.swing.text.FlowView this ^javax.swing.event.DocumentEvent changes ^java.awt.Shape a ^javax.swing.text.ViewFactory f]
    (-> this (.removeUpdate changes a f))))

(defn changed-update
  "Gives notification from the document that attributes were changed
   in a location that this view is responsible for.

  changes - the change information from the associated document - `javax.swing.event.DocumentEvent`
  a - the current allocation of the view - `java.awt.Shape`
  f - the factory to use to rebuild if the view has children - `javax.swing.text.ViewFactory`"
  ([^javax.swing.text.FlowView this ^javax.swing.event.DocumentEvent changes ^java.awt.Shape a ^javax.swing.text.ViewFactory f]
    (-> this (.changedUpdate changes a f))))

(defn set-parent
  "Sets the parent of the view.
   This is reimplemented to provide the superclass
   behavior as well as calling the loadChildren
   method if this view does not already have children.
   The children should not be loaded in the
   constructor because the act of setting the parent
   may cause them to try to search up the hierarchy
   (to get the hosting Container for example).
   If this view has children (the view is being moved
   from one place in the view hierarchy to another),
   the loadChildren method will not be called.

  parent - the parent of the view, null if none - `javax.swing.text.View`"
  ([^javax.swing.text.FlowView this ^javax.swing.text.View parent]
    (-> this (.setParent parent))))

