## 需求
### 需求一

写一个Person类，要有name，age属性，要有一个introduce方法， introduce方法返回一个字符串形如： My name is Tom. I am 21 years old.

### 需求二 

Person 类有一个introduce 方法，Student 类是Person 的子类，有name, age，还有classNumber(klass)属性，有一个introduce 方法，introduce 方法返回一个字符串如： My name is Tom, I am 21 years old. I am a Student. I am at Class 2.

Worker 类是Person 的子类，有name, age 属性，还有job 属性。也有一个introduce 方法，introduce 方法返回一个字符串如：My name is Tom, I am 21 years old. I am a Worker. I work as a xx.
这两个类是一个类的扩展，但是他们有自己不同属性，也会有不同的方法。

### 需求三 

一个班级有多个学生，一个班级会分配一个老师。
Student的class属性不是一个数字，而是一个对象。

### 需求四

当学生的姓名、班级发生变化的时候，会通知这个班级的其他学生和老师。
* 姓名发生变化的时候，班里的其他学生和老师都能接收到消息；
* 班级发生变化的时候，原有的和新的班里的学生和老师都能接收到消息；

通知的内容为： My name is Tom. I am 21 years old. I am a student of Class 2 now.