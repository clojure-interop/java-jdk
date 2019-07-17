(ns jdk.awt.FlowLayout
  "A flow layout arranges components in a directional flow, much
  like lines of text in a paragraph. The flow direction is
  determined by the container's componentOrientation
  property and may be one of two values:

  ComponentOrientation.LEFT_TO_RIGHT
  ComponentOrientation.RIGHT_TO_LEFT

  Flow layouts are typically used
  to arrange buttons in a panel. It arranges buttons
  horizontally until no more buttons fit on the same line.
  The line alignment is determined by the align
  property. The possible values are:

  LEFT
  RIGHT
  CENTER
  LEADING
  TRAILING


  For example, the following picture shows an applet using the flow
  layout manager (its default layout manager) to position three buttons:



  Here is the code for this applet:



  import java.awt.*;
  import java.applet.Applet;

  public class myButtons extends Applet {
      Button button1, button2, button3;
      public void init() {
          button1 = new Button(`Ok`);
          button2 = new Button(`Open`);
          button3 = new Button(`Close`);
          add(button1);
          add(button2);
          add(button3);
      }
  }

  A flow layout lets each component assume its natural (preferred) size."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt FlowLayout]))

(defn ->flow-layout
  "Constructor.

  Creates a new flow layout manager with the indicated alignment
   and the indicated horizontal and vertical gaps.

   The value of the alignment argument must be one of
   FlowLayout.LEFT, FlowLayout.RIGHT,
   FlowLayout.CENTER, FlowLayout.LEADING,
   or FlowLayout.TRAILING.

  align - the alignment value - `int`
  hgap - the horizontal gap between components and between the components and the borders of the Container - `int`
  vgap - the vertical gap between components and between the components and the borders of the Container - `int`"
  ([^Integer align ^Integer hgap ^Integer vgap]
    (new FlowLayout align hgap vgap))
  ([^Integer align]
    (new FlowLayout align))
  ([]
    (new FlowLayout )))

(def *-left
  "Static Constant.

  This value indicates that each row of components
   should be left-justified.

  type: int"
  FlowLayout/LEFT)

(def *-center
  "Static Constant.

  This value indicates that each row of components
   should be centered.

  type: int"
  FlowLayout/CENTER)

(def *-right
  "Static Constant.

  This value indicates that each row of components
   should be right-justified.

  type: int"
  FlowLayout/RIGHT)

(def *-leading
  "Static Constant.

  This value indicates that each row of components
   should be justified to the leading edge of the container's
   orientation, for example, to the left in left-to-right orientations.

  type: int"
  FlowLayout/LEADING)

(def *-trailing
  "Static Constant.

  This value indicates that each row of components
   should be justified to the trailing edge of the container's
   orientation, for example, to the right in left-to-right orientations.

  type: int"
  FlowLayout/TRAILING)

(defn set-alignment
  "Sets the alignment for this layout.
   Possible values are

   FlowLayout.LEFT
   FlowLayout.RIGHT
   FlowLayout.CENTER
   FlowLayout.LEADING
   FlowLayout.TRAILING

  align - one of the alignment values shown above - `int`"
  ([^java.awt.FlowLayout this ^Integer align]
    (-> this (.setAlignment align))))

(defn get-vgap
  "Gets the vertical gap between components and
   between the components and the borders of the
   Container.

  returns: the vertical gap between components
               and between the components and the borders
               of the Container - `int`"
  (^Integer [^java.awt.FlowLayout this]
    (-> this (.getVgap))))

(defn set-hgap
  "Sets the horizontal gap between components and
   between the components and the borders of the
   Container.

  hgap - the horizontal gap between components and between the components and the borders of the Container - `int`"
  ([^java.awt.FlowLayout this ^Integer hgap]
    (-> this (.setHgap hgap))))

(defn set-vgap
  "Sets the vertical gap between components and between
   the components and the borders of the Container.

  vgap - the vertical gap between components and between the components and the borders of the Container - `int`"
  ([^java.awt.FlowLayout this ^Integer vgap]
    (-> this (.setVgap vgap))))

(defn preferred-layout-size
  "Returns the preferred dimensions for this layout given the
   visible components in the specified target container.

  target - the container that needs to be laid out - `java.awt.Container`

  returns: the preferred dimensions to lay out the
              subcomponents of the specified container - `java.awt.Dimension`"
  (^java.awt.Dimension [^java.awt.FlowLayout this ^java.awt.Container target]
    (-> this (.preferredLayoutSize target))))

(defn to-string
  "Returns a string representation of this FlowLayout
   object and its values.

  returns: a string representation of this layout - `java.lang.String`"
  (^java.lang.String [^java.awt.FlowLayout this]
    (-> this (.toString))))

(defn get-hgap
  "Gets the horizontal gap between components
   and between the components and the borders
   of the Container

  returns: the horizontal gap between components
               and between the components and the borders
               of the Container - `int`"
  (^Integer [^java.awt.FlowLayout this]
    (-> this (.getHgap))))

(defn get-align-on-baseline?
  "Returns true if components are to be vertically aligned along
   their baseline.  The default is false.

  returns: true if components are to be vertically aligned along
                their baseline - `boolean`"
  (^Boolean [^java.awt.FlowLayout this]
    (-> this (.getAlignOnBaseline))))

(defn minimum-layout-size
  "Returns the minimum dimensions needed to layout the visible
   components contained in the specified target container.

  target - the container that needs to be laid out - `java.awt.Container`

  returns: the minimum dimensions to lay out the
              subcomponents of the specified container - `java.awt.Dimension`"
  (^java.awt.Dimension [^java.awt.FlowLayout this ^java.awt.Container target]
    (-> this (.minimumLayoutSize target))))

(defn get-alignment
  "Gets the alignment for this layout.
   Possible values are FlowLayout.LEFT,
   FlowLayout.RIGHT, FlowLayout.CENTER,
   FlowLayout.LEADING,
   or FlowLayout.TRAILING.

  returns: the alignment value for this layout - `int`"
  (^Integer [^java.awt.FlowLayout this]
    (-> this (.getAlignment))))

(defn set-align-on-baseline
  "Sets whether or not components should be vertically aligned along their
   baseline.  Components that do not have a baseline will be centered.
   The default is false.

  align-on-baseline - whether or not components should be vertically aligned on their baseline - `boolean`"
  ([^java.awt.FlowLayout this ^Boolean align-on-baseline]
    (-> this (.setAlignOnBaseline align-on-baseline))))

(defn add-layout-component
  "Adds the specified component to the layout.
   Not used by this class.

  name - the name of the component - `java.lang.String`
  comp - the component to be added - `java.awt.Component`"
  ([^java.awt.FlowLayout this ^java.lang.String name ^java.awt.Component comp]
    (-> this (.addLayoutComponent name comp))))

(defn remove-layout-component
  "Removes the specified component from the layout.
   Not used by this class.

  comp - the component to remove - `java.awt.Component`"
  ([^java.awt.FlowLayout this ^java.awt.Component comp]
    (-> this (.removeLayoutComponent comp))))

(defn layout-container
  "Lays out the container. This method lets each
   visible component take
   its preferred size by reshaping the components in the
   target container in order to satisfy the alignment of
   this FlowLayout object.

  target - the specified component being laid out - `java.awt.Container`"
  ([^java.awt.FlowLayout this ^java.awt.Container target]
    (-> this (.layoutContainer target))))

