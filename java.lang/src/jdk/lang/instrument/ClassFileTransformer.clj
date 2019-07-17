(ns jdk.lang.instrument.ClassFileTransformer
  "An agent provides an implementation of this interface in order
  to transform class files.
  The transformation occurs before the class is defined by the JVM.

  Note the term class file is used as defined in section 3.1 of
  The Java™ Virtual Machine Specification,
  to mean a sequence
  of bytes in class file format, whether or not they reside in a file."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.instrument ClassFileTransformer]))

(defn transform
  "The implementation of this method may transform the supplied class file and
   return a new replacement class file.


   There are two kinds of transformers, determined by the canRetransform
   parameter of
   Instrumentation.addTransformer(ClassFileTransformer,boolean):

      retransformation capable transformers that were added with
          canRetransform as true

      retransformation incapable transformers that were added with
          canRetransform as false or where added with
          Instrumentation.addTransformer(ClassFileTransformer)




   Once a transformer has been registered with
   addTransformer,
   the transformer will be called for every new class definition and every class redefinition.
   Retransformation capable transformers will also be called on every class retransformation.
   The request for a new class definition is made with
   ClassLoader.defineClass
   or its native equivalents.
   The request for a class redefinition is made with
   Instrumentation.redefineClasses
   or its native equivalents.
   The request for a class retransformation is made with
   Instrumentation.retransformClasses
   or its native equivalents.
   The transformer is called during the processing of the request, before the class file bytes
   have been verified or applied.
   When there are multiple transformers, transformations are composed by chaining the
   transform calls.
   That is, the byte array returned by one call to transform becomes the input
   (via the classfileBuffer parameter) to the next call.


   Transformations are applied in the following order:

      Retransformation incapable transformers

      Retransformation incapable native transformers

      Retransformation capable transformers

      Retransformation capable native transformers




   For retransformations, the retransformation incapable transformers are not
   called, instead the result of the previous transformation is reused.
   In all other cases, this method is called.
   Within each of these groupings, transformers are called in the order registered.
   Native transformers are provided by the ClassFileLoadHook event
   in the Java Virtual Machine Tool Interface).


   The input (via the classfileBuffer parameter) to the first
   transformer is:

      for new class definition,
          the bytes passed to ClassLoader.defineClass

      for class redefinition,
          definitions.getDefinitionClassFile() where
          definitions is the parameter to
          Instrumentation.redefineClasses

      for class retransformation,
           the bytes passed to the new class definition or, if redefined,
           the last redefinition, with all transformations made by retransformation
           incapable transformers reapplied automatically and unaltered;
           for details see
           Instrumentation.retransformClasses




   If the implementing method determines that no transformations are needed,
   it should return null.
   Otherwise, it should create a new byte[] array,
   copy the input classfileBuffer into it,
   along with all desired transformations, and return the new array.
   The input classfileBuffer must not be modified.


   In the retransform and redefine cases,
   the transformer must support the redefinition semantics:
   if a class that the transformer changed during initial definition is later
   retransformed or redefined, the
   transformer must insure that the second class output class file is a legal
   redefinition of the first output class file.


   If the transformer throws an exception (which it doesn't catch),
   subsequent transformers will still be called and the load, redefine
   or retransform will still be attempted.
   Thus, throwing an exception has the same effect as returning null.
   To prevent unexpected behavior when unchecked exceptions are generated
   in transformer code, a transformer can catch Throwable.
   If the transformer believes the classFileBuffer does not
   represent a validly formatted class file, it should throw
   an IllegalClassFormatException;
   while this has the same effect as returning null. it facilitates the
   logging or debugging of format corruptions.

  loader - the defining loader of the class to be transformed, may be null if the bootstrap loader - `java.lang.ClassLoader`
  class-name - the name of the class in the internal form of fully qualified class and interface names as defined in The Java Virtual Machine Specification. For example, `java/util/List`. - `java.lang.String`
  class-being-redefined - if this is triggered by a redefine or retransform, the class being redefined or retransformed; if this is a class load, null - `java.lang.Class<?>`
  protection-domain - the protection domain of the class being defined or redefined - `java.security.ProtectionDomain`
  classfile-buffer - the input byte buffer in class file format - must not be modified - `byte[]`

  returns: a well-formed class file buffer (the result of the transform),
                  or null if no transform is performed. - `byte[]`

  throws: java.lang.instrument.IllegalClassFormatException - if the input does not represent a well-formed class file"
  ([^java.lang.instrument.ClassFileTransformer this ^java.lang.ClassLoader loader ^java.lang.String class-name ^java.lang.Class class-being-redefined ^java.security.ProtectionDomain protection-domain classfile-buffer]
    (-> this (.transform loader class-name class-being-redefined protection-domain classfile-buffer))))

