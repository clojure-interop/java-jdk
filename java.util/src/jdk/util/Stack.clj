(ns jdk.util.Stack
  "The Stack class represents a last-in-first-out
  (LIFO) stack of objects. It extends class Vector with five
  operations that allow a vector to be treated as a stack. The usual
  push and pop operations are provided, as well as a
  method to peek at the top item on the stack, a method to test
  for whether the stack is empty, and a method to search
  the stack for an item and discover how far it is from the top.

  When a stack is first created, it contains no items.

  A more complete and consistent set of LIFO stack operations is
  provided by the Deque interface and its implementations, which
  should be used in preference to this class.  For example:


    Deque<Integer> stack = new ArrayDeque<Integer>();"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Stack]))

(defn ->stack
  "Constructor.

  Creates an empty Stack."
  ([]
    (new Stack )))

(defn push
  "Pushes an item onto the top of this stack. This has exactly
   the same effect as:


   addElement(item)

  item - the item to be pushed onto this stack. - `Stack.E`

  returns: the item argument. - `Stack.E`"
  ([^java.util.Stack this ^Stack.E item]
    (-> this (.push item))))

(defn pop
  "Removes the object at the top of this stack and returns that
   object as the value of this function.

  returns: The object at the top of this stack (the last item
            of the Vector object). - `Stack.E`

  throws: java.util.EmptyStackException - if this stack is empty."
  ([^java.util.Stack this]
    (-> this (.pop))))

(defn peek
  "Looks at the object at the top of this stack without removing it
   from the stack.

  returns: the object at the top of this stack (the last item
            of the Vector object). - `Stack.E`

  throws: java.util.EmptyStackException - if this stack is empty."
  ([^java.util.Stack this]
    (-> this (.peek))))

(defn empty
  "Tests if this stack is empty.

  returns: true if and only if this stack contains
            no items; false otherwise. - `boolean`"
  ([^java.util.Stack this]
    (-> this (.empty))))

(defn search
  "Returns the 1-based position where an object is on this stack.
   If the object o occurs as an item in this stack, this
   method returns the distance from the top of the stack of the
   occurrence nearest the top of the stack; the topmost item on the
   stack is considered to be at distance 1. The equals
   method is used to compare o to the
   items in this stack.

  o - the desired object. - `java.lang.Object`

  returns: the 1-based position from the top of the stack where
            the object is located; the return value -1
            indicates that the object is not on the stack. - `int`"
  ([^java.util.Stack this ^java.lang.Object o]
    (-> this (.search o))))

