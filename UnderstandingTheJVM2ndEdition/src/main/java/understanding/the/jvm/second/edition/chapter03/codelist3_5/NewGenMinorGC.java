package understanding.the.jvm.second.edition.chapter03.codelist3_5;

/**
 * VM参数：
 * -verbose：gc-Xms20M-Xmx20M-Xmn10M
 * -XX：+PrintGCDetails
 * -XX：SurvivorRatio=8
 * *********说明：************
 * -Xms20M、-Xmx20M、-Xmn10M这3个参数限制了Java堆大小为20MB，不可扩 展，
 * 其中10MB分配给新生代，剩下的10MB分配给老年代。
 * -XX：SurvivorRatio=8决定了新生代中Eden区与一个Survivor区的空间比例是8:1，新生代总可用空间为 9216KB（Eden区+1个Survivor区的总容量）。
 */
public class NewGenMinorGC {
	private static final int _1MB=1024*1024;
	
	@SuppressWarnings("unused")
	public static void main(String[] args){
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[2*_1MB];
		allocation2 = new byte[2*_1MB];
		allocation3 = new byte[2*_1MB];
		allocation4 = new byte[2*_1MB];
	}
}
/* 默认的收集器(Parallel Scavenge + Parallel Old)
[GC [PSYoungGen: 7144K->584K(9216K)] 7144K->6728K(19456K), 0.0024703 secs] [Times: user=0.02 sys=0.00, real=0.00 secs] 
[Full GC [PSYoungGen: 584K->0K(9216K)] [ParOldGen: 6144K->6618K(10240K)] 6728K->6618K(19456K) [PSPermGen: 2608K->2607K(21504K)], 0.0082979 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
Heap
 PSYoungGen      total 9216K, used 2213K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
  eden space 8192K, 27% used [0x00000000ff600000,0x00000000ff8297b0,0x00000000ffe00000)
  from space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
  to   space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
 ParOldGen       total 10240K, used 6618K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
  object space 10240K, 64% used [0x00000000fec00000,0x00000000ff276ae8,0x00000000ff600000)
 PSPermGen       total 21504K, used 2614K [0x00000000f9a00000, 0x00000000faf00000, 0x00000000fec00000)
  object space 21504K, 12% used [0x00000000f9a00000,0x00000000f9c8d8d0,0x00000000faf00000)
  
*************添加参数-XX:UseSerialGC (Serial + Serial Old)
[GC[DefNew: 6979K->476K(9216K), 0.0037311 secs] 6979K->6620K(19456K), 0.0037666 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
Heap
 def new generation   total 9216K, used 2769K [0x00000000f9a00000, 0x00000000fa400000, 0x00000000fa400000)
  eden space 8192K,  28% used [0x00000000f9a00000, 0x00000000f9c3d7e0, 0x00000000fa200000)
  from space 1024K,  46% used [0x00000000fa300000, 0x00000000fa377018, 0x00000000fa400000)
  to   space 1024K,   0% used [0x00000000fa200000, 0x00000000fa200000, 0x00000000fa300000)
 tenured generation   total 10240K, used 6144K [0x00000000fa400000, 0x00000000fae00000, 0x00000000fae00000)
   the space 10240K,  60% used [0x00000000fa400000, 0x00000000faa00030, 0x00000000faa00200, 0x00000000fae00000)
 compacting perm gen  total 21248K, used 2615K [0x00000000fae00000, 0x00000000fc2c0000, 0x0000000100000000)
   the space 21248K,  12% used [0x00000000fae00000, 0x00000000fb08dc58, 0x00000000fb08de00, 0x00000000fc2c0000)
No shared spaces configured.

*************添加参数-XX:+UseParNewGC (ParNew + Serial Old)
[GC[ParNew: 6979K->501K(9216K), 0.0024669 secs] 6979K->6645K(19456K), 0.0025095 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
Heap
 par new generation   total 9216K, used 2795K [0x00000000f9a00000, 0x00000000fa400000, 0x00000000fa400000)
  eden space 8192K,  28% used [0x00000000f9a00000, 0x00000000f9c3d7e0, 0x00000000fa200000)
  from space 1024K,  49% used [0x00000000fa300000, 0x00000000fa37d768, 0x00000000fa400000)
  to   space 1024K,   0% used [0x00000000fa200000, 0x00000000fa200000, 0x00000000fa300000)
 tenured generation   total 10240K, used 6144K [0x00000000fa400000, 0x00000000fae00000, 0x00000000fae00000)
   the space 10240K,  60% used [0x00000000fa400000, 0x00000000faa00030, 0x00000000faa00200, 0x00000000fae00000)
 compacting perm gen  total 21248K, used 2615K [0x00000000fae00000, 0x00000000fc2c0000, 0x0000000100000000)
   the space 21248K,  12% used [0x00000000fae00000, 0x00000000fb08dc58, 0x00000000fb08de00, 0x00000000fc2c0000)
No shared spaces configured.

*************添加参数-XX:+UseConcMarkSweepGC (ParNew + CMS + Serial Old(Serial Old收集器将作为CMS收集器出现Concurrent Mode Failure失败后的后备收集器使用))
[GC[ParNew: 7144K->493K(9216K), 0.0083312 secs] 7144K->6639K(19456K), 0.0083726 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
[GC [1 CMS-initial-mark: 6146K(10240K)] 8687K(19456K), 0.0002805 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
Heap
 par new generation   total 9216K, used 2707K [0x00000000f9a00000, 0x00000000fa400000, 0x00000000fa400000)
  eden space 8192K,  27% used [0x00000000f9a00000, 0x00000000f9c297b0, 0x00000000fa200000)
  from space 1024K,  48% used [0x00000000fa300000, 0x00000000fa37b768, 0x00000000fa400000)
  to   space 1024K,   0% used [0x00000000fa200000, 0x00000000fa200000, 0x00000000fa300000)
 concurrent mark-sweep generation total 10240K, used 6146K [0x00000000fa400000, 0x00000000fae00000, 0x00000000fae00000)
 concurrent-mark-sweep perm gen total 21248K, used 2616K [0x00000000fae00000, 0x00000000fc2c0000, 0x0000000100000000)
[CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 
[CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
*/