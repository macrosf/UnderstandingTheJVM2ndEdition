package understanding.the.jvm.second.edition.chapter08.codelist8_5;

/**
 * 方法静态解析演示
 *
 */
public class StaticResolution {
	public static void sayHello(){
		System.out.println("hello world!");
	}
	
	public static void main(String[] args){
		StaticResolution.sayHello();
	}
}

/*
Classfile /C:/Users/2000105922/git/UnderstandingTheJVM2ndEdition/UnderstandingTheJVM2ndEdition/target/classes/understanding/the/jvm/second/edition/chapter08/codelist8_5/StaticResolution.class
  Last modified 2017-2-15; size 745 bytes
  MD5 checksum c16819e7ca8ff4bcbb045a4c61c4d485
  Compiled from "StaticResolution.java"
public class understanding.the.jvm.second.edition.chapter08.codelist8_5.StaticResolution
  minor version: 0
  major version: 49
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Class              #2             // understanding/the/jvm/second/edition/chapter08/codelist8_5/StaticResolution
   #2 = Utf8               understanding/the/jvm/second/edition/chapter08/codelist8_5/StaticResolution
   #3 = Class              #4             // java/lang/Object
   #4 = Utf8               java/lang/Object
   #5 = Utf8               <init>
   #6 = Utf8               ()V
   #7 = Utf8               Code
   #8 = Methodref          #3.#9          // java/lang/Object."<init>":()V
   #9 = NameAndType        #5:#6          // "<init>":()V
  #10 = Utf8               LineNumberTable
  #11 = Utf8               LocalVariableTable
  #12 = Utf8               this
  #13 = Utf8               Lunderstanding/the/jvm/second/edition/chapter08/codelist8_5/StaticResolution;
  #14 = Utf8               sayHello
  #15 = Fieldref           #16.#18        // java/lang/System.out:Ljava/io/PrintStream;
  #16 = Class              #17            // java/lang/System
  #17 = Utf8               java/lang/System
  #18 = NameAndType        #19:#20        // out:Ljava/io/PrintStream;
  #19 = Utf8               out
  #20 = Utf8               Ljava/io/PrintStream;
  #21 = String             #22            // hello world!
  #22 = Utf8               hello world!
  #23 = Methodref          #24.#26        // java/io/PrintStream.println:(Ljava/lang/String;)V
  #24 = Class              #25            // java/io/PrintStream
  #25 = Utf8               java/io/PrintStream
  #26 = NameAndType        #27:#28        // println:(Ljava/lang/String;)V
  #27 = Utf8               println
  #28 = Utf8               (Ljava/lang/String;)V
  #29 = Utf8               main
  #30 = Utf8               ([Ljava/lang/String;)V
  #31 = Methodref          #1.#32         // understanding/the/jvm/second/edition/chapter08/codelist8_5/StaticResolution.sayHello:()V
  #32 = NameAndType        #14:#6         // sayHello:()V
  #33 = Utf8               args
  #34 = Utf8               [Ljava/lang/String;
  #35 = Utf8               SourceFile
  #36 = Utf8               StaticResolution.java
{
  public understanding.the.jvm.second.edition.chapter08.codelist8_5.StaticResolution();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #8                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 7: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   Lunderstanding/the/jvm/second/edition/chapter08/codelist8_5/StaticResolution;

  public static void sayHello();
    descriptor: ()V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=0, args_size=0
         0: getstatic     #15                 // Field java/lang/System.out:Ljava/io/PrintStream;
         3: ldc           #21                 // String hello world!
         5: invokevirtual #23                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
         8: return
      LineNumberTable:
        line 9: 0
        line 10: 8
      LocalVariableTable:
        Start  Length  Slot  Name   Signature

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=0, locals=1, args_size=1
         0: invokestatic  #31                 // Method sayHello:()V
         3: return
      LineNumberTable:
        line 13: 0
        line 14: 3
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       4     0  args   [Ljava/lang/String;
}
SourceFile: "StaticResolution.java"
 */ 
