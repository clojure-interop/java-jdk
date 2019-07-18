(ns javax.annotation.processing.AbstractProcessor
  "An abstract annotation processor designed to be a convenient
  superclass for most concrete annotation processors.  This class
  examines annotation values to compute the options, annotation types, and source version supported by its
  subtypes.

  The getter methods may issue
  warnings about noteworthy conditions using the facilities available
  after the processor has been initialized.

  Subclasses are free to override the implementation and
  specification of any of the methods in this class as long as the
  general Processor
  contract for that method is obeyed."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.annotation.processing AbstractProcessor]))

(defn get-supported-options
  "If the processor class is annotated with SupportedOptions, return an unmodifiable set with the same set
   of strings as the annotation.  If the class is not so
   annotated, an empty set is returned.

  returns: the options recognized by this processor, or an empty
   set if none - `java.util.Set<java.lang.String>`"
  (^java.util.Set [^AbstractProcessor this]
    (-> this (.getSupportedOptions))))

(defn get-supported-annotation-types
  "If the processor class is annotated with SupportedAnnotationTypes, return an unmodifiable set with the
   same set of strings as the annotation.  If the class is not so
   annotated, an empty set is returned.

  returns: the names of the annotation types supported by this
   processor, or an empty set if none - `java.util.Set<java.lang.String>`"
  (^java.util.Set [^AbstractProcessor this]
    (-> this (.getSupportedAnnotationTypes))))

(defn get-supported-source-version
  "If the processor class is annotated with SupportedSourceVersion, return the source version in the
   annotation.  If the class is not so annotated, SourceVersion.RELEASE_6 is returned.

  returns: the latest source version supported by this processor - `javax.lang.model.SourceVersion`"
  (^javax.lang.model.SourceVersion [^AbstractProcessor this]
    (-> this (.getSupportedSourceVersion))))

(defn init
  "Initializes the processor with the processing environment by
   setting the processingEnv field to the value of the
   processingEnv argument.  An IllegalStateException will be thrown if this method is called
   more than once on the same object.

  processing-env - environment to access facilities the tool framework provides to the processor - `javax.annotation.processing.ProcessingEnvironment`

  throws: java.lang.IllegalStateException - if this method is called more than once."
  ([^AbstractProcessor this ^javax.annotation.processing.ProcessingEnvironment processing-env]
    (-> this (.init processing-env))))

(defn process
  "Processes a set of annotation types on type elements
   originating from the prior round and returns whether or not
   these annotation types are claimed by this processor.  If true is returned, the annotation types are claimed and subsequent
   processors will not be asked to process them; if false
   is returned, the annotation types are unclaimed and subsequent
   processors may be asked to process them.  A processor may
   always return the same boolean value or may vary the result
   based on chosen criteria.

   The input set will be empty if the processor supports `*` and the root elements have no annotations.  A Processor must gracefully handle an empty set of annotations.

  annotations - the annotation types requested to be processed - `java.util.Set`
  round-env - environment for information about the current and prior round - `javax.annotation.processing.RoundEnvironment`

  returns: whether or not the set of annotation types are claimed by this processor - `boolean`"
  (^Boolean [^AbstractProcessor this ^java.util.Set annotations ^javax.annotation.processing.RoundEnvironment round-env]
    (-> this (.process annotations round-env))))

(defn get-completions
  "Returns an empty iterable of completions.

  element - the element being annotated - `javax.lang.model.element.Element`
  annotation - the (perhaps partial) annotation being applied to the element - `javax.lang.model.element.AnnotationMirror`
  member - the annotation member to return possible completions for - `javax.lang.model.element.ExecutableElement`
  user-text - source code text to be completed - `java.lang.String`

  returns: suggested completions to the annotation - `java.lang.Iterable<? extends javax.annotation.processing.Completion>`"
  ([^AbstractProcessor this ^javax.lang.model.element.Element element ^javax.lang.model.element.AnnotationMirror annotation ^javax.lang.model.element.ExecutableElement member ^java.lang.String user-text]
    (-> this (.getCompletions element annotation member user-text))))

