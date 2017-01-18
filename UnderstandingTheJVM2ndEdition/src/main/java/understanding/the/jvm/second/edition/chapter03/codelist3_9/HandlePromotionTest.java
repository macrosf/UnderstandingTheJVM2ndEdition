package understanding.the.jvm.second.edition.chapter03.codelist3_9;

/**
*VM参数：-Xms20M-Xmx20M-Xmn10M-XX：+PrintGCDetails-XX：SurvivorRatio=8-XX：-HandlePromotionFailure
*/
public class HandlePromotionTest {

	private static final int _1MB=1024*1024;
	@SuppressWarnings("unused")
	public static void main(String[] args){
		byte[] allocation1, allocation2, allocation3, allocation4,
			   allocation5, allocation6, allocation7;
		allocation1 = new byte[2*_1MB];
		allocation2 = new byte[2*_1MB];
		allocation3 = new byte[2*_1MB];
		allocation1 = null;
		allocation4 = new byte[2*_1MB];
		allocation5 = new byte[2*_1MB];
		allocation6 = new byte[2*_1MB];
		allocation4 = null;
		allocation5 = null;
		allocation6 = null;
		allocation7 = new byte[2*_1MB];
	}
}
/*
****以HandlePromotionFailure=false参数来运行的结果：****(一次minor GC，一次full GC)
[GC [DefNew
Desired survivor size 524288 bytes, new threshold 15 (max 15)
- age   1:     157784 bytes,     157784 total
: 6651K->154K(9216K), 0.0025400 secs] 6651K->4250K(19456K), 0.0025633 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC [DefNew: 6384K->6384K(9216K), 0.0000075 secs][Tenured: 4096K->4250K(10240K), 0.0030622 secs] 10480K->4250K(19456K), [Perm : 2114K->2114K(12288K)], 0.0031013 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
Heap
 def new generation   total 9216K, used 2211K [0x04620000, 0x05020000, 0x05020000)
  eden space 8192K,  27% used [0x04620000, 0x04848fd8, 0x04e20000)
  from space 1024K,   0% used [0x04f20000, 0x04f20000, 0x05020000)
  to   space 1024K,   0% used [0x04e20000, 0x04e20000, 0x04f20000)
 tenured generation   total 10240K, used 4250K [0x05020000, 0x05a20000, 0x05a20000)
   the space 10240K,  41% used [0x05020000, 0x05446878, 0x05446a00, 0x05a20000)
 compacting perm gen  total 12288K, used 2123K [0x05a20000, 0x06620000, 0x09a20000)
   the space 12288K,  17% used [0x05a20000, 0x05c32ea8, 0x05c33000, 0x06620000)
No shared spaces configured.

****以HandlePromotionFailure=true参数来运行的结果：***(两次full GC)
[GC [DefNew
Desired survivor size 524288 bytes, new threshold 15 (max 15)
- age   1:     157784 bytes,     157784 total
: 6651K->154K(9216K), 0.0023549 secs] 6651K->4250K(19456K), 0.0023717 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC [DefNew
Desired survivor size 524288 bytes, new threshold 15 (max 15)
- age   2:     157784 bytes,     157784 total
: 6384K->154K(9216K), 0.0003586 secs] 10480K->4250K(19456K), 0.0003813 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
Heap
 def new generation   total 9216K, used 2366K [0x04760000, 0x05160000, 0x05160000)
  eden space 8192K,  27% used [0x04760000, 0x04988fd8, 0x04f60000)
  from space 1024K,  15% used [0x04f60000, 0x04f86858, 0x05060000)
  to   space 1024K,   0% used [0x05060000, 0x05060000, 0x05160000)
 tenured generation   total 10240K, used 4096K [0x05160000, 0x05b60000, 0x05b60000)
   the space 10240K,  40% used [0x05160000, 0x05560020, 0x05560200, 0x05b60000)
 compacting perm gen  total 12288K, used 2123K [0x05b60000, 0x06760000, 0x09b60000)
   the space 12288K,  17% used [0x05b60000, 0x05d72ea8, 0x05d73000, 0x06760000)
No shared spaces configured.
 */ 
