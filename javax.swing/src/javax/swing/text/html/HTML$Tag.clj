(ns javax.swing.text.html.HTML$Tag
  "Typesafe enumeration for an HTML tag.  Although the
  set of HTML tags is a closed set, we have left the
  set open so that people can add their own tag types
  to their custom parser and still communicate to the
  reader."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html HTML$Tag]))

(defn ->tag
  "Constructor."
  (^HTML$Tag []
    (new HTML$Tag )))

(def *-a
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/A)

(def *-address
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/ADDRESS)

(def *-applet
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/APPLET)

(def *-area
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/AREA)

(def *-b
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/B)

(def *-base
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/BASE)

(def *-basefont
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/BASEFONT)

(def *-big
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/BIG)

(def *-blockquote
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/BLOCKQUOTE)

(def *-body
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/BODY)

(def *-br
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/BR)

(def *-caption
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/CAPTION)

(def *-center
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/CENTER)

(def *-cite
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/CITE)

(def *-code
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/CODE)

(def *-dd
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/DD)

(def *-dfn
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/DFN)

(def *-dir
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/DIR)

(def *-div
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/DIV)

(def *-dl
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/DL)

(def *-dt
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/DT)

(def *-em
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/EM)

(def *-font
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/FONT)

(def *-form
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/FORM)

(def *-frame
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/FRAME)

(def *-frameset
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/FRAMESET)

(def *-h-1
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/H1)

(def *-h-2
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/H2)

(def *-h-3
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/H3)

(def *-h-4
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/H4)

(def *-h-5
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/H5)

(def *-h-6
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/H6)

(def *-head
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/HEAD)

(def *-hr
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/HR)

(def *-html
  "Static Constant.

  type: javax.swing.text.html.$Tag"
  HTML$Tag/HTML)

(def *-i
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/I)

(def *-img
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/IMG)

(def *-input
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/INPUT)

(def *-isindex
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/ISINDEX)

(def *-kbd
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/KBD)

(def *-li
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/LI)

(def *-link
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/LINK)

(def *-map
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/MAP)

(def *-menu
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/MENU)

(def *-meta
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/META)

(def *-noframes
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/NOFRAMES)

(def *-object
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/OBJECT)

(def *-ol
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/OL)

(def *-option
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/OPTION)

(def *-p
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/P)

(def *-param
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/PARAM)

(def *-pre
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/PRE)

(def *-samp
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/SAMP)

(def *-script
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/SCRIPT)

(def *-select
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/SELECT)

(def *-small
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/SMALL)

(def *-span
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/SPAN)

(def *-strike
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/STRIKE)

(def *-s
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/S)

(def *-strong
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/STRONG)

(def *-style
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/STYLE)

(def *-sub
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/SUB)

(def *-sup
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/SUP)

(def *-table
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/TABLE)

(def *-td
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/TD)

(def *-textarea
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/TEXTAREA)

(def *-th
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/TH)

(def *-title
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/TITLE)

(def *-tr
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/TR)

(def *-tt
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/TT)

(def *-u
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/U)

(def *-ul
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/UL)

(def *-var
  "Static Constant.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/VAR)

(def *-implied
  "Static Constant.

  All text content must be in a paragraph element.
   If a paragraph didn't exist when content was
   encountered, a paragraph is manufactured.

   This is a tag synthesized by the HTML reader.
   Since elements are identified by their tag type,
   we create a some fake tag types to mark the elements
   that were manufactured.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/IMPLIED)

(def *-content
  "Static Constant.

  All text content is labeled with this tag.

   This is a tag synthesized by the HTML reader.
   Since elements are identified by their tag type,
   we create a some fake tag types to mark the elements
   that were manufactured.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/CONTENT)

(def *-comment
  "Static Constant.

  All comments are labeled with this tag.

   This is a tag synthesized by the HTML reader.
   Since elements are identified by their tag type,
   we create a some fake tag types to mark the elements
   that were manufactured.

  type: javax.swing.text.html.HTML$Tag"
  HTML$Tag/COMMENT)

(defn block?
  "Returns true if this tag is a block
   tag, which is a tag used to add structure to a
   document.

  returns: true if this tag is a block
     tag, otherwise returns false - `boolean`"
  (^Boolean [^HTML$Tag this]
    (-> this (.isBlock))))

(defn breaks-flow
  "Returns true if this tag causes a
   line break to the flow of data, otherwise returns
   false.

  returns: true if this tag causes a
     line break to the flow of data, otherwise returns
     false - `boolean`"
  (^Boolean [^HTML$Tag this]
    (-> this (.breaksFlow))))

(defn preformatted?
  "Returns true if this tag is pre-formatted,
   which is true if the tag is either PRE or
   TEXTAREA.

  returns: true if this tag is pre-formatted,
     otherwise returns false - `boolean`"
  (^Boolean [^HTML$Tag this]
    (-> this (.isPreformatted))))

(defn to-string
  "Returns the string representation of the
   tag.

  returns: the String representation of the tag - `java.lang.String`"
  (^java.lang.String [^HTML$Tag this]
    (-> this (.toString))))

