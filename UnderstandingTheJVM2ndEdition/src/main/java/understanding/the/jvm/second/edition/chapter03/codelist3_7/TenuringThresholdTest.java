package understanding.the.jvm.second.edition.chapter03.codelist3_7;

/**
*VM参数：-verbose：gc-Xms20M-Xmx20M-Xmn10M-XX：+PrintGCDetails-XX：SurvivorRatio=8-XX：MaxTenuringThreshold=1
*-XX：+PrintTenuringDistribution
*/
public class TenuringThresholdTest {

	private static final int _1MB=1024*1024;
	@SuppressWarnings("unused")
	public static void main(String[] args){
		byte[] allocation1, allocation2, allocation3;
		allocation1 = new byte[_1MB/4];
		//什么时候进入老年代取决于XX：MaxTenuringThreshold设置
		allocation2 = new byte[4*_1MB];
		allocation3 = new byte[4*_1MB];
		allocation3 = null;
		allocation3 = new byte[4*_1MB];
	}
}
/*
******以MaxTenuringThreshold=1参数来运行的结果：*****
[GC[DefNew
Desired survivor size 524288 bytes, new threshold 1 (max 1)
- age   1:     749808 bytes,     749808 total
: 5352K->732K(9216K), 0.0032525 secs] 5352K->4828K(19456K), 0.0032904 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC[DefNew
Desired survivor size 524288 bytes, new threshold 1 (max 1)
- age   1:        136 bytes,        136 total
: 4912K->0K(9216K), 0.0013327 secs] 9008K->4827K(19456K), 0.0013504 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
Heap
 def new generation   total 9216K, used 4178K [0x00000000f9a00000, 0x00000000fa400000, 0x00000000fa400000)
  eden space 8192K,  51% used [0x00000000f9a00000, 0x00000000f9e14820, 0x00000000fa200000)
  from space 1024K,   0% used [0x00000000fa200000, 0x00000000fa200088, 0x00000000fa300000)
  to   space 1024K,   0% used [0x00000000fa300000, 0x00000000fa300000, 0x00000000fa400000)
 tenured generation   total 10240K, used 4827K [0x00000000fa400000, 0x00000000fae00000, 0x00000000fae00000)
   the space 10240K,  47% used [0x00000000fa400000, 0x00000000fa8b6db8, 0x00000000fa8b6e00, 0x00000000fae00000)
 compacting perm gen  total 21248K, used 2616K [0x00000000fae00000, 0x00000000fc2c0000, 0x0000000100000000)
   the space 21248K,  12% used [0x00000000fae00000, 0x00000000fb08e390, 0x00000000fb08e400, 0x00000000fc2c0000)
No shared spaces configured.

******以MaxTenuringThreshold=15参数来运行的结果：*****JDK1.7
[GC[DefNew
Desired survivor size 524288 bytes, new threshold 1 (max 15)
- age   1:     749808 bytes,     749808 total
: 5187K->732K(9216K), 0.0034142 secs] 5187K->4828K(19456K), 0.0034518 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC[DefNew
Desired survivor size 524288 bytes, new threshold 15 (max 15)
- age   1:        104 bytes,        104 total
: 4992K->0K(9216K), 0.0012465 secs] 9088K->4828K(19456K), 0.0012617 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
Heap
 def new generation   total 9216K, used 4260K [0x00000000f9a00000, 0x00000000fa400000, 0x00000000fa400000)
  eden space 8192K,  52% used [0x00000000f9a00000, 0x00000000f9e28ff0, 0x00000000fa200000)
  from space 1024K,   0% used [0x00000000fa200000, 0x00000000fa200068, 0x00000000fa300000)
  to   space 1024K,   0% used [0x00000000fa300000, 0x00000000fa300000, 0x00000000fa400000)
 tenured generation   total 10240K, used 4828K [0x00000000fa400000, 0x00000000fae00000, 0x00000000fae00000)
   the space 10240K,  47% used [0x00000000fa400000, 0x00000000fa8b7100, 0x00000000fa8b7200, 0x00000000fae00000)
 compacting perm gen  total 21248K, used 2616K [0x00000000fae00000, 0x00000000fc2c0000, 0x0000000100000000)
   the space 21248K,  12% used [0x00000000fae00000, 0x00000000fb08e390, 0x00000000fb08e400, 0x00000000fc2c0000)
No shared spaces configured.
 
******以MaxTenuringThreshold=15参数来运行的结果：*****JDK1.6
[GC [DefNew
Desired survivor size 524288 bytes, new threshold 15 (max 15)
- age   1:     419968 bytes,     419968 total
: 4859K->410K(9216K), 0.0023804 secs] 4859K->4506K(19456K), 0.0023979 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC [DefNew
Desired survivor size 524288 bytes, new threshold 15 (max 15)
- age   2:     419968 bytes,     419968 total
: 4506K->410K(9216K), 0.0004105 secs] 8602K->4506K(19456K), 0.0004245 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
Heap
 def new generation   total 9216K, used 4588K [0x046d0000, 0x050d0000, 0x050d0000)
  eden space 8192K,  51% used [0x046d0000, 0x04ae4828, 0x04ed0000)
  from space 1024K,  40% used [0x04ed0000, 0x04f36880, 0x04fd0000)
  to   space 1024K,   0% used [0x04fd0000, 0x04fd0000, 0x050d0000)
 tenured generation   total 10240K, used 4096K [0x050d0000, 0x05ad0000, 0x05ad0000)
   the space 10240K,  40% used [0x050d0000, 0x054d0010, 0x054d0200, 0x05ad0000)
 compacting perm gen  total 12288K, used 2123K [0x05ad0000, 0x066d0000, 0x09ad0000)
   the space 12288K,  17% used [0x05ad0000, 0x05ce2df8, 0x05ce2e00, 0x066d0000)
No shared spaces configured. 
 */ 
