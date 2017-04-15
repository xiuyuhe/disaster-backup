前端文档
-----
### 技术使用
- HTML / CSS / JS 
- BootStrap V3  , jQuery v1.11.1 , Font Awesome 4.0.3 
- art-template@4.0.0-beta1 ,bootstrap-treeview.js v1.2.0 , jqPaginator

-----
#### art-template
项目地址：https://github.com/aui/art-template

-----
#### treeview
项目地址：https://github.com/jonmiles/bootstrap-treeview

基本使用：
1.  引入
 ```html
 <!-- Required Stylesheets -->
 <link href="bootstrap.css" rel="stylesheet">
 
 <!-- Required Javascript -->
 <script src="jquery.js"></script>
 <script src="bootstrap-treeview.js"></script>
 ```
2.  定义将会被绑定的 DOM节点
```html
<div id="tree"></div>
```
3.  基本的使用方法
```html
function getTree() {
  // 需要显示的数据
  return data;
}

$('#tree').treeview({data: getTree()});
```
4.  数据结构
```html
var tree = [
  {
    text: "Parent 1",
    nodes: [
      {
        text: "Child 1",
        nodes: [
          {
            text: "Grandchild 1"
          },
          {
            text: "Grandchild 2"
          }
        ]
      },
      {
        text: "Child 2"
      }
    ]
  },
  {
    text: "Parent 2"
  },
  {
    text: "Parent 3"
  },
  {
    text: "Parent 4"
  },
  {
    text: "Parent 5"
  }
];
```
5.  更多选项 (具体意义查看文档 https://github.com/jonmiles/bootstrap-treeview)
```html
 {
   text: "Node 1",
   icon: "glyphicon glyphicon-stop",
   selectedIcon: "glyphicon glyphicon-stop",
   color: "#000000",
   backColor: "#FFFFFF",
   href: "#node-1",
   selectable: true,
   state: {
     checked: true,
     disabled: true,
     expanded: true,
     selected: true
   },
   tags: ['available'],
   nodes: [
     {},
     ...
   ]
 }
```

---
### jqPaginator
项目地址：http://jqpaginator.keenwon.com/