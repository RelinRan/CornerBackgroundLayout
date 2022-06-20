# SQLite
SQLite数据库操作
# 资源
|名字|资源|
|-|-|
|AAR|[sqlite.aar](https://github.com/RelinRan/SQLite/blob/master/sqlite.aar)|
|Gitee|[SQLite](https://gitee.com/relin/SQLite)|
|GitHub |[SQLite](https://github.com/RelinRan/SQLite)|
# Maven
1.build.grade | setting.grade
```
repositories {
	...
	maven { url 'https://jitpack.io' }
}
```
2./app/build.grade
```
dependencies {
	implementation 'com.github.RelinRan:SQLite:2022.6.20.1'
}
```
数据库操作
# 初始化
```
SQLite.initialize(getApplicationContext());
```
# 建表
```
//方式1
SQLite.administrator().create("table_name",new String[]{"column_name_a","column_name_b"});
//方式2
User user = new User();
SQLite.administrator().create(user);
```
# 新增
```
//方式1
User user = new User();
SQLite.administrator().insert(user);
//方式2
SQLite.administrator().insert("sql");
//方式3
ContentValues values = new ContentValues();
values.put("user_id","1");
values.put("user_name","name");
SQLite.administrator().insert("table_name",values);
```
# 删除
```
//方式1
SQLite.administrator().delete("sql");
//方式2
SQLite.administrator().delete(User.class,"user_id=?",new String[]{"1"});
//方式3
SQLite.administrator().delete("table_name","user_id=?",new String[]{"1"});
```
# 更新
```
//方式1
SQLite.administrator().update("sql");
//方式2
User user = new User();
user.setUserName("Name");
ContentValues values = new ContentValues();
values.put("user_id","1");
values.put("user_name","name");
SQLite.administrator().update(user,values,"user_id=?",new String[]{"1"});
```
# 查询
```
//方式1
List<Map<String, String>> list = SQLite.administrator().query("sql");
//方式2
List<User> list = SQLite.administrator().query(User.class,"sql");
```
# 删除表数据
```
//方式1
SQLite.administrator().deleteTable("table_name");
//方式2
SQLite.administrator().deleteTable(User.class);
//方式3
SQLite.administrator().dropTable("table_name");//删除表
```
