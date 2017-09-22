# 懒加载
- ViewPager + Fragment 懒加载
    例如有四个Fragment，分别为A，B，C，D.默认A为第一个显示.那么初始化的顺序为:
    先初始化A的构造函数,A的setUserVisibleHint(boolean)方法
    再初始化B的构造函数,B的setUserVisibleHint(boolean)方法