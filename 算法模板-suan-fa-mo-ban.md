---
title: 算法模板
date: 2022-01-07 14:10:41.364
updated: 2022-01-20 18:44:59.011
url: /archives/suan-fa-mo-ban
categories: 算法
tags: 
---

[TOC](算法模板)
# 算法技巧

在做题的时候，一定要仔细读题，不要漏掉条件，写代码思维敏捷一点，在写读入的时候，要看清条件。思维敏捷一点！！！

#  算法一轮复习

## Java API复习

###  输入与输出

#### java.io.*

```java
import java.io.*;

/**
 * @author 18068
 */
public class InputAndOutput {
    public static void main(String[] args) throws IOException {
        //输入 关键是读入数据量大
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        //读入外部文件
//        BufferedReader read2 = new BufferedReader(new InputStreamReader(new FileInputStream("a.txt")));
        //写入数据
//        BufferedWriter write = new BufferedWriter(new OutputStreamWriter(System.out));

        //读入以空格为分隔的字符串数组
        String [] s =read.readLine().split(" ");
        //读入一个字符
        char c = (char) read.read();
        do{
            c = (char)read.read();
            //输出c
            System.out.println(c);
        }while (c!='e'); //满足c！='e'继续执行
        read.close();
//        write.write(2);
//        write.flush();
//        //关闭写入流，必须在之前刷新它
//        write.close();
    }
}
 String[] s = read.readLine().split("\\\s+");  //输入的空格不计
```

#### java.util.*

```
(二)java.util.Scanner
利用Scanner类进行输入之前最好使用hasNextXXX（）验证一下，在使用next()读入数据。Scanner最常用，正常情况下都是是够用；不过当输入量和输出量太大的时候（达到百万到千万），那么这种输出方式就不够用了

Scanner scan = new Scanner(System.in) ;
        if(scan.hasNext()) {
            System.out.println(scan.next());//读取到有效的字符才结束，有效字符前的空白被自动去掉，有效字符后的空白被当作结束符，因此next()不能读取有空格的字符串
        }
        if(scan.hasNext()) {
            System.out.println(scan.nextLine());//与BufferdeReader的readLine()类似，读入一行字符串以回车结束
        }
Scanner类不仅支持输入字符串，还支持基本数据类型的输入。

Scanner scan = new Scanner(System.in) ;
        int a=0,b=0 ;
        if(scan.hasNextInt()) {//double,boolean,byte…类似
            a = scan.nextInt() ;
            b = scan.nextInt() ;
        }
        System.out.println(a+b);
        scan.close();
//输入n组数据的格式

Scanner scan = new Scanner(System.in) ;
        int a,b ;
        int n = scan.nextInt() ;
        for(int i=0;i<n;i++) {
            a = scan.nextInt() ;
            b = scan.nextInt() ;
        }
        scan.close();

```

### 数组

```java
int []arr = new int[10010];
for(int i = 0; i < n; i++){
	arr[i] = sc.nextInt();
}
一维数组全部初始化：
Arrays.fill(arr,-1);
挨个使用数组里的值：
for(int x: arr){

}或者用上面的
二维数组初始化：
int[] arr = new int[110][110];
for(int[] row : arr)
    Arrays.fill(row, -1);
```

#### **判断二维数组是否为空**

1、二维数组首地址是否为空，即array==null；
2、二维数组是否为{}，即array.length==0的情况；
3、二维数组是否为{{}}，即array.length=1&&array[0].length==0的情况；

```java
if((array==null||array.length==0)||(array.length==1&&array[0].length==0))
```

#### **数组拷贝**

- 二维数组的拷贝

不能直接指向地址: 

```java
int[][] nums = new int[3][4];
int[][] arr = nums;
//这两个指向的是同一个地址
应该这样指向：
  int[][] arr = new int[3][4];
  for(int i = 0; i < n; i++){
  		arr[i] = nums[i].clone();
   }
```



- 拷贝所有元素

使用Object类的clone方法

```java
int[] a = {1,2,3}
int[] b = a.clone();
```

- 拷贝指定位置的元素

使用Arrays.copyOf方法

```java
//copyOf(oringinal, int newlength)
//oringinal:原数组      newlength:复制数组的长度
//这个方法是从原数组的起始位置开始复制，复制的长度是newlength。这个方法只能从原数组的起始位置开始复制。
int[] a = {1,2,3};
int[] b = Arrays.copyOf(a,3);
```

指定范围的拷贝，使用Arrays.copyOfRange方法

```java
//函数原型：copyOfRange(oringinal,int from, int to)
//该方法是从original数组的下标from开始复制，到下标to结束
int[] a = {1,2,3,4};
int[] b = Arrays.copyOfRange(a,2,3);
```

指定范围的拷贝（leetcode常用）

```java
//将源数组从起始位置srcPos开始将length长度的元素复制到目标数组，目标数组从destPos位置开始接收复制元素。
    int[] nums = {1, 2, 3, 0, 0, 0};
    int[] nums1 = {1, 4, 5};
    System.arraycopy(nums1, 0, nums, 3, nums1.length);

```

#### **字符数组与字符串互转**

1. 构造String时传参

```
char data[] = {'s', 'g', 'k'};
String str = new String(data);
```

2. String.valueOf(char[] chr)

```
char[] cha = {'s','g','h'};
String n = String.valueOf(cha);
```

#### **数组与list互相交换**

1. 数组转List
   1 包装类型数组（注意下面方法只能应用于包装类型数组）
           Integer[] arr = new Integer[] { 1, 2, 3 };

```java
    List<Integer> list = Arrays.asList(arr);

    for(Integer i:list)
                System.out.println(i);
```
2 基本类型数组
JAVA 8中可以采用以下方法，但需要注意只能对数字类型的数组作转换（int, long, double等）

```java
    long[] arr = {1,2,3,4};

    List<Long> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

    for(Long i:list)
        System.out.println(i+" ");
```

### 排序

#### 数组排序

Arrays.sort(arr)可以对数组按升序排序，此时arr可以是基本类型的数组(如int[], double[], char[]等)，也可以是包装类型(Integer[], Double[]等)。
Arrays.sort(arr, Collections.reverseOrder()) 可以对数组按降序排序，但此时arr只能是包装类型。
要对基本类型的数组作逆序排序。

（https://leetcode-cn.com/problems/largest-number/comments/） 力扣179 用到了包装类排序和转换成string排序。

二维数组自定义排序：

默认为从小到大排序，用参数a减参数b。若需要从大到小排序，则用参数b减参数a。（不一定是相减，从小到大排按正常思路，参数a大则返回正数；若要从大到小排，则按相反思路，参数a大则返回负数)

在排序的时候可以这样：

```java
if(o1[0]==o2[0]&&o1[1]!=o2[1]){
    return o1[1]-o2[1];
}
return o1[0]-o2[0];
```

```java
int[][] nums2 = new int[2][2];
Arrays.sort(nums2, (o1, o2) ->  o1[0] - o2[0]);
Arrays.sort(nums2, new Comparator<int[]>() {
    @Override
    public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
    }
});
```

**容器排序**

#### List排序

```java
List<Integer> list = new ArrayList<>();
//降序排序
list.sort((o1, o2) -> o2-o1);
//升序排序
list.sort((o1, o2) -> o1-o2);
```

**- 对字符串类型或者char类型排序**:

```
      List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("hard");
        stringList.add("good");
//        stringList.sort((String::compareTo));//字典序
//        stringList.sort(Comparator.naturalOrder());//字典序
//        stringList.sort((String s1, String s2)->s1.compareTo(s2));//字典序
//        stringList.sort((String s1, String s2)->s2.compareTo(s1));//逆字典序
//        stringList.sort(Comparator.reverseOrder());//逆字典序
          stringList.sort((String::lastIndexOf));//按最后一位字母的字典序
        for(String s:stringList)
            System.out.print(s+ " ");
        System.out.println();
```



#### List数组自定义排序

```java
List<List<Integer>> list = new ArrayList<>();
list.sort((o1, o2) ->  o1.get(0) - o2.get(0));
list.sort(new Comparator<List<Integer>>() {
    @Override
    public int compare(List<Integer> o1, List<Integer> o2) {
        return 0;
    }
});
```

- Map介绍

**HashMap**：最常用的Map，根据key的HashCode值来存储数据，根据key可以直接获取它的Value，具有很快的访问速度。HashMap最多只允许一条记录的key值为null(多条会覆盖)；允许多条记录的Value为null。非线程安全

**TreeMap**: 根据key排序,默认是按升序排序，也可以指定排序的比较器，遍历TreeMap时，得到的记录是排过序的。TreeMap不允许key的值为null。非线程安全

**LinkedHashMap**: 插入顺序，遍历LinkedHashMap时，先得到的记录肯定是先插入的。继承HashMap，非线程安全。

```java
HashMap<Integer,Integer> map = new HashMap<>();
map.put(1,map.getOrDefault(1,0)+1);
for(int x:map.keySet()){
	System.out.println(x+":"+map.get(x));
}
for(int x:map.values()){
    System.out.println(x);
}
```



#### TreeMap排序

TreeMap只能根据key进行排序，TreeMap本身是个二叉树，元素的顺序是由key的值决定的

TreeMap内部默认有个Comparator，在new的时候可以覆盖默认的Comparator定义自己的排序规则，不过还是只能根据key进行排序。

```
private static void sortTreeMap(){
    Map<String,String> map =new TreeMap<>((k1,k2)->{
        return k1.compareTo(k2);
    });
    map.put("a","2");
    map.put("c","5");
    map.put("d","6");
    map.put("b","1");
    map.forEach((k,v)->{
        System.out.println(k+":"+v);
    });
}
```

#### HashMap排序

HashMap本身是没有顺序的，不能直接对其进行排序

要排序，只能先转成list，然后对list排序后，再转成LinkedHasHMap

这样做排序，完全由自己定义，既可以对key排序，也可以对value排序。

```java
private static void sortMapValue(){
    Map<String,String> map =new HashMap<>();
    map.put("a","2");
    map.put("c","5");
    map.put("d","6");
    map.put("b","1");
    List<Map.Entry<String,String>> lstEntry=new ArrayList<>(map.entrySet());
    Collections.sort(lstEntry,((o1, o2) -> {
        return o1.getValue().compareTo(o2.getValue());
    }));
    lstEntry.forEach(o->{
        System.out.println(o.getKey()+":"+o.getValue());
    });

    //如果一定要返回一个map，就new一个LinkedHashMap，将list中所有值依次put进去就可以
    /*LinkedHashMap<String,String> linkedHashMap=new LinkedHashMap<>();
    lstEntry.forEach(o->{
        linkedHashMap.put(o.getKey(),o.getValue());
    });*/

}
```

#### TreeSet排序

```java
TreeSet<Integer> set = new TreeSet<Integer>((o1, o2) -> {
    return o2-o1;
});
```

### 字符串

#### String

**1 length（）字符串的长度**

```
String a = "Hello Word!";
System.out.println(a.length);
```

输出的结果是字符串长度10。

 

**2 charAt（）截取一个字符**

```
String a = "Hello Word";
System.out.println(a.charAt(1));
```

输出的结果是字符串a的下标为1的字符e。

 

**3 getchars（）截取多个字符并由其他字符串接收**

```
String a = "Hello Word";
char[] b = new char[10];
a.getChars(0, 5, b, 0);
System.out.println(b);
```

输出的结果为Hello，其中第一个参数0是要截取的字符串的初始下标（int sourceStart），第二个参数5是要截取的字符串的结束后的下一个下标（int sourceEnd）也就是实际截取到的下标是int sourceEnd-1，第三个参数是接收的字符串（char target[]），最后一个参数是接收的字符串开始接收的位置。

 

**4 getBytes()将字符串变成一个byte数组**

```
String a = "Hello Word";
byte b[] = a.getBytes();
System.out.println(new String(b));
```

输出的结果为Hello Word的byte数组。

 

**5 toCharArray()将字符串变成一个字符数组**

```
String a = "Hello Word";
char[]b = a.toCharArray();
System.out.println(b);  
```

输出的结果为Hello Word字符数组。

 

**6 equals()和\**equalsIgnoreCase()\**比较两个字符串是否相等，前者区分大小写，后者不区分**

```
String a = "Hello Word";
String b = "hello word";
System.out.println(a.equals(b));System.out.println(a.equalsIgnoreCase(b));  
```

输出的结果为第一条为false，第二条为true。

 

**7 startsWith()和endsWith()判断字符串是不是以特定的字符开头或结束**

```
String a = "Hello Word";
System.out.println(a.startsWith("ee"));  
System.out.println(a.endsWith("rd"));
```

输出的结果第一条为false，第二条为true。

 

**8 toUpperCase()和toLowerCase()将字符串转换为大写或小写**

```
String a = "Hello Word";
System.out.println(a.toUpperCase());
System.out.println(a.toLowerCase());
```

输出的结果第一条为“HELLO WORD”，第二条为“hello word”。

 

**9 concat() 连接两个字符串**

```
String a = "Hello Word";
String b = "你好";
System.out.println(b.concat(a));
```

输出的结果为“你好Hello Word”。

 

**10 trim()去掉起始和结束的空格**

```
String a = "    Hello Word   ";
System.out.println(a.trim());
```

输出的结果为“Hello Word”。

 

**11 substring（）截取字符串**

```
String a = "Hello Word";
System.out.println(a.substring(0, 5));
System.out.println(a.substring(6));
```

输出的结果第一条为“Hello”,第一个参数0（beginIndex）是开始截取的位置，第二个参数5（endIndex）是截取结束的位置，输出的结果第二条是“Word”，参数6（beginIndex）是开始截取的位置。

 

**12 indexOf()和lastIndexOf()前者是查找字符或字符串第一次出现的地方，后者是查找字符或字符串最后一次出现的地方**

```
String a = "Hello Word";
System.out.println(a.indexOf("o"));
System.out.println(a.lastIndexOf("o"));
```

输出的结果第一条是4，是o第一次出现的下标，第二条是7，是o最后一次出现的下标。

 

**13 compareTo()和compareToIgnoreCase(）按字典顺序比较两个字符串的大小，前者区分大小写，后者不区分**

```
String a = "Hello Word";
String b = "hello word";
System.out.println(a.compareTo(b));
System.out.println(a.compareToIgnoreCase(b)); 
```

输出的结果第一条为-32，第二条为0，两个字符串在字典顺序中大小相同，返回0。

 

**14 replace() 替换**

```
String a = "Hello Word";
String b = "你好";
System.out.println(a.replace(a, b));
System.out.println(a.replace(a, "HELLO WORD"));System.out.println(b.replace("你", "大家"));
```

#### StringBuilder和StringBuffer

 StringBuilder 的方法不是线程安全的，不能同步访问，推荐使用StringBuilder。

```java
 StringBuilder sb = new StringBuilder("aaa");
 StringBuilder sb1 = new StringBuilder(12);
 StringBuilder sb2 = new StringBuilder();//默认大小为16个字符
append(任意类型)  追加到字符串后面

reverse 反转字符串

insert(int offset, 任意类型)  在某个index后插入字符串

toString()  返回String类的对象
```



### 常用数据结构

- 栈

**java.util;**

Stack 类表示后进先出（LIFO）对象堆栈。 它使用五个操作扩展了类Vector，这些操作允许将向量视为堆栈。

```
Stack<Integer> stack = new Stack<>();   //新建堆栈
stack.push(1) ;  // 向stack栈顶压入一个元素
stack.pop() ;    // 从stack中弹出栈顶元素
stack.peek() ;    // 查看stack中栈顶元素，不弹出
stack.empty() ;     // 判断stack是否是空栈
stack.search(2) ;      // 若该对象存在，返回对象在此堆栈上的从1开始的位置。
                               // 栈顶元素为对象时，返回1
                               // 若不存在，则返回-1，
```

Deque接口及其实现提供了一套更完整，更一致的LIFO堆栈操作，应优先使用此类。

（Deque意为双端队列，double ended queue）。具体来说又有ArrayDeuqe和LinkedList两种具体类来实现，两者的区别体现在底层分别使用数组和链表来实现。

LinkedList 是一个继承于AbstractSequentialList的双向链表。它也可以被当作堆栈、队列或双端队列进行操作。
LinkedList 实现 List 接口，能对它进行队列操作。

实现Deque接口，即能将LinkedList当作双端队列使用。

当LinkedList被当做栈来使用时，常用api及对应关系如下：

| 栈方法  | 等效方法                 |
| ------- | ------------------------ |
| push(e) | addFirst(e)              |
| pop()   | removeFirst()            |
| peek()  | peekFirst()              |
| empty() | isEmpty() //判断是否为空 |

- 队列

  java中虽然有Queue接口，单java并没有给出具体的队列实现类，而Java中让LinkedList类实现了Queue接口，所以使用队列的时候，一般采用LinkedList。因为LinkedList是双向链表，可以很方便的实现队列的所有功能。

  Queue使用时要尽量避免Collection的add()和remove()方法，而是要使用offer()来加入元素，使用poll()来获取并移出元素。它们的优点是通过返回值可以判断成功与否，add()和remove()方法在失败的时候会抛出异常。 如果要使用前端而不移出该元素，使用element()或者peek()方法。

  java中定义队列 一般这样定义： Queue<E> queue = new LinkedList<E>();

  当采用LinkedList来实现时，api的使用和对用关系如下：

  | 队列方法 | 等效方法                                                     |
  | -------- | ------------------------------------------------------------ |
  | offer(e) | offer(e)/offerLast(e) //进队列，将元素加入队列末尾           |
  | poll()   | poll()/pollFirst() //获取队列头的元素并移除                  |
  | peek()   | peek()/peekFirst() //获取队列头的元素    isEmpty() //判断是否为空 |

```
Queue<Integer> queue = new LinkedList<>();
queue.element();
queue.offer(1);
queue.poll();
queue.peek();
```

- 双向队列

```
Deque <Integer> deque = new LinkedList<>();
deque.offer(1);
deque.offer(2);
deque.offerFirst(3);
deque.pollLast();
```

- 小根堆

PriorityQueue类实现了优先队列，默认是一个小根堆的形式，如果要定义大根堆，需要在初始化的时候加入一个自定义的比较器。

 PriorityQueue 实现heap

 minHeap：PriorityQueue默认实现小根堆

```
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(8);
        minHeap.offer(5);
        minHeap.offer(3);
        minHeap.offer(4);
        minHeap.offer(2);

        while(!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }
```

- 大根堆

```
class maxComparator implements Comparator<Integer> {
            @Override
            public int compare(Integer num1, Integer num2) {
                return num1 >= num2 ? -1 : 1 ;
            }
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new maxComparator());

        maxHeap.offer(5);
        maxHeap.offer(3);
        maxHeap.offer(4);
        maxHeap.offer(1);
        maxHeap.offer(2);

        while(!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());
        }
```



2. List转数组
   使用toArray()方法，用一个预定义的数组作为出参接收转化后的数组

        List<Integer> stockList = new ArrayList<>();
        stockList.add(1);
        stockList.add(2);
        
        Integer[] stockArr = new Integer[stockList.size()];
        stockArr = stockList.toArray(stockArr);
        
        for(Integer s : stockArr)
            System.out.println(s+" ");

## 常用技巧

 **求 一个 数中有几个 1组成：**

比如 x = 82 = 1 0 1   k = 9 

```java
  for (int j = 0; x; j ++, x /= k){
  		s[j] += x % k;
  }
```

**将字符串转为整数**



```java
long num = 0;
while(k < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
    num = num * 10 +str.charAt(i)-'0';
    k++;
}
```

```c++
while(k < str.size() && str[k] >= '0' && str[k] <= '9'){
    num = nums *10 + str[k] - '0';
    k ++;
}
```



**一维转二维**以及**二维转一维**

比如将一个一维转为一个二维的数组：

```java
获取二维数组的高： int x = k/3;
获取二维数组的宽： int y = k%3;
通过二维获取一维的值：
遍历高，获取值：arr[k*x+y]
```

**向上取整**与**向下取整**

```java
（x+1）/2
 x/2
```

**输出补前导0**

比如输出这个yyyy-mm-dd，而输入的数是 44 3 4

```java
System.out.printf("%04d-%02d-%02d",y,m,d);
```



## 一. 基础算法

### （1）排序算法

#### 1.冒泡排序

```java
public static void  bubbleSort(int []nums){
        if(nums ==null||nums.length<2){
            return ;
        }
        for(int i  = 0 ;i < nums.length;i++){
            for(int j = 0; j < nums.length-i-1;j++){
                if(nums[j]>nums[j+1]){
                    swap(nums,j,j+1);
                }
            }
        }
    }
    public static void  swap(int [] nums,int a,int b){
//        int temp = nums[a];
//        nums[a] = nums[b];
//        nums[b] = temp;
         nums[a] = nums[a]^nums[b];
         nums[b] = nums[a]^nums[b];
         nums[a] = nums[a]^nums[b];
    }	
```

#### 2. 快速排序

快速排序思想：

1. 确定分界点，把数组分成两部分。
   常用的分界点有 数组第一个数，数组最后一个数，数组中间那个数
   一般我会选用数组中间那个数作为分界点，这样后面的写法也固定了，不容易遇到边界问题。

2. 根据分界点调整数组，使得分界点左边的数都小于等于分界点，分界点右边的数都大于等于分界点
   方法：利用双指针的移动，左指针在左边大于分界点的数停下，右指针在右边小于分界点的数停下，交换这两个数。

3. 分别递归处理左右两边。

4. 时间复杂度为O(nlogn)。

   **快排Java代码模板**

```
public static void quickSort(int[] arr,int l ,int r){
        if(l >= r) return;                  //递归结束条件
        int i = l - 1;                      //左边的指针
        int j = r + 1;                      //右边的指针
        int x = arr[l + ((r - l) >> 1)];    //选取数组中间的那个数作为分界点，把数组分成两部分
        while(i < j){
            do{
                i++;
            }while(arr[i] < x);             //在左边大于分界点的数停下
            do{
                j--;
            }while(arr[j] > x);             //在右边小于分界点的数停下
            //此时的arr[i] > x ，arr[j] < x,如果此时i，j还没有见面，则交换两者的位置，然后在while(i < j)里继续循环，直到i和j相遇。
            if(i < j){                      //交换两个数
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        quickSort(arr,l,j);                 //递归处理左边
        quickSort(arr,j+1,r);               //递归处理右边
    }
```

#### 3. 归并排序

归并排序思想：

1. 将数组平均分成两部分（奇数个数的话就是一个为n/2个，一个为n/2+1个）。

2. 分别递归地排序数组的这两部分。

3. 将排好序的两部分归并成一整块。

   方法：利用双指针的移动，将两部分中更小的那个数存到临时存储数组中。

4.时间复杂度为O(nlogn)。
**归并Java代码模板**

```
public static void mergeSort(int[] arr,int l,int r){
		int[] temp = new int[r-l+1];
        if(l >= r) return;                      //递归结束条件
        int mid = l + (r - l)/2;                //将数组分成[L,mid] 和 [mid+1,R] 两部分
        mergeSort(arr,l,mid);                   //递归排序左半部分
        mergeSort(arr,mid+1,r);                 //递归排序右半部分
        int i = l;                              //左半部分的指针
        int j = mid + 1;                        //右半部分的指针
        int k = 0;                              //临时存储数组的索引
        while(i <= mid && j <= r){              //循环找到两部分中更小的那个数
            if(arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];          //temp为临时存储数组
        }
        while(i <= mid) temp[k++] = arr[i++];   //把左半部分没存入的数存到临时存储数组中
        while(j <= r) temp[k++] = arr[j++];     //把右半部分没存入的数存到临时存储数组中
        for(i = l,j = 0; i <= r; i++,j++){      //将临时存储数组中排好序的数复制到原数组中
            arr[i] = temp[j];
        }
    }
```

**逆序对的数量**

![image-20210526114228490](C:\Users\18068\AppData\Roaming\Typora\typora-user-images\image-20210526114228490.png)

```java
import java.util.*;
class Main{
    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(mergeSort(arr,0,n-1));
    }
    static long mergeSort(int[]arr,int l,int r){
        int[] tmp = new int[r-l+1];
        if(l>=r){
            return 0;
        }
        int mid = (l+r)/2;
        int i = l;
        int j = mid+1;
        long res = 0;
        res = mergeSort(arr,l,mid)+mergeSort(arr,mid+1,r);
        int k = 0;
        while(i<=mid&&j<=r){
            if(arr[i]<=arr[j]){
                tmp[k++] = arr[i++];
            }else{
                res += mid-i+1;
                tmp[k++] = arr[j++];
            }
        }
        while(i <= mid){
            tmp[k++] = arr[i++];
        }
        while(j <= r){
            tmp[k++] = arr[j++];
        }
        for(i = l,j = 0; i <= r; i++,j++){
            arr[i] = tmp[j];
        }
        return res;
        
    }
}
```



### （2）二分

总结：https://www.acwing.com/blog/content/114/

二分法
维基百科中对二分法的解释：二分法（dichotomy）指的是将一个整体事物分割成两部分。也即是说，这两部分必须是互补事件，即所有事物必须属于双方中的一方，且互斥，即没有事物可以同时属于双方。

所以二分和单调性确实是没有绝对关系的。

二分就是把区间划分成两部分，我把这两部分分别记为left 和 right。满足left就一定不满足right，满足right就一定不满足left。

整数二分口诀：
最大值最小，先r后l l+1，mid那里不加1
最小值最大，先l后r r-1，mid那里要加1

个人是这么记忆的：
如果在else 后写的是r 就要减1，然后在上面的mid那里+1；如果在else后写的是l，就加1，上面的mid就不用加1。

https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/solution/yi-wen-dai-ni-gao-ding-er-fen-sou-suo-ji-ki52/

```
//check(mid)是对mid处的数进行判断。
//若符合right，答案就在left。即binarySearch1
//若符合left，答案就在right。即binarySearch2

int binarySearch1(int l,int r){
    while(l < r){
        int mid = l + (r - 1) / 2;      //mid那里不+1
        if(check(mid)) r = mid;         //先r
        else l = mid + 1;                //后l l+1
    }
    return l;                           //二分到最后一个，即l==r时，为所求
}

int binarySearch2(int l,int r){
    while(l < r){
        int mid = l + (r - l) / 2 + 1;  //mid那里要+1 
        if(check(mid)) l = mid;         //先l
        else r = mid - 1;               //后r  r-1    
    }
    return l;                           //二分到最后一个，即l==r时，为所求
}
```

实数二分

```java
double binarySearch3(double l,double r){
    double eps;//根据题目设置精度，一般是题目精度的1e-2倍
    while(r - l > eps){
        double mid = (r + l) / 2;
        if(check(mid)) l = mid;
        else r = mid;
    }
    return l;
}


```

例子：

l到r中求最大值：

```java
 /**
     * l到r范围内求最大值
     */
     public static int process(int []arr,int l, int r){
         if (l==r){
             return arr[l];
         }
         int mid = l+(r-l) >> 1;
         int leftMax = process(arr,l,mid);
         int rightMax = process(arr,mid+1,r);
         return Math.max(leftMax,rightMax);
     }
```

二分搜索：

```java
  public static int binarySearch(int []arr, int target) {
        int left = 0;
        int right = arr.length - 1; // 注意

        while(left <= right) { // 注意
            int mid = (right + left) / 2;
            if(arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1; // 注意
            } else if (arr[mid] > target) {
                right = mid - 1; // 注意
            }
        }
        return -1;
    }
```



### （3）高精度

java实现了求最大公约数：BigInteger.gcd()

2. 最大公约数x最小公倍数=mxn

```java
public static int gcd(int a,int b){
	return b!=0?gcd(b:a%b):a;
}
```

```java
初始化： BigInteger a = new BigInteger("String类型");
返回字符串中包含1的位数： BigInteger.bitCount();
BigInteger test1 = BigInteger.valueOf(long类型的数据 3);
加法：a.add(b)
减法：a.subtract(b)
乘法：a.multiply(b)
除法：a.divide(b)
取余：a.mod(b)
比较：a.compareTo(b) -1，0或1，因为BigInteger的数字小于等于或大于 val 。 
```



### （4）前缀和差分

一维前缀和（记住不要越界）：

```java
 for(int i = 1; i <= m; i++){
 	arr[i] = sc.nextInt();
    arr[i] = arr[i]+arr[i-1];
 }
```

二维前缀和（记住不要越界）：

```java
for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                arr[i][j] = sc.nextInt();
                nums[i][j] = arr[i][j]+nums[i][j-1]+nums[i-1][j]-nums[i-1][j-1];
            }
        }
  int a = sc.nextInt();
  int b = sc.nextInt();
  int c = sc.nextInt();
  int d = sc.nextInt();
  System.out.println(nums[c][d]-nums[c][b-1]-nums[a-1][d]+nums[a-1][b-1]);
```

**差分**：

给定a[1],a[2],,,a[n]

构建差分数组b[n],使得 a[i] = b[1]+b[2] +,,+b[i]

核心操作：将a[l-r]全部加上c等价b[l]+=c,b[r+1]-=c

证明：

对于a[1-l-1]无影响

对于a[l-r]加了c

对于a[r+1-n] 无影响

```
构建差分数组：
int []arr = new int[m+5];
int []nums = new int[m+5];
for(int i = 1; i <= m; i++){
    arr[i] = sc.nextInt();
    nums[i] = arr[i] -arr[i-1];
}
关键操作：
nums[a] +=c;
nums[b+1] -=c;
输出原数组：
for(int i = 1; i <= m; i++){
	nums[i] = nums[i]+nums[i-1];
    System.out.print(nums[i]+" ");
}
```

给定原矩阵 a[i,j]，构造b[i,j]使得b是a的二维前缀和

差分核心操作：给（x1,y1）为左上角，(x2,y2)为右下角的子矩阵的所有数a[i,j]加上c。

s[x1,y1] +=c

s[x1,y2+1] -=c

s[x2+1,y1]  -=c

s[x2+1,y2+1] +=c

```
import java.io.*;
class Main{
    static int [][]nums1 = new int[1005][1005];
    static int [][]nums2 = new int[1005][1005];
    static int n,m,q;
    public static void main(String []args)throws Exception{
       BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
       String s1[] = read.readLine().split(" ");
        n = Integer.valueOf(s1[0]);
        m = Integer.valueOf(s1[1]);
        q = Integer.valueOf(s1[2]);
        for(int i =1;i<n+1;i++){
            String[] s2 = read.readLine().split(" ");
            for(int j =1;j<m+1;j++){
                nums1[i][j] = Integer.valueOf(s2[j-1]);
            }
        }
        for(int i =1;i<n+1;i++){
            for(int j =1;j<m+1;j++){
               insert(i,j,i,j,nums1[i][j]);
            }
        }
        
        int x1 = 0,y1 = 0,x2 = 0,y2 = 0,c =0;
        for(int i =0;i<q;i++){
            String []s3 = read.readLine().split(" ");
            x1 = Integer.valueOf(s3[0]);
            y1 = Integer.valueOf(s3[1]);
            x2 = Integer.valueOf(s3[2]);
            y2 = Integer.valueOf(s3[3]);
            c = Integer.valueOf(s3[4]);
            insert(x1,y1,x2,y2,c);
        }
          for(int i =1;i<n+1;i++){
            for(int j =1;j<m+1;j++){
              nums1[i][j] = nums1[i-1][j]+nums1[i][j-1]-nums1[i-1][j-1]+nums2[i][j];
            }
        }
          for(int i =1;i<n+1;i++){
            for(int j =1;j<m+1;j++){
               w.write(nums1[i][j]+" ");
            }
            w.write("\n");
        }
        w.flush();
    }
    static void insert(int x1,int y1,int x2,int y2,int c){
        nums2[x1][y1] +=c;
        nums2[x1][y2+1] -=c;
        nums2[x2+1][y1] -=c;
        nums2[x2+1][y2+1] +=c;
    }
    
}
```

### （5）双指针算法

**最长不连续重复子序列**

```java
import java.util.*;
class Main{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i <n; i++){
            arr[i] = sc.nextInt();
        }
        int res = 0;
        int []nums = new int[100005];
        for(int i = 0, j = 0; i < n; i++){
            nums[arr[i]]++;
            while(nums[arr[i]]>1){
                nums[arr[j]]--;
                j++;
            }
            res = Math.max(res,i-j+1);
        }
        System.out.println(res);
    }
}
```

**数组元素的目标和**

```
import java.util.*;
class Main{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int m = sc.nextInt();
        int[] b = new int[m];
        int k = sc.nextInt();
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < m; i++){
            b[i] = sc.nextInt();
        }
        for(int i = 0,j = m -1; i < n; i++){
            while(j>=0&&a[i]+b[j]>k){
                j--;
            }
            if(a[i]+b[j]==k){
                System.out.println(i +" "+j);
                return;
            }
        }
    }
}
```

​		

**判断子序列**

```java
import java.util.*;
class Main{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        int[] nums = new int[m];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < m; i++){
            nums[i] = sc.nextInt();
        }
        int res = 0,j = 0;
        for(int i = 0; i < m; i++){
            if(j < n &&arr[j]==nums[i]){
                j++;
            }

        }
        if(j==n){
                System.out.println("Yes");
        }else{        
            System.out.println("No");
        }
    }
}
```

### （6）位运算

计算第i位： n>>i &1

```
public static int cal(int x){
        int res = 0;
        while(x!=0){
            x = x&(x-1);
            res++;
        }
        return res;
    }
```

```
   public static int cal(int x){
        int res = 0;
        while(x!=0){
            if((1&x)==1){
                res++;
            }
            x = x/2;
        }
        return res;
    }
```

```
 System.out.print(Integer.bitCount(x)+" ");
```

**二进制枚举**

acw 3976

```c++
#include <iostream>
#include <cmath>

using namespace std;

char str[11];
int INF = 0x3f3f3f3f, res;

bool check(int x) {
    int t = (int)sqrt(x);
    return x && t * t == x;
}

void dfs(int x, int t, int s) {
    if (!str[x]) {
        if (check(s)) res = min(res, t);
        return;
    }
    dfs(x + 1, t + 1, s);
    if (s || str[x] != 48)
        dfs(x + 1, t, s * 10 + str[x] - 48);
}

int main() {
    int task;
    for (scanf("%d", &task); task--; ) {
        scanf("%s", str);
        res = INF;
        dfs(0, 0, 0);
        printf("%d\n", res == INF ? -1 : res);
    }
    return 0;
}

作者：垫底抽风
链接：https://www.acwing.com/activity/content/code/content/1589763/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

```c++
#include <iostream>
#include <cstring>
#include <algorithm>
#include <cmath>

using namespace std;

int main()
{
    int T;
    cin >> T;
    while (T -- )
    {
        string str;
        cin >> str;
        int n = str.size();

        int res = 100;
        for (int i = 0; i < 1 << n; i ++ )
        {
            int x = 0;
            for (int j = 0; j < n; j ++ )
                if (i >> j & 1)
                    x = x * 10 + str[j] - '0';

            int t = sqrt(x);
            if (x && t * t == x) res = min(res, n - (int)to_string(x).size());
        }
        if (res == 100) res = -1;
        cout << res << endl;
    }

    return 0;
}

作者：yxc
链接：https://www.acwing.com/activity/content/code/content/1592363/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



### （7）离散化

个数少，值域大

存储所有出现的坐标值，然后排序，离散化到新数组，将坐标对应的值存入前缀和数组，根据lr在离散化数组中找到下标，然后根据前缀和计算差值。
1、利用TreeMap将所有的（x,c）存储起来平均O(nlogn)

2、区间l，r将他们作为键值存储到TreeMap;平均O(mlogm),他们所对应的值不变，并且将区间（l，r）作为查询键值对存储到集合O(m)

3、根据map的value值集合构造前缀和数组O(n + m)

4、根据map的key键集合构造查询数组O(n + m)

5、根据集合的键值对在查询数组中查找对应的离散化下标O(mlog(n+m))

6、根据前缀和进行计算

时间复杂度
总的时间复杂度O(nlogn) + O(nlogn) + O(m) + 2O(n + m) + O(mlog(n+m)) 抽象为 O(nlogn)

```
//离散化
import java.io.*;
import java.lang.Integer;
import java.util.*;
class Node{//键值对相当于c++的pair<int, int>
    public int first;
    public int second;
    public Node(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Main{
    static int N = 300010;
    static int[] sum = new int[N];//离散数组，存储前缀和
    static TreeMap<Integer, Integer> map = new TreeMap<>();//存储坐标和长度
    static ArrayList<Node> query = new ArrayList<>();//用于查询 相当于c++的vector<pair<int,int>>

    static int binserySearch(Integer[] index, int x){//二分查找
        int l = 0, r = index.length - 1;
        while(l < r){
            int mid = l + r >> 1;
            if(index[mid] < x)l = mid + 1;
            else r = mid;
        }
        return l;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String[] params = buf.readLine().split(" ");
        int n = Integer.valueOf(params[0]);
        int m = Integer.valueOf(params[1]);
        for(int i = 0; i < n; ++i){
            String[] xc = buf.readLine().split(" ");
            int x = Integer.valueOf(xc[0]);
            int c = Integer.valueOf(xc[1]);
            map.put(x, map.getOrDefault(x, 0) + c);
            //记录所有的（x,c）记录下来，利用TreeMap进行存储 nlogn的时间复杂度
        }
        for(int i = 0; i < m; ++i){
            String[] lr = buf.readLine().split(" ");
            int l = Integer.valueOf(lr[0]);
            int r = Integer.valueOf(lr[1]);
            map.put(l, map.getOrDefault(l, 0));
            map.put(r, map.getOrDefault(r, 0));
            query.add(new Node(l, r));
        }
        int k = 1;
        for(int num : map.values()){
            sum[k] = sum[k - 1] + num;
            k++;
        }
        Object[] obj = map.keySet().toArray();
        Integer[] index = Arrays.copyOfRange(obj, 0, obj.length, Integer[].class);
        for(Node node : query){
            int x1 = binserySearch(index, node.first);
            int x2 = binserySearch(index, node.second);
            int res = sum[x2 + 1] - sum[x1];
            System.out.printf("%d\n", res);
        }

    }


}
```

### （8）区间合并

1.如果只计算区间合并后的个数的话，可以利用右端点进行枚举。

```
import java.util.*;
class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][]nums = new int[n][2];
        for(int i =0;i<n;i++){
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }
        Arrays.sort(nums,(o1,o2) ->{
            return o1[0]-o2[0];
        });
        int res = 1;
        int maxr = nums[0][1];
        for(int i =1;i<n;i++){
            if(nums[i][0]<=maxr){
                maxr = Math.max(maxr,nums[i][1]);
            }else{
                res++;
                maxr = nums[i][1];
            }
        }
        System.out.println(res);
        
    }
}
```

![image-20210224110217986](C:\Users\18068\AppData\Roaming\Typora\typora-user-images\image-20210224110217986.png)



```java
import java.util.*;
class Main{
    static ArrayList<int[]> list = new ArrayList<>();
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[2];
        for(int i = 0; i < n; i++){
            nums = new int[2];
            nums[0] = sc.nextInt();
            nums[1] = sc.nextInt();
            list.add(nums);
        }
        list.sort((o1,o2) ->{
            return o1[0]-o2[0];
        });
        System.out.println(merge(list));
    }
    static int merge(ArrayList<int[]>list){
        ArrayList<int[]> res = new ArrayList<>();
        int l = Integer.MIN_VALUE;
        int r = Integer.MIN_VALUE;
        for(int[] a:list){
            if(a[0] > r){
                if(l!=Integer.MIN_VALUE){
                    res.add(new int[]{l,r});
                }
                l = a[0];
                r = a[1];
            }else{
                r = Math.max(r,a[1]);
            }
        }
        if(l != Integer.MIN_VALUE){
            res.add(new int[]{l,r});
        }
        return res.size();
    }
}
```

### （9）计算器

建立中缀表达式，然后递归来求，也可以。

双栈解法：对于表达式而言：我们使用两个栈nums和ops。

nums：存数字。

ops：存放所有的数字以外的操作。

```java

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        Stack<Integer> num = new Stack<>();
        Stack<Character> op = new Stack<>();
        String str = sc.next();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                int j = i, x = 0;
                while (j < str.length() && Character.isDigit(str.charAt(j))) {
                    x = x * 10 + str.charAt(j++) - '0';
                }
                num.push(x);
                i = j - 1;
            } else if (c == '(') {
                op.push(c);
            } else if (c == ')') {
                while (op.peek() != '(') {
                    eval(num, op);
                }
                //将左括号扔出去
                op.pop();
            } else {

                while (!op.isEmpty() && map.get(op.peek()) != null && map.get(op.peek()) >= map.get(c)) {
                    eval(num, op);
                }
                op.push(c);
            }
        }
        while (!op.isEmpty()) {
            eval(num, op);
        }
        System.out.println(num.peek());
    }

    static void eval(Stack<Integer> num, Stack<Character> op) {
        int b = num.pop();
        int a = num.pop();
        char c = op.pop();
        int x = 0;
        if (c == '+') {
            x = a + b;
        } else if (c == '-') {
            x = a - b;
        } else if (c == '*') {
            x = a * b;
        } else {
            x = a / b;
        }
        num.push(x);
    }
}
```



## 二. 数据结构

用数组模拟链表，栈和队列。

### （1）链表

单链表最多用的是邻接表：存储图和树

双链表用来优化某些问题

![image-20210224132311947](C:\Users\18068\AppData\Roaming\Typora\typora-user-images\image-20210224132311947.png)

1.先定义head ：头结点的下标

e[i] 节点i的值

ne[i] 表示节点i的next指针

idx存储当前用到了哪个点

2.init 初始化操作

head = -1; idx = 0;

3.将x插入到头节点

e[idx] = x;

ne[idx] = head;

head = idx;

idx++;

4.将x插入到下标是k的点后面

e[idx] = x;

ne[idx] = ne[k];

ne[k] = idx;

idx++;

5.将下标是k后面的点删掉

ne[k] = ne[ne[k]];

```java
import java.io.*;
import java.util.Scanner;

public class Main {
    private static int N = 100010;  // 数据规模为 10w

    private static int head;                // 表示头结点的下标
    private static int[] e = new int[N];    // 表示结点 i的值
    private static int[] ne = new int[N];   // 表示结点 i的 next指针是多少
    private static int idx;                 // 表示存储当前结点已经使用结点的下一个结点

    // 初始化数据
    private static void init() {
        head = -1;  // 没有头结点
        idx = 0;    // 没有存入数据
    }

    // 将 val插到头结点
    private static void addToHead(int val) {
        e[idx] = val;   // 赋值
        ne[idx] = head; // 插入之前头结点的前面
        head = idx;     // 更新头结点信息
        idx++;          // idx向右移动
    }

    // 将下标是 k的点后面的点删掉
    private static void remove(int k) {
        ne[k] = ne[ne[k]];  // 让下标为 k的结点指向 下个结点的下个结点
    }

    // 将 val插入下标为 k的点的后面
    private static void add(int k, int val) {
        e[idx] = val;
        ne[idx] = ne[k];
        ne[k] = idx;
        idx++;
    }

    // 程序入口
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(reader.readLine());

        init();     // 初始化操作

        // 进行 m次操作
        while (m-- > 0) {
            String[] s = reader.readLine().split(" ");

            if (s[0].equals("H")) {  // 插入头结点操作, 不能使用 ==, 要使用 equals()

                int val = Integer.parseInt(s[1]);
                addToHead(val);
            } else if (s[0].equals("I")) {   // 普通插入操作
                int k = Integer.parseInt(s[1]);
                int val = Integer.parseInt(s[2]);
                add(k - 1, val);    // 第 k个结点的下标为 k-1, 所以插入到下标为 k-1结点的后面
            } else {    // s[0] == "D", 删除操作
                int k = Integer.parseInt(s[1]);

                if (k == 0) {  // 题意: k = 0, 删除头结点
                    head = ne[head];
                } else
                    remove(k - 1);  // 第 k个结点的下标为 k-1, 所以是删除到下标为 k-1后面的后面
            }
        }

        // 打印输出
        for (int i = head; i != -1; i = ne[i]) {
            System.out.print(e[i] + " ");
        }
    }
}
```

**双链表**

e[N]表示这个点是谁

l[N]表示这个点右边的点是谁

r[N]表示这个点右边的点是谁

```
/*
注意点：
    1.往最后端点插入时，可以用l[1],即最后一个位置的左节点来确定
    2.同样，往一个点左边插入时，需要的也是l[k]
    3.初始化操作：r[0]=1; l[1]=0; idx=2; head和tail分别为下标0和1
    4.      int t=0;
            while(r[t]!=1){t=r[t];}
            add(t,x);
            //这种方式取尾节点的时间最差为1e9，时间会爆掉=100000^2
*/
import java.util.*;
class Main{
    private static int N=100010;
    //private static int head;
    private static int idx=0;
    private static int[] e=new int[N];
    private static int[] l=new int[N];
    private static int[] r=new int[N];
    public static void init(){
        r[0]=1;
        l[1]=0;
        idx=2;
    }
    //在idx为k后加入一个节点
    public static void add(int k,int x){
        e[idx]=x;
        r[idx]=r[k];
        //l[idx] = l[r[k]];
        l[idx]=k;
        l[r[k]]=idx;
        r[k]=idx++;  //这步要最后做
    }
    //删除idx为k的节点
    public static void remove(int k){
        l[r[k]]=l[k];
        r[l[k]]=r[k];
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        init();
        while(n-->0){
            String c=sc.next();
			
            int k,x;
            
            //0和1相当于头和尾
            if(c.equals("L")){
                x=sc.nextInt();
                add(0,x);
            }else if(c.equals("R")){
                x=sc.nextInt();
                add(l[1],x);

                /*int t=0;
                while(r[t]!=1){t=r[t];}
                add(t,x);*/
            }else if(c.equals("D")){
                k=sc.nextInt();
                /因为0和1已经被占了，第一个添加的节点是从2开始的，所以第k个节点编号是k+1。
                remove(k+1);
            }else if(c.equals("IL")){
                k=sc.nextInt();
                x=sc.nextInt();
                add(l[k+1],x);
            }else if(c.equals("IR")){
                k=sc.nextInt();
                x=sc.nextInt();
                add(k+1,x);
            }
        }
        for(int i=0;r[i]!=1;i=r[i]) 
            System.out.print(e[r[i]]+" ");
    }
}


```

### （2）栈

```

import java.util.*;
class Main{
    static int idx = 0;
    static int[] arr = new int[100005];
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while((n--)!=0){
            String s = sc.next();
            if("push".equals(s)){
                int x = sc.nextInt();
                push(x);
            }else if("pop".equals(s)){
                pop();
            }else if("empty".equals(s)){
                System.out.println(isEmpty());
            }else if("query".equals(s)){
                System.out.println(query());
            }
        }
    }
    public static void push(int x){
        arr[++idx] = x;
    }
    public static void pop(){
        idx--;
    }
    public static String isEmpty(){
        if(idx>0){
            return "NO";
        }
            return "YES";
    }
    public static int query(){
        return arr[idx];
    }
}
```

### （3）队列



```
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Main {
    static int N = 100010;
    static int []queue =  new int[N];
    static int up = 0;
    static int down = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(read.readLine());
        while ((n--)!=0) {
            String[] s = read.readLine().split(" ");
            if("push".equals(s[0])){
                push(Integer.valueOf(s[1]));
            }else if("query".equals(s[0])){
                System.out.println(query());
            }else if("pop".equals(s[0])){
                pop();
            }else if("empty".equals(s[0])){
                System.out.println(empty());
            }
        }

    }
    static void push(int x){
        queue[up++] = x;
    }
    static void pop(){
        down++;
    }
    static int query(){
        return queue[down];
    }
    static String empty(){
        if(up==down){
            return "YES";
        }else{
            return "NO";
        }
    }
}

```

### （4）单调栈

这道题暴力做法的话，暴力枚举 两层循环即可。

```
for(int i = 0; i < n; i++){
	for(int j = i-1; j >=0; j--){
		if(arr[j]>arr[i]){
			return j;
		}
	}
}
```



保持数组一直是一个单调递增的序列，每次添加时找到比添加的数小的第一个数，然后再将本数添加到数组中，使得数组一直是一个单调递增的序列。



```
import java.util.*;
class Main{
    static int[] arr = new int[100005];
    static int idx = 0;
    public static void main(String []args){
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            while(idx!=0&&arr[idx]>=x){
                idx--;
            }
            if(idx!=0){
                System.out.print(arr[idx]+" ");
            }else{
                System.out.print("-1"+" ");
            }
            arr[++idx] = x;
        }
    }
}
```

### （5）单调队列（难）

先看看使用普通队列怎么做

将队列中没用的元素删掉发现具有了单调性

可以用o（1）的时间复杂度从队头或者队尾去出最值。

只要前面的数比后面的数大，断定前面的点就没用

```

import java.io.*;
class Main {
    //1. 定义队列 
    private static final int N = 1000010;
    private static int[] q = new int[N];
    private static int[] arr = new int[N];
    private static int hh = 0, tt = -1;//队头和队尾

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]); // 数组长度
        int m = Integer.parseInt(line1[1]); // 滑动窗口长度
        String[] line2 = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(line2[i]);
        }

        //1. 求解最小值、那么队列存取升序
        //q[]中存储的是坐标
        for(int i=0;i<n;i++){
            //滑出了，从对头出队
            //k=3  i=0,1,2 3划出
            if(hh<=tt&&i-m+1>q[hh]){
                hh++;
            }

            //保证升序
            while(hh<=tt&&arr[q[tt]]>=arr[i]){
                tt--;
            }

            //存入坐标
            q[++tt] = i;

            if(i+1>=m){
                bw.write(arr[q[hh]]+" ");
            }
        }

        bw.write("\n");
        //求解最大值，保证降序
        hh=0;
        tt=-1;  
        for(int i=0;i<n;i++){
            //滑出
            if(hh<=tt&&i-m+1>q[hh]){
                hh++;
            }

            //最大值，降序
            while(hh<=tt&&arr[q[tt]]<arr[i]){
                tt--;
            }

            q[++tt] = i;
            if(i+1>=m){
                bw.write(arr[q[hh]]+" ");
            }
        }

        bw.flush();
        br.close();
        bw.close();

    }
}


```

```java


import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
         int[] nums = new int[n+1];
        String[] s = reader.readLine().split(" ");
        for (int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(s[i]);
        }
        Deque<Integer> qMin = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++){
            //检查是否出了队列，因为i-k+1 ~ i,出了的话就不行了
            while(!qMin.isEmpty() && qMin.peekFirst() < i-k+1){
                qMin.pollFirst();
            }
            //如果新加入的数比队列的后面的数小，就入队
            while(!qMin.isEmpty() && nums[i] < nums[qMin.peekLast()]){
                qMin.pollLast();
            }
            qMin.add(i);

            if(i+1>=k){
                writer.write(nums[qMin.peekFirst()] + " ");
            }
        }
        writer.write("\n");

        // max
        Deque<Integer> qMax = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++){
            while(!qMax.isEmpty() && qMax.peekFirst() < i-k+1){
                qMax.pollFirst();
            }
            while(!qMax.isEmpty() && nums[i] > nums[qMax.peekLast()]){
                qMax.pollLast();
            }
            qMax.add(i);

            if(i+1>=k){
                writer.write(nums[qMax.peekFirst()] + " ");
            }
        }
        writer.write("\n");

        writer.flush();
        reader.close();
        writer.close();


    }
}

```



### （6）KMP算法

https://www.acwing.com/solution/content/11332/

https://www.bilibili.com/video/BV1hW411a7ys/?spm_id_from=333.788.recommend_more_video.-1

KMP算法主要是求字符串匹配的问题。

主要是对BF算法的一个化简，在每次失去匹配的时候，不是将p串往后移一位，而是把p串移动到下一次可以与前面部分匹配的位置，这个是通过next数组来确定的。

![image-20210507160112263](https://s3.bmp.ovh/imgs/2022/01/d2f225bfabe8f1e3.png)



KMP主要分为两步：求next数组和匹配字符串。

```java
import java.util.*;
import java.io.*;
class Main{
    static int n, m;
    static int[] ne;
    static String S,P;
    static char[] s,p;
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.valueOf(read.readLine());
        P = read.readLine();
        p = new char[n+1];
        for(int i = 1; i <= n; i++){
            p[i] = P.charAt(i-1);
        }
        m = Integer.valueOf(read.readLine());
        S = read.readLine();
        s = new char[m+1];
        for(int i = 1; i <= m; i++){
            s[i] = S.charAt(i-1);
        }
        ne = new int[n+1];
        //ne[1] = 0
        //求next数组  
            for(int i = 2, j = 0; i <= n; i++){//
                while(j != 0 && p[i] != p[j+1]){
                    j = ne[j];
                }
                if(p[i] == p[j+1]){
                    j++;
                }
                ne[i] = j;
            }
        for(int i = 1, j = 0; i <= m; i++){
            while(j != 0 && s[i] != p[j+1]){
                j = ne[j];
            }
            if(s[i] == p[j+1]){//
                j++;
            }
            if(j == n){
                writer.write(i-n+" ");
                j = ne[j];//
            }
        }
        writer.flush();
        writer.close();
        read.close();
    }
}
```



### （7）Trie树

快速存储和查找字符串集合的数据结构

![trie.png](https://cdn.acwing.com/media/article/image/2021/01/18/35590_a624568f59-trie.png)



```
import java.util.*;
class Main{
    static int N = 100005;
    //存储节点
    static int[][] arr = new int[N][26];
    //以当前单词结尾的单词的个数
    static int[] end = new int[N];
    //根节点，也是空节点
    static int idx = 0;
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while((n--)!=0){
            String s = sc.next();
            if("Q".equals(s)){
                String ss = sc.next();
                System.out.println(query(ss));
            }else{
                String ss = sc.next();
                insert(ss);
            }
        }
    }
    public static int query(String s){
        char[] ch = s.toCharArray();
        int p = 0;
        for(int i = 0; i < ch.length; i++){
            int x = ch[i] - 'a';
            if(arr[p][x]==0){
                return 0;
            }
            p = arr[p][x];
        }
        return end[p];
    }
    public static void insert(String s){
        int p = 0;
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length; i++){
            int x = ch[i] - 'a';
            if(arr[p][x]==0){
                arr[p][x] = ++idx;
            }
            p  = arr[p][x];
        }
        end[p]++;
    }
}
```

**最大异或和**



 

```
import java.util.*;
import java.io.*;

class Main{

    static int idx;
    static int[][] son = new int[3000000][2];

    static void insert(int x){
        int p = 0;
        for(int i = 30; i >= 0; i--){
            int u = (x >> i)&1;
            if(son[p][u] == 0){
                son[p][u] = ++ idx;
            }
            p = son[p][u];
        }
    }
     static int query(int x){
        int p = 0, res = 0;
        for(int i = 30; i >= 0; i--){
            
            int u = (x >> i) & 1;
            if(son[p][1-u] != 0){
                //因为这里存的就是结果 我们要知道如果是1的话，两位是相对的，所以肯定是异或肯定是1
                res += (1 << i);
                p = son[p][1-u];
            }else{
                p = son[p][u];
            }
        }
        return res;
    }
     public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int res = 0;
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            insert(a[i]);
            res = Math.max(res,query(a[i]));
        }
        
        System.out.println(res);
    }
}
```

### （8）并查集

思维性较强

快速的处理将两个集合合并，询问两个集合是否在一个集合中

基本原理：每个集合都用一棵树来表示。树根的编号就是整个集合的编号。每个节点存储它的父节点，p[x]表示x的父节点。

问题一：如何判断树根: if (p[x] ==x)

问题二：如何求x的集合编号：

while(p[x]!=x){

​	x = p[x];

}  优化：路径压缩

问题三：合并两个集合

px的是x的集合编号，py是y的集合编号。直接将p[x] = y即可。



```java
import java.io.*;
import java.util.*;
class Main{
    static int[] p = new int[100010];
    public static void main(String [] args) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter write = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = read.readLine().split(" ");
        int n = Integer.valueOf(s[0]);
        int m = Integer.valueOf(s[1]);
        for(int i = 1;i <=n; i++){
            p[i] = i;
        }
        while((m--)!=0){
            String[] ss = read.readLine().split(" ");
            int a = Integer.valueOf(ss[1]);
            int b = Integer.valueOf(ss[2]);
            if("M".equals(ss[0])){
                p[find(a)]=find(b);
            }else{
                if(find(a)==find(b)){
                    write.write("Yes");
                }else{
                    write.write("No");
                }
                
                write.write("\n");
            }
        }
        write.flush();
        write.close();
        read.close();
    }
    static int find(int a){
        //如果a的父亲节点不是a的话，就一直找 直到找到为止
        if(p[a]!=a){
            p[a] = find(p[a]);
        }
        return p[a];
    }
}
```

### （9）堆排序

1.插入一个值 heap[++size] = x;up(size)

2.求集合当中的最小值 heap[1]

3.删除最小值 heap[1] = heap[size];size--;down(1)  删除头结点非常地困难，但是删除尾结点很简单。

4.删除任意一个元素 heap[k] = heap[size] ;size--;down[k]:up[k]

5.修改任意一个元素heap[k] = x;down[k]; up[k];

性质：每个点都满足小于等于左右两边的值

存储：根节点：，左儿子：2x,右儿子：2x+1

例如： 1 2 3 即是 1是根节点，2是左儿子，3是右儿子。



```java
import java.util.*;
//把整个数组建成堆，每次输出堆顶即可
//因此只需要用到输出集合的最小值
//还有删除最小值，关键是实现down操作。
//求最小值是o1的时间复杂度，而求插入和删除的时间复杂度与树的高度有关因此是logn的
class Main{
    static int m,n,size;
    static int[] p = new int[100010];
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 1; i <=n; i++){
            p[i] = sc.nextInt();
        }
        size = n;
        for(int i = n/2; i !=0;i--){
            down(i);
        }
        for(int i = 1; i <=m; i++){
            System.out.print(p[1]+" ");
            p[1] = p[size];
            size--; 
            down(1); 
        }
    }
    static void down(int u){
        int t = u;
        //如果子节点<当前节点的话就把下标位置赋给t
        if(u*2<=size&&p[u*2]<p[t]){
            t = u*2;
        }
        if(u*2+1<=size&&p[u*2+1]<p[t]){
            t = u*2+1;
        }
        if(u!=t){
            int temp = p[u];
            p[u] = p[t];
            p[t] = temp;
            down(t);
        }
    }
    
}
```

难题：

```java
import java.util.*;
class Main{
    //堆
    static int[] h = new int[100010];
    //p是指针，h是堆 这里是指指针指向堆,存放第k个插入点的下标
    static int[] ph = new int[100010];
    //p是指针，h是堆，这里是指堆指向指针，存放堆中点的插入次序
    static int[] hp = new int[100010];
    static int n,size,m; //操作次数以及堆的大小以及插入的数的个数
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        while((n--)!=0){
            String op = sc.next();
            if("I".equals(op)){
                int x = sc.nextInt();
                m++;
                h[++size] = x;
                ph[m] = size;
                hp[size] = m;
                up(size);
            }else if("PM".equals(op)){
                System.out.println(h[1]);
            }else if("DM".equals(op)){
                heapSwap(1,size);
                size--;
                down(1);
            }else if("D".equals(op)){
                int k = sc.nextInt();
                int u = ph[k]; //这里使用u=ph[k]来保存第k个插入点的坐标
                heapSwap(u,size);  //因为在此处heapSwap操作后ph[k]的值已经发生 
                size--;   //如果在up,down操作中仍然使用ph[k]作为参数就会发生错误
                up(u);
                down(u);
            }else if("C".equals(op)){
                int k = sc.nextInt();
                int x = sc.nextInt();
                h[ph[k]] = x;  //此处由于未涉及heapSwap操作且下面的up、down操作只会发生一个所以
                down(ph[k]);  //所以可直接传入ph[k]作为参数
                up(ph[k]);
            }
        }
    }
    //这个交换过程其实有那么些绕 但关键是理解 如果hp[u]=k 则ph[k]=u 的映射关系
    //之所以要进行这样的操作是因为 经过一系列操作 堆中的元素并不会保持原有的插入顺序
    //从而我们需要对应到原先第K个堆中元素
    //如果理解这个原理 那么就能明白其实三步交换的顺序是可以互换 
    //h,hp,ph之间两两存在映射关系 所以交换顺序的不同对结果并不会产生影响
    static void up(int u){
        if(u/2>0&&h[u]<h[u/2]){
            heapSwap(u,u/2);
            up(u/2);
        }
    }
    static void down(int u){
        int t = u;
        if(u*2<=size&&h[t]>h[u*2]){
            t = u*2;
        }
        if(u*2+1<=size&&h[t] > h[u*2+1]){
            t = u*2+1;
        }
        if(u!=t){
            heapSwap(u,t);
            down(t);
        }
    }
    static void heapSwap(int u, int v){
        swap(h,u,v);
        swap(hp,u,v);
        swap(ph,hp[u],hp[v]);
    }
    static void swap(int []a,int u,int v){
        int tmp = a[u];
        a[u] = a[v];
        a[v] =tmp;
    }
}
```

###  (10) 哈希表 

哈希表这一节分为存储结构和字符串哈希方式

存储结构分为开放寻址法，拉链法。

这个和离散化挺像的，不过哈希表是无序的，离散化以后是有序的。 



（1） 一般是使用mod进行取模存储 x mod 1e5

   (2)  一般都会产生hash冲突，因为值域太小，所以会出现hash冲突，这里有两种方式解决冲突：拉链法和开放寻址法。

拉链法 ：开一个数组来存储，然后开邻接表来啊存储值。

一般在hash表都做增加和查询操作，并不会真做删除操作，通常都是开一个bool数组进行标记，来达到一个逻辑删除的效果。

 代码实现：

质数能减少hash冲突，比如从0开始步长为5，容量为15，就容易导致hash冲突，而质数就是13，步长为5的话，就能全部访问到，而好的hash function可以不用苛求为质数。

在定义数组时，需要将数组的大小设为一个质数，并且离2的整数次幂远一点。

**拉链法**

```java
import java.util.*;
class Main{
    public static void main(String []args){
        for(int i = 100000;;i++){
            boolean flag = true;
            for(int j = 2; j *j <= i;j++){
                if(i%j==0){
                    System.out.println(j);
                    flag = false;
                    break;
                }
            }
            if(flag){
                    System.out.println(i);
                    break;
            }
        }
    }
}
```

```java
import java.util.*;
class Main{
    static int N = 100003;
    //拉链数组
    static int[] h = new int[N];
    //地址为i的数组
    static int[] e = new int[N];
    //地址为i的下一个节点的位置
    static int[] ne = new int[N];
    //节点的地址
    static int idx = 0;
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Arrays.fill(h,-1);
        while((n--)!=0){
            String s = sc.next();
            int x = sc.nextInt();
            if("I".equals(s)){
                insert(x);
            }else{
                if(find(x)){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }
        }   
    }
    static void insert(int x){
        int k = (x%N+N)%N;
        e[idx] = x; //节点idx的值为x
        ne[idx] = h[k]; 
        h[k] = idx++;
    }
    static boolean find(int x){
        int k = (x%N+N)%N;//使得值为正的，数学中的取余为正的，但是java中的取余是负的，所以要+N
        for(int i = h[k];i !=-1; i = ne[i]){
            if(e[i]==x){
                return true;
            }
        }
        return false;
    }
}
```

**开放寻址法**
思路
1.将x映射成小数组下标k，如果不同x所得k相同，则存储到k+1位置，以此类推
需要维护的变量：N:操作数量的两倍 , a[N]：寻址数组

Java 代码

```java
import java.util.*;

public class Main{
    private static int N = 200003;
    //因为要用null标识节点空，所以类型为Integer
    private static Integer[] a = new Integer[N];
    public static int find(int x){
        int k = (x % N + N) % N;
        //别忘了第二个已存在的条件
        while(a[k] != null && a[k] != x){
            k++;
            if(k == N){
                k = 0;
            }
        }
        return k;
    }

    public static void main(String[] args){
        //先将所有位置设为null，标识为空
        for(int i = 0;i < a.length;i++){
            a[i] = null;
        }        
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        while(m-- > 0){
           String opt = scanner.next();
           int x = scanner.nextInt();
           if("I".equals(opt)){
              a[find(x)] = x;
           }else{
               //这是比较的是a[find(x)]
               System.out.println(a[find(x)] == null ? "No" : "Yes");
           }
        }
    }
}


    
  
import java.util.*;
class Main{
    static int N = 100003;
    static int[] h = new int[N];
    static int bound = (int)1e9+1;
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Arrays.fill(h,bound);
        while((n--)!=0){
            String s = sc.next();
            int x = sc.nextInt();
            int k = find(x);
            if("I".equals(s)){
                h[k] = x;
            }else{
                if(h[k]!=bound){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }
        }   
    }
    //找下标
    static int find(int x){
        int k = (x%N+N)%N;
        while(h[k]!=bound&&h[k]!=x){
            k++;
            if(k == N){
                k = 0;
            }
        }
        return k;
    }
}
    
```

**字符串哈希**



前缀和哈希 牛逼

![image-20210303090211087](https://s3.bmp.ovh/imgs/2022/01/2db7bb58277c79ab.png)

![image-20210303091926802](https://s3.bmp.ovh/imgs/2022/01/168603323122c5dc.png)

字符串哈希可以快速的判断

https://www.acwing.com/solution/content/12337/

就一个简单的例子：2313 = 23*100+13

```java

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter write = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = read.readLine().split(" ");
        int n = Integer.valueOf(s[0]);
        int t = Integer.valueOf(s[1]);
        String w = read.readLine();
        int P = 131;
        //存p进制各位表示的数
        long[] h = new long[n+10];
        //用来存进制
        long[] p = new long[n+10];
        p[0] = 1;
        for (int i = 1; i <=n; i++) {
            p[i] = p[i-1] * P;
            h[i] = h[i-1] * P+w.charAt(i-1);
        }
        while (t-- >0){
            s = read.readLine().split(" ");
            int l1 = Integer.valueOf(s[0]);
            int r1 = Integer.valueOf(s[1]);
            int l2 = Integer.valueOf(s[2]);
            int r2 = Integer.valueOf(s[3]);
            String out =  h[r1] - h[l1 - 1] * p[r1 - l1 + 1] == h[r2] - h[l2 - 1] * p[r2 - l2 + 1] ?
                    "Yes" : "No";
            write.write(out+"\n");

        }
        write.flush();
    }
}
```

## 三. 搜索和图论

### (1)DFS

- 优缺点

- 容易爆栈，如果树有1e4层，就爆了

- 空间和深度成正比，相对较小。

- 不能搜最短，最小。

  **思考方式&&代码模板**

  ```[
  dfs()//参数用来表示状态
  {
  	if(到达终点状态){
  		//根据题意添加
  		return;
  	}
  	if(越界或者不合法状态){
  		return;
  	}
  	if(特殊状态){
  		//剪枝
  		return;
  	}
  	for(扩展方式){
  		if(扩展方式所达到状态合法){
  		 	修改操作；//根据题意来参加
  		 	标记；
  		 	dfs();
  		 	(还原标记);
  		 	//是否还原标记根据题意
  		 	//如果加上（还原标记）就是回溯
  		}
  	}
  }
  ```

  

**全排列**

理解：

这里的dfs函数指的是什么？

第u行到第n行的path的路径

如何求出一整个路径？

 假设已经知道第u+1行到最后一行的所有path，其实综合12可知：path[u]与path[u+1]合并后，即为dfs的解。

为什么要进行回溯？

递归的外层是一个循环，如果不进行恢复现场，下层回溯到上层状态被改变，数据就会乱套，甚至死循环。

```java
import java.util.*;
class Main{
    static int[] arr = new int[10];
    static boolean[] flag = new boolean[10];
    static int n;
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dfs(0);
    }
    static void dfs(int u){
        if(u==n){
            for(int i = 0; i < n; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i = 1;i <= n;i++){
            //如果当前没有走过的话，就开始走
            if(!flag[i]){
                arr[u] = i;
                //置为true后，就不再走了
                flag[i] = true;
                dfs(u+1);
                //遍历完成后，置为false
                flag[i] = false;
            }
        }
    }
}
```

**八皇后问题**：

```java
import java.util.*;
class Main{
    //记录正对角线
    static boolean[] dg = new boolean[20];
    //记录负对角线
    static boolean[] udg = new boolean[20];
    //记录列
    static boolean[] col = new boolean[10];
    //记录答案
    static char[][] arr = new char[10][10];
    static int n ;
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        //初始化为.
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = '.';
            }
        }
        //从第0行开始遍历
        dfs(0);
    }
    static void dfs(int u){
        //如果遍历到最后一行就将答案输出	
        //ch[i]直接输出一行
        if(u==n){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        //u是行 i是列 u+i指的是截距，由于都是正整数所以不担心为0，然而如果是-u+i的话有可能是负数，u最大就是n-1，所以设为n即可。
        for(int i = 0; i < n; i++){
            if(!col[i]&&!dg[u+i]&&!udg[-u+i+n]){
                //变换记录答案
                arr[u][i] = 'Q';
                //做标记
                col[i] = dg[u+i] = udg[-u+i+n] = true;
                dfs(u+1);
                //返回原样 
                col[i] = dg[u+i] = udg[-u+i+n] = false;
                arr[u][i] = '.';
            }
        }
    }
}
```



### (2)BFS



模板：

```java
while(queue.isEmpty()){
    queue.poll(队头);
    拓展所有部分
    if(x未遍历){
        queue.offer(x);
        d[x] = d[t] + 1;
    }
}
```



- 优缺点

- 空间是指数级别的大

- 不会有爆栈的风险

- 可以搜最短，最小

  一般情况下，我们是用队列来实现，先进先出，使用队列来保存未被检测的结点。结点按照宽度优先的次序被访问和进出队列。

**代码思路**

  1.先初始化队列q；
  2.从起点开始访问，并且改变他的状态为已经访问；
  3.如果他的队列非空，取出首个元素，将它弹出！
  4.如果u==目标状态，然后对所以与u邻近的点进入队列；
  5.标记它已经被访问！

**代码模板**

```java
import java.util.*;
class Main{
    static int n,m;
    static int[][] arr;
    static int[][] path;
    static Node[][]pre;
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        pre = new Node[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        bfs();
    }
    static void bfs(){
        path = new int[n][m];
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            
            for(int i = 0;i < 4; i++){
                int x = node.x + dx[i];
                int y = node.y + dy[i];
                if(x >= 0 && x < n && y >= 0 && y < m && arr[x][y] == 0 && path[x][y]==0 ){
                    pre[x][y] = node;
                    arr[x][y] = 1; 
                    queue.add(new Node(x,y));
                    path[x][y] +=path[node.x][node.y]+1;
                }
            }
        }
        int x = n-1,y = m-1;
        while(x!=0||y!=0){
            System.out.println(x+" "+y);
            Node node = pre[x][y];
            x = node.x;
            y = node.y;
        }
        System.out.println(path[n-1][m-1]);
    }
}
class Node{
    int x;
    int y;
    public Node(int x,int y){
        this.x = x;
        this.y = y;
    }
}
```

**ACW845**

```java
import java.util.*;
import java.io.*;
class Main{
    static void swap(char[] c,int a,int b){
        char s = c[a];
        c[a] = c[b];
        c[b] = s;
    }
    static int bfs(String start,String end){
        Queue<String> q = new LinkedList<>();
        Map<String,Integer> map = new HashMap<>();
        q.offer(start);
        map.put(start,0);
        int []dx = {0,1,0,-1};
        int []dy = {1,0,-1,0};
        while(!q.isEmpty()){
            String t = q.poll();
            if(t.equals(end)){
                return map.get(t);
            }
            int k = t.indexOf('x');
           //二维转为一维
            int x = k/3,y = k%3;
            for(int i = 0;i < 4;i++){
                int a = x + dx[i];
                int b = y + dy[i];
                if(a>=0&&a<3&&b>=0&&b<3){
                    char []arr = t.toCharArray();
                    //一维转为二维
                     swap(arr,k,a*3+b);//交换值&变状态（因为前面是一维存储字符串，所以二维坐标转一维下标）
                    String s=new String(arr);//转成字符串，因为定义队列和map是用String的

                    if(map.get(s)==null){//如果这个状态没出现过就存储这个状态
                        q.offer(s);
                        map.put(s,map.get(t)+1);//变化前的次数值加一，因为是+1所以保证四个方向变化的值都是一样的；
                    }

                }
            }
        }
        return -1;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        String q[]=sc.readLine().split(" ");
        String start="";//因为输入问题所以不能直接给一个字符串
        for(int i=0;i<q.length;i++){
            start+=q[i];
        }
        String end="12345678x";
        System.out.println(bfs(start,end));//从开始状态到结束状态要多少次交换
    }


}

作者：福尔摩DONG
链接：https://www.acwing.com/activity/content/code/content/798623/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```



### (3)树与图的深度优先遍历

树是一种特殊的图，树是一种无环连通图。

所以只需要了解图就行了，图分为有向图与无向图。

无向图是一种特殊的有向图。

有向图：a->b 邻接矩阵 g[a,b] 用来存储边的信息，如果有权重的话g[a,b]就是权重，否则的话存储的就是booelan值【表示有边或者无边】。

邻接表：每一个头节点后面都跟了一个单链表。

树和图的遍历一般分为深度优先遍历和广度优先遍历。

```java
数组建立领接表
int h[N],e[N*2],ne[N*2],idx;
void add(int a,int b){
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
}
// 需要标记数组st[N],  遍历节点的每个相邻的便
void dfs(int u) {
    st[u] = true; // 标记一下，记录为已经被搜索过了，下面进行搜索过程
    for (int i = h[u]; i != -1; i = ne[i]) {
        int j = e[i];
        if (!st[j]) {
            dfs(j);
        }
    }
}
```

**数的重心**

```java
https://www.acwing.com/solution/content/13513/
import java.io.*;
import java.util.*;

class Main{
    //以有向图的格式存储无向图，所以每个节点至多对应2n-2条边
    static int N = 100010, M = N*2;
    //存储n个单链表所以会有n个头
    static int[] h = new int[N];
    //存储元素的值
    static int[] e = new int[M];
    //存储列表的next值
    static int[] ne = new int[M];
    //idx是单链表指针
    static int idx,n;
    static boolean[] st = new boolean[N];
    static int ans = N;
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        //将头结点都指向-1
        Arrays.fill(h,-1);
        n = Integer.valueOf(read.readLine().trim());
        for(int i = 0; i < n-1; i++){
            //树是不存在环的，对于有n个节点的树，必定是n-1条边
            String[] s = read.readLine().split(" ");
            int a = Integer.valueOf(s[0]);
            int b = Integer.valueOf(s[1]);
            add(a,b);
            add(b,a);
        }
        dfs(1);
        System.out.println(ans);
    }
    //插入法，将b插到a后边
    static void add(int a,int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
    //以u为根的子树中点的数量，包括u节点
    static int dfs(int u){
        //标记访问过u节点
        st[u] = true;
        //res存储删掉某个节点后，最大的联通子图节点数
        //存储以u为根的数的节点数，包括u
        int sum = 1,res = 0;
        //访问u的每个子节点
        for(int i  = h[u]; i != -1; i = ne[i]){
            int j = e[i];
            //因为每个节点的编号是不一样的，所以用编号为下标，来标记是否被访问过
            if(!st[j]){
                //u节点的单棵子树节点数，如图中的size值。
                int s = dfs(j);
                //记录最大联通子图的节点数
                res = Math.max(res,s);
                //
                sum += s;
            }
        }
        res = Math.max(res,n - sum);
        ans = Math.min(ans,res);
        return sum;
    }
}
```



### (4)树与图的广度优先遍历

这些边的权重默认是1，与下面的算法不同。

```java
import java.util.*;

class Main{
    static int N = 100010;
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] d = new int[N];
    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] st = new boolean[N];
    static int idx,n;
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        Arrays.fill(h,-1);
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(a,b);
        }
        System.out.println(bfs(1));
        
    }
    static void add(int a,int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
    static int bfs(int u){
        queue.offer(u);
        Arrays.fill(d,-1);
        d[1] = 0;
        
        while(queue.size()!=0){
            int t = queue.poll();
            for(int i = h[t]; i != -1; i = ne[i]){
                int j = e[i];
                if(d[j] == -1){
                    queue.offer(j);
                    d[j] = d[t] + 1; 
                }
            }
           
        }
         return d[n];
    }
}
```

```java
import java.util.*;
class Main{
    static int n, m,idx, N = (int)1e5+10;
    static int[] h = new int[N], e = new int[N*2], ne = new int[N*2],d = new int[N];
    static boolean[] st = new boolean[N]; 
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        Arrays.fill(h,-1);
        for(int i = 0; i < m ;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(a,b);
        }
        bfs();
    }
    static void bfs(){
        queue.offer(1);
        while(!queue.isEmpty()){
            int t = queue.poll();
            for(int i = h[t]; i != -1; i = ne[i]){
                int j = e[i];
                if(!st[j]){
                    st[j] = true;
                    d[j] = d[t]+1;
                    queue.offer(j);
                }
            }
        }
        if(d[n] == 0){
           System.out.println(-1); 
        }else{
            System.out.println(d[n]); 
        }
        
    }
    //链式前向星
    static void add(int a,int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
```



### (5) 拓扑排序

有向图才有拓扑序列，拓扑序列就是对于每条边的起点都在终点前边。

环一定不是拓扑图，拓扑图又叫有向无环图（DAG）。

入度为0代表着没有任何一点在我的前面，你只需要不断地挖墙角就可以了

![image-20210602101316321](https://s3.bmp.ovh/imgs/2022/01/49e3ea1f23f67f93.png)

```java
将入度为0的点加入到queue中，

while(!queue.isEmpty()){
	取出队头
    枚举t的所有出边t到j；
    删除t到j，d[j]--即j的入度--；
    if(d[j]==0){
        将j加入到队列中
    }
    
}


```

```java
//本题中每次将入度为0的点删除后，你会发现这就是答案，因为它之前已经没有点了，它后面的点都比它大。
import java.util.*;
class Main{
    static int N = 100010;
    //d是记录i节点的入度，ans记录的是答案
    static int[]h = new int[N],e = new int[N*2],ne = new int[N*2],d = new int[N],ans = new int[N];
    //队列
    static Queue<Integer> queue = new LinkedList<>();
    //从一开始记录答案
    static int n,m,idx,cnt = 1;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        //记得初始化
        Arrays.fill(h,-1);
        while(m-- != 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(a,b);
            //将b的入度添加1
            d[b]++;
        }
        if(bfs()){
            for(int i = 1; i <= n; i++){
                System.out.print(ans[i]+" ");
            }
            }else{
                 System.out.println(-1);
            }
        }
    
    static void add(int a,int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
    static boolean bfs(){
        //将入度为0的点添加到队列中
        for(int i = 1; i <= n; i++){
            if(d[i]==0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int t = queue.poll();
            //记录答案
            ans[cnt] = t;
            cnt++;
            //找t到j的点，将j的入度减一，判断其是否为0，是0的添加到队列中，在下一回开始的时候会把它添加到答案中。
            for(int i = h[t]; i != -1; i = ne[i]){
                int j = e[i];
                d[j]--;
                if(d[j]==0){
                    queue.offer(j);
                }
            }
        }
        //最后如何答案出来的话，肯定为n，如果小于n说明有的点存在问题，不符合条件。
        return cnt >= n;
    }
}
```




### (6)Dijkstra

如果是稠密图（边数多）的话，建议使用朴素版的的迪杰斯特拉算法，稠密图用邻接矩阵来存。稀疏图用邻接表来存。

稀疏图的话可以使用堆优化版的迪杰斯特拉算法。

朴素化Dijkstra：

（1）初始化距离dist[1] = 0, dist[i] = 正无穷

（2）s是当前已确定最短距离的点。

for(int i = 0; i < n; i++){

​			t是不在s中的距离最近的点

​			将t加入到s中

​			用t更新到其他点的距离。

} 



朴素版的迪杰斯特拉算法：

```java
package Acwing;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Dijkstra算法
 */
public class Dijkstra {
    static int N = 510;
    static int[][] g =  new int[N][N];
    static int[] dist = new int[N];//从1号点到各个点的距离
    static boolean[] st = new boolean[N];//判断每个点的最短距离是否已经确定
    static int n,m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        //解决重边和自环
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i==j){
                    g[i][j] = 0;
                }else{
                    g[i][j] = 0x3f3f3f;
                }
            }

        }
        while(m-- !=0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            g[a][b] = Math.min(g[a][b],c);
        }
        int t = dijkstra();
        System.out.println(t);
    }
    static int dijkstra(){
        //算法思路：
        初始化距离：一号节点的距离为0，其他节点的距离为正无穷
        循环n次，每一次都将集合s外距离最短的点x加入到s中，然后用x去更新x邻接点的距离。
        Arrays.fill(dist,0x3f3f3f);
        dist[1] = 0;
        for(int i = 0; i < n; i++){
            //表示还没有确定距离当前点最近的点（贪心思想）
            int t = -1;
            for(int j = 1; j <= n; j++){
                //如果当前点没有确定最短路并且
                if(!st[j]&&(t==-1||dist[t]>dist[j])){
                    t = j;
                }

            }
            st[t] = true;
            //用t更新其他点的距离
            for (int j = 1; j <= n; j++){
                dist[j] = Math.min(dist[j],dist[t]+g[t][j]);
            }

        }
        if (dist[n]==0x3f3f3f){
            return -1;
        }else{
            return dist[n];
        }
    }
}

```

堆优化版的迪杰斯特拉算法：

```java
package Acwing;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 堆优化版的Dijkstra算法
 */
public class Dijkstra2 {
    static int N = 1000010;

    static int[] dist = new int[N];//从1号点到各个点的距离
    static boolean[] st = new boolean[N];//判断每个点的最短距离是否已经确定
    static int[] h = new int[N],w = new int[N],e = new int[N],ne = new int[N];
    static int idx;
    static int n,m;
    static void add(int a,int b, int c){
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        Arrays.fill(h,-1);
        while(m-- !=0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            add(a,b,c);
        }
        int t = dijkstra();
        System.out.println(t);
    }
    static int dijkstra(){
        // 堆优化版的迪杰斯特拉算法是将 寻找不在s中的距离最短的点 这一步骤优化到nlongn 
        //1. 将一号点的距离置为0，其他点置为正无穷
        //2.将一号点放进去
        //3.不断循环，知道堆为空，每次执行操作将弹出堆顶（找到s外距离最短的点，并且标记最短路径已经确定），用该点去更新邻接点的距离，若更新成功就加入到堆中
        Arrays.fill(dist,0x3f3f3f3f);
        dist[1] = 0;
        PriorityQueue<int[]> queue = new <int[]>((o1,o2)->{
            return o1[0] - o2[0];
        });

        //将一号点放进去，距离是0，编号是1
        queue.offer(new int[]{0,1});
        while(!queue.isEmpty()){
            int[] t = queue.poll();
			//找到不在s中的点t
            int distance = t[0];
            int ver = t[1];
            if (st[ver]){
                continue;
            }
            st[ver] = true;
            //用这一点去到其他点的距离
            for(int i = h[ver]; i!=-1; i = ne[i]){
                int j = e[i];
                //这里的w[i]就是i到j的距离，上面用链式向前星存储过。
                if(dist[j] > distance + w[i]){
                    //更新距离
                    dist[j] =  distance + w[i];
                    //将新点的距离（到1的距离）和编号加入到队列中
                    queue.offer(new int[]{dist[j],j});
                }
            }
        }
        if(dist[n]!= 0x3f3f3f3f){
            return dist[n];
        }else{
            return -1;
        }
    }
}

```





### (7)Bellman-Ford算法



适用于最多经过k条边，并且可能存在负权回路。

a，b，w代表的是从a到b的边，权重为w。

`只需要两重循环，外层是遍历所有点，内层遍历所有点`

这个算法可以直接用结构体存就可以，不用链表存。

`如果图中存在负权回路的话，最短路径不一定存在。`



下面的外循环迭代k次，代表 经过 不超过k条边的 最短路径。

可用循环n次判断负环，若n个点有n+1条边，说明存在负环，这个值比较小，说明存在负数。



```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N = 510;
    static int M = 100010;
    //总点数
    static int n ;
    //总边数
    static int m ;
    //最多经过k条边
    static int k ;
    //记录从1号点到n号的距离
    static int[] dist = new int[N];
    //结构体数组
    static Node[] list = new Node[M];
    static int INF = 0x3f3f3f;
    //备份数组
    static int[] backup = new int[N];
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        n = Integer.valueOf(s[0]);
        m = Integer.valueOf(s[1]);
        k = Integer.valueOf(s[2]);
        for(int i = 0; i < m; i++){
            String[] ss = reader.readLine().split(" ");
            int a = Integer.valueOf(ss[0]);
            int b = Integer.valueOf(ss[1]);
            int c = Integer.valueOf(ss[2]);
            list[i] = new Node(a,b,c);
        }
        bellman_ford();
    }
    static void bellman_ford(){
        Arrays.fill(dist,INF);
        dist[1] = 0;
        for(int i = 0; i < k; i++){
            //backup = Arrays.copyOf(dist,n+1);
            backup = dist.clone();
            for(int j = 0; j < m; j++){
                Node node = list[j];
                int a = node.a;
                int b = node.b;
                int c = node.c;
                dist[b] = Math.min(dist[b],backup[a]+c);

            }
        }
        //定义的正无穷是个数值，可能被更新。
        if(dist[n] > INF/2){
            System.out.println("impossible");
        }else{
            System.out.println(dist[n]);
        }
    }
}
class Node{
    int a,b,c;
    Node(int a,int b,int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

```

迪杰斯特拉算法与Bellman_ford算法的区别与联系：https://www.acwing.com/solution/content/9306/



### (8)spfa算法

https://www.acwing.com/solution/content/9306/

要求不含负环,万能路算法



是对bellman_fold算法的简化，在第二个内循环中，它循环了m条边，更新每个点到起点的最小值，其实我们只需要把变小的值存到一个队列里面，然后用它去更新其他值即可。

比如 t变小了，就更新所有以t为起点的边即t的所有出边，比如 t --> b ,然后将b加入到队列中【此时要判断队列中有没有b，有的话就不更新了】              中心思想【我更新过谁，我就拿谁去更新别人】

```java

import java.util.*;

/**
 *spfa算法
 */
public class Spfa {
    static int N = 1000010;

    static int[] dist = new int[N];//从1号点到各个点的距离
    static boolean[] st = new boolean[N];//判断这个点是否加入到队列中
    static int[] h = new int[N], w = new int[N], e = new int[N], ne = new int[N];
    static int idx;
    static int n, m;

    static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        Arrays.fill(h, -1);
        while (m-- != 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            add(a, b, c);
        }
        int t = spfa();
        if(t== -1){
            System.out.println("impossible");
        }else{
            System.out.println(t);
        }
    }

    static int spfa() {
        Arrays.fill(dist, 0x3f3f3f);
        dist[1] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        //表示当前点已经加入到队列中
        st[1] = true;
        while (!queue.isEmpty()) {
            int t = queue.poll();
            st[t] = false;
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dist[t] + w[i]) {
                    dist[j] = dist[t] + w[i];
                    if (!st[j]) {
                        queue.offer(j);
                        st[j] = true;

                    }
                }
            }
        }  if (dist[n] == 0x3f3f3f) {
            return -1;
        }else {
            return dist[n];
        }
    }
}
```

判断负环：

https://www.acwing.com/solution/content/6336/



```java
package Acwing;

import java.util.*;

/**
 * spfa判断负环
 */
public class Spfa2 {
    static int N = 2010;
    static int M = 10010;
    static int[] dist = new int[N];//从x点到各个点的距离
    static boolean[] st = new boolean[N];
    //cnt存储的是边数
    static int[] h = new int[N], w = new int[M], e = new int[M], ne = new int[M], cnt = new int[M];
    static int idx;
    static int n, m;

    static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        Arrays.fill(h, -1);
        while (m-- != 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            add(a, b, c);
        }

        if (spfa()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    static boolean spfa() {

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
            st[i] = true;
        }
        while (!queue.isEmpty()) {
            int t = queue.poll();
            st[t] = false;

            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dist[t] + w[i]) {
                    dist[j] = dist[t] + w[i];
                    cnt[j] = cnt[t] + 1;

                    if (cnt[j] >= n) {
                        return true;
                    }
                    if (!st[j]) {
                        queue.offer(j);
                        st[j] = true;

                    }
                }
            }
        }
        return false;
    }
}
```



力扣周赛题：

```java
  private static int MOD = (int)Math.pow(10, 9)+7;
  public int countRestrictedPaths(int n, int[][] edges) {
    Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
    for (int[] edge : edges) {
      map.putIfAbsent(edge[0], new HashMap<>());
      map.putIfAbsent(edge[1], new HashMap<>());
      map.get(edge[0]).put(edge[1], edge[2]);
      map.get(edge[1]).put(edge[0], edge[2]);
    }
    int[] minDis = new int[n+1];
    Arrays.fill(minDis, Integer.MAX_VALUE);
    minDis[n] = 0;
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{n, 0});
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int[] current = queue.poll();
        int currentId = current[0];
        int currentDis = current[1];
        Map<Integer, Integer> next = map.get(currentId);
        for (Map.Entry<Integer, Integer> entry : next.entrySet()) {
          int nextId = entry.getKey();
          int currentToNext = entry.getValue();
          int nextDis = currentDis+currentToNext;
          if (nextDis < minDis[nextId]) {
            minDis[nextId] = nextDis;
            queue.add(new int[]{nextId, nextDis});
          }
        }
      }
    }
    int[] result = new int[n+1];
    result[n] = 1;
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)->a[1]-b[1]);
    for (int i = 1; i < minDis.length; i++) {
      priorityQueue.add(new int[]{i, minDis[i]});
    }
    while (!priorityQueue.isEmpty()) {
      int[] current = priorityQueue.poll();
      int currentId = current[0];
      int currentMinDis = minDis[currentId];
      Map<Integer, Integer> next = map.get(currentId);
      for (Map.Entry<Integer, Integer> entry : next.entrySet()) {
        int nextId = entry.getKey();
        int nextMinDis = minDis[nextId];
        if (nextMinDis < currentMinDis) {
          result[currentId] += result[nextId];
          result[currentId] %= MOD;
        }
      }
    }
    return result[1];
  }


作者：MapleStore
链接：https://leetcode-cn.com/problems/number-of-restricted-paths-from-first-to-last-node/solution/java-bfssuan-zui-duan-ju-chi-you-xian-du-m8au/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```
![image-20210504131629554](https://s3.bmp.ovh/imgs/2022/01/fc49c18dfff0e7fa.png)
### (9)prim算法

![image-20210504155737160](https://s3.bmp.ovh/imgs/2022/01/27b9cc41e7d62983.png)

了解最小生成树：

最小树 ：不能形成环，n个顶点必有n-1条边。

朴素版prim算法：





https://www.acwing.com/solution/content/14120/

```java
import java.util.Arrays;
import java.util.Scanner;
//可以使用memset(array, 0x3f, sizeof(array))来为数组设初值为0x3f3f3f3f，因为这个数的每个字节都是0x3f。
public class Main {
    static int N = 510;
    static int n, m;
    static int[][] g = new int[N][N];
    static boolean[] st = new boolean[N];
    static int[] dist = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    g[i][j] = 0;
                } else {
                    g[i][j] = 0x3f3f3f3f;
                }
            }
        }
        while (m-- != 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            g[a][b] = g[b][a] = Math.min(g[a][b], c);
        }
        int t = prim();
        if (t == 0x3f3f3f3f) {
            System.out.println("impossible");
        } else {
            System.out.println(t);
        }

    }

    static int prim() {
        Arrays.fill(dist, 0x3f3f3f3f);
        dist[1] = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!st[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }
            if(dist[t]==0x3f3f3f3f) {
                return 0x3f3f3f3f;
            }
            //先累加再更新
            res += dist[t];
            //拿这个点去更新其他所有的点到集合的距离
            for (int j = 1; j <= n; j++) {
                System.out.println(dist[j]+" "+g[t][j]);
                dist[j] = Math.min(dist[j],g[t][j]);
                
            }

            st[t] = true;
        }
        return res;

    }
}

```

### (10)Kruskal算法

直接选择权值最小的边

![image-20210504141054387](https://s3.bmp.ovh/imgs/2022/01/8ef47e4214efd5bf.png)

```java
import java.util.ArrayList;

import java.util.Scanner;

public class Main{
    static int n, m;
    static int[] p = new int[200010];
    static ArrayList<int[]> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < m; i++){
            int[] arr = new int[3];
            arr[0] = sc.nextInt();
            arr[1] = sc.nextInt();
            arr[2] = sc.nextInt();
            list.add(arr);
        }
        list.sort((o1,o2)->{
            return o1[2]-o2[2];
        });

//        for(int i = 0; i < m; i++){
//            System.out.println(Arrays.toString(list.get(i)));
//
//        }
        for(int i = 1; i <= n; i++) {
            p[i] = i;
        }
        int res = 0, cnt = 0;
        for(int i = 0; i < m; i++){
            int a = list.get(i)[0];
            int b = list.get(i)[1];
            int w = list.get(i)[2];
            if(find(a)!=find(b)){
                p[find(a)] = p[find(b)];
                cnt ++;
                res += w;
            }
        }
        if (cnt == n-1){
            System.out.println(res);
        }else{
            System.out.println("impossible");
        }
    }
    static int find(int x){
        if(x!=p[x]){
            p[x] = find(p[x]);
        }
        return p[x];
    }

}

```

### (11）floyd算法

用邻接矩阵来存储所有的边，基于动态规划

这里的> INF/2，是这样一种情况在更新的时候，虽然求的是两个数最小值，但是

1到2的距离是1-2,3的距离初始化是+无穷，则在更新到3的距离过程中，则可能更新成-2 + +无穷.

```java


import java.util.Scanner;


public class Main {
    static int N = 210;
    static int n,m,k,INF = (int)1e9;
    static int[][] d = new int[N][N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i==j){
                    d[i][j] = 0;
                }else{
                    d[i][j] = INF;
                }
            }
        }
        for(int i = 0 ; i < m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            d[x][y] = Math.min(d[x][y],z);
        }
        floyd();
        while(k-- !=0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(d[a][b] > INF/2){
                System.out.println("impossible");
            }else{
                System.out.println(d[a][b]);
            }
        }
    }
    static void floyd(){
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    //从
                    d[i][j] = Math.min(d[i][j],d[i][k]+d[k][j]);
                }
            }
        }
    }
}

```



### (12)二分图

二分图：当且仅当图中不含奇数环，

![image-20210608084207186](https://s3.bmp.ovh/imgs/2022/01/c78f15949e7dda83.png)

https://www.acwing.com/solution/content/6347/

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    static int n;
    static int m;
    static int N = 100010;
    static int M = 200010;
    static int[] h = new int[N];
    static int[] e = new int[M];
    static int[] ne = new int[M];
    static int idx = 0;
    static int[] color = new int[N];//共1和2两种不同的颜色
    static boolean[] st = new boolean[N];
    public static void add(int a,int b)
    {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx ++;
    }
    //dfs(u,c)表示把u号点染色成c颜色，并且判断从u号点开始染其他相连的点是否成功
    public static boolean dfs(int u,int c)
    {
        color[u] = c;
        for(int i = h[u];i != -1;i = ne[i])
        {
            int j = e[i];
            //当前点没有染过颜色
            if(color[j] == 0)
            {	//染成另外一种颜色
                if(!dfs(j,3 - c)) return false;
            }
            //矛盾
            else if(color[j] == c) return false;//颜色重复
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = reader.readLine().split(" ");
        n = Integer.parseInt(str1[0]);
        m = Integer.parseInt(str1[1]);
        Arrays.fill(h, -1);
        while(m -- > 0)
        {
            String[] str2 = reader.readLine().split(" ");
            int a = Integer.parseInt(str2[0]);
            int b = Integer.parseInt(str2[1]);
            add(a,b);
            add(b,a);
        }
        boolean flag = true;//标记是否染色成功
        for(int i = 1;i <= n;i++)
        {
            //若未染色
            if(color[i] == 0)
            {
                if(!dfs(i,1))
                {
                    flag = false;
                    break;
                }
            }
        }
        if(flag) System.out.println("Yes");
        else System.out.println("No");
    }
}

```

### (13)匈牙利算法

要了解匈牙利算法必须先理解下面的概念：

匹配：在图论中，一个「匹配」是一个边的集合，其中任意两条边都没有公共顶点。

最大匹配：一个图所有匹配中，所含匹配边数最多的匹配，称为这个图的最大匹配。

下面是一些补充概念：

完美匹配：如果一个图的某个匹配中，所有的顶点都是匹配点，那么它就是一个完美匹配。

交替路：从一个未匹配点出发，依次经过非匹配边、匹配边、非匹配边…形成的路径叫交替路。

增广路：从一个未匹配点出发，走交替路，如果途径另一个未匹配点（出发的点不算），则这条交替 路称为增广路（agumenting path）

```java
import java.util.*;
class Main{
    static int N = 510,M = 100010,n1,n2,m,idx;
    static int[] h = new int[M],ne = new int[M],e = new int[M];
    //用来存储女生匹配的男生
    static int[] match = new int[N];
    static boolean[]  st = new boolean[N];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Arrays.fill(h,-1);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int m = sc.nextInt();
        while(m-- != 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(a,b);
        }
        int cnt = 0;
        for(int i = 1; i <= n1; i++){
            //初始化女生都没有预定过，给自己增加信心
            Arrays.fill(st,false);
            if(find(i)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    //为男生添加女生联系方式
    static void add(int a,int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
    static boolean find(int x){
        //在列表里找找女生
        for(int i = h[x]; i != -1; i = ne[i]){
            int j = e[i];
            if(!st[j]){//如果女孩还没有被预定
                st[j] = true;//预定成功
                if(match[j]==0||find(match[j])){//看女孩是否有男朋友或者她的男朋友可以出轨
                    match[j] = x;//直接横刀夺爱
                    return true;
                }
            }
        }
        return false;
    }
}
```



## 四.数学知识

### （1）质数

质数是针对所有大于1的所有自然数，在大于1的整数中，如果只包含1和本身两个约数，就被称为质数，或者叫做素数。

**试除法求质数**：

```java
 public static String  cal(int x){
        if(x<2){
            return "No";
        }
        for(int i = 2;i<=x/i;i++){
            if(x%i==0){
                return "No";
            }
        }
        return "Yes";
    }
```

**分解质因数**

```java
    public static void cal(int x){
        for(int i = 2 ;i <= x/i; i++){
            if(x%i==0){
                int s = 0;
                while(x%i==0){
                    x /=i;
                    s++;
                }
                System.out.println(i +" "+s);
            }
           
        }
        if(x>1){
               System.out.println(x +" "+1);
           }
       System.out.println();
}
```

**质数个数**

埃氏筛法：

比如一个数为n，如果2到n-1中没有这个数的约数的话，那么这个数就是素数。

```java
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean[] st = new boolean[(int)1e6+10];
        int n = sc.nextInt();
        int res = 0;
        for(int i = 2; i <= n; i++){
            if(!st[i]){
                res++; 
                //但凡是前边质数的倍数都不是质数，是合数 只需要将所有质数的倍数删了即可
                for(int j = i; j <= n; j = j+i){
                    st[j] = true;
                }
            }
           
        }
        System.out.println(res);
    }
}
```

线性筛法：

n只会被最小质因子筛掉，

```java
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean[] st = new boolean[(int)1e6+10];
        //用来存放质数
        int[] primes = new int[(int)1e6+10];
        int n = sc.nextInt();
        int cnt = 0;
        for(int i = 2; i <= n; i++){
            if(!st[i]){
                primes[cnt++] = i;
            } 
            //假设primes[0]为n最小的质因子,i为最大的因数，
        //易知若primes[i]中i>0,则会进入循环后产生多余的标记。
            for(int j = 0;primes[j] <= n/i; j++){
                //标记;primes[j]一定是primes[j]*i的最小质因子
                st[primes[j]*i] = true;
                 //表明primes[j]一定是i的最小质因子,没有必要再遍历,primes要小于等于i的最小质因子
            //这样能保证每个数遍历一遍,而没有重复
                if(i%primes[j] == 0){
                    break;
                }
            }
           
        }
        System.out.println(cnt);
    }
}
```



### （2）约数

**试除法求约数**

```java
  TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < n; i++){
            int m = sc.nextInt();
            for(int j = 1;j<=m/j;j++){
                if(m%j==0){
                    set.add(j);
                    set.add(m/j);
                }
            }
            for(int x:set){
                System.out.print(x+" ");
            }
            set = new TreeSet<>();
            System.out.println();
        }
```



**约数个数**

int范围内 约数个数最多约为1500个，

先去分解质因数，然后统计每一质因数的个数，

然后根据乘法定理，约数的个数就是(a1+1)*(a2+1)*...

>  乘法定理：做一件事，完成它需要分成n个步骤，做第一 步有m1种不同的方法，做第二步有m2种不同的方法，……，做第n步有mn种不同的方法。那么完成这件事共有 N=m1×m2×m3×…×mn 种不同的方法。 和[加法原理](https://baike.baidu.com/item/加法原理/7538330)是数学概率方面的基本原理。

```java
import java.util.*;
class Main{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>();
        while(n-- !=0){
            int m = sc.nextInt();
            for(int i = 2; i <= m/i; i++){
                if(m%i==0){
                    while(m%i==0){
                        map.put(i,map.getOrDefault(i,0)+1);
                        m /=i;
                    }
                }
            }
            if(m>1){
                    map.put(m,map.getOrDefault(m,0)+1);
            }
        }
        long res = 1;
        for(int x:map.values()){
            res = (res*(x+1))%1000000007;
        }
        System.out.println(res);
        
    }
}
```

**约数之和**

![image-20210505143308560](C:\Users\18068\AppData\Roaming\Typora\typora-user-images\image-20210505143308560.png)

这里我们会发现还是算质因数的个数，然后再去计算，这次要计算阶乘和，然后再相乘。计算阶乘和，可以用y总的，~~也可以使用阶乘和公式，也可以循环加起来。~~

```java
import java.util.*;
class Main{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>();
        while(n-- !=0){
            int m = sc.nextInt();
            for(int i = 2; i <= m/i; i++){
                if(m%i == 0){
                    while(m%i==0){
                        map.put(i,map.getOrDefault(i,0)+1);
                        m /= i;
                    }
                }
            }
            if(m > 1){
                map.put(m,map.getOrDefault(m,0)+1);
            }
        }
        long res = 1;
        for(int x: map.keySet()){
            int cnt = map.get(x);
            long ans = 1;
            while(cnt-- !=0){
                ans = (ans*x+1)%(int)(1e9+7);
            }
            res = res*ans%(int)(1e9+7);
        }
        System.out.println(res);
    }
    
}
```

**最大公约数**

```java
 static int gcd(int a,int b){
        return b!=0?gcd(b,a%b):a;
    }
```

### （3）欧拉函数

![image-20210310193025907](C:\Users\18068\AppData\Roaming\Typora\typora-user-images\image-20210310193025907.png)

**根据定义求欧拉函数**

这题算的时候，比如3就是 3 比如6就是 2 和 3；

```java
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-- !=0){
            int m = sc.nextInt();
            cal(m);
        }
    }
    static void cal(int m){
        HashSet<Integer> set = new HashSet<>();
        long res = m;
        //从1到n中去除p1,p2...pk的所有倍数
        for(int i = 2; i <= m/i; i++){
            if(m%i == 0){
                while(m%i == 0){
                    m /= i;
                }
                 set.add(i);
            }
        }
        if(m>1){
            set.add(m);
        }
        for(int x:set){
            res = res/x*(x-1);
        }
        System.out.println(res);
    }
}
```

筛法求欧拉函数：

```java
import java.util.*;
class Main{
    static int n = 0, N = 1000010;
    static int[] phi = new int[N];//存储数字n的质数的个数
    static int[] primes = new int[N];//存储质数的下标对应的质数
    static int cnt = 0;//存储质数的下标
    static boolean[] st = new boolean[N];//标示n有没有被筛掉
    static long euler(int n){
        phi[1] = 1;//从定义出发
        for(int i = 2; i <= n; ++i){
            if(!st[i]){
                primes[cnt++] = i;//质数的集合
                phi[i] = i - 1;//如果i是质数，那么与它互质的个数是i - 1
            }
            for(int j = 0; primes[j] <= n / i; ++j){
                st[primes[j] * i] = true;//筛掉prrmes[j]的倍数
                if(i % primes[j] == 0){//如果primes[j] 与i不互质，表示primes[j]是i的一个质因子，i的欧拉函数中包含primes[j]，然后根据定义得到下列公式
                    phi[primes[j] * i] = primes[j] * phi[i];
                    break;//剪枝
                }
                //如果primes[j] 与i互质，表示primes[j]不是i的一个质因子，i的欧拉函数中不包含primes[j]，然后根据定义得到下列公式
                phi[primes[j] * i] = (primes[j] - 1) * phi[i];
            }
        }
        long res = 0;
        for(int i = 1; i <= n; ++i){
            res += phi[i];
        }
        return res;
    }

    public static void main(String[] args)throws Exception{
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.print(euler(n));
    }
}

```



### （4）快速幂

 	任何数都可以用二进制来表示

![image-20210506130501990](C:\Users\18068\AppData\Roaming\Typora\typora-user-images\image-20210506130501990.png)



```java
import java.util.*;
class Main{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n ;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            int res = 1;
            while(b!=0){
                if((b&1)==1){
                    res = Math.floorMod(res*1L*a,p);
                }
                a = Math.floorMod(a*1L*a,p);
                b = b >> 1;
            }   
            System.out.println(res);
        }
        
    }
}
2 5 
101
res 2  
    
```

求逆元：

![image-20210506134959787](C:\Users\18068\AppData\Roaming\Typora\typora-user-images\image-20210506134959787.png)

整除：b|a：b能整除a，a能被b整除。b是除数，a是被除数。

### （5）扩展欧几里得 算法

裴蜀定理：

对于任意正整数a,b，一定存在整数x，y，使得ax+by = gcd(a,b)



### （6）高斯消元

### （7）求组合数

![s](C:\Users\18068\AppData\Roaming\Typora\typora-user-images\image-20210508154633704.png)

```java
用DP写：
import java.util.*;
class Main{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mod = (int)1e9+7;
        long[][] dp = new long[2010][2010];
        for(int i = 0; i <= 2000; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = (dp[i-1][j] + dp[i-1][j-1])%mod;
                }
            }
        }
        while(n-- != 0){
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(dp[x][y]);
        }
    }
    
}
```

![image-20210508154814905](C:\Users\18068\AppData\Roaming\Typora\typora-user-images\image-20210508154814905.png)

```java


import java.util.Scanner;

public class Main {
    static int mod = (int)1e9+7;
    static int[] fact = new int[(int)1e5+10],infact = new int[(int)1e5+10];
    static long qmi(int a, int k, int p){
        long res = 1;
        while( k > 0){
            if( (k & 1) != 0 ) {
                res = res * a % p;
            }
            a =(int) ((long) a * a % p);
            k >>= 1;
        }
        return (int) res;
    }
    public static void main(String[] args) {
        fact[0] = infact[0] = 1;
        for(int i = 1; i < fact.length; i++){
            fact[i] =(int) ((long)fact[i - 1] * i % mod);
            infact[i] = (int) ((long) infact[i - 1] * qmi(i, mod - 2, mod ) % mod);
        }
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-- !=0){
            int a=  sc.nextInt();
            int b = sc.nextInt();
            int res = (int) ((long) fact[a] * infact[a - b] % mod * infact[b] % mod);
            System.out.println(res);

        }
    }
}

```



### （8）博弈论

经典NIM游戏：

```java
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            res ^= x;
        }
        if(res == 0){
            System.out.println("No");
        }else{
            System.out.println("Yes");
        }
    }
}


```

台阶-NIM游戏：

```java
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        for(int i = 1; i <= n; i++){
            int x = sc.nextInt();
            if(i%2!=0){
                res ^= x;
            }
        }
        if(res ==0){
            System.out.println("No");
        }else{
            System.out.println("Yes");
        }
    }
}
```



## 五. 动态规划

### （1）背包问题

**01背包**

​	![image-20210318205250218](C:\Users\18068\AppData\Roaming\Typora\typora-user-images\image-20210318205250218.png)

```java
//dp[i][j]表示的是从个数为i且总体积不超过j的物品的集合
//dp问题主要就是状态表示和状态计算：
//状态计算：这个集合可以分为包含第i个物品的集合和不包含第i个物品的集合，即为dp[i][j] = dp[i-1][j] 和 
//dp[i-1][j-v[i]]+w[i] 由于状态表示就是最大价值，因此最后的dp[n][m]就是答案。
import java.util.*;
class Main{
    static int[] dp = new int[1005];
    static int n, m;
    static int[] v = new int[1005], w = new int[1005];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 1; i <= n; i++){
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        //物品个数为0时没有意义，而体积是从0开始的。
        for(int i = 1; i <= n; i++){
            //状态表示的时候：从v[i]往大枚举会导致数据被污染
            for(int j = m; j >= v[i]; j--){
                    dp[j] = Math.max(dp[j],dp[j-v[i]]+w[i]);
            }
        }
        System.out.println(dp[m]);
    }
}
```

```java
//dp[i][j]表示的是从个数为i且总体积不超过j的物品的集合
//dp问题主要就是状态表示和状态计算：
//状态计算：这个集合可以分为包含第i个物品的集合和不包含第i个物品的集合，即为dp[i][j] = dp[i-1][j] 和 
//dp[i-1][j-v[i]]+w[i] 由于状态表示就是最大价值，因此最后的dp[n][m]就是答案。
import java.util.*;
class Main{
    static int[][] dp = new int[1005][1005];
    static int n, m;
    static int[] v = new int[1005], w = new int[1005];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 1; i <= n; i++){
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        //物品个数为0时没有意义，而体积是从0开始的。
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= m; j++){
                dp[i][j] = dp[i-1][j];
                if(j >= v[i]){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-v[i]]+w[i]);
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
```

**完全背包**

![image-20210617234137419](C:\Users\18068\AppData\Roaming\Typora\typora-user-images\image-20210617234137419.png)

```java
import java.util.*;
class Main{
    static int n,m;
    static int []v = new int[1010];
    static int []w = new int[1010];
    static int [][]nums = new int [1010][1010];
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i = 1 ; i <= n;i++){
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        //这个问题可以分成无数个 dp[i][j] = dp[i-1][j-k*v[i]]+w[i]
        for(int i = 1;i<=n;i++){
            for(int j =0;j<=m;j++){
                for(int k = 0;k*v[i]<=j;k++){
                    nums[i][j] = Math.max(nums[i][j],nums[i-1][j-k*v[i]]+k*w[i]);
                }
            }
        }
        System.out.println(nums[n][m]);
    }
}
```

```java
//状态表示前i个物品且体积不超过j的物品的集合。
//集合划分：第i个物品选几个可用k次来划分一下集合
import java.util.*;
class Main{
    static int[] v = new int[1010];
    static int[] w = new int[1010];
    static int[][] dp = new int[1010][1010];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        for(int i = 1; i <= n;i++){
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        //因为dp[0][1...n]表示的是从前0个物品中选且总体积不超过1.。n所以dp[0][1...n]肯定是0
        for(int i = 1; i <= n;i++){
            for(int j = 0; j <= m; j++){
              dp[i][j] = dp[i-1][j];
              if(j-v[i] >= 0){
                  dp[i][j] = Math.max(dp[i][j],dp[i][j-v[i]]+w[i]);
              }
            }
        }
        System.out.println(dp[n][m]);
    }
}
```



```java
import java.util.*;
class Main{
    static int[] v = new int[1010];
    static int[] w = new int[1010];
    static int[] dp = new int[1010];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        for(int i = 1; i <= n;i++){
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        //因为dp[0][1...n]表示的是从前0个物品中选且总体积不超过1.。n所以dp[0][1...n]肯定是0
        for(int i = 1; i <= n;i++){
            for(int j = v[i]; j <= m; j++){
                //因为完全背包是从第i维转移过来的
                    dp[j] = Math.max(dp[j],dp[j-v[i]]+w[i]);
                }
            }
        
        System.out.println(dp[m]);
    }
}
```

多重背包：

转换为01背包来写

```java
import java.util.*;
class Main{
    static int[] v = new int[100005], w = new int[100005];
    static int[] dp = new int[100005];
    static int n,m;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int cnt = 1;
        for(int i = 1; i <= n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            for(int j = 0; j < c; j++){
                v[cnt] = a;
                w[cnt] = b;
                cnt++;
            }
        }
        for(int i = 1; i <= cnt; i++){
            for(int j = m; j >= v[i]; j--){
                dp[j] = Math.max(dp[j],dp[j-v[i]]+w[i]);
            }
        }
        System.out.println(dp[m]);
    }
}
```



```java
import java.util.*;
class Main{

    static int[][] arr = new int[105][105];
    static int[] s = new int[105];
    static int[] w = new int[105];
    static int[] v = new int[105];
    static int n, m;
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 1; i <= n; i++){

            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
            s[i] = sc.nextInt();
        }
        //由于每个物品有个数限制，因此在写暴力的时候加一个k <= s[i]即可
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= m; j++){
                for(int k = 0; k<=s[i]&&k*v[i]<=j; k++){
                    arr[i][j] = Math.max(arr[i][j],arr[i-1][j-k*v[i]]+k*w[i]);
                }
            }
        }
        System.out.println(arr[n][m]);
    }
}


```

多重背包2：

https://blog.csdn.net/qq_33171970/article/details/50582671

就是将多重背包转为01背包，用二进制来优化，

```java
import java.util.*;
class Main{
    static int N = 25000,M = 2010;
    static int n,m;
    static int[] dp = new int[N],v = new int[N],w = new int[N];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int cnt = 0;
        for(int i = 0; i < n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int s = sc.nextInt();
            int k = 1;//组别里的个数
            while(k <= s){
                cnt ++;//组别先增加
                v[cnt] = a*k;//整体体积
                w[cnt] = b*k;//整体价值
                s -= k;//s减小
                k *= 2;//组别里的个数增加
            }
            //将剩余的补齐
            if(s > 0){
                cnt ++;
                v[cnt] = a*s;
                w[cnt] = b*s;
                
            }
        }
        n = cnt;
        for(int i = 1; i <= n; i++){
            for(int j = m;j >= v[i]; j--){
                dp[j] = Math.max(dp[j],dp[j-v[i]]+w[i]);
            }
        }
        System.out.println(dp[m]);
    }
}
```

分组背包：

```java

import java.util.*;
class Main{
    static int n, m;
    static int[]v = new int[110],w = new int[110];
    static int[] f = new int[110];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
         m = sc.nextInt();
        for(int i = 1; i <= n; i++){
            s[i] = sc.nextInt();
            for(int j = 1; j <= s[i]; j++){
                v[j] = sc.nextInt();
                w[j] = sc.nextInt();
            }
        }
        for(int i = 1; i <= n; i++){
            for(int j = m; j >= 0; j--){
                for(int k = 0; k < s[j]; k++){
                    if(v[i][k] <= j){
                        f[j] = Math.max(f[j],f[j-v[i][k]]+w[i][k]);
                    }
                    
                }
            }
        }
        System.out.println(f[m]);
        
    }
}
```

```java
/**
    核心思路：把f[i][j] 看成前i组里面选总体积小于j的最大价值
              然后划分区间：第i组里面选k个属于 ——>0到s[i]个
              结果就是转移成去掉第i组第k个物品的体积v[i][k]就变成从n-1里面选最大值，因为去掉了第k个物品
              所以要加上k的价值w[i][k];
**/
import java.util.*;
class Main{
    static int n, m;
    static int[][]v = new int[110][110],w = new int[110][110],f = new int[110][110];
    static int[] s = new int[110];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
         m = sc.nextInt();

        for(int i = 1; i <= n; i++){
            s[i] = sc.nextInt();
            for(int j = 0; j < s[i]; j++){
                v[i][j] = sc.nextInt();
                w[i][j] = sc.nextInt();
            }
        }
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= m; j++){
                f[i][j] = f[i-1][j];
                for(int k = 0; k < s[i]; k++){
                    if(v[i][k] <= j){
                        f[i][j] = Math.max(f[i][j],f[i-1][j-v[i][k]]+w[i][k]);
                    }
                    
                }
            }
        }
        System.out.println(f[n][m]);
        
    }
}
```

### （2）线性DP

数字三角形：

 ![image-20210511101514209](C:\Users\18068\AppData\Roaming\Typora\typora-user-images\image-20210511101514209.png)

```java
import java.util.*;
class Main{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n+1][n+1];
        for(int i = 0 ; i <= n; i++){
            Arrays.fill(arr[i],-(int)1e9);
        }
        for(int i = 1 ; i <= n; i++){
            for(int j = 1; j <=i; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                arr[i][j] += Math.max(arr[i-1][j],arr[i-1][j-1]);
            }
        }
         
        int res =  -(int)1e9;
        for(int i = 1 ; i <= n; i++){
            res = Math.max(res,arr[n][i]);
        }
        System.out.println(res);
    }
}
```

最长上升子序列：

![ ](C:\Users\18068\AppData\Roaming\Typora\typora-user-images\image-20210511112707824.png)

```java
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
             arr[i] = sc.nextInt();
        }
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int res = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[j]<arr[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        System.out.println(res);
    }
}
```

最长公共子序列：

```java
import java.util.*;
class Main{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s1 = sc.next();
        String s2 = sc.next();
        int[][] dp = new int[n+1][m+1];
        for(int i = 1; i <= n; i++){
            char c1 = s1.charAt(i-1);
            for(int j = 1; j <= m; j++){
                char c2 = s2.charAt(j-1);
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                if(c1 == c2){
                    dp[i][j] = dp[i-1][j-1]+1;
                }  
                
            }
        }
        System.out.println(dp[n][m]);
    }
}
```

石子合并：



![image-20210511155111557](C:\Users\18068\AppData\Roaming\Typora\typora-user-images\image-20210511155111557.png)

```java
import java.util.*;
class Main{
    static int []s = new int[310];
    static int [][]f = new int[310][310];
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i <= n; i++){
            s[i] = sc.nextInt();
            s[i] +=s[i-1]; 
        }
        for(int len = 2; len <= n; len++){
            for(int i = 1; i+len-1 <= n ; i++){
                int l = i,r = i+len-1;
                f[l][r] = Integer.MAX_VALUE;
                for(int k = l; k < r; k++){
                    f[l][r] = Math.min(f[l][r],f[l][k]+f[k+1][r]+s[r]-s[l-1]);
                }
            }
        }
        System.out.println(f[1][n]);
    }
}
```



## 六. 二叉树问题

### 前序和中序重建二叉树（ac18）



### 后序和中序求层次遍历（ac1497）



## 大佬板子

```java
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.Collection;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.ArrayDeque;
import java.io.InputStream;


public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskC solver = new TaskC();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskC {
        int[] h;
        int[] e;
        int[] ne;
        int[] w;
        int idx;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            h = new int[n + 5];
            int[] inDeg = new int[n + 5];
            e = new int[m * 2 + 5];
            ne = new int[m * 2 + 5];
            w = new int[m * 2 + 5];
            idx = 0;
            Arrays.fill(h, -1);
            List<int[]> res = new ArrayList<>();
            List<int[]> tmp1 = new ArrayList<>();
            boolean[] vis = new boolean[n + 5];
            for (int i = 0; i < m; i++) {
                int t = in.nextInt();
                int x = in.nextInt();
                int y = in.nextInt();
                if (t == 1) {
                    add(x, y, 1);
                    inDeg[y]++;
                    tmp1.add(new int[]{x, y});
                } else {
                    add(x, y, 0);
                    add(y, x, 0);
                }
            }
            Queue<Integer> queue = new ArrayDeque<>();
            for (int j = 1; j <= n; j++) {
                if (inDeg[j] == 0) {
                    queue.add(j);
                }
            }
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int u = queue.poll();
                    vis[u] = true;
                    for (int k = h[u]; k != -1; k = ne[k]) {
                        int j = e[k];
                        if (vis[j]) {
                            continue;
                        }
                        if (w[k] == 0) {
                            res.add(new int[]{u, j});
                        } else {
                            inDeg[j]--;
                            if (inDeg[j] == 0) {
                                queue.add(j);
                            }
                        }

                    }
                }
            }
            if (res.size() + tmp1.size() == m) {
                out.println("YES");
                for (int[] re : res) {
                    out.println(re[0] + " " + re[1]);
                }
                for (int[] re : tmp1) {
                    out.println(re[0] + " " + re[1]);
                }
            } else {
                out.println("NO");
            }

        }

        void add(int a, int b, int v) {
            e[idx] = b;
            w[idx] = v;
            ne[idx] = h[a];
            h[a] = idx++;
        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void println(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return nextString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}



```

