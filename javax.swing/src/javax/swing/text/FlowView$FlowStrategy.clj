(ns javax.swing.text.FlowView$FlowStrategy
  "Strategy for maintaining the physical form
  of the flow.  The default implementation is
  completely stateless, and recalculates the
  entire flow if the layout is invalid on the
  given FlowView.  Alternative strategies can
  be implemented by subclassing, and might
  perform incremental repair to the layout
  or alternative breaking behavior."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text FlowView$FlowStrategy]))

(defn ->flow-strategy
  "Constructor."
  (^FlowView$FlowStrategy []
    (new FlowView$FlowStrategy )))

(defn insert-update
  "Gives notification that something was inserted into the document
   in a location that the given flow view is responsible for.  The
   strategy should update the appropriate changed region (which
   depends upon the strategy used for repair).

  fv - `javax.swing.text.FlowView`
  e - the change information from the associated document - `javax.swing.event.DocumentEvent`
  alloc - the current allocation of the view inside of the insets. This value will be null if the view has not yet been displayed. - `java.awt.Rectangle`"
  ([^FlowView$FlowStrategy this ^javax.swing.text.FlowView fv ^javax.swing.event.DocumentEvent e ^java.awt.Rectangle alloc]
    (-> this (.insertUpdate fv e alloc))))

(defn remove-update
  "Gives notification that something was removed from the document
   in a location that the given flow view is responsible for.

  fv - `javax.swing.text.FlowView`
  e - the change information from the associated document - `javax.swing.event.DocumentEvent`
  alloc - the current allocation of the view inside of the insets. - `java.awt.Rectangle`"
  ([^FlowView$FlowStrategy this ^javax.swing.text.FlowView fv ^javax.swing.event.DocumentEvent e ^java.awt.Rectangle alloc]
    (-> this (.removeUpdate fv e alloc))))

(defn changed-update
  "Gives notification from the document that attributes were changed
   in a location that this view is responsible for.

  fv - the FlowView containing the changes - `javax.swing.text.FlowView`
  e - the DocumentEvent describing the changes done to the Document - `javax.swing.event.DocumentEvent`
  alloc - Bounds of the View - `java.awt.Rectangle`"
  ([^FlowView$FlowStrategy this ^javax.swing.text.FlowView fv ^javax.swing.event.DocumentEvent e ^java.awt.Rectangle alloc]
    (-> this (.changedUpdate fv e alloc))))

(defn layout
  "Update the flow on the given FlowView.  By default, this causes
   all of the rows (child views) to be rebuilt to match the given
   constraints for each row.  This is called by a FlowView.layout
   to update the child views in the flow.

  fv - the view to reflow - `javax.swing.text.FlowView`"
  ([^FlowView$FlowStrategy this ^javax.swing.text.FlowView fv]
    (-> this (.layout fv))))

