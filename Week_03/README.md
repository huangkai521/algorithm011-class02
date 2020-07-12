学习笔记
### 递归模板
```java
public void recur(int level, param){
    // terminator 递归终止条件
    if (level > MAX_LEVEL) {
	 	// process result and return 处理结果
        return;

    }
	
    // process current logic 处理当前层程序
    process(level, param);
	
    // drill down 下探一层
    recur(level+1, newParam);
	
    // revert the current status 重置当前层状态，一般不用
}
```
----
### 分治模板
```java
public void divideConquer(problem, param1, param2 .....) {
    // terminator 递归终止条件
    if (problem == null) {
        // process result and return 处理结果，比如添加到list等等
        return;
    }
	
    // process data 处理数据，分割子问题。比如pow里面将数据除以2
    data = prepareData(problem);
    subproblems = splitProblem(problem, data);
	
    // conquer subproblems 处理子问题
    subresult1 = divideConquer(subproblems[0], p1, p2 ...);
    subresult2 = divideConquer(subproblems[1], p1, p2....);
    subresult3 = divideConquer(subproblema[3], p1, p2 ...);

    // process and gererate final result 合并结果，比如pow将结果相乘
    result  = mergeResult(subresult1, subresult2, subresult3);
	
    // revert the current level status 重置当前层状态
}
```

