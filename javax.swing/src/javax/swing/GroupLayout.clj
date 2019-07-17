(ns javax.swing.GroupLayout
  "GroupLayout is a LayoutManager that hierarchically
  groups components in order to position them in a Container.
  GroupLayout is intended for use by builders, but may be
  hand-coded as well.
  Grouping is done by instances of the Group class. GroupLayout supports two types of groups. A sequential group
  positions its child elements sequentially, one after another. A
  parallel group aligns its child elements in one of four ways.

  Each group may contain any number of elements, where an element is
  a Group, Component, or gap. A gap can be thought
  of as an invisible component with a minimum, preferred and maximum
  size. In addition GroupLayout supports a preferred gap,
  whose value comes from LayoutStyle.

  Elements are similar to a spring. Each element has a range as
  specified by a minimum, preferred and maximum.  Gaps have either a
  developer-specified range, or a range determined by LayoutStyle. The range for Components is determined from
  the Component's getMinimumSize, getPreferredSize and getMaximumSize methods. In addition,
  when adding Components you may specify a particular range
  to use instead of that from the component. The range for a Group is determined by the type of group. A ParallelGroup's
  range is the maximum of the ranges of its elements. A SequentialGroup's range is the sum of the ranges of its elements.

  GroupLayout treats each axis independently.  That is, there
  is a group representing the horizontal axis, and a group
  representing the vertical axis.  The horizontal group is
  responsible for determining the minimum, preferred and maximum size
  along the horizontal axis as well as setting the x and width of the
  components contained in it. The vertical group is responsible for
  determining the minimum, preferred and maximum size along the
  vertical axis as well as setting the y and height of the
  components contained in it. Each Component must exist in both
  a horizontal and vertical group, otherwise an IllegalStateException
  is thrown during layout, or when the minimum, preferred or
  maximum size is requested.

  The following diagram shows a sequential group along the horizontal
  axis. The sequential group contains three components. A parallel group
  was used along the vertical axis.



  To reinforce that each axis is treated independently the diagram shows
  the range of each group and element along each axis. The
  range of each component has been projected onto the axes,
  and the groups are rendered in blue (horizontal) and red (vertical).
  For readability there is a gap between each of the elements in the
  sequential group.

  The sequential group along the horizontal axis is rendered as a solid
  blue line. Notice the sequential group is the sum of the children elements
  it contains.

  Along the vertical axis the parallel group is the maximum of the height
  of each of the components. As all three components have the same height,
  the parallel group has the same height.

  The following diagram shows the same three components, but with the
  parallel group along the horizontal axis and the sequential group along
  the vertical axis.




  As c1 is the largest of the three components, the parallel
  group is sized to c1. As c2 and c3 are smaller
  than c1 they are aligned based on the alignment specified
  for the component (if specified) or the default alignment of the
  parallel group. In the diagram c2 and c3 were created
  with an alignment of LEADING. If the component orientation were
  right-to-left then c2 and c3 would be positioned on
  the opposite side.

  The following diagram shows a sequential group along both the horizontal
  and vertical axis.



  GroupLayout provides the ability to insert gaps between
  Components. The size of the gap is determined by an
  instance of LayoutStyle. This may be turned on using the
  setAutoCreateGaps method.  Similarly, you may use
  the setAutoCreateContainerGaps method to insert gaps
  between components that touch the edge of the parent container and the
  container.

  The following builds a panel consisting of two labels in
  one column, followed by two textfields in the next column:


    JComponent panel = ...;
    GroupLayout layout = new GroupLayout(panel);
    panel.setLayout(layout);

    // Turn on automatically adding gaps between components
    layout.setAutoCreateGaps(true);

    // Turn on automatically creating gaps between components that touch
    // the edge of the container and the container.
    layout.setAutoCreateContainerGaps(true);

    // Create a sequential group for the horizontal axis.

    GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

    // The sequential group in turn contains two parallel groups.
    // One parallel group contains the labels, the other the text fields.
    // Putting the labels in a parallel group along the horizontal axis
    // positions them at the same x location.
    //
    // Variable indentation is used to reinforce the level of grouping.
    hGroup.addGroup(layout.createParallelGroup().
             addComponent(label1).addComponent(label2));
    hGroup.addGroup(layout.createParallelGroup().
             addComponent(tf1).addComponent(tf2));
    layout.setHorizontalGroup(hGroup);

    // Create a sequential group for the vertical axis.
    GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

    // The sequential group contains two parallel groups that align
    // the contents along the baseline. The first parallel group contains
    // the first label and text field, and the second parallel group contains
    // the second label and text field. By using a sequential group
    // the labels and text fields are positioned vertically after one another.
    vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
             addComponent(label1).addComponent(tf1));
    vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
             addComponent(label2).addComponent(tf2));
    layout.setVerticalGroup(vGroup);

  When run the following is produced.



  This layout consists of the following.
  The horizontal axis consists of a sequential group containing two
          parallel groups.  The first parallel group contains the labels,
          and the second parallel group contains the text fields.
      The vertical axis consists of a sequential group
          containing two parallel groups.  The parallel groups are configured
          to align their components along the baseline. The first parallel
          group contains the first label and first text field, and
          the second group consists of the second label and second
          text field.

  There are a couple of things to notice in this code:

    You need not explicitly add the components to the container; this
        is indirectly done by using one of the add methods of
        Group.
    The various add methods return
        the caller.  This allows for easy chaining of invocations.  For
        example, group.addComponent(label1).addComponent(label2); is
        equivalent to
        group.addComponent(label1); group.addComponent(label2);.
    There are no public constructors for Groups; instead
        use the create methods of GroupLayout."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing GroupLayout]))

(defn ->group-layout
  "Constructor.

  Creates a GroupLayout for the specified Container.

  host - the Container the GroupLayout is the LayoutManager for - `java.awt.Container`

  throws: java.lang.IllegalArgumentException - if host is null"
  ([^java.awt.Container host]
    (new GroupLayout host)))

(def *-default-size
  "Static Constant.

  Indicates the size from the component or gap should be used for a
   particular range value.

  type: int"
  GroupLayout/DEFAULT_SIZE)

(def *-preferred-size
  "Static Constant.

  Indicates the preferred size from the component or gap should
   be used for a particular range value.

  type: int"
  GroupLayout/PREFERRED_SIZE)

(defn invalidate-layout
  "Invalidates the layout, indicating that if the layout manager
   has cached information it should be discarded.

  parent - the Container hosting this LayoutManager - `java.awt.Container`

  throws: java.lang.IllegalArgumentException - if parent is not the same Container that this was created with"
  ([^javax.swing.GroupLayout this ^java.awt.Container parent]
    (-> this (.invalidateLayout parent))))

(defn get-layout-alignment-y
  "Returns the alignment along the y axis.  This specifies how
   the component would like to be aligned relative to other
   components.  The value should be a number between 0 and 1
   where 0 represents alignment along the origin, 1 is aligned
   the furthest away from the origin, 0.5 is centered, etc.

  parent - the Container hosting this LayoutManager - `java.awt.Container`

  returns: alignment; this implementation returns .5 - `float`

  throws: java.lang.IllegalArgumentException - if parent is not the same Container that this was created with"
  (^Float [^javax.swing.GroupLayout this ^java.awt.Container parent]
    (-> this (.getLayoutAlignmentY parent))))

(defn get-auto-create-gaps?
  "Returns true if gaps between components are automatically
   created.

  returns: true if gaps between components are automatically
           created - `boolean`"
  (^Boolean [^javax.swing.GroupLayout this]
    (-> this (.getAutoCreateGaps))))

(defn get-auto-create-container-gaps?
  "Returns true if gaps between the container and components that
   border the container are automatically created.

  returns: true if gaps between the container and components that
           border the container are automatically created - `boolean`"
  (^Boolean [^javax.swing.GroupLayout this]
    (-> this (.getAutoCreateContainerGaps))))

(defn set-horizontal-group
  "Sets the Group that positions and sizes
   components along the horizontal axis.

  group - the Group that positions and sizes components along the horizontal axis - `javax.swing.GroupLayout.Group`

  throws: java.lang.IllegalArgumentException - if group is null"
  ([^javax.swing.GroupLayout this ^javax.swing.GroupLayout.Group group]
    (-> this (.setHorizontalGroup group))))

(defn link-size
  "Forces the specified components to have the same size along the
   specified axis regardless of their preferred, minimum or
   maximum sizes. Components that are linked are given the maximum
   of the preferred size of each of the linked components. For
   example, if you link two components along the horizontal axis
   and the preferred width is 10 and 20, both components are given
   a width of 20.

   This can be used multiple times to force any number of
   components to share the same size.

   Linked Components are not be resizable.

  axis - the axis to link the size along; one of SwingConstants.HORIZONTAL or SwingConstans.VERTICAL - `int`
  components - the Components that are to have the same size - `java.awt.Component`

  throws: java.lang.IllegalArgumentException - if components is null, or contains null; or axis is not SwingConstants.HORIZONTAL or SwingConstants.VERTICAL"
  ([^javax.swing.GroupLayout this ^Integer axis ^java.awt.Component components]
    (-> this (.linkSize axis components)))
  ([^javax.swing.GroupLayout this ^java.awt.Component components]
    (-> this (.linkSize components))))

(defn preferred-layout-size
  "Returns the preferred size for the specified container.

  parent - the container to return the preferred size for - `java.awt.Container`

  returns: the preferred size for parent - `java.awt.Dimension`

  throws: java.lang.IllegalArgumentException - if parent is not the same Container this was created with"
  (^java.awt.Dimension [^javax.swing.GroupLayout this ^java.awt.Container parent]
    (-> this (.preferredLayoutSize parent))))

(defn to-string
  "Returns a string representation of this GroupLayout.
   This method is intended to be used for debugging purposes,
   and the content and format of the returned string may vary
   between implementations.

  returns: a string representation of this GroupLayout - `java.lang.String`"
  (^java.lang.String [^javax.swing.GroupLayout this]
    (-> this (.toString))))

(defn replace
  "Replaces an existing component with a new one.

  existing-component - the component that should be removed and replaced with newComponent - `java.awt.Component`
  new-component - the component to put in existingComponent's place - `java.awt.Component`

  throws: java.lang.IllegalArgumentException - if either of the components are null or existingComponent is not being managed by this layout manager"
  ([^javax.swing.GroupLayout this ^java.awt.Component existing-component ^java.awt.Component new-component]
    (-> this (.replace existing-component new-component))))

(defn get-layout-alignment-x
  "Returns the alignment along the x axis.  This specifies how
   the component would like to be aligned relative to other
   components.  The value should be a number between 0 and 1
   where 0 represents alignment along the origin, 1 is aligned
   the furthest away from the origin, 0.5 is centered, etc.

  parent - the Container hosting this LayoutManager - `java.awt.Container`

  returns: the alignment; this implementation returns .5 - `float`

  throws: java.lang.IllegalArgumentException - if parent is not the same Container that this was created with"
  (^Float [^javax.swing.GroupLayout this ^java.awt.Container parent]
    (-> this (.getLayoutAlignmentX parent))))

(defn get-layout-style
  "Returns the LayoutStyle used for calculating the preferred
   gap between components. This returns the value specified to
   setLayoutStyle, which may be null.

  returns: the LayoutStyle used for calculating the preferred
           gap between components - `javax.swing.LayoutStyle`"
  (^javax.swing.LayoutStyle [^javax.swing.GroupLayout this]
    (-> this (.getLayoutStyle))))

(defn set-layout-style
  "Sets the LayoutStyle used to calculate the preferred
   gaps between components. A value of null indicates the
   shared instance of LayoutStyle should be used.

  layout-style - the LayoutStyle to use - `javax.swing.LayoutStyle`"
  ([^javax.swing.GroupLayout this ^javax.swing.LayoutStyle layout-style]
    (-> this (.setLayoutStyle layout-style))))

(defn minimum-layout-size
  "Returns the minimum size for the specified container.

  parent - the container to return the size for - `java.awt.Container`

  returns: the minimum size for parent - `java.awt.Dimension`

  throws: java.lang.IllegalArgumentException - if parent is not the same Container that this was created with"
  (^java.awt.Dimension [^javax.swing.GroupLayout this ^java.awt.Container parent]
    (-> this (.minimumLayoutSize parent))))

(defn get-honors-visibility?
  "Returns whether component visibility is considered when sizing and
   positioning components.

  returns: whether component visibility is considered when sizing and
           positioning components - `boolean`"
  (^Boolean [^javax.swing.GroupLayout this]
    (-> this (.getHonorsVisibility))))

(defn maximum-layout-size
  "Returns the maximum size for the specified container.

  parent - the container to return the size for - `java.awt.Container`

  returns: the maximum size for parent - `java.awt.Dimension`

  throws: java.lang.IllegalArgumentException - if parent is not the same Container that this was created with"
  (^java.awt.Dimension [^javax.swing.GroupLayout this ^java.awt.Container parent]
    (-> this (.maximumLayoutSize parent))))

(defn create-baseline-group
  "Creates and returns a ParallelGroup that aligns it's
   elements along the baseline.

  resizable - whether the group is resizable - `boolean`
  anchor-baseline-to-top - whether the baseline is anchored to the top or bottom of the group - `boolean`

  returns: `javax.swing.GroupLayout.ParallelGroup`"
  (^javax.swing.GroupLayout.ParallelGroup [^javax.swing.GroupLayout this ^Boolean resizable ^Boolean anchor-baseline-to-top]
    (-> this (.createBaselineGroup resizable anchor-baseline-to-top))))

(defn add-layout-component
  "Notification that a Component has been added to
   the parent container.  You should not invoke this method
   directly, instead you should use one of the Group
   methods to add a Component.

  name - the string to be associated with the component - `java.lang.String`
  component - the Component to be added - `java.awt.Component`"
  ([^javax.swing.GroupLayout this ^java.lang.String name ^java.awt.Component component]
    (-> this (.addLayoutComponent name component))))

(defn create-sequential-group
  "Creates and returns a SequentialGroup.

  returns: a new SequentialGroup - `javax.swing.GroupLayout.SequentialGroup`"
  (^javax.swing.GroupLayout.SequentialGroup [^javax.swing.GroupLayout this]
    (-> this (.createSequentialGroup))))

(defn create-parallel-group
  "Creates and returns a ParallelGroup with the specified
   alignment and resize behavior. The alignment argument specifies how children elements are
   positioned that do not fill the group. For example, if a ParallelGroup with an alignment of TRAILING is given
   100 and a child only needs 50, the child is
   positioned at the position 50 (with a component orientation of
   left-to-right).

   Baseline alignment is only useful when used along the vertical
   axis. A ParallelGroup created with a baseline alignment
   along the horizontal axis is treated as LEADING.

   Refer to ParallelGroup for details on
   the behavior of baseline groups.

  alignment - the alignment for the elements of the group - `javax.swing.GroupLayout.Alignment`
  resizable - true if the group is resizable; if the group is not resizable the preferred size is used for the minimum and maximum size of the group - `boolean`

  returns: a new ParallelGroup - `javax.swing.GroupLayout.ParallelGroup`

  throws: java.lang.IllegalArgumentException - if alignment is null"
  (^javax.swing.GroupLayout.ParallelGroup [^javax.swing.GroupLayout this ^javax.swing.GroupLayout.Alignment alignment ^Boolean resizable]
    (-> this (.createParallelGroup alignment resizable)))
  (^javax.swing.GroupLayout.ParallelGroup [^javax.swing.GroupLayout this ^javax.swing.GroupLayout.Alignment alignment]
    (-> this (.createParallelGroup alignment)))
  (^javax.swing.GroupLayout.ParallelGroup [^javax.swing.GroupLayout this]
    (-> this (.createParallelGroup))))

(defn remove-layout-component
  "Notification that a Component has been removed from
   the parent container.  You should not invoke this method
   directly, instead invoke remove on the parent
   Container.

  component - the component to be removed - `java.awt.Component`"
  ([^javax.swing.GroupLayout this ^java.awt.Component component]
    (-> this (.removeLayoutComponent component))))

(defn set-vertical-group
  "Sets the Group that positions and sizes
   components along the vertical axis.

  group - the Group that positions and sizes components along the vertical axis - `javax.swing.GroupLayout.Group`

  throws: java.lang.IllegalArgumentException - if group is null"
  ([^javax.swing.GroupLayout this ^javax.swing.GroupLayout.Group group]
    (-> this (.setVerticalGroup group))))

(defn set-honors-visibility
  "Sets whether the component's visibility is considered for
   sizing and positioning. A value of Boolean.TRUE
   indicates that if component is not visible it should
   not be treated as part of the layout. A value of false
   indicates that component is positioned and sized
   regardless of it's visibility.  A value of null
   indicates the value specified by the single argument method setHonorsVisibility should be used.

   If component is not a child of the Container this
   GroupLayout is managing, it will be added to the
   Container.

  component - the component - `java.awt.Component`
  honors-visibility - whether visibility of this component should be considered for sizing and positioning - `java.lang.Boolean`

  throws: java.lang.IllegalArgumentException - if component is null"
  ([^javax.swing.GroupLayout this ^java.awt.Component component ^java.lang.Boolean honors-visibility]
    (-> this (.setHonorsVisibility component honors-visibility)))
  ([^javax.swing.GroupLayout this ^Boolean honors-visibility]
    (-> this (.setHonorsVisibility honors-visibility))))

(defn set-auto-create-container-gaps
  "Sets whether a gap between the container and components that
   touch the border of the container should automatically be
   created. The default is false.

  auto-create-container-padding - whether a gap between the container and components that touch the border of the container should automatically be created - `boolean`"
  ([^javax.swing.GroupLayout this ^Boolean auto-create-container-padding]
    (-> this (.setAutoCreateContainerGaps auto-create-container-padding))))

(defn layout-container
  "Lays out the specified container.

  parent - the container to be laid out - `java.awt.Container`

  throws: java.lang.IllegalStateException - if any of the components added to this layout are not in both a horizontal and vertical group"
  ([^javax.swing.GroupLayout this ^java.awt.Container parent]
    (-> this (.layoutContainer parent))))

(defn set-auto-create-gaps
  "Sets whether a gap between components should automatically be
   created.  For example, if this is true and you add two
   components to a SequentialGroup a gap between the
   two components is automatically be created.  The default is
   false.

  auto-create-padding - whether a gap between components is automatically created - `boolean`"
  ([^javax.swing.GroupLayout this ^Boolean auto-create-padding]
    (-> this (.setAutoCreateGaps auto-create-padding))))

