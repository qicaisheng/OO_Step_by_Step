## 需求
1. 写一个Person 类，要有name, age 属性， 要有一个introduce 方法， introduce 方法返回一个字符串如：My name is Tom. I am 21 years old.
2. Person 类有一个introduce 方法，Student 类是Person 的子类，有name, age，还有classNumber(klass)属性，有一个introduce 方法，introduce 方法返回一个字符串如： My name is Tom, I am 21 years old. I am a Student. I am at Class 2.
Worker 类是Person 的子类，有name, age 属性，还有job 属性。也有一个introduce 方法，introduce 方法返回一个字符串如：My name is Tom, I am 21 years old. I am a Worker. I work as a xx.
这两个类是一个类的扩展，但是他们有自己不同属性，也会有不同的方法。
3. Student 的class 属性不是一个数字，而是一个对象。
4. 当学生的姓名、班级发生变化的时候，会通知老师。每当发生变化的时候，就发一个消息出去，通知每一个关心自己变化的实体。