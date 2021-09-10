# 序列化流的介绍

Tags : JDK8 Eclipse

---

[TOC]

---

## 简介

`ObjectInputStream`和`ObjectOutputStream`实现了将对象转字节数组,实现了对象的序列化操作.
## 类文件

* `RandomAccessFileDemol`               简单实现了一个对象序列化写入文件
* `Student`                                                    准备被序列化的对象
*  student                                                      序列化后生成的文件

## 序列化与反序列化介绍
### 名词解释
**对象序列化:**  将Object转换为byte序列.
**对象序列化:**  将byte转换为Object序列.

### 工作方式
**`Serializable`接口:**   对象必须实现该序列化接口,才能进行序列化操作
**`transient`属性修饰:** 对象如果被`transient` 关键字修饰,则在序列化或反序列化时该属性不会被写入或者读取.

