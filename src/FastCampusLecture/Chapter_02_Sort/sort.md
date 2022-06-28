## 2. 정렬

### 1. 정렬 조건이 필요하다. 
```java
static class Elem implements Comparable<Elem>{
    
    @Override
    public int compareTo(Elem other){
        return num - other.num;
        /*
         * 이때 음수 return : 전자가 먼저
         * 이떄 양수 return : 후자자 먼저
         * 0 : 동일 
         * */
    }
}
```
### 2. 정렬 알고리즘은 평균 N logN 만큼의 시간복잡도를 갖는다.

### 3. In-place / stable 여부를 알아야 한다.

- 정렬 알고리즘이 in-place (제자리) 한지? 즉 메모리를 추가로 더쓰는지
- stable(안정) 한지? 동등한 위상의 원소들의 순서 관계가 보존되는지
- Array.sort 의 경우 int , double 과 같은 원소 정렬은 in-place 
- object 의 경우 stable sort

### 4. 정렬의 특성

- 같은 정보들은 인접해 있을 것이다.
- 각 원소마다, 가장 가까운 원소는 자신의 양 옆중에 있다.
