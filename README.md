# CornerBackgroundLayout
1.支持背景圆角显示
2.支持背景缺角显示
3.优惠券背景自动颜色
# 预览
![效果](./ic_preview.png)
# 资源
|名字|资源|
|-|-|
|AAR|[corner_background_layout.aar](https://github.com/RelinRan/CornerBackgroundLayout/blob/master/corner_background_layout.aar)|
|Gitee|[CornerBackgroundLayout](https://gitee.com/relin/CornerBackgroundLayout)|
|GitHub |[CornerBackgroundLayout](https://github.com/RelinRan/CornerBackgroundLayout)|
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
	implementation 'com.github.RelinRan:CornerBackgroundLayout:2022.6.20.1'
}
```
# xml
~~~
    <com.androidx.widget.CornerBackgroundLayout
        android:layout_width="match_parent"
        android:layout_margin="10dp"
        app:solid="#2070E5"
        app:radius="10dp"
        app:leftTopLackRadius="8dp"
        app:leftBottomLackRadius="8dp"
        android:layout_height="90dp"/>
~~~
# attrs.xml
~~~
    <attr name="solid" format="color" />
    <attr name="radius" format="dimension" />
    <attr name="lackRadius" format="dimension" />
    <attr name="leftTopLackRadius" format="dimension" />
    <attr name="leftBottomLackRadius" format="dimension" />
    <attr name="rightTopLackRadius" format="dimension" />
    <attr name="rightBottomLackRadius" format="dimension" />
    <declare-styleable name="CornerBackgroundLayout">
        <attr name="solid"/>
        <attr name="radius"/>
        <attr name="lackRadius" />
        <attr name="leftTopLackRadius"/>
        <attr name="leftBottomLackRadius"/>
        <attr name="rightTopLackRadius"/>
        <attr name="rightBottomLackRadius"/>
    </declare-styleable>
~~~
