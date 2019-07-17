(ns javax.swing.JTabbedPane
  "A component that lets the user switch between a group of components by
  clicking on a tab with a given title and/or icon.
  For examples and information on using tabbed panes see
  How to Use Tabbed Panes,
  a section in The Java Tutorial.

  Tabs/components are added to a TabbedPane object by using the
  addTab and insertTab methods.
  A tab is represented by an index corresponding
  to the position it was added in, where the first tab has an index equal to 0
  and the last tab has an index equal to the tab count minus 1.

  The TabbedPane uses a SingleSelectionModel
  to represent the set
  of tab indices and the currently selected index.  If the tab count
  is greater than 0, then there will always be a selected index, which
  by default will be initialized to the first tab.  If the tab count is
  0, then the selected index will be -1.

  The tab title can be rendered by a Component.
  For example, the following produce similar results:


  // In this case the look and feel renders the title for the tab.
  tabbedPane.addTab(`Tab`, myComponent);
  // In this case the custom component is responsible for rendering the
  // title of the tab.
  tabbedPane.addTab(null, myComponent);
  tabbedPane.setTabComponentAt(0, new JLabel(`Tab`));
  The latter is typically used when you want a more complex user interaction
  that requires custom components on the tab.  For example, you could
  provide a custom component that animates or one that has widgets for
  closing the tab.

  If you specify a component for a tab, the JTabbedPane
  will not render any text or icon you have specified for the tab.

  Note:
  Do not use setVisible directly on a tab component to make it visible,
  use setSelectedComponent or setSelectedIndex methods instead.

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
  (:import [javax.swing JTabbedPane]))

(defn ->j-tabbed-pane
  "Constructor.

  Creates an empty TabbedPane with the specified tab placement
   and tab layout policy.  Tab placement may be either:
   JTabbedPane.TOP, JTabbedPane.BOTTOM,
   JTabbedPane.LEFT, or JTabbedPane.RIGHT.
   Tab layout policy may be either: JTabbedPane.WRAP_TAB_LAYOUT
   or JTabbedPane.SCROLL_TAB_LAYOUT.

  tab-placement - the placement for the tabs relative to the content - `int`
  tab-layout-policy - the policy for laying out tabs when all tabs will not fit on one run - `int`

  throws: java.lang.IllegalArgumentException - if tab placement or tab layout policy are not one of the above supported values"
  ([tab-placement tab-layout-policy]
    (new JTabbedPane tab-placement tab-layout-policy))
  ([tab-placement]
    (new JTabbedPane tab-placement))
  ([]
    (new JTabbedPane )))

(def *-wrap-tab-layout
  "Static Constant.

  The tab layout policy for wrapping tabs in multiple runs when all
   tabs will not fit within a single run.

  type: int"
  JTabbedPane/WRAP_TAB_LAYOUT)

(def *-scroll-tab-layout
  "Static Constant.

  Tab layout policy for providing a subset of available tabs when all
   the tabs will not fit within a single run.  If all the tabs do
   not fit within a single run the look and feel will provide a way
   to navigate to hidden tabs.

  type: int"
  JTabbedPane/SCROLL_TAB_LAYOUT)

(defn set-displayed-mnemonic-index-at
  "Provides a hint to the look and feel as to which character in the
   text should be decorated to represent the mnemonic. Not all look and
   feels may support this. A value of -1 indicates either there is
   no mnemonic for this tab, or you do not wish the mnemonic to be
   displayed for this tab.

   The value of this is updated as the properties relating to the
   mnemonic change (such as the mnemonic itself, the text...).
   You should only ever have to call this if
   you do not wish the default character to be underlined. For example, if
   the text at tab index 3 was 'Apple Price', with a mnemonic of 'p',
   and you wanted the 'P'
   to be decorated, as 'Apple Price', you would have to invoke
   setDisplayedMnemonicIndex(3, 6) after invoking
   setMnemonicAt(3, KeyEvent.VK_P).
   Note that it is the programmer's responsibility to ensure
   that each tab has a unique mnemonic or unpredictable results may
   occur.

  tab-index - the index of the tab that the mnemonic refers to - `int`
  mnemonic-index - index into the String to underline - `int`

  throws: java.lang.IndexOutOfBoundsException - if tabIndex is out of range (tabIndex < 0 || tabIndex >= tab count)"
  ([this tab-index mnemonic-index]
    (-> this (.setDisplayedMnemonicIndexAt tab-index mnemonic-index))))

(defn add-change-listener
  "Adds a ChangeListener to this tabbedpane.

  l - the ChangeListener to add - `javax.swing.event.ChangeListener`"
  ([this l]
    (-> this (.addChangeListener l))))

(defn get-tab-count
  "Returns the number of tabs in this tabbedpane.

  returns: an integer specifying the number of tabbed pages - `int`"
  ([this]
    (-> this (.getTabCount))))

(defn set-mnemonic-at
  "Sets the keyboard mnemonic for accessing the specified tab.
   The mnemonic is the key which when combined with the look and feel's
   mouseless modifier (usually Alt) will activate the specified
   tab.

   A mnemonic must correspond to a single key on the keyboard
   and should be specified using one of the VK_XXX
   keycodes defined in java.awt.event.KeyEvent
   or one of the extended keycodes obtained through
   java.awt.event.KeyEvent.getExtendedKeyCodeForChar.
   Mnemonics are case-insensitive, therefore a key event
   with the corresponding keycode would cause the button to be
   activated whether or not the Shift modifier was pressed.

   This will update the displayed mnemonic property for the specified
   tab.

  tab-index - the index of the tab that the mnemonic refers to - `int`
  mnemonic - the key code which represents the mnemonic - `int`

  throws: java.lang.IndexOutOfBoundsException - if tabIndex is out of range (tabIndex < 0 || tabIndex >= tab count)"
  ([this tab-index mnemonic]
    (-> this (.setMnemonicAt tab-index mnemonic))))

(defn set-selected-component
  "Sets the selected component for this tabbedpane.  This
   will automatically set the selectedIndex to the index
   corresponding to the specified component.

  c - `java.awt.Component`

  throws: java.lang.IllegalArgumentException - if component not found in tabbed pane"
  ([this c]
    (-> this (.setSelectedComponent c))))

(defn set-tab-layout-policy
  "Sets the policy which the tabbedpane will use in laying out the tabs
   when all the tabs will not fit within a single run.
   Possible values are:

   JTabbedPane.WRAP_TAB_LAYOUT
   JTabbedPane.SCROLL_TAB_LAYOUT


   The default value, if not set by the UI, is JTabbedPane.WRAP_TAB_LAYOUT.

   Some look and feels might only support a subset of the possible
   layout policies, in which case the value of this property may be
   ignored.

  tab-layout-policy - the policy used to layout the tabs - `int`

  throws: java.lang.IllegalArgumentException - if layoutPolicy value isn't one of the above valid values"
  ([this tab-layout-policy]
    (-> this (.setTabLayoutPolicy tab-layout-policy))))

(defn get-tab-component-at
  "Returns the tab component at index.

  index - the index of the item being queried - `int`

  returns: the tab component at index - `java.awt.Component`

  throws: java.lang.IndexOutOfBoundsException - if index is out of range (index < 0 || index >= tab count)"
  ([this index]
    (-> this (.getTabComponentAt index))))

(defn remove-tab-at
  "Removes the tab at index.
   After the component associated with index is removed,
   its visibility is reset to true to ensure it will be visible
   if added to other containers.

  index - the index of the tab to be removed - `int`

  throws: java.lang.IndexOutOfBoundsException - if index is out of range (index < 0 || index >= tab count)"
  ([this index]
    (-> this (.removeTabAt index))))

(defn set-foreground-at
  "Sets the foreground color at index to
   foreground which can be
   null, in which case the tab's foreground color
   will default to the foreground color of this tabbedpane.
   An internal exception is raised if there is no tab at that index.

   It is up to the look and feel to honor this property, some may
   choose to ignore it.

  index - the tab index where the foreground should be set - `int`
  foreground - the color to be displayed as the tab's foreground - `java.awt.Color`

  throws: java.lang.IndexOutOfBoundsException - if index is out of range (index < 0 || index >= tab count)"
  ([this index foreground]
    (-> this (.setForegroundAt index foreground))))

(defn set-tab-placement
  "Sets the tab placement for this tabbedpane.
   Possible values are:
   JTabbedPane.TOP
   JTabbedPane.BOTTOM
   JTabbedPane.LEFT
   JTabbedPane.RIGHT

   The default value, if not set, is SwingConstants.TOP.

  tab-placement - the placement for the tabs relative to the content - `int`

  throws: java.lang.IllegalArgumentException - if tab placement value isn't one of the above valid values"
  ([this tab-placement]
    (-> this (.setTabPlacement tab-placement))))

(defn get-tab-run-count
  "Returns the number of tab runs currently used to display
   the tabs.

  returns: an integer giving the number of rows if the
            tabPlacement
            is TOP or BOTTOM
            and the number of columns if
            tabPlacement
            is LEFT or RIGHT,
            or 0 if there is no UI set on this tabbedpane - `int`"
  ([this]
    (-> this (.getTabRunCount))))

(defn index-of-tab
  "Returns the first tab index with a given title,  or
   -1 if no tab has this title.

  title - the title for the tab - `java.lang.String`

  returns: the first tab index which matches title, or
            -1 if no tab has this title - `int`"
  ([this title]
    (-> this (.indexOfTab title))))

(defn get-bounds-at
  "Returns the tab bounds at index.  If the tab at
   this index is not currently visible in the UI, then returns
   null.
   If there is no UI set on this tabbedpane,
   then returns null.

  index - the index to be queried - `int`

  returns: a Rectangle containing the tab bounds at
            index, or null if tab at
            index is not currently visible in the UI,
            or if there is no UI set on this tabbedpane - `java.awt.Rectangle`

  throws: java.lang.IndexOutOfBoundsException - if index is out of range (index < 0 || index >= tab count)"
  ([this index]
    (-> this (.getBoundsAt index))))

(defn get-background-at
  "Returns the tab background color at index.

  index - the index of the item being queried - `int`

  returns: the Color of the tab background at
            index - `java.awt.Color`

  throws: java.lang.IndexOutOfBoundsException - if index is out of range (index < 0 || index >= tab count)"
  ([this index]
    (-> this (.getBackgroundAt index))))

(defn enabled-at?
  "Returns whether or not the tab at index is
   currently enabled.

  index - the index of the item being queried - `int`

  returns: true if the tab at index is enabled;
            false otherwise - `boolean`

  throws: java.lang.IndexOutOfBoundsException - if index is out of range (index < 0 || index >= tab count)"
  ([this index]
    (-> this (.isEnabledAt index))))

(defn index-at-location
  "Returns the tab index corresponding to the tab whose bounds
   intersect the specified location.  Returns -1 if no tab
   intersects the location.

  x - the x location relative to this tabbedpane - `int`
  y - the y location relative to this tabbedpane - `int`

  returns: the tab index which intersects the location, or
           -1 if no tab intersects the location - `int`"
  ([this x y]
    (-> this (.indexAtLocation x y))))

(defn set-tool-tip-text-at
  "Sets the tooltip text at index to toolTipText
   which can be null.
   An internal exception is raised if there is no tab at that index.

  index - the tab index where the tooltip text should be set - `int`
  tool-tip-text - the tooltip text to be displayed for the tab - `java.lang.String`

  throws: java.lang.IndexOutOfBoundsException - if index is out of range (index < 0 || index >= tab count)"
  ([this index tool-tip-text]
    (-> this (.setToolTipTextAt index tool-tip-text))))

(defn get-ui-class-id
  "Returns the name of the UI class that implements the
   L&F for this component.

  returns: the string `TabbedPaneUI` - `java.lang.String`"
  ([this]
    (-> this (.getUIClassID))))

(defn get-selected-index
  "Returns the currently selected index for this tabbedpane.
   Returns -1 if there is no currently selected tab.

  returns: the index of the selected tab - `int`"
  ([this]
    (-> this (.getSelectedIndex))))

(defn set-tab-component-at
  "Sets the component that is responsible for rendering the
   title for the specified tab.  A null value means
   JTabbedPane will render the title and/or icon for
   the specified tab.  A non-null value means the component will
   render the title and JTabbedPane will not render
   the title and/or icon.

   Note: The component must not be one that the developer has
         already added to the tabbed pane.

  index - the tab index where the component should be set - `int`
  component - the component to render the title for the specified tab - `java.awt.Component`

  throws: java.lang.IndexOutOfBoundsException - if index is out of range (index < 0 || index >= tab count)"
  ([this index component]
    (-> this (.setTabComponentAt index component))))

(defn set-disabled-icon-at
  "Sets the disabled icon at index to icon
   which can be null.
   An internal exception is raised if there is no tab at that index.

  index - the tab index where the disabled icon should be set - `int`
  disabled-icon - the icon to be displayed in the tab when disabled - `javax.swing.Icon`

  throws: java.lang.IndexOutOfBoundsException - if index is out of range (index < 0 || index >= tab count)"
  ([this index disabled-icon]
    (-> this (.setDisabledIconAt index disabled-icon))))

(defn remove-change-listener
  "Removes a ChangeListener from this tabbedpane.

  l - the ChangeListener to remove - `javax.swing.event.ChangeListener`"
  ([this l]
    (-> this (.removeChangeListener l))))

(defn get-change-listeners
  "Returns an array of all the ChangeListeners added
   to this JTabbedPane with addChangeListener.

  returns: all of the ChangeListeners added or an empty
           array if no listeners have been added - `javax.swing.event.ChangeListener[]`"
  ([this]
    (-> this (.getChangeListeners))))

(defn get-tool-tip-text-at
  "Returns the tab tooltip text at index.

  index - the index of the item being queried - `int`

  returns: a string containing the tool tip text at index - `java.lang.String`

  throws: java.lang.IndexOutOfBoundsException - if index is out of range (index < 0 || index >= tab count)"
  ([this index]
    (-> this (.getToolTipTextAt index))))

(defn set-ui
  "Sets the UI object which implements the L&F for this component.

  ui - the new UI object - `javax.swing.plaf.TabbedPaneUI`"
  ([this ui]
    (-> this (.setUI ui))))

(defn get-selected-component
  "Returns the currently selected component for this tabbedpane.
   Returns null if there is no currently selected tab.

  returns: the component corresponding to the selected tab - `java.awt.Component`"
  ([this]
    (-> this (.getSelectedComponent))))

(defn get-tool-tip-text
  "Returns the tooltip text for the component determined by the
   mouse event location.

  event - the MouseEvent that tells where the cursor is lingering - `java.awt.event.MouseEvent`

  returns: the String containing the tooltip text - `java.lang.String`"
  ([this event]
    (-> this (.getToolTipText event))))

(defn index-of-component
  "Returns the index of the tab for the specified component.
   Returns -1 if there is no tab for this component.

  component - the component for the tab - `java.awt.Component`

  returns: the first tab which matches this component, or -1
            if there is no tab for this component - `int`"
  ([this component]
    (-> this (.indexOfComponent component))))

(defn remove
  "Removes the specified Component from the
   JTabbedPane. The method does nothing
   if the component is null.

  component - the component to remove from the tabbedpane - `java.awt.Component`"
  ([this component]
    (-> this (.remove component))))

(defn set-component-at
  "Sets the component at index to component.
   An internal exception is raised if there is no tab at that index.

  index - the tab index where this component is being placed - `int`
  component - the component for the tab - `java.awt.Component`

  throws: java.lang.IndexOutOfBoundsException - if index is out of range (index < 0 || index >= tab count)"
  ([this index component]
    (-> this (.setComponentAt index component))))

(defn get-ui
  "Returns the UI object which implements the L&F for this component.

  returns: a TabbedPaneUI object - `javax.swing.plaf.TabbedPaneUI`"
  ([this]
    (-> this (.getUI))))

(defn get-displayed-mnemonic-index-at
  "Returns the character, as an index, that the look and feel should
   provide decoration for as representing the mnemonic character.

  tab-index - the index of the tab that the mnemonic refers to - `int`

  returns: index representing mnemonic character if one exists;
      otherwise returns -1 - `int`

  throws: java.lang.IndexOutOfBoundsException - if index is out of range (tabIndex < 0 || tabIndex >= tab count)"
  ([this tab-index]
    (-> this (.getDisplayedMnemonicIndexAt tab-index))))

(defn get-component-at
  "Returns the component at index.

  index - the index of the item being queried - `int`

  returns: the Component at index - `java.awt.Component`

  throws: java.lang.IndexOutOfBoundsException - if index is out of range (index < 0 || index >= tab count)"
  ([this index]
    (-> this (.getComponentAt index))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this JTabbedPane.
   For tabbed panes, the AccessibleContext takes the form of an
   AccessibleJTabbedPane.
   A new AccessibleJTabbedPane instance is created if necessary.

  returns: an AccessibleJTabbedPane that serves as the
           AccessibleContext of this JTabbedPane - `javax.accessibility.AccessibleContext`"
  ([this]
    (-> this (.getAccessibleContext))))

(defn get-mnemonic-at
  "Returns the keyboard mnemonic for accessing the specified tab.
   The mnemonic is the key which when combined with the look and feel's
   mouseless modifier (usually Alt) will activate the specified
   tab.

  tab-index - the index of the tab that the mnemonic refers to - `int`

  returns: the key code which represents the mnemonic;
           -1 if a mnemonic is not specified for the tab - `int`

  throws: java.lang.IndexOutOfBoundsException - if index is out of range (tabIndex < 0 || tabIndex >= tab count)"
  ([this tab-index]
    (-> this (.getMnemonicAt tab-index))))

(defn index-of-tab-component
  "Returns the index of the tab for the specified tab component.
   Returns -1 if there is no tab for this tab component.

  tab-component - the tab component for the tab - `java.awt.Component`

  returns: the first tab which matches this tab component, or -1
            if there is no tab for this tab component - `int`"
  ([this tab-component]
    (-> this (.indexOfTabComponent tab-component))))

(defn get-title-at
  "Returns the tab title at index.

  index - the index of the item being queried - `int`

  returns: the title at index - `java.lang.String`

  throws: java.lang.IndexOutOfBoundsException - if index is out of range (index < 0 || index >= tab count)"
  ([this index]
    (-> this (.getTitleAt index))))

(defn set-title-at
  "Sets the title at index to title which
   can be null.
   The title is not shown if a tab component for this tab was specified.
   An internal exception is raised if there is no tab at that index.

  index - the tab index where the title should be set - `int`
  title - the title to be displayed in the tab - `java.lang.String`

  throws: java.lang.IndexOutOfBoundsException - if index is out of range (index < 0 || index >= tab count)"
  ([this index title]
    (-> this (.setTitleAt index title))))

(defn set-background-at
  "Sets the background color at index to
   background
   which can be null, in which case the tab's background color
   will default to the background color of the tabbedpane.
   An internal exception is raised if there is no tab at that index.

   It is up to the look and feel to honor this property, some may
   choose to ignore it.

  index - the tab index where the background should be set - `int`
  background - the color to be displayed in the tab's background - `java.awt.Color`

  throws: java.lang.IndexOutOfBoundsException - if index is out of range (index < 0 || index >= tab count)"
  ([this index background]
    (-> this (.setBackgroundAt index background))))

(defn add-tab
  "Adds a component and tip
   represented by a title and/or icon,
   either of which can be null.
   Cover method for insertTab.

  title - the title to be displayed in this tab - `java.lang.String`
  icon - the icon to be displayed in this tab - `javax.swing.Icon`
  component - the component to be displayed when this tab is clicked - `java.awt.Component`
  tip - the tooltip to be displayed for this tab - `java.lang.String`"
  ([this title icon component tip]
    (-> this (.addTab title icon component tip)))
  ([this title icon component]
    (-> this (.addTab title icon component)))
  ([this title component]
    (-> this (.addTab title component))))

(defn set-selected-index
  "Sets the selected index for this tabbedpane. The index must be
   a valid tab index or -1, which indicates that no tab should be selected
   (can also be used when there are no tabs in the tabbedpane).  If a -1
   value is specified when the tabbedpane contains one or more tabs, then
   the results will be implementation defined.

  index - the index to be selected - `int`

  throws: java.lang.IndexOutOfBoundsException - if index is out of range (index < -1 || index >= tab count)"
  ([this index]
    (-> this (.setSelectedIndex index))))

(defn add
  "Adds a component at the specified tab index.
   If constraints is a String or an
   Icon, it will be used for the tab title,
   otherwise the component's name will be used as the tab title.
   Cover method for insertTab.

  component - the component to be displayed when this tab is clicked - `java.awt.Component`
  constraints - the object to be displayed in the tab - `java.lang.Object`
  index - the position to insert this new tab - `int`"
  ([this component constraints index]
    (-> this (.add component constraints index)))
  ([this title component]
    (-> this (.add title component)))
  ([this component]
    (-> this (.add component))))

(defn get-tab-placement
  "Returns the placement of the tabs for this tabbedpane.

  returns: `int`"
  ([this]
    (-> this (.getTabPlacement))))

(defn get-foreground-at
  "Returns the tab foreground color at index.

  index - the index of the item being queried - `int`

  returns: the Color of the tab foreground at
            index - `java.awt.Color`

  throws: java.lang.IndexOutOfBoundsException - if index is out of range (index < 0 || index >= tab count)"
  ([this index]
    (-> this (.getForegroundAt index))))

(defn insert-tab
  "Inserts a new tab for the given component, at the given index,
   represented by the given title and/or icon, either of which may
   be null.

  title - the title to be displayed on the tab - `java.lang.String`
  icon - the icon to be displayed on the tab - `javax.swing.Icon`
  component - the component to be displayed when this tab is clicked. - `java.awt.Component`
  tip - the tooltip to be displayed for this tab - `java.lang.String`
  index - the position to insert this new tab (> 0 and <= getTabCount()) - `int`

  throws: java.lang.IndexOutOfBoundsException - if the index is out of range (< 0 or > getTabCount())"
  ([this title icon component tip index]
    (-> this (.insertTab title icon component tip index))))

(defn set-icon-at
  "Sets the icon at index to icon which can be
   null. This does not set disabled icon at icon.
   If the new Icon is different than the current Icon and disabled icon
   is not explicitly set, the LookAndFeel will be asked to generate a disabled
   Icon. To explicitly set disabled icon, use setDisableIconAt().
   The icon is not shown if a tab component for this tab was specified.
   An internal exception is raised if there is no tab at that index.

  index - the tab index where the icon should be set - `int`
  icon - the icon to be displayed in the tab - `javax.swing.Icon`

  throws: java.lang.IndexOutOfBoundsException - if index is out of range (index < 0 || index >= tab count)"
  ([this index icon]
    (-> this (.setIconAt index icon))))

(defn get-model
  "Returns the model associated with this tabbedpane.

  returns: `javax.swing.SingleSelectionModel`"
  ([this]
    (-> this (.getModel))))

(defn get-tab-layout-policy
  "Returns the policy used by the tabbedpane to layout the tabs when all the
   tabs will not fit within a single run.

  returns: `int`"
  ([this]
    (-> this (.getTabLayoutPolicy))))

(defn remove-all
  "Removes all the tabs and their corresponding components
   from the tabbedpane."
  ([this]
    (-> this (.removeAll))))

(defn set-model
  "Sets the model to be used with this tabbedpane.

  model - the model to be used - `javax.swing.SingleSelectionModel`"
  ([this model]
    (-> this (.setModel model))))

(defn update-ui
  "Resets the UI property to a value from the current look and feel."
  ([this]
    (-> this (.updateUI))))

(defn set-enabled-at
  "Sets whether or not the tab at index is enabled.
   An internal exception is raised if there is no tab at that index.

  index - the tab index which should be enabled/disabled - `int`
  enabled - whether or not the tab should be enabled - `boolean`

  throws: java.lang.IndexOutOfBoundsException - if index is out of range (index < 0 || index >= tab count)"
  ([this index enabled]
    (-> this (.setEnabledAt index enabled))))

(defn get-disabled-icon-at
  "Returns the tab disabled icon at index.
   If the tab disabled icon doesn't exist at index
   this will forward the call to the look and feel to construct
   an appropriate disabled Icon from the corresponding enabled
   Icon. Some look and feels might not render the disabled Icon,
   in which case it won't be created.

  index - the index of the item being queried - `int`

  returns: the icon at index - `javax.swing.Icon`

  throws: java.lang.IndexOutOfBoundsException - if index is out of range (index < 0 || index >= tab count)"
  ([this index]
    (-> this (.getDisabledIconAt index))))

(defn get-icon-at
  "Returns the tab icon at index.

  index - the index of the item being queried - `int`

  returns: the icon at index - `javax.swing.Icon`

  throws: java.lang.IndexOutOfBoundsException - if index is out of range (index < 0 || index >= tab count)"
  ([this index]
    (-> this (.getIconAt index))))

