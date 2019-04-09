package pdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class zhaofriend {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int index = scan.nextInt();
		HashMap<Integer, ArrayList<Integer>> totalMap = new HashMap<>();
		scan.nextLine();
		for(int i = 0; i < n; i++) {
			String tempNumStr = scan.nextLine();
			ArrayList<Integer> tempNumList = new ArrayList<>();
			for(String str : tempNumStr.split(" ")) {
				//将得到的"1 2 3"切割，做成一个字符串数组
				tempNumList.add(Integer.parseInt(str));
			}
			if(index == i || !tempNumList.contains(index)) {
				totalMap.put(i, tempNumList);
			}
		}
		ArrayList<Integer> indexFriends = totalMap.get(index);
		int max = 0;
		int res = -1;
		for(Map.Entry<Integer, ArrayList<Integer>> entry : totalMap.entrySet()) {
			ArrayList<Integer> tempFriends = entry.getValue();
			if(entry.getKey() != index) {
				tempFriends.retainAll(indexFriends);
				res = tempFriends.size() > max ? entry.getKey() : res;
				max = tempFriends.size() > max ? tempFriends.size() : max;
			}
		}
		
		System.out.println(res);
		scan.close();
	}
	
	public static Set<String> fun(String[] f) {
		Set<String> s = new HashSet<>();
		for(int i = 0; i<f.length; i++) {
			s.add(f[i]+"0");
		}
		
		return s;
	}
	
	public static void funJiaoji() {
        List<String> strList = new ArrayList<String>();
        List<String> strList2 = new ArrayList<String>();
        for(int i = 0; i < 10; i ++) {
            strList.add("aaa>>" + i);
            strList2.add("aaa>>" + (10 - i));
        }
         
        //求出交集
        strList2.retainAll(strList);
        System.out.println("交集大小：" + strList2.size());
         
        for(int i = 0; i < strList2.size(); i++) {
            System.out.println(strList2.get(i));
        }       
    }
	
	public static void funUnion() {
        List<String> strList = new ArrayList<String>();
        List<String> strList2 = new ArrayList<String>();
        for(int i = 0; i < 10; i ++) {
            strList.add("aaa>>" + i);
            strList2.add("aaa>>" + (10 - i));
        }
        //求出并集
        strList2.removeAll(strList);
        strList2.addAll(strList);
        System.out.println("并集大小：" + strList2.size());      
         
        for(int i = 0; i < strList2.size(); i++) {
            System.out.println(strList2.get(i));
        }       
    }
}
