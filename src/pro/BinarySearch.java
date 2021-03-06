package pro;
/**
 * 二分查找
 * @author kangpan
 *
 */
public class BinarySearch {
	
	public static int rank(int[] arr,int key) {
		int lo = 0;
		int hi = arr.length - 1;
		while(lo <= hi) {
			int mid = lo + (hi - lo)/2;
			if(key < arr[mid]) {
				hi = mid - 1;
			}else if (key > arr[mid]) {
				lo = mid + 1;
			}else {
				return mid;
			}
		}
		return -1;		
	}
}
