package understanding.the.jvm.second.edition.chapter06.codelist6_5;

public class ExceptionTableDemo {
	public static int inc() throws Exception{
		int x;
		try{
			x=1;
			//throw new Exception();
			return x;
		}catch(RuntimeException e){
			x=2;
			return x;
		}finally{
			x=3;
		}
	}
	
	public static void main(String[] args) throws Exception{
		System.out.println("x="+inc());
	}
}

/*
Classfile /C:/Users/2000105922/git/UnderstandingTheJVM2ndEdition/UnderstandingTheJVM2ndEdition/target/classes/understanding/the/jvm/second/edition/chapter06/codelist6_5/ExceptionTableDemo.class
Last modified 2017-1-31; size 1146 bytes
MD5 checksum 814ac9c3934dc9bc2b10667f627aa050
Compiled from "ExceptionTableDemo.java"
public class understanding.the.jvm.second.edition.chapter06.codelist6_5.ExceptionTableDemo
minor version: 0
major version: 49
flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
 #1 = Class              #2             // understanding/the/jvm/second/edition/chapter06/codelist6_5/ExceptionTableDemo
 #2 = Utf8               understanding/the/jvm/second/edition/chapter06/codelist6_5/ExceptionTableDemo
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
#13 = Utf8               Lunderstanding/the/jvm/second/edition/chapter06/codelist6_5/ExceptionTableDemo;
#14 = Utf8               inc
#15 = Utf8               ()I
#16 = Utf8               Exceptions
#17 = Class              #18            // java/lang/Exception
#18 = Utf8               java/lang/Exception
#19 = Class              #20            // java/lang/RuntimeException
#20 = Utf8               java/lang/RuntimeException
#21 = Utf8               x
#22 = Utf8               I
#23 = Utf8               e
#24 = Utf8               Ljava/lang/RuntimeException;
#25 = Utf8               main
#26 = Utf8               ([Ljava/lang/String;)V
#27 = Fieldref           #28.#30        // java/lang/System.out:Ljava/io/PrintStream;
#28 = Class              #29            // java/lang/System
#29 = Utf8               java/lang/System
#30 = NameAndType        #31:#32        // out:Ljava/io/PrintStream;
#31 = Utf8               out
#32 = Utf8               Ljava/io/PrintStream;
#33 = Class              #34            // java/lang/StringBuilder
#34 = Utf8               java/lang/StringBuilder
#35 = String             #36            // x=
#36 = Utf8               x=
#37 = Methodref          #33.#38        // java/lang/StringBuilder."<init>":(Ljava/lang/String;)V
#38 = NameAndType        #5:#39         // "<init>":(Ljava/lang/String;)V
#39 = Utf8               (Ljava/lang/String;)V
#40 = Methodref          #1.#41         // understanding/the/jvm/second/edition/chapter06/codelist6_5/ExceptionTableDemo.inc:()I
#41 = NameAndType        #14:#15        // inc:()I
#42 = Methodref          #33.#43        // java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
#43 = NameAndType        #44:#45        // append:(I)Ljava/lang/StringBuilder;
#44 = Utf8               append
#45 = Utf8               (I)Ljava/lang/StringBuilder;
#46 = Methodref          #33.#47        // java/lang/StringBuilder.toString:()Ljava/lang/String;
#47 = NameAndType        #48:#49        // toString:()Ljava/lang/String;
#48 = Utf8               toString
#49 = Utf8               ()Ljava/lang/String;
#50 = Methodref          #51.#53        // java/io/PrintStream.println:(Ljava/lang/String;)V
#51 = Class              #52            // java/io/PrintStream
#52 = Utf8               java/io/PrintStream
#53 = NameAndType        #54:#39        // println:(Ljava/lang/String;)V
#54 = Utf8               println
#55 = Utf8               args
#56 = Utf8               [Ljava/lang/String;
#57 = Utf8               SourceFile
#58 = Utf8               ExceptionTableDemo.java
{
public understanding.the.jvm.second.edition.chapter06.codelist6_5.ExceptionTableDemo();
  descriptor: ()V
  flags: ACC_PUBLIC
  Code:
    stack=1, locals=1, args_size=1
       0: aload_0
       1: invokespecial #8                  // Method java/lang/Object."<init>":()V
       4: return
    LineNumberTable:
      line 3: 0
    LocalVariableTable:
      Start  Length  Slot  Name   Signature
          0       5     0  this   Lunderstanding/the/jvm/second/edition/chapter06/codelist6_5/ExceptionTableDemo;

public static int inc() throws java.lang.Exception;
  descriptor: ()I
  flags: ACC_PUBLIC, ACC_STATIC
  Exceptions:
    throws java.lang.Exception
  Code:
    stack=1, locals=4, args_size=0
       0: iconst_1
       1: istore_0
       2: iload_0
       3: istore_3
       4: iconst_3
       5: istore_0
       6: iload_3
       7: ireturn
       8: astore_1
       9: iconst_2
      10: istore_0
      11: iload_0
      12: istore_3
      13: iconst_3
      14: istore_0
      15: iload_3
      16: ireturn
      17: astore_2
      18: iconst_3
      19: istore_0
      20: aload_2
      21: athrow
    Exception table:
       from    to  target type
           0     4     8   Class java/lang/RuntimeException
           0     4    17   any
           8    13    17   any
    LineNumberTable:
      line 7: 0
      line 9: 2
      line 14: 4
      line 9: 6
      line 10: 8
      line 11: 9
      line 12: 11
      line 14: 13
      line 12: 15
      line 13: 17
      line 14: 18
      line 15: 20
    LocalVariableTable:
      Start  Length  Slot  Name   Signature
          2       6     0     x   I
         11       6     0     x   I
         20       2     0     x   I
          9       8     1     e   Ljava/lang/RuntimeException;

public static void main(java.lang.String[]) throws java.lang.Exception;
  descriptor: ([Ljava/lang/String;)V
  flags: ACC_PUBLIC, ACC_STATIC
  Exceptions:
    throws java.lang.Exception
  Code:
    stack=4, locals=1, args_size=1
       0: getstatic     #27                 // Field java/lang/System.out:Ljava/io/PrintStream;
       3: new           #33                 // class java/lang/StringBuilder
       6: dup
       7: ldc           #35                 // String x=
       9: invokespecial #37                 // Method java/lang/StringBuilder."<init>":(Ljava/lang/String;)V
      12: invokestatic  #40                 // Method inc:()I
      15: invokevirtual #42                 // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
      18: invokevirtual #46                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      21: invokevirtual #50                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      24: return
    LineNumberTable:
      line 19: 0
      line 20: 24
    LocalVariableTable:
      Start  Length  Slot  Name   Signature
          0      25     0  args   [Ljava/lang/String;
}
SourceFile: "ExceptionTableDemo.java"
*/