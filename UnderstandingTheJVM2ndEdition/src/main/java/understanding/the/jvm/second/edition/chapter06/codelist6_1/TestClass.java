package understanding.the.jvm.second.edition.chapter06.codelist6_1;

public class TestClass {
	private int m;
	public int inc(){
		return m+1;
	}
}

/*
C:\Users\2000105922>javap.exe -verboseTestClass.class

Classfile /C:/Users/2000105922/git/UnderstandingTheJVM2ndEdition/UnderstandingTheJVM2ndEdition/target/classes/understanding/the/jvm/second/edition/chapter06/codelist6_1/TestClass.class
  Last modified 2017-1-25; size 471 bytes
  MD5 checksum 3eed6c8ec4238b9ebd6fe3347a6130ee
  Compiled from "TestClass.java"
public class understanding.the.jvm.second.edition.chapter06.codelist6_1.TestClass
  minor version: 0
  major version: 49
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Class              #2             // understanding/the/jvm/second/edition/chapter06/codelist6_1/TestClass
   #2 = Utf8               understanding/the/jvm/second/edition/chapter06/codelist6_1/TestClass
   #3 = Class              #4             // java/lang/Object
   #4 = Utf8               java/lang/Object
   #5 = Utf8               m
   #6 = Utf8               I
   #7 = Utf8               <init>
   #8 = Utf8               ()V
   #9 = Utf8               Code
  #10 = Methodref          #3.#11         // java/lang/Object."<init>":()V
  #11 = NameAndType        #7:#8          // "<init>":()V
  #12 = Utf8               LineNumberTable
  #13 = Utf8               LocalVariableTable
  #14 = Utf8               this
  #15 = Utf8               Lunderstanding/the/jvm/second/edition/chapter06/codelist6_1/TestClass;
  #16 = Utf8               inc
  #17 = Utf8               ()I
  #18 = Fieldref           #1.#19         // understanding/the/jvm/second/edition/chapter06/codelist6_1/TestClass.m:I
  #19 = NameAndType        #5:#6          // m:I
  #20 = Utf8               SourceFile
  #21 = Utf8               TestClass.java
{
  public understanding.the.jvm.second.edition.chapter06.codelist6_1.TestClass();

    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #10                 // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 3: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   Lunderstanding/the/jvm/second/edition/chapter06/codelist6_1/TestClass;

  public int inc();
    descriptor: ()I
    flags: ACC_PUBLIC
    Code:
      stack=2, locals=1, args_size=1
         0: aload_0
         1: getfield      #18                 // Field m:I
         4: iconst_1
         5: iadd
         6: ireturn
      LineNumberTable:
        line 6: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       7     0  this   Lunderstanding/the/jvm/second/edition/chapter06/codelist6_1/TestClass;
}
SourceFile: "TestClass.java"
*/