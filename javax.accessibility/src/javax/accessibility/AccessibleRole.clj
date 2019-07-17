(ns javax.accessibility.AccessibleRole
  "Class AccessibleRole determines the role of a component.  The role of a
  component describes its generic function. (E.G.,
  `push button,` `table,` or `list.`)
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
  (:import [javax.accessibility AccessibleRole]))

(def *-alert
  "Static Constant.

  Object is used to alert the user about something.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/ALERT)

(def *-column-header
  "Static Constant.

  The header for a column of data.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/COLUMN_HEADER)

(def *-canvas
  "Static Constant.

  Object that can be drawn into and is used to trap
   events.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/CANVAS)

(def *-combo-box
  "Static Constant.

  A list of choices the user can select from.  Also optionally
   allows the user to enter a choice of their own.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/COMBO_BOX)

(def *-desktop-icon
  "Static Constant.

  An iconified internal frame in a DESKTOP_PANE.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/DESKTOP_ICON)

(def *-html-container
  "Static Constant.

  An object containing a collection of Accessibles that
   together represents HTML content.  The child
   Accessibles would include objects implementing
   AccessibleText, AccessibleHypertext,
   AccessibleIcon, and other interfaces.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/HTML_CONTAINER)

(def *-internal-frame
  "Static Constant.

  A frame-like object that is clipped by a desktop pane.  The
   desktop pane, internal frame, and desktop icon objects are
   often used to create multiple document interfaces within an
   application.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/INTERNAL_FRAME)

(def *-desktop-pane
  "Static Constant.

  A pane that supports internal frames and
   iconified versions of those internal frames.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/DESKTOP_PANE)

(def *-option-pane
  "Static Constant.

  A specialized pane whose primary use is inside a DIALOG

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/OPTION_PANE)

(def *-window
  "Static Constant.

  A top level window with no title or border.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/WINDOW)

(def *-frame
  "Static Constant.

  A top level window with a title bar, border, menu bar, etc.  It is
   often used as the primary window for an application.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/FRAME)

(def *-dialog
  "Static Constant.

  A top level window with title bar and a border.  A dialog is similar
   to a frame, but it has fewer properties and is often used as a
   secondary window for an application.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/DIALOG)

(def *-color-chooser
  "Static Constant.

  A specialized pane that lets the user choose a color.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/COLOR_CHOOSER)

(def *-directory-pane
  "Static Constant.

  A pane that allows the user to navigate through
   and select the contents of a directory.  May be used
   by a file chooser.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/DIRECTORY_PANE)

(def *-file-chooser
  "Static Constant.

  A specialized dialog that displays the files in the directory
   and lets the user select a file, browse a different directory,
   or specify a filename.  May use the directory pane to show the
   contents of a directory.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/FILE_CHOOSER)

(def *-filler
  "Static Constant.

  An object that fills up space in a user interface.  It is often
   used in interfaces to tweak the spacing between components,
   but serves no other purpose.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/FILLER)

(def *-hyperlink
  "Static Constant.

  A hypertext anchor

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/HYPERLINK)

(def *-icon
  "Static Constant.

  A small fixed size picture, typically used to decorate components.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/ICON)

(def *-label
  "Static Constant.

  An object used to present an icon or short string in an interface.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/LABEL)

(def *-root-pane
  "Static Constant.

  A specialized pane that has a glass pane and a layered pane as its
   children.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/ROOT_PANE)

(def *-glass-pane
  "Static Constant.

  A pane that is guaranteed to be painted on top
   of all panes beneath it.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/GLASS_PANE)

(def *-layered-pane
  "Static Constant.

  A specialized pane that allows its children to be drawn in layers,
   providing a form of stacking order.  This is usually the pane that
   holds the menu bar as well as the pane that contains most of the
   visual components in a window.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/LAYERED_PANE)

(def *-list
  "Static Constant.

  An object that presents a list of objects to the user and allows the
   user to select one or more of them.  A list is usually contained
   within a scroll pane.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/LIST)

(def *-list-item
  "Static Constant.

  An object that presents an element in a list.  A list is usually
   contained within a scroll pane.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/LIST_ITEM)

(def *-menu-bar
  "Static Constant.

  An object usually drawn at the top of the primary dialog box of
   an application that contains a list of menus the user can choose
   from.  For example, a menu bar might contain menus for `File,`
   `Edit,` and `Help.`

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/MENU_BAR)

(def *-popup-menu
  "Static Constant.

  A temporary window that is usually used to offer the user a
   list of choices, and then hides when the user selects one of
   those choices.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/POPUP_MENU)

(def *-menu
  "Static Constant.

  An object usually found inside a menu bar that contains a list
   of actions the user can choose from.  A menu can have any object
   as its children, but most often they are menu items, other menus,
   or rudimentary objects such as radio buttons, check boxes, or
   separators.  For example, an application may have an `Edit` menu
   that contains menu items for `Cut` and `Paste.`

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/MENU)

(def *-menu-item
  "Static Constant.

  An object usually contained in a menu that presents an action
   the user can choose.  For example, the `Cut` menu item in an
   `Edit` menu would be an action the user can select to cut the
   selected area of text in a document.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/MENU_ITEM)

(def *-separator
  "Static Constant.

  An object usually contained in a menu to provide a visual
   and logical separation of the contents in a menu.  For example,
   the `File` menu of an application might contain menu items for
   `Open,` `Close,` and `Exit,` and will place a separator between
   `Close` and `Exit` menu items.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/SEPARATOR)

(def *-page-tab-list
  "Static Constant.

  An object that presents a series of panels (or page tabs), one at a
   time, through some mechanism provided by the object.  The most common
   mechanism is a list of tabs at the top of the panel.  The children of
   a page tab list are all page tabs.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/PAGE_TAB_LIST)

(def *-page-tab
  "Static Constant.

  An object that is a child of a page tab list.  Its sole child is
   the panel that is to be presented to the user when the user
   selects the page tab from the list of tabs in the page tab list.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/PAGE_TAB)

(def *-panel
  "Static Constant.

  A generic container that is often used to group objects.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/PANEL)

(def *-progress-bar
  "Static Constant.

  An object used to indicate how much of a task has been completed.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/PROGRESS_BAR)

(def *-password-text
  "Static Constant.

  A text object used for passwords, or other places where the
   text contents is not shown visibly to the user

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/PASSWORD_TEXT)

(def *-push-button
  "Static Constant.

  An object the user can manipulate to tell the application to do
   something.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/PUSH_BUTTON)

(def *-toggle-button
  "Static Constant.

  A specialized push button that can be checked or unchecked, but
   does not provide a separate indicator for the current state.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/TOGGLE_BUTTON)

(def *-check-box
  "Static Constant.

  A choice that can be checked or unchecked and provides a
   separate indicator for the current state.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/CHECK_BOX)

(def *-radio-button
  "Static Constant.

  A specialized check box that will cause other radio buttons in the
   same group to become unchecked when this one is checked.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/RADIO_BUTTON)

(def *-row-header
  "Static Constant.

  The header for a row of data.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/ROW_HEADER)

(def *-scroll-pane
  "Static Constant.

  An object that allows a user to incrementally view a large amount
   of information.  Its children can include scroll bars and a viewport.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/SCROLL_PANE)

(def *-scroll-bar
  "Static Constant.

  An object usually used to allow a user to incrementally view a
   large amount of data.  Usually used only by a scroll pane.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/SCROLL_BAR)

(def *-viewport
  "Static Constant.

  An object usually used in a scroll pane.  It represents the portion
   of the entire data that the user can see.  As the user manipulates
   the scroll bars, the contents of the viewport can change.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/VIEWPORT)

(def *-slider
  "Static Constant.

  An object that allows the user to select from a bounded range.  For
   example, a slider might be used to select a number between 0 and 100.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/SLIDER)

(def *-split-pane
  "Static Constant.

  A specialized panel that presents two other panels at the same time.
   Between the two panels is a divider the user can manipulate to make
   one panel larger and the other panel smaller.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/SPLIT_PANE)

(def *-table
  "Static Constant.

  An object used to present information in terms of rows and columns.
   An example might include a spreadsheet application.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/TABLE)

(def *-text
  "Static Constant.

  An object that presents text to the user.  The text is usually
   editable by the user as opposed to a label.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/TEXT)

(def *-tree
  "Static Constant.

  An object used to present hierarchical information to the user.
   The individual nodes in the tree can be collapsed and expanded
   to provide selective disclosure of the tree's contents.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/TREE)

(def *-tool-bar
  "Static Constant.

  A bar or palette usually composed of push buttons or toggle buttons.
   It is often used to provide the most frequently used functions for an
   application.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/TOOL_BAR)

(def *-tool-tip
  "Static Constant.

  An object that provides information about another object.  The
   accessibleDescription property of the tool tip is often displayed
   to the user in a small `help bubble` when the user causes the
   mouse to hover over the object associated with the tool tip.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/TOOL_TIP)

(def *-awt-component
  "Static Constant.

  An AWT component, but nothing else is known about it.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/AWT_COMPONENT)

(def *-swing-component
  "Static Constant.

  A Swing component, but nothing else is known about it.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/SWING_COMPONENT)

(def *-unknown
  "Static Constant.

  The object contains some Accessible information, but its role is
   not known.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/UNKNOWN)

(def *-status-bar
  "Static Constant.

  A STATUS_BAR is an simple component that can contain
   multiple labels of status information to the user.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/STATUS_BAR)

(def *-date-editor
  "Static Constant.

  A DATE_EDITOR is a component that allows users to edit
   java.util.Date and java.util.Time objects

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/DATE_EDITOR)

(def *-spin-box
  "Static Constant.

  A SPIN_BOX is a simple spinner component and its main use
   is for simple numbers.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/SPIN_BOX)

(def *-font-chooser
  "Static Constant.

  A FONT_CHOOSER is a component that lets the user pick various
   attributes for fonts.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/FONT_CHOOSER)

(def *-group-box
  "Static Constant.

  A GROUP_BOX is a simple container that contains a border
   around it and contains components inside it.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/GROUP_BOX)

(def *-header
  "Static Constant.

  A text header

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/HEADER)

(def *-footer
  "Static Constant.

  A text footer

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/FOOTER)

(def *-paragraph
  "Static Constant.

  A text paragraph

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/PARAGRAPH)

(def *-ruler
  "Static Constant.

  A ruler is an object used to measure distance

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/RULER)

(def *-editbar
  "Static Constant.

  A role indicating the object acts as a formula for
   calculating a value.  An example is a formula in
   a spreadsheet cell.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/EDITBAR)

(def *-progress-monitor
  "Static Constant.

  A role indicating the object monitors the progress
   of some operation.

  type: javax.accessibility.AccessibleRole"
  AccessibleRole/PROGRESS_MONITOR)

