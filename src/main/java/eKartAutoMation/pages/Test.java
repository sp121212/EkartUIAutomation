package eKartAutoMation.pages;


public class Test {
	
	public static ThreadLocal<Integer> intTL=new ThreadLocal<>();
	public static void main(String[] args) {
		
//		Map<String, String>  mapList=new HashMap<>();
//		
//		mapList.put("1", "TEST1");
//		mapList.put("2", "TEST1");
//		mapList.put("3", "TEST1");
//		mapList.put("4", "TEST1");
//		
//		System.out.println(mapList);
		
		intTL.set(100);
		intTL.set(50);
		intTL.set(150);
		intTL.set(200);
		
		
		System.out.println(getINT());
		System.out.println(getINT());
		
		System.out.println(getINT());
		System.out.println(getINT());
		System.out.println(getINT());
	}

	
	public static Integer getINT() {
	return	intTL.get();
	}
}
