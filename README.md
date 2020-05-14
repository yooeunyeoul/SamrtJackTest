# SamrtJackTest
스마트잭 테스트 


디자인 패턴 : MVVM 적용 

DI = Dagger

뷰 바인딩 : DataBinding  

비동기 처리 : RxJava

바코드 라이브러리 : Zxing

네트워킹 : retrofit2 + okHttp3 + Gson




####################알고리즘 테스트 로직입니다. #######################
```java
public class TestClass {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Map<Integer, ArrayList<Integer>> rockPosMap = new HashMap<>();
		Map<Integer, Integer> rockCountMap = new HashMap<>();
		Map<Integer, Integer> frogJumpMap = new HashMap<>();
		
		
		System.out.println("테스트 할 횟수를 입력하세요"); 
	    int caseCount =sc.nextInt();
	      
	  
	    
	    for (int i = 0; i < caseCount; i++) {
            ArrayList<Integer> rockPositionList = new ArrayList<>();
            rockPositionList.add(0);
            
            System.out.println(i+"번째 테스트 돌의 갯수를 입력하세요"); 
    	    int rockCount =sc.nextInt();
      

            for (int j = 0; j < rockCount; j++) {
                System.out.println(i+"번째 테스트 돌의 "+ j+"번위치를 입력하세요");
                Scanner sc2 = new Scanner(System.in);
                int rockPos = sc2.nextInt();
                rockPositionList.add(rockPos);
                
            
        	    
            }

            System.out.println(i+"번째 테스트 개구리 최대 점프 거리를 입력하세요"); 
    	    int maxJumpCount =sc.nextInt();
    	    
    	    rockPosMap.put(i, rockPositionList);
    	    
    	    rockCountMap.put(i,rockCount+1);
    	    
            frogJumpMap.put(i, maxJumpCount);
            
        }
	    
        for (int i = 0; i < caseCount; i++) {

            System.out.println("Case #" + i + 1);
            
            ArrayList<Integer> rockPosition = rockPosMap.get(i);
           int k = frogJumpMap.get(i);
           int minJumpCount =0;
            
            
            outerloop:
            	
            for (int j = 0; j < rockPosition.size(); j++) {
                int prePos = rockPosition.get(j);
                Boolean isGoNext = false;
                for (int l = j + 1; l < rockPosition.size(); l++) {
                    int nextRockPosition = l+1;
                    int rockLength = rockPosition.get(l) - prePos;

                    //뜀박질이 더 넓을 때
                    if (k > rockLength) {


//                        // 다음 돌이 마지막 돌일 때
                        if (nextRockPosition == rockPosition.size()) {
                            minJumpCount = minJumpCount + 1;
                            break outerloop;
                        }


                        isGoNext = true;

                        //뜀박질이 같을 때
                    } else if (k == rockLength) {
                        minJumpCount = minJumpCount + 1;
                        j = l - 1;
                        break;

                        //뜀박질이 적을 때
                    } else if (k < rockLength) {
                        // 한번이라도 뛰어넘은 적이 있을 
                        if (isGoNext) {
                            minJumpCount = minJumpCount + 1;
                            j = l - 2;
                            break;
                        } else {
                            minJumpCount = -1;
                            break outerloop;
                        }

                    }
                }

            }

            System.out.println(minJumpCount);
        }

	        
	}
}
```






