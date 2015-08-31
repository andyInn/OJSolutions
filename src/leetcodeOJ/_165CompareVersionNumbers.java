package leetcodeOJ;

public class _165CompareVersionNumbers {
	public static int compareVersion(String version1, String version2) {
		String[] arr1 = version1.split("\\.");
		String[] arr2 = version2.split("\\.");
		int len1 = arr1.length, len2 = arr2.length, min=Math.min(len1, len2), i=0;
		for (; i<min; i++) {
			if (Integer.valueOf(arr1[i]) > Integer.valueOf(arr2[i]))
				return 1;
			if (Integer.valueOf(arr1[i]) < Integer.valueOf(arr2[i]))
				return -1;
		}
		if(len1>len2){
			while(i<len1){
				if(Integer.valueOf(arr1[i]) > 0)
					return 1;
				i++;
			}
		}else if(len1<len2){
			while(i<len2){
				if(Integer.valueOf(arr2[i]) > 0)
					return -1;
				i++;
			}
		}
		return 0;
	}

	public static void main(String... strings) {
//		System.out.println(compareVersion("5", "3"));
//		System.out.println(compareVersion("5", "8"));
//		System.out.println(compareVersion("3", "3"));
//		System.out.println(compareVersion("5.6", "5.17"));
//		System.out.println(compareVersion("5.8", "5.4"));
//		System.out.println(compareVersion("5.", "5.0"));
//		System.out.println(compareVersion("5", "5.0"));
//		System.out.println(compareVersion("5", "5.3"));
//		System.out.println(compareVersion("5.9", "5"));
//		System.out.println(compareVersion("5.9", "5.9.1"));
		System.out.println(compareVersion("5.9.2", "5.9."));
		System.out.println(compareVersion("5.9.0", "5.9."));
		System.out.println(compareVersion("5.9.0", "5.9.0.1"));
		System.out.println(compareVersion("5.9.0", "5.9.0.0."));
	}
}
