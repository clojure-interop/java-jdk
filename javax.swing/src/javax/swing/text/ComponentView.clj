(ns javax.swing.text.ComponentView
  "Component decorator that implements the view interface.  The
  entire element is used to represent the component.  This acts
  as a gateway from the display-only View implementations to
  interactive lightweight components (ie it allows components
  to be embedded into the View hierarchy).

  The component is placed relative to the text baseline
  according to the value returned by
  Component.getAlignmentY.  For Swing components
  this value can be conveniently set using the method
  JComponent.setAlignmentY.  For example, setting
  a value of 0.75 will cause 75 percent of the
  component to be above the baseline, and 25 percent of the
  component to be below the baseline.

  This class is implemented to do the extra work necessary to
  work properly in the presence of multiple threads (i.e. from
  asynchronous notification of model changes for example) by
  ensuring that all component access is done on the event thread.

  The component used is determined by the return value of the
  createComponent method.  The default implementation of this
  method is to return the component held as an attribute of
  the element (by calling StyleConstants.getComponent).  A
  limitation of this behavior is that the component cannot
  be used by more than one text component (i.e. with a shared
  model).  Subclasses can remove this constraint by implementing
  the createComponent to actually create a component based upon
  some kind of specification contained in the attributes.  The
  ObjectView class in the html package is an example of a
  ComponentView implementation that supports multiple component
  views of a shared model."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text ComponentView]))

(defn ->component-view
  "Constructor.

  Creates a new ComponentView object.

  elem - the element to decorate - `javax.swing.text.Element`"
  (^ComponentView [^javax.swing.text.Element elem]
    (new ComponentView elem)))

(defn get-component
  "Fetch the component associated with the view.

  returns: `java.awt.Component`"
  (^java.awt.Component [^ComponentView this]
    (-> this (.getComponent))))

(defn set-parent
  "Sets the parent for a child view.
   The parent calls this on the child to tell it who its
   parent is, giving the view access to things like
   the hosting Container.  The superclass behavior is
   executed, followed by a call to createComponent if
   the parent view parameter is non-null and a component
   has not yet been created. The embedded components parent
   is then set to the value returned by getContainer.
   If the parent view parameter is null, this view is being
   cleaned up, thus the component is removed from its parent.

   The changing of the component hierarchy will
   touch the component lock, which is the one thing
   that is not safe from the View hierarchy.  Therefore,
   this functionality is executed immediately if on the
   event thread, or is queued on the event queue if
   called from another thread (notification of change
   from an asynchronous update).

  p - the parent - `javax.swing.text.View`"
  ([^ComponentView this ^javax.swing.text.View p]
    (-> this (.setParent p))))

(defn get-preferred-span
  "Determines the preferred span for this view along an
   axis.  This is implemented to return the value
   returned by Component.getPreferredSize along the
   axis of interest.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`

  returns: the span the view would like to be rendered into >=0.
             Typically the view is told to render into the span
             that is returned, although there is no guarantee.
             The parent may choose to resize or break the view. - `float`

  throws: java.lang.IllegalArgumentException - for an invalid axis"
  (^Float [^ComponentView this ^Integer axis]
    (-> this (.getPreferredSpan axis))))

(defn get-minimum-span
  "Determines the minimum span for this view along an
   axis.  This is implemented to return the value
   returned by Component.getMinimumSize along the
   axis of interest.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`

  returns: the span the view would like to be rendered into >=0.
             Typically the view is told to render into the span
             that is returned, although there is no guarantee.
             The parent may choose to resize or break the view. - `float`

  throws: java.lang.IllegalArgumentException - for an invalid axis"
  (^Float [^ComponentView this ^Integer axis]
    (-> this (.getMinimumSpan axis))))

(defn get-maximum-span
  "Determines the maximum span for this view along an
   axis.  This is implemented to return the value
   returned by Component.getMaximumSize along the
   axis of interest.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`

  returns: the span the view would like to be rendered into >=0.
             Typically the view is told to render into the span
             that is returned, although there is no guarantee.
             The parent may choose to resize or break the view. - `float`

  throws: java.lang.IllegalArgumentException - for an invalid axis"
  (^Float [^ComponentView this ^Integer axis]
    (-> this (.getMaximumSpan axis))))

(defn paint
  "The real paint behavior occurs naturally from the association
   that the component has with its parent container (the same
   container hosting this view).  This is implemented to do nothing.

  g - the graphics context - `java.awt.Graphics`
  a - the shape - `java.awt.Shape`"
  ([^ComponentView this ^java.awt.Graphics g ^java.awt.Shape a]
    (-> this (.paint g a))))

(defn get-alignment
  "Determines the desired alignment for this view along an
   axis.  This is implemented to give the alignment of the
   embedded component.

  axis - may be either View.X_AXIS or View.Y_AXIS - `int`

  returns: the desired alignment.  This should be a value
     between 0.0 and 1.0 where 0 indicates alignment at the
     origin and 1.0 indicates alignment to the full span
     away from the origin.  An alignment of 0.5 would be the
     center of the view. - `float`"
  (^Float [^ComponentView this ^Integer axis]
    (-> this (.getAlignment axis))))

(defn view-to-model
  "Provides a mapping from the view coordinate space to the logical
   coordinate space of the model.

  x - the X coordinate >=0 - `float`
  y - the Y coordinate >=0 - `float`
  a - the allocated region to render into - `java.awt.Shape`
  bias - `javax.swing.text.Position$Bias[]`

  returns: the location within the model that best represents
      the given point in the view - `int`"
  (^Integer [^ComponentView this ^Float x ^Float y ^java.awt.Shape a bias]
    (-> this (.viewToModel x y a bias))))

(defn model-to-view
  "Provides a mapping from the coordinate space of the model to
   that of the view.

  pos - the position to convert >=0 - `int`
  a - the allocated region to render into - `java.awt.Shape`
  b - the bias toward the previous character or the next character represented by the offset, in case the position is a boundary of two views; b will have one of these values: Position.Bias.Forward Position.Bias.Backward - `javax.swing.text.Position$Bias`

  returns: the bounding box of the given position is returned - `java.awt.Shape`

  throws: javax.swing.text.BadLocationException - if the given position does not represent a valid location in the associated document"
  (^java.awt.Shape [^ComponentView this ^Integer pos ^java.awt.Shape a ^javax.swing.text.Position$Bias b]
    (-> this (.modelToView pos a b))))

