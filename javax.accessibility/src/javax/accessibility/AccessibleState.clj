(ns javax.accessibility.AccessibleState
  "Class AccessibleState describes a component's particular state.  The actual
  state of the component is defined as an AccessibleStateSet, which is a
  composed set of AccessibleStates.
  The toDisplayString method allows you to obtain the localized string
  for a locale independent key from a predefined ResourceBundle for the
  keys defined in this class.
  The constants in this class present a strongly typed enumeration
  of common object roles.  A public constructor for this class has been
  purposely omitted and applications should use one of the constants
  from this class.  If the constants in this class are not sufficient
  to describe the role of an object, a subclass should be generated
  from this class and it should provide constants in a similar manner."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.accessibility AccessibleState]))

(def *-active
  "Static Constant.

  Indicates a window is currently the active window.  This includes
   windows, dialogs, frames, etc.  In addition, this state is used
   to indicate the currently active child of a component such as a
   list, table, or tree.  For example, the active child of a list
   is the child that is drawn with a rectangle around it.

  type: javax.accessibility.AccessibleState"
  AccessibleState/ACTIVE)

(def *-pressed
  "Static Constant.

  Indicates this object is currently pressed.  This is usually
   associated with buttons and indicates the user has pressed a
   mouse button while the pointer was over the button and has
   not yet released the mouse button.

  type: javax.accessibility.AccessibleState"
  AccessibleState/PRESSED)

(def *-armed
  "Static Constant.

  Indicates that the object is armed.  This is usually used on buttons
   that have been pressed but not yet released, and the mouse pointer
   is still over the button.

  type: javax.accessibility.AccessibleState"
  AccessibleState/ARMED)

(def *-busy
  "Static Constant.

  Indicates the current object is busy.  This is usually used on objects
   such as progress bars, sliders, or scroll bars to indicate they are
   in a state of transition.

  type: javax.accessibility.AccessibleState"
  AccessibleState/BUSY)

(def *-checked
  "Static Constant.

  Indicates this object is currently checked.  This is usually used on
   objects such as toggle buttons, radio buttons, and check boxes.

  type: javax.accessibility.AccessibleState"
  AccessibleState/CHECKED)

(def *-editable
  "Static Constant.

  Indicates the user can change the contents of this object.  This
   is usually used primarily for objects that allow the user to
   enter text.  Other objects, such as scroll bars and sliders,
   are automatically editable if they are enabled.

  type: javax.accessibility.AccessibleState"
  AccessibleState/EDITABLE)

(def *-expandable
  "Static Constant.

  Indicates this object allows progressive disclosure of its children.
   This is usually used with hierarchical objects such as trees and
   is often paired with the EXPANDED or COLLAPSED states.

  type: javax.accessibility.AccessibleState"
  AccessibleState/EXPANDABLE)

(def *-collapsed
  "Static Constant.

  Indicates this object is collapsed.  This is usually paired with the
   EXPANDABLE state and is used on objects that provide progressive
   disclosure such as trees.

  type: javax.accessibility.AccessibleState"
  AccessibleState/COLLAPSED)

(def *-expanded
  "Static Constant.

  Indicates this object is expanded.  This is usually paired with the
   EXPANDABLE state and is used on objects that provide progressive
   disclosure such as trees.

  type: javax.accessibility.AccessibleState"
  AccessibleState/EXPANDED)

(def *-enabled
  "Static Constant.

  Indicates this object is enabled.  The absence of this state from an
   object's state set indicates this object is not enabled.  An object
   that is not enabled cannot be manipulated by the user.  In a graphical
   display, it is usually grayed out.

  type: javax.accessibility.AccessibleState"
  AccessibleState/ENABLED)

(def *-focusable
  "Static Constant.

  Indicates this object can accept keyboard focus, which means all
   events resulting from typing on the keyboard will normally be
   passed to it when it has focus.

  type: javax.accessibility.AccessibleState"
  AccessibleState/FOCUSABLE)

(def *-focused
  "Static Constant.

  Indicates this object currently has the keyboard focus.

  type: javax.accessibility.AccessibleState"
  AccessibleState/FOCUSED)

(def *-iconified
  "Static Constant.

  Indicates this object is minimized and is represented only by an
   icon.  This is usually only associated with frames and internal
   frames.

  type: javax.accessibility.AccessibleState"
  AccessibleState/ICONIFIED)

(def *-modal
  "Static Constant.

  Indicates something must be done with this object before the
   user can interact with an object in a different window.  This
   is usually associated only with dialogs.

  type: javax.accessibility.AccessibleState"
  AccessibleState/MODAL)

(def *-opaque
  "Static Constant.

  Indicates this object paints every pixel within its
   rectangular region. A non-opaque component paints only some of
   its pixels, allowing the pixels underneath it to `show through`.
   A component that does not fully paint its pixels therefore
   provides a degree of transparency.

  type: javax.accessibility.AccessibleState"
  AccessibleState/OPAQUE)

(def *-resizable
  "Static Constant.

  Indicates the size of this object is not fixed.

  type: javax.accessibility.AccessibleState"
  AccessibleState/RESIZABLE)

(def *-multiselectable
  "Static Constant.

  Indicates this object allows more than one of its children to
   be selected at the same time.

  type: javax.accessibility.AccessibleState"
  AccessibleState/MULTISELECTABLE)

(def *-selectable
  "Static Constant.

  Indicates this object is the child of an object that allows its
   children to be selected, and that this child is one of those
   children that can be selected.

  type: javax.accessibility.AccessibleState"
  AccessibleState/SELECTABLE)

(def *-selected
  "Static Constant.

  Indicates this object is the child of an object that allows its
   children to be selected, and that this child is one of those
   children that has been selected.

  type: javax.accessibility.AccessibleState"
  AccessibleState/SELECTED)

(def *-showing
  "Static Constant.

  Indicates this object, the object's parent, the object's parent's
   parent, and so on, are all visible.  Note that this does not
   necessarily mean the object is painted on the screen.  It might
   be occluded by some other showing object.

  type: javax.accessibility.AccessibleState"
  AccessibleState/SHOWING)

(def *-visible
  "Static Constant.

  Indicates this object is visible.  Note: this means that the
   object intends to be visible; however, it may not in fact be
   showing on the screen because one of the objects that this object
   is contained by is not visible.

  type: javax.accessibility.AccessibleState"
  AccessibleState/VISIBLE)

(def *-vertical
  "Static Constant.

  Indicates the orientation of this object is vertical.  This is
   usually associated with objects such as scrollbars, sliders, and
   progress bars.

  type: javax.accessibility.AccessibleState"
  AccessibleState/VERTICAL)

(def *-horizontal
  "Static Constant.

  Indicates the orientation of this object is horizontal.  This is
   usually associated with objects such as scrollbars, sliders, and
   progress bars.

  type: javax.accessibility.AccessibleState"
  AccessibleState/HORIZONTAL)

(def *-single-line
  "Static Constant.

  Indicates this (text) object can contain only a single line of text

  type: javax.accessibility.AccessibleState"
  AccessibleState/SINGLE_LINE)

(def *-multi-line
  "Static Constant.

  Indicates this (text) object can contain multiple lines of text

  type: javax.accessibility.AccessibleState"
  AccessibleState/MULTI_LINE)

(def *-transient
  "Static Constant.

  Indicates this object is transient.  An assistive technology should
   not add a PropertyChange listener to an object with transient state,
   as that object will never generate any events.  Transient objects
   are typically created to answer Java Accessibility method queries,
   but otherwise do not remain linked to the underlying object (for
   example, those objects underneath lists, tables, and trees in Swing,
   where only one actual UI Component does shared rendering duty for
   all of the data objects underneath the actual list/table/tree elements).

  type: javax.accessibility.AccessibleState"
  AccessibleState/TRANSIENT)

(def *-manages-descendants
  "Static Constant.

  Indicates this object is responsible for managing its
   subcomponents.  This is typically used for trees and tables
   that have a large number of subcomponents and where the
   objects are created only when needed and otherwise remain virtual.
   The application should not manage the subcomponents directly.

  type: javax.accessibility.AccessibleState"
  AccessibleState/MANAGES_DESCENDANTS)

(def *-indeterminate
  "Static Constant.

  Indicates that the object state is indeterminate.  An example
   is selected text that is partially bold and partially not
   bold. In this case the attributes associated with the selected
   text are indeterminate.

  type: javax.accessibility.AccessibleState"
  AccessibleState/INDETERMINATE)

(def *-truncated
  "Static Constant.

  A state indicating that text is truncated by a bounding rectangle
   and that some of the text is not displayed on the screen.  An example
   is text in a spreadsheet cell that is truncated by the bounds of
   the cell.

  type: javax.accessibility.AccessibleState"
  AccessibleState/TRUNCATED)

