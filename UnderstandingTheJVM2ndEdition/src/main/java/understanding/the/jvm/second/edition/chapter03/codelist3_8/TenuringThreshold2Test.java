package understanding.the.jvm.second.edition.chapter03.codelist3_8;

/**
*VM参数：-verbose：gc-Xms20M-Xmx20M-Xmn10M-XX：+PrintGCDetails-XX：SurvivorRatio=8-XX：MaxTenuringThreshold=15
*-XX：+PrintTenuringDistribution
*/
public class TenuringThreshold2Test {

	private static final int _1MB = 1024*1024;
	
	@SuppressWarnings("unused")
	public static void main(String[] args){
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[_1MB/4];
		//allocation1+allocation2大于survivo空间一半
		allocation2 = new byte[_1MB/4];
		allocation3 = new byte[4*_1MB];
		allocation4 = new byte[4*_1MB];
		allocation4 = null;
		allocation4 = new byte[4*_1MB];
	}
}

/*
[GC [DefNew
Desired survivor size 524288 bytes, new threshold 1 (max 15)
- age   1:     682128 bytes,     682128 total
: 5115K->666K(9216K), 0.0026774 secs] 5115K->4762K(19456K), 0.0026977 secs] [Times: user=0.02 sys=0.00, real=0.00 secs] 
[GC [DefNew
Desired survivor size 524288 bytes, new threshold 15 (max 15)
: 4762K->0K(9216K), 0.0006649 secs] 8858K->4762K(19456K), 0.0006799 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
Heap
 def new generation   total 9216K, used 4178K [0x04670000, 0x05070000, 0x05070000)
  eden space 8192K,  51% used [0x04670000, 0x04a84828, 0x04e70000)
  from space 1024K,   0% used [0x04e70000, 0x04e70000, 0x04f70000)
  to   space 1024K,   0% used [0x04f70000, 0x04f70000, 0x05070000)
 tenured generation   total 10240K, used 4762K [0x05070000, 0x05a70000, 0x05a70000)
   the space 10240K,  46% used [0x05070000, 0x055168a0, 0x05516a00, 0x05a70000)
 compacting perm gen  total 12288K, used 2123K [0x05a70000, 0x06670000, 0x09a70000)
   the space 12288K,  17% used [0x05a70000, 0x05c82e20, 0x05c83000, 0x06670000)
No shared spaces configured.

****注释掉--> allocation2 = new byte[_1MB/4]; <--这句话后后的执行结果（注意第二次minor GC后DefNew里面剩余了409K数据：“4506K->409K(9216K),”） 注：jre=1.6
[GC [DefNew
Desired survivor size 524288 bytes, new threshold 15 (max 15)
- age   1:     419968 bytes,     419968 total
: 4859K->410K(9216K), 0.0024859 secs] 4859K->4506K(19456K), 0.0025030 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC [DefNew
Desired survivor size 524288 bytes, new threshold 15 (max 15)
- age   2:     419824 bytes,     419824 total
: 4506K->409K(9216K), 0.0004500 secs] 8602K->4506K(19456K), 0.0004650 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
Heap
 def new generation   total 9216K, used 4588K [0x046c0000, 0x050c0000, 0x050c0000)
  eden space 8192K,  51% used [0x046c0000, 0x04ad4828, 0x04ec0000)
  from space 1024K,  40% used [0x04ec0000, 0x04f267f0, 0x04fc0000)
  to   space 1024K,   0% used [0x04fc0000, 0x04fc0000, 0x050c0000)
 tenured generation   total 10240K, used 4096K [0x050c0000, 0x05ac0000, 0x05ac0000)
   the space 10240K,  40% used [0x050c0000, 0x054c0010, 0x054c0200, 0x05ac0000)
 compacting perm gen  total 12288K, used 2123K [0x05ac0000, 0x066c0000, 0x09ac0000)
   the space 12288K,  17% used [0x05ac0000, 0x05cd2df8, 0x05cd2e00, 0x066c0000)
No shared spaces configured.

 */
