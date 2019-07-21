(ns javax.swing.plaf.synth.Region
  "A distinct rendering area of a Swing component.  A component may
  support one or more regions.  Specific component regions are defined
  by the typesafe enumeration in this class.

  Regions are typically used as a way to identify the Components
  and areas a particular style is to apply to. Synth's file format allows you
  to bind styles based on the name of a Region.
  The name is derived from the field name of the constant:

   Map all characters to lowercase.
   Map the first character to uppercase.
   Map the first character after underscores to uppercase.
   Remove all underscores.

  For example, to identify the SPLIT_PANE
  Region you would use SplitPane.
  The following shows a custom SynthStyleFactory
  that returns a specific style for split panes:


     public SynthStyle getStyle(JComponent c, Region id) {
         if (id == Region.SPLIT_PANE) {
             return splitPaneStyle;
         }
         ...
     }
  The following xml
  accomplishes the same thing:


  <style id=\"splitPaneStyle\">
    ...
  </style>
  <bind style=\"splitPaneStyle\" type=\"region\" key=\"SplitPane\"/>"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.synth Region]))

(def *-arrow-button
  "Static Constant.

  ArrowButton's are special types of buttons that also render a
   directional indicator, typically an arrow. ArrowButtons are used by
   composite components, for example ScrollBar's contain ArrowButtons.
   To bind a style to this Region use the name
   ArrowButton.

  type: javax.swing.plaf.synth.Region"
  Region/ARROW_BUTTON)

(def *-button
  "Static Constant.

  Button region. To bind a style to this Region use the name
   Button.

  type: javax.swing.plaf.synth.Region"
  Region/BUTTON)

(def *-check-box
  "Static Constant.

  CheckBox region. To bind a style to this Region use the name
   CheckBox.

  type: javax.swing.plaf.synth.Region"
  Region/CHECK_BOX)

(def *-check-box-menu-item
  "Static Constant.

  CheckBoxMenuItem region. To bind a style to this Region use
   the name CheckBoxMenuItem.

  type: javax.swing.plaf.synth.Region"
  Region/CHECK_BOX_MENU_ITEM)

(def *-color-chooser
  "Static Constant.

  ColorChooser region. To bind a style to this Region use
   the name ColorChooser.

  type: javax.swing.plaf.synth.Region"
  Region/COLOR_CHOOSER)

(def *-combo-box
  "Static Constant.

  ComboBox region. To bind a style to this Region use
   the name ComboBox.

  type: javax.swing.plaf.synth.Region"
  Region/COMBO_BOX)

(def *-desktop-pane
  "Static Constant.

  DesktopPane region. To bind a style to this Region use
   the name DesktopPane.

  type: javax.swing.plaf.synth.Region"
  Region/DESKTOP_PANE)

(def *-desktop-icon
  "Static Constant.

  DesktopIcon region. To bind a style to this Region use
   the name DesktopIcon.

  type: javax.swing.plaf.synth.Region"
  Region/DESKTOP_ICON)

(def *-editor-pane
  "Static Constant.

  EditorPane region. To bind a style to this Region use
   the name EditorPane.

  type: javax.swing.plaf.synth.Region"
  Region/EDITOR_PANE)

(def *-file-chooser
  "Static Constant.

  FileChooser region. To bind a style to this Region use
   the name FileChooser.

  type: javax.swing.plaf.synth.Region"
  Region/FILE_CHOOSER)

(def *-formatted-text-field
  "Static Constant.

  FormattedTextField region. To bind a style to this Region use
   the name FormattedTextField.

  type: javax.swing.plaf.synth.Region"
  Region/FORMATTED_TEXT_FIELD)

(def *-internal-frame
  "Static Constant.

  InternalFrame region. To bind a style to this Region use
   the name InternalFrame.

  type: javax.swing.plaf.synth.Region"
  Region/INTERNAL_FRAME)

(def *-internal-frame-title-pane
  "Static Constant.

  TitlePane of an InternalFrame. The TitlePane typically
   shows a menu, title, widgets to manipulate the internal frame.
   To bind a style to this Region use the name
   InternalFrameTitlePane.

  type: javax.swing.plaf.synth.Region"
  Region/INTERNAL_FRAME_TITLE_PANE)

(def *-label
  "Static Constant.

  Label region. To bind a style to this Region use the name
   Label.

  type: javax.swing.plaf.synth.Region"
  Region/LABEL)

(def *-list
  "Static Constant.

  List region. To bind a style to this Region use the name
   List.

  type: javax.swing.plaf.synth.Region"
  Region/LIST)

(def *-menu
  "Static Constant.

  Menu region. To bind a style to this Region use the name
   Menu.

  type: javax.swing.plaf.synth.Region"
  Region/MENU)

(def *-menu-bar
  "Static Constant.

  MenuBar region. To bind a style to this Region use the name
   MenuBar.

  type: javax.swing.plaf.synth.Region"
  Region/MENU_BAR)

(def *-menu-item
  "Static Constant.

  MenuItem region. To bind a style to this Region use the name
   MenuItem.

  type: javax.swing.plaf.synth.Region"
  Region/MENU_ITEM)

(def *-menu-item-accelerator
  "Static Constant.

  Accelerator region of a MenuItem. To bind a style to this
   Region use the name MenuItemAccelerator.

  type: javax.swing.plaf.synth.Region"
  Region/MENU_ITEM_ACCELERATOR)

(def *-option-pane
  "Static Constant.

  OptionPane region. To bind a style to this Region use
   the name OptionPane.

  type: javax.swing.plaf.synth.Region"
  Region/OPTION_PANE)

(def *-panel
  "Static Constant.

  Panel region. To bind a style to this Region use the name
   Panel.

  type: javax.swing.plaf.synth.Region"
  Region/PANEL)

(def *-password-field
  "Static Constant.

  PasswordField region. To bind a style to this Region use
   the name PasswordField.

  type: javax.swing.plaf.synth.Region"
  Region/PASSWORD_FIELD)

(def *-popup-menu
  "Static Constant.

  PopupMenu region. To bind a style to this Region use
   the name PopupMenu.

  type: javax.swing.plaf.synth.Region"
  Region/POPUP_MENU)

(def *-popup-menu-separator
  "Static Constant.

  PopupMenuSeparator region. To bind a style to this Region
   use the name PopupMenuSeparator.

  type: javax.swing.plaf.synth.Region"
  Region/POPUP_MENU_SEPARATOR)

(def *-progress-bar
  "Static Constant.

  ProgressBar region. To bind a style to this Region
   use the name ProgressBar.

  type: javax.swing.plaf.synth.Region"
  Region/PROGRESS_BAR)

(def *-radio-button
  "Static Constant.

  RadioButton region. To bind a style to this Region
   use the name RadioButton.

  type: javax.swing.plaf.synth.Region"
  Region/RADIO_BUTTON)

(def *-radio-button-menu-item
  "Static Constant.

  RegionButtonMenuItem region. To bind a style to this Region
   use the name RadioButtonMenuItem.

  type: javax.swing.plaf.synth.Region"
  Region/RADIO_BUTTON_MENU_ITEM)

(def *-root-pane
  "Static Constant.

  RootPane region. To bind a style to this Region use
   the name RootPane.

  type: javax.swing.plaf.synth.Region"
  Region/ROOT_PANE)

(def *-scroll-bar
  "Static Constant.

  ScrollBar region. To bind a style to this Region use
   the name ScrollBar.

  type: javax.swing.plaf.synth.Region"
  Region/SCROLL_BAR)

(def *-scroll-bar-track
  "Static Constant.

  Track of the ScrollBar. To bind a style to this Region use
   the name ScrollBarTrack.

  type: javax.swing.plaf.synth.Region"
  Region/SCROLL_BAR_TRACK)

(def *-scroll-bar-thumb
  "Static Constant.

  Thumb of the ScrollBar. The thumb is the region of the ScrollBar
   that gives a graphical depiction of what percentage of the View is
   currently visible. To bind a style to this Region use
   the name ScrollBarThumb.

  type: javax.swing.plaf.synth.Region"
  Region/SCROLL_BAR_THUMB)

(def *-scroll-pane
  "Static Constant.

  ScrollPane region. To bind a style to this Region use
   the name ScrollPane.

  type: javax.swing.plaf.synth.Region"
  Region/SCROLL_PANE)

(def *-separator
  "Static Constant.

  Separator region. To bind a style to this Region use
   the name Separator.

  type: javax.swing.plaf.synth.Region"
  Region/SEPARATOR)

(def *-slider
  "Static Constant.

  Slider region. To bind a style to this Region use
   the name Slider.

  type: javax.swing.plaf.synth.Region"
  Region/SLIDER)

(def *-slider-track
  "Static Constant.

  Track of the Slider. To bind a style to this Region use
   the name SliderTrack.

  type: javax.swing.plaf.synth.Region"
  Region/SLIDER_TRACK)

(def *-slider-thumb
  "Static Constant.

  Thumb of the Slider. The thumb of the Slider identifies the current
   value. To bind a style to this Region use the name
   SliderThumb.

  type: javax.swing.plaf.synth.Region"
  Region/SLIDER_THUMB)

(def *-spinner
  "Static Constant.

  Spinner region. To bind a style to this Region use the name
   Spinner.

  type: javax.swing.plaf.synth.Region"
  Region/SPINNER)

(def *-split-pane
  "Static Constant.

  SplitPane region. To bind a style to this Region use the name
   SplitPane.

  type: javax.swing.plaf.synth.Region"
  Region/SPLIT_PANE)

(def *-split-pane-divider
  "Static Constant.

  Divider of the SplitPane. To bind a style to this Region
   use the name SplitPaneDivider.

  type: javax.swing.plaf.synth.Region"
  Region/SPLIT_PANE_DIVIDER)

(def *-tabbed-pane
  "Static Constant.

  TabbedPane region. To bind a style to this Region use
   the name TabbedPane.

  type: javax.swing.plaf.synth.Region"
  Region/TABBED_PANE)

(def *-tabbed-pane-tab
  "Static Constant.

  Region of a TabbedPane for one tab. To bind a style to this
   Region use the name TabbedPaneTab.

  type: javax.swing.plaf.synth.Region"
  Region/TABBED_PANE_TAB)

(def *-tabbed-pane-tab-area
  "Static Constant.

  Region of a TabbedPane containing the tabs. To bind a style to this
   Region use the name TabbedPaneTabArea.

  type: javax.swing.plaf.synth.Region"
  Region/TABBED_PANE_TAB_AREA)

(def *-tabbed-pane-content
  "Static Constant.

  Region of a TabbedPane containing the content. To bind a style to this
   Region use the name TabbedPaneContent.

  type: javax.swing.plaf.synth.Region"
  Region/TABBED_PANE_CONTENT)

(def *-table
  "Static Constant.

  Table region. To bind a style to this Region use
   the name Table.

  type: javax.swing.plaf.synth.Region"
  Region/TABLE)

(def *-table-header
  "Static Constant.

  TableHeader region. To bind a style to this Region use
   the name TableHeader.

  type: javax.swing.plaf.synth.Region"
  Region/TABLE_HEADER)

(def *-text-area
  "Static Constant.

  TextArea region. To bind a style to this Region use
   the name TextArea.

  type: javax.swing.plaf.synth.Region"
  Region/TEXT_AREA)

(def *-text-field
  "Static Constant.

  TextField region. To bind a style to this Region use
   the name TextField.

  type: javax.swing.plaf.synth.Region"
  Region/TEXT_FIELD)

(def *-text-pane
  "Static Constant.

  TextPane region. To bind a style to this Region use
   the name TextPane.

  type: javax.swing.plaf.synth.Region"
  Region/TEXT_PANE)

(def *-toggle-button
  "Static Constant.

  ToggleButton region. To bind a style to this Region use
   the name ToggleButton.

  type: javax.swing.plaf.synth.Region"
  Region/TOGGLE_BUTTON)

(def *-tool-bar
  "Static Constant.

  ToolBar region. To bind a style to this Region use
   the name ToolBar.

  type: javax.swing.plaf.synth.Region"
  Region/TOOL_BAR)

(def *-tool-bar-content
  "Static Constant.

  Region of the ToolBar containing the content. To bind a style to this
   Region use the name ToolBarContent.

  type: javax.swing.plaf.synth.Region"
  Region/TOOL_BAR_CONTENT)

(def *-tool-bar-drag-window
  "Static Constant.

  Region for the Window containing the ToolBar. To bind a style to this
   Region use the name ToolBarDragWindow.

  type: javax.swing.plaf.synth.Region"
  Region/TOOL_BAR_DRAG_WINDOW)

(def *-tool-tip
  "Static Constant.

  ToolTip region. To bind a style to this Region use
   the name ToolTip.

  type: javax.swing.plaf.synth.Region"
  Region/TOOL_TIP)

(def *-tool-bar-separator
  "Static Constant.

  ToolBar separator region. To bind a style to this Region use
   the name ToolBarSeparator.

  type: javax.swing.plaf.synth.Region"
  Region/TOOL_BAR_SEPARATOR)

(def *-tree
  "Static Constant.

  Tree region. To bind a style to this Region use the name
   Tree.

  type: javax.swing.plaf.synth.Region"
  Region/TREE)

(def *-tree-cell
  "Static Constant.

  Region of the Tree for one cell. To bind a style to this
   Region use the name TreeCell.

  type: javax.swing.plaf.synth.Region"
  Region/TREE_CELL)

(def *-viewport
  "Static Constant.

  Viewport region. To bind a style to this Region use
   the name Viewport.

  type: javax.swing.plaf.synth.Region"
  Region/VIEWPORT)

(defn subregion?
  "Returns true if the Region is a subregion of a Component, otherwise
   false. For example, Region.BUTTON corresponds do a
   Component so that Region.BUTTON.isSubregion()
   returns false.

  returns: true if the Region is a subregion of a Component. - `boolean`"
  (^Boolean [^Region this]
    (-> this (.isSubregion))))

(defn get-name
  "Returns the name of the region.

  returns: name of the Region. - `java.lang.String`"
  (^java.lang.String [^Region this]
    (-> this (.getName))))

(defn to-string
  "Returns the name of the Region.

  returns: name of the Region. - `java.lang.String`"
  (^java.lang.String [^Region this]
    (-> this (.toString))))

