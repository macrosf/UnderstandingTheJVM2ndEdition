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

******以MaxTenuringThreshold=15参数来运行的结果：*****
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
 
 */ 
