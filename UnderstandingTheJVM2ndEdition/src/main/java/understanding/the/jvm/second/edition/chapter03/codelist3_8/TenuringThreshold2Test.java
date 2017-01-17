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
[GC[DefNew
Desired survivor size 524288 bytes, new threshold 1 (max 15)
- age   1:    1012176 bytes,    1012176 total
: 5443K->988K(9216K), 0.0030681 secs] 5443K->5084K(19456K), 0.0031038 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC[DefNew
Desired survivor size 524288 bytes, new threshold 15 (max 15)
- age   1:        136 bytes,        136 total
: 5248K->0K(9216K), 0.0014303 secs] 9344K->5083K(19456K), 0.0015516 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
Heap
 def new generation   total 9216K, used 4260K [0x00000000f9a00000, 0x00000000fa400000, 0x00000000fa400000)
  eden space 8192K,  52% used [0x00000000f9a00000, 0x00000000f9e28fd0, 0x00000000fa200000)
  from space 1024K,   0% used [0x00000000fa200000, 0x00000000fa200088, 0x00000000fa300000)
  to   space 1024K,   0% used [0x00000000fa300000, 0x00000000fa300000, 0x00000000fa400000)
 tenured generation   total 10240K, used 5083K [0x00000000fa400000, 0x00000000fae00000, 0x00000000fae00000)
   the space 10240K,  49% used [0x00000000fa400000, 0x00000000fa8f6e98, 0x00000000fa8f7000, 0x00000000fae00000)
 compacting perm gen  total 21248K, used 2616K [0x00000000fae00000, 0x00000000fc2c0000, 0x0000000100000000)
   the space 21248K,  12% used [0x00000000fae00000, 0x00000000fb08e3a8, 0x00000000fb08e400, 0x00000000fc2c0000)
No shared spaces configured.
 */
